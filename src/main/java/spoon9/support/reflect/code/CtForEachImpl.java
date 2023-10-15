/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.reflect.code;

import spoon9.reflect.annotations.MetamodelPropertyField;
import spoon9.reflect.code.CtExpression;
import spoon9.reflect.code.CtForEach;
import spoon9.reflect.code.CtLocalVariable;
import spoon9.reflect.visitor.CtVisitor;
import spoon9.reflect.path.CtRole;

public class CtForEachImpl extends CtLoopImpl implements CtForEach {
	private static final long serialVersionUID = 1L;

	@MetamodelPropertyField(role = CtRole.EXPRESSION)
    CtExpression<?> expression;

	@MetamodelPropertyField(role = CtRole.FOREACH_VARIABLE)
    CtLocalVariable<?> variable;

	@Override
	public void accept(CtVisitor visitor) {
		visitor.visitCtForEach(this);
	}

	@Override
	public CtExpression<?> getExpression() {
		return expression;
	}

	@Override
	public CtLocalVariable<?> getVariable() {
		return variable;
	}

	@Override
	public <T extends CtForEach> T setExpression(CtExpression<?> expression) {
		if (expression != null) {
			expression.setParent(this);
		}
		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, CtRole.EXPRESSION, expression, this.expression);
		this.expression = expression;
		return (T) this;
	}

	@Override
	public <T extends CtForEach> T setVariable(CtLocalVariable<?> variable) {
		if (variable != null) {
			variable.setParent(this);
		}
		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, CtRole.FOREACH_VARIABLE, variable, this.variable);
		this.variable = variable;
		return (T) this;
	}

	@Override
	public CtForEach clone() {
		return (CtForEach) super.clone();
	}
}
