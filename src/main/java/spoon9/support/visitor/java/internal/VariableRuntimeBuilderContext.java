/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2023 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) or the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.visitor.java.internal;

import spoon9.reflect.declaration.CtAnnotation;
import spoon9.reflect.declaration.CtField;
import spoon9.reflect.declaration.CtParameter;
import spoon9.reflect.declaration.CtVariable;
import spoon9.reflect.path.CtRole;
import spoon9.reflect.reference.CtTypeReference;

import java.lang.annotation.Annotation;

public class VariableRuntimeBuilderContext extends AbstractRuntimeBuilderContext {
	private CtVariable ctVariable;

	public VariableRuntimeBuilderContext(CtField<?> ctField) {
		super(ctField);
		this.ctVariable = ctField;
	}

	public VariableRuntimeBuilderContext(CtParameter<?> ctParameter) {
		super(ctParameter);
		this.ctVariable = ctParameter;
	}

	@Override
	public void addAnnotation(CtAnnotation<Annotation> ctAnnotation) {
		ctVariable.addAnnotation(ctAnnotation);
	}

	@Override
	public void addTypeReference(CtRole role, CtTypeReference<?> ctTypeReference) {
		switch (role) {
		case TYPE:
			ctVariable.setType(ctTypeReference);
			return;
		}
		super.addTypeReference(role, ctTypeReference);
	}
}
