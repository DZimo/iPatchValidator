/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2023 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) or the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.reflect.code;

import spoon9.reflect.annotations.PropertyGetter;
import spoon9.reflect.annotations.PropertySetter;

import static spoon9.reflect.path.CtRole.EXPRESSION;

/**
 * This code element defines a <code>while</code> loop.
 *
 * Example:
 * <pre>
 *     int x = 0;
 *     while (x!=10) {
 *         x=x+1;
 *     };
 * </pre>
 *
 */
public interface CtWhile extends CtLoop {
	/**
	 * Gets the looping boolean test expression.
	 */
	@PropertyGetter(role = EXPRESSION)
	CtExpression<Boolean> getLoopingExpression();

	/**
	 * Sets the looping boolean test expression.
	 */
	@PropertySetter(role = EXPRESSION)
	<T extends CtWhile> T setLoopingExpression(CtExpression<Boolean> expression);

	@Override
	CtWhile clone();
}
