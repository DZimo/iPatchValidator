/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2023 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) or the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.reflect.code;

import spoon9.reflect.annotations.MetamodelPropertyField;
import spoon9.reflect.code.CtDo;
import spoon9.reflect.code.CtExpression;
import spoon9.reflect.visitor.CtVisitor;

import static spoon9.reflect.path.CtRole.EXPRESSION;

public class CtDoImpl extends CtLoopImpl implements CtDo {
	private static final long serialVersionUID = 1L;

	@MetamodelPropertyField(role = EXPRESSION)
	CtExpression<Boolean> expression;

	@Override
	public void accept(CtVisitor visitor) {
		visitor.visitCtDo(this);
	}

	@Override
	public CtExpression<Boolean> getLoopingExpression() {
		return expression;
	}

	@Override
	public <T extends CtDo> T setLoopingExpression(CtExpression<Boolean> expression) {
		if (expression != null) {
			expression.setParent(this);
		}
		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, EXPRESSION, expression, this.expression);
		this.expression = expression;
		return (T) this;
	}

	@Override
	public CtDo clone() {
		return (CtDo) super.clone();
	}
}
