/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2023 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) or the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.visitor.java.internal;

import spoon9.reflect.declaration.CtAnnotation;
import spoon9.reflect.declaration.CtConstructor;
import spoon9.reflect.declaration.CtEnumValue;
import spoon9.reflect.declaration.CtField;
import spoon9.reflect.declaration.CtMethod;
import spoon9.reflect.declaration.CtPackage;
import spoon9.reflect.declaration.CtParameter;
import spoon9.reflect.declaration.CtRecordComponent;
import spoon9.reflect.declaration.CtShadowable;
import spoon9.reflect.declaration.CtType;
import spoon9.reflect.declaration.CtTypeParameter;
import spoon9.reflect.path.CtRole;
import spoon9.reflect.reference.CtTypeReference;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericDeclaration;

abstract class AbstractRuntimeBuilderContext implements RuntimeBuilderContext {

	protected AbstractRuntimeBuilderContext(CtShadowable element) {
		element.setShadow(true);
	}

	@Override
	public void addPackage(CtPackage ctPackage) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addType(CtType<?> aType) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addAnnotation(CtAnnotation<Annotation> ctAnnotation) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addConstructor(CtConstructor<?> ctConstructor) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addMethod(CtMethod<?> ctMethod) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addField(CtField<?> ctField) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addEnumValue(CtEnumValue<?> ctEnumValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addParameter(CtParameter ctParameter) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addFormalType(CtTypeParameter parameterRef) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addTypeReference(CtRole role, CtTypeReference<?> ctTypeReference) {
		throw new UnsupportedOperationException();
	}


	@Override
	public void addRecordComponent(CtRecordComponent ctRecordComponent) {
		throw new UnsupportedOperationException();
	}

	@Override
	public CtTypeParameter getTypeParameter(GenericDeclaration genericDeclaration, String string) {
		return null;
	}
}
