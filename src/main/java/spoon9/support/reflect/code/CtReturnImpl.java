/**
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.reflect.code;

import spoon9.reflect.annotations.MetamodelPropertyField;
import spoon9.reflect.code.CtCodeElement;
import spoon9.reflect.code.CtExpression;
import spoon9.reflect.code.CtReturn;
import spoon9.reflect.declaration.CtType;
import spoon9.reflect.visitor.CtVisitor;

import static spoon9.reflect.path.CtRole.EXPRESSION;

public class CtReturnImpl<R> extends CtStatementImpl implements CtReturn<R> {
	private static final long serialVersionUID = 1L;

	@MetamodelPropertyField(role = EXPRESSION)
	CtExpression<R> returnedExpression;

	@Override
	public void accept(CtVisitor visitor) {
		visitor.visitCtReturn(this);
	}

	@Override
	public CtExpression<R> getReturnedExpression() {
		return returnedExpression;
	}

	@Override
	public <T extends CtReturn<R>> T setReturnedExpression(CtExpression<R> expression) {
		if (expression != null) {
			expression.setParent(this);
		}
		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, EXPRESSION, expression, this.returnedExpression);
		this.returnedExpression = expression;
		return (T) this;
	}

	@Override
	public CtReturn<R> clone() {
		return (CtReturn<R>) super.clone();
	}

	@Override
	public Void S() {
		return null;
	}

	public CtCodeElement getSubstitution(CtType<?> targetType) {
		return clone();
	}
}
