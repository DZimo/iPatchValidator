/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2023 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) or the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.reflect.code;

import spoon9.reflect.annotations.MetamodelPropertyField;
import spoon9.reflect.code.CtCodeElement;
import spoon9.reflect.code.CtExpression;
import spoon9.reflect.code.CtThrow;
import spoon9.reflect.declaration.CtType;
import spoon9.reflect.visitor.CtVisitor;

import static spoon9.reflect.path.CtRole.EXPRESSION;

public class CtThrowImpl extends CtStatementImpl implements CtThrow {
	private static final long serialVersionUID = 1L;

	@MetamodelPropertyField(role = EXPRESSION)
	CtExpression<? extends Throwable> throwExpression;

	@Override
	public void accept(CtVisitor visitor) {
		visitor.visitCtThrow(this);
	}

	@Override
	public CtExpression<? extends Throwable> getThrownExpression() {
		return throwExpression;
	}

	@Override
	public <T extends CtThrow> T setThrownExpression(CtExpression<? extends Throwable> expression) {
		if (expression != null) {
			expression.setParent(this);
		}
		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, EXPRESSION, expression, this.throwExpression);
		this.throwExpression = expression;
		return (T) this;
	}

	@Override
	public CtThrow clone() {
		return (CtThrow) super.clone();
	}

	@Override
	public Void S() {
		return null;
	}

	public CtCodeElement getSubstitution(CtType<?> targetType) {
		return clone();
	}

}
