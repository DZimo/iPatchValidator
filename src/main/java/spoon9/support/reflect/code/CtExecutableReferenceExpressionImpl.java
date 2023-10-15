/**
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.reflect.code;

import spoon9.reflect.annotations.MetamodelPropertyField;
import spoon9.reflect.code.CtExecutableReferenceExpression;
import spoon9.reflect.code.CtExpression;
import spoon9.reflect.reference.CtExecutableReference;
import spoon9.reflect.visitor.CtVisitor;

import static spoon9.reflect.path.CtRole.EXECUTABLE_REF;

public class CtExecutableReferenceExpressionImpl<T, E extends CtExpression<?>> extends CtTargetedExpressionImpl<T, E> implements CtExecutableReferenceExpression<T, E> {
	@MetamodelPropertyField(role = EXECUTABLE_REF)
	CtExecutableReference<T> executable;

	@Override
	public void accept(CtVisitor visitor) {
		visitor.visitCtExecutableReferenceExpression(this);
	}

	@Override
	public CtExecutableReference<T> getExecutable() {
		return executable;
	}

	@Override
	public <C extends CtExecutableReferenceExpression<T, E>> C setExecutable(CtExecutableReference<T> executable) {
		if (executable != null) {
			executable.setParent(this);
		}
		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, EXECUTABLE_REF, executable, this.executable);
		this.executable = executable;
		return (C) this;
	}

	@Override
	public CtExecutableReferenceExpression<T, E> clone() {
		return (CtExecutableReferenceExpression<T, E>) super.clone();
	}
}
