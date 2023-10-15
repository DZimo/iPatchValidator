/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2023 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) or the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.visitor.java.internal;

import java.lang.annotation.Annotation;
import spoon9.reflect.declaration.CtAnnotation;
import spoon9.reflect.declaration.CtRecordComponent;
import spoon9.reflect.path.CtRole;
import spoon9.reflect.reference.CtTypeReference;

public class RecordComponentRuntimeBuilderContext extends AbstractRuntimeBuilderContext {

	private final CtRecordComponent component;
	public RecordComponentRuntimeBuilderContext(CtRecordComponent element) {
		super(element);
		this.component = element;
	}
	@Override
	public void addAnnotation(CtAnnotation<Annotation> ctAnnotation) {
		component.addAnnotation(ctAnnotation);
	}

	@Override
	public void addTypeReference(CtRole role, CtTypeReference<?> ctTypeReference) {
		component.setType((CtTypeReference) ctTypeReference);
	}
}
