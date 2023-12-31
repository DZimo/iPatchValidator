/**
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.reflect.reference;

import spoon9.reflect.declaration.CtElement;
import spoon9.reflect.declaration.CtExecutable;
import spoon9.reflect.declaration.CtParameter;
import spoon9.reflect.declaration.ParentNotInitializedException;
import spoon9.reflect.reference.CtExecutableReference;
import spoon9.reflect.reference.CtParameterReference;
import spoon9.reflect.visitor.CtVisitor;

import java.util.List;

public class CtParameterReferenceImpl<T> extends CtVariableReferenceImpl<T> implements CtParameterReference<T> {
	private static final long serialVersionUID = 1L;

	public CtParameterReferenceImpl() {
	}

	@Override
	public void accept(CtVisitor visitor) {
		visitor.visitCtParameterReference(this);
	}

	@Override
	public CtExecutableReference<?> getDeclaringExecutable() {
		CtParameter<T> declaration = getDeclaration();
		if (declaration == null) {
			return null;
		}
		return declaration.getParent().getReference();
	}

	@Override
	@SuppressWarnings("unchecked")
	public CtParameter<T> getDeclaration() {
		final CtParameter<T> ctParameter = lookupDynamically();
		if (ctParameter != null) {
			return ctParameter;
		}
		return null;
	}

	private CtParameter<T> lookupDynamically() {
		CtElement element = this;
		CtParameter optional = null;
		String name = getSimpleName();
		try {
			do {
				CtExecutable executable = element.getParent(CtExecutable.class);
				if (executable == null) {
					return null;
				}
				for (CtParameter parameter : (List<CtParameter>) executable.getParameters()) {
					if (name.equals(parameter.getSimpleName())) {
						optional = parameter;
					}
				}
				element = executable;
			} while (optional == null);
		} catch (ParentNotInitializedException e) {
			return null;
		}
		return optional;
	}

	@Override
	public CtParameterReference<T> clone() {
		return (CtParameterReference<T>) super.clone();
	}
}
