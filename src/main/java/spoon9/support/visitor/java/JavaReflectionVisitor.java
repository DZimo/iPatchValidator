/**
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.visitor.java;

import spoon9.reflect.path.CtRole;
import spoon9.support.visitor.java.reflect.RtMethod;
import spoon9.support.visitor.java.reflect.RtParameter;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * Internal, package-visible interface for building shadow classes.
 * Client code should not rely on it.
 */
interface JavaReflectionVisitor {
	/** Visits a {@link Package} */
	void visitPackage(Package aPackage);

	/** Visits a {@link Class} */
	<T> void visitClass(Class<T> clazz);

	/** Visits a {@link Class} representing an interface, see {@link Class#isInterface()} ()} */
	<T> void visitInterface(Class<T> clazz);

	/** Visits a {@link Class} representing an enum, see {@link Class#isEnum()} */
	<T> void visitEnum(Class<T> clazz);

	/** Visits a {@link Class} representing an enum, see {@link Class#isAnnotation()} */
	<T extends Annotation> void visitAnnotationClass(Class<T> clazz);

	/** Visits an {@link Annotation} instance */
	void visitAnnotation(Annotation annotation);

	/** Visits a {@link Constructor} */
	<T> void visitConstructor(Constructor<T> constructor);

	/** Visits a {@link RtMethod} (spoon wrapper) */
	void visitMethod(RtMethod method);

	/** Visits a {@link Field} */
	void visitField(Field field);

	/** Visits a {@link Field} from an enum */
	void visitEnumValue(Field field);

	/** Visits a {@link RtParameter} (spoon wrapper) */
	void visitParameter(RtParameter parameter);

	/** Visits a {@link TypeVariable} */
	<T extends GenericDeclaration> void visitTypeParameter(TypeVariable<T> parameter);

	/** Visits a {@link TypeVariable}
	 * @param role {@link CtRole} which this reference plays*/
	<T extends GenericDeclaration> void visitTypeParameterReference(CtRole role, TypeVariable<T> parameter);

	/** Visits a {@link Type}
	 * @param role {@link CtRole} which this reference plays*/
	void visitTypeReference(CtRole role, Type type);

	/** Visits a {@link ParameterizedType}
	 * @param role {@link CtRole} which this reference plays*/
	void visitTypeReference(CtRole role, ParameterizedType type);

	/** Visits a {@link WildcardType}
	 * @param role {@link CtRole} which this reference plays*/
	void visitTypeReference(CtRole role, WildcardType type);

	/** Visits a {@link Class} in generic parameters
	 * @param role {@link CtRole} which this reference plays*/
	<T> void visitTypeReference(CtRole role, Class<T> clazz);

	/** Visits a class as an array reference
	 * @param role {@link CtRole} which this reference plays*/
	<T> void visitArrayReference(CtRole role, Type typeArray);
}
