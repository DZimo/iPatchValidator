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

import static spoon9.reflect.path.CtRole.BODY;
import static spoon9.reflect.path.CtRole.EXPRESSION;


/**
 * This code element defines a <code>synchronized</code> statement.
 *
 * Example:
 * <pre>
 *    java.util.List l = new java.util.ArrayList();
 *    synchronized(l) {
 *     	System.out.println("foo");
 *    }
 * </pre>
 */
public interface CtSynchronized extends CtStatement {
	/**
	 * Gets the expression that defines the monitored object if any.
	 *
	 * @return the monitored object if defined, null otherwise
	 */
	@PropertyGetter(role = EXPRESSION)
	CtExpression<?> getExpression();

	/**
	 * Sets the expression that defines the monitored.
	 */
	@PropertySetter(role = EXPRESSION)
	<T extends CtSynchronized> T setExpression(CtExpression<?> expression);

	/**
	 * Gets the synchronized block.
	 */
	@PropertyGetter(role = BODY)
	CtBlock<?> getBlock();

	/**
	 * Sets the synchronized block.
	 */
	@PropertySetter(role = BODY)
	<T extends CtSynchronized> T setBlock(CtBlock<?> block);

	@Override
	CtSynchronized clone();
}
