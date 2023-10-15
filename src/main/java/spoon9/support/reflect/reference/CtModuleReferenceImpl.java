/**
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.reflect.reference;

import spoon9.reflect.declaration.CtModule;
import spoon9.reflect.reference.CtModuleReference;
import spoon9.reflect.visitor.CtVisitor;

import java.lang.reflect.AnnotatedElement;

public class CtModuleReferenceImpl extends CtReferenceImpl implements CtModuleReference {

	public CtModuleReferenceImpl() {
	}

	@Override
	public CtModule getDeclaration() {
		return this.getFactory().Module().getOrCreate(this.getSimpleName());
	}

	@Override
	protected AnnotatedElement getActualAnnotatedElement() {
		return null;
	}

	@Override
	public void accept(CtVisitor visitor) {
		visitor.visitCtModuleReference(this);
	}

	@Override
	public CtModuleReference clone() {
		return (CtModuleReference) super.clone();
	}
}
