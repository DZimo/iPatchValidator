/**
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.reflect.reference;

import spoon9.reflect.declaration.CtAnnotation;
import spoon9.reflect.declaration.CtElement;
import spoon9.reflect.reference.CtUnboundVariableReference;
import spoon9.reflect.visitor.CtVisitor;
import spoon9.support.DerivedProperty;
import spoon9.support.UnsettableProperty;

import java.lang.annotation.Annotation;
import java.util.List;

/** represents a reference to an unbound field (used when no full classpath is available */
public class CtUnboundVariableReferenceImpl<T> extends CtVariableReferenceImpl<T> implements CtUnboundVariableReference<T> {
	private static final long serialVersionUID = -932423216089690817L;

	@Override
	public void accept(CtVisitor visitor) {
		visitor.visitCtUnboundVariableReference(this);
	}

	@Override
	public CtUnboundVariableReference<T> clone() {
		return (CtUnboundVariableReference<T>) super.clone();
	}

	@Override
	@DerivedProperty
	public List<CtAnnotation<? extends Annotation>> getAnnotations() {
		return emptyList();
	}

	@Override
	@UnsettableProperty
	public <E extends CtElement> E setAnnotations(List<CtAnnotation<? extends Annotation>> annotations) {
		return (E) this;
	}
}
