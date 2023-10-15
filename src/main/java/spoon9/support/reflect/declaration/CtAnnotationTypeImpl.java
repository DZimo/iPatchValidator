/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2023 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) or the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.reflect.declaration;

import spoon9.reflect.declaration.CtAnnotationMethod;
import spoon9.reflect.declaration.CtAnnotationType;
import spoon9.reflect.declaration.CtFormalTypeDeclarer;
import spoon9.reflect.declaration.CtMethod;
import spoon9.reflect.declaration.CtType;
import spoon9.reflect.declaration.CtTypeParameter;
import spoon9.reflect.reference.CtTypeReference;
import spoon9.reflect.visitor.CtVisitor;
import spoon9.support.DerivedProperty;
import spoon9.support.UnsettableProperty;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * The implementation for {@link CtAnnotationType}.
 *
 * @author Renaud Pawlak
 */
public class CtAnnotationTypeImpl<T extends Annotation> extends CtTypeImpl<T> implements CtAnnotationType<T> {
	private static final long serialVersionUID = 1L;

	@Override
	public void accept(CtVisitor v) {
		v.visitCtAnnotationType(this);
	}

	@Override
	public boolean isAnnotationType() {
		return true;
	}

	@Override
	@DerivedProperty
	public Set<CtTypeReference<?>> getSuperInterfaces() {
		return Collections.emptySet();
	}

	@Override
	@DerivedProperty
	public CtTypeReference<?> getSuperclass() {
		return null;
	}

	@Override
	@UnsettableProperty
	public <C extends CtType<T>> C setSuperclass(CtTypeReference<?> superClass) {
		return (C) this;
	}

	@Override
	@UnsettableProperty
	public <C extends CtType<T>> C setSuperInterfaces(Set<CtTypeReference<?>> interfaces) {
		return (C) this;
	}

	@Override
	@DerivedProperty
	public List<CtTypeParameter> getFormalCtTypeParameters() {
		return emptyList();
	}

	@Override
	@UnsettableProperty
	public <C extends CtFormalTypeDeclarer> C setFormalCtTypeParameters(List<CtTypeParameter> formalTypeParameters) {
		return (C) this;
	}

	@Override
	public boolean isSubtypeOf(CtTypeReference<?> type) {
		return getReference().isSubtypeOf(type);
	}

	@Override
	public CtAnnotationType<T> clone() {
		return (CtAnnotationType<T>) super.clone();
	}

	@Override
	public Set<CtAnnotationMethod<?>> getAnnotationMethods() {
		Set<CtAnnotationMethod<?>> annotationsMethods = new LinkedHashSet<>();
		for (CtMethod<?> method : getMethods()) {
			if (method instanceof  CtAnnotationMethod) {
				annotationsMethods.add((CtAnnotationMethod<?>) method);
			}
		}
		return annotationsMethods;
	}

	@Override
	public <M, C extends CtType<T>> C addMethod(CtMethod<M> method) {
		return super.addMethod(method);
	}
}