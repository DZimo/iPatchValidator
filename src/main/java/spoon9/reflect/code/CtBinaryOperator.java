/**
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.reflect.code;

import spoon9.reflect.annotations.PropertyGetter;
import spoon9.reflect.annotations.PropertySetter;

import static spoon9.reflect.path.CtRole.*;

/**
 * This interface defines a binary operator.
 *
 * Example:
 * <pre>
 *     // 3+4 is the binary expression
 *     int x = 3 + 4;
 * </pre>
 * @param <T>
 * 		Type of this expression
 */
public interface CtBinaryOperator<T> extends CtExpression<T> {

	/**
	 * Returns the left-hand operand.
	 */
	@PropertyGetter(role = LEFT_OPERAND)
	CtExpression<?> getLeftHandOperand();

	/**
	 * Returns the right-hand operand.
	 */
	@PropertyGetter(role = RIGHT_OPERAND)
	CtExpression<?> getRightHandOperand();

	/**
	 * Sets the left-hand operand.
	 */
	@PropertySetter(role = LEFT_OPERAND)
	<C extends CtBinaryOperator<T>> C setLeftHandOperand(CtExpression<?> expression);

	/**
	 * Sets the right-hand operand.
	 */
	@PropertySetter(role = RIGHT_OPERAND)
	<C extends CtBinaryOperator<T>> C setRightHandOperand(CtExpression<?> expression);

	/**
	 * Sets the kind of this binary operator.
	 */
	@PropertySetter(role = OPERATOR_KIND)
	<C extends CtBinaryOperator<T>> C setKind(BinaryOperatorKind kind);

	/**
	 * Gets the kind of this binary operator.
	 */
	@PropertyGetter(role = OPERATOR_KIND)
	BinaryOperatorKind getKind();

	@Override
	CtBinaryOperator<T> clone();
}
