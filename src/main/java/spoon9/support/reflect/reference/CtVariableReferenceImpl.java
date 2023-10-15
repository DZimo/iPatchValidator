/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.reflect.reference;

import spoon9.reflect.annotations.MetamodelPropertyField;
import spoon9.reflect.declaration.CtVariable;
import spoon9.reflect.declaration.ModifierKind;
import spoon9.reflect.reference.CtTypeReference;
import spoon9.reflect.reference.CtVariableReference;
import spoon9.reflect.visitor.CtVisitor;
import spoon9.reflect.path.CtRole;

import java.lang.reflect.AnnotatedElement;
import java.util.Collections;
import java.util.Set;

public abstract class CtVariableReferenceImpl<T> extends CtReferenceImpl implements CtVariableReference<T> {
	private static final long serialVersionUID = 1L;

	@MetamodelPropertyField(role = CtRole.TYPE)
    CtTypeReference<T> type;

	public CtVariableReferenceImpl() {
	}

	@Override
	public void accept(CtVisitor visitor) {
		// nothing
	}

	@Override
	public CtTypeReference<T> getType() {
		return type;
	}

	@Override
	public <C extends CtVariableReference<T>> C setType(CtTypeReference<T> type) {
		if (type != null) {
			type.setParent(this);
		}
		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, CtRole.TYPE, type, this.type);
		this.type = type;
		return (C) this;
	}

	@Override
	protected AnnotatedElement getActualAnnotatedElement() {
		// this is never available through reflection
		return null;
	}

	@Override
	public CtVariable<T> getDeclaration() {
		return null;
	}

	@Override
	public Set<ModifierKind> getModifiers() {
		CtVariable<T> v = getDeclaration();
		if (v != null) {
			return v.getModifiers();
		}
		return Collections.emptySet();
	}

	@Override
	public CtVariableReference<T> clone() {
		return (CtVariableReference<T>) super.clone();
	}
}
