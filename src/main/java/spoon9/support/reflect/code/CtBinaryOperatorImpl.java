/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.reflect.code;

import spoon9.reflect.annotations.MetamodelPropertyField;
import spoon9.reflect.code.BinaryOperatorKind;
import spoon9.reflect.code.CtBinaryOperator;
import spoon9.reflect.code.CtExpression;
import spoon9.reflect.visitor.CtVisitor;
import spoon9.reflect.path.CtRole;

public class CtBinaryOperatorImpl<T> extends CtExpressionImpl<T> implements CtBinaryOperator<T> {
	private static final long serialVersionUID = 1L;

	@MetamodelPropertyField(role = CtRole.OPERATOR_KIND)
    BinaryOperatorKind kind;

	@MetamodelPropertyField(role = CtRole.LEFT_OPERAND)
    CtExpression<?> leftHandOperand;

	@MetamodelPropertyField(role = CtRole.RIGHT_OPERAND)
	CtExpression<?> rightHandOperand;

	@Override
	public void accept(CtVisitor visitor) {
		visitor.visitCtBinaryOperator(this);
	}

	@Override
	public CtExpression<?> getLeftHandOperand() {
		return leftHandOperand;
	}

	@Override
	public CtExpression<?> getRightHandOperand() {
		return rightHandOperand;
	}

	@Override
	public <C extends CtBinaryOperator<T>> C setLeftHandOperand(CtExpression<?> expression) {
		if (expression != null) {
			expression.setParent(this);
		}
		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, CtRole.LEFT_OPERAND, expression, this.leftHandOperand);
		leftHandOperand = expression;
		return (C) this;
	}

	@Override
	public <C extends CtBinaryOperator<T>> C setRightHandOperand(CtExpression<?> expression) {
		if (expression != null) {
			expression.setParent(this);
		}
		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, CtRole.RIGHT_OPERAND, expression, this.rightHandOperand);
		rightHandOperand = expression;
		return (C) this;
	}

	@Override
	public <C extends CtBinaryOperator<T>> C setKind(BinaryOperatorKind kind) {
		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, CtRole.OPERATOR_KIND, kind, this.kind);
		this.kind = kind;
		return (C) this;
	}

	@Override
	public BinaryOperatorKind getKind() {
		return kind;
	}

	@Override
	public CtBinaryOperator<T> clone() {
		return (CtBinaryOperator<T>) super.clone();
	}
}
