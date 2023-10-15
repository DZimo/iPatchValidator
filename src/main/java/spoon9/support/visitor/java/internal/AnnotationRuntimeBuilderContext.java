/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2023 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) or the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.visitor.java.internal;

import spoon9.reflect.declaration.CtAnnotation;
import spoon9.reflect.path.CtRole;
import spoon9.reflect.reference.CtTypeReference;

import java.lang.annotation.Annotation;

public class AnnotationRuntimeBuilderContext extends AbstractRuntimeBuilderContext {
	private CtAnnotation<Annotation> ctAnnotation;

	public AnnotationRuntimeBuilderContext(CtAnnotation<Annotation> ctAnnotation) {
		super(ctAnnotation);
		this.ctAnnotation = ctAnnotation;
	}

	@Override
	public void addAnnotation(CtAnnotation<Annotation> ctAnnotation) {
		this.ctAnnotation.addAnnotation(ctAnnotation);
	}

	@Override
	public void addTypeReference(CtRole role, CtTypeReference<?> typeReference) {
		switch (role) {
		case ANNOTATION_TYPE:
			ctAnnotation.setAnnotationType((CtTypeReference<? extends Annotation>) typeReference);
			ctAnnotation.setType((CtTypeReference<Annotation>) typeReference);
			return;
		}
		super.addTypeReference(role, typeReference);
	}

	public CtAnnotation<Annotation> getCtAnnotation() {
		return this.ctAnnotation;
	}
}
