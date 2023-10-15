/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.visitor.java.internal;

import spoon9.reflect.declaration.CtAnnotation;
import spoon9.reflect.declaration.CtConstructor;
import spoon9.reflect.declaration.CtEnumValue;
import spoon9.reflect.declaration.CtField;
import spoon9.reflect.declaration.CtMethod;
import spoon9.reflect.declaration.CtPackage;
import spoon9.reflect.declaration.CtParameter;
import spoon9.reflect.declaration.CtType;
import spoon9.reflect.declaration.CtTypeParameter;
import spoon9.reflect.path.CtRole;
import spoon9.reflect.reference.CtTypeReference;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericDeclaration;

public interface RuntimeBuilderContext {
	void addPackage(CtPackage ctPackage);

	void addType(CtType<?> aType);

	void addAnnotation(CtAnnotation<Annotation> ctAnnotation);

	void addConstructor(CtConstructor<?> ctConstructor);

	void addMethod(CtMethod<?> ctMethod);

	void addField(CtField<?> ctField);

	void addEnumValue(CtEnumValue<?> ctEnumValue);

	void addParameter(CtParameter ctParameter);

	void addTypeReference(CtRole role, CtTypeReference<?> ctTypeReference);

	void addFormalType(CtTypeParameter parameterRef);


	CtTypeParameter getTypeParameter(GenericDeclaration genericDeclaration, String string);
}
