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
import spoon9.reflect.declaration.CtField;

import static spoon9.reflect.path.CtRole.ASSIGNMENT;

/**
 * Represents the right hand side of an assignment
 *
 * See {@link CtAssignment}, {@link CtLocalVariable}, {@link CtField}
 */
public interface CtRHSReceiver<A> {
	/**
	 * Returns the right-hand side of the "=" operator.
	 */
	@PropertyGetter(role = ASSIGNMENT)
	CtExpression<A> getAssignment();

	/**
	 * Sets the right-hand side expression (RHS) of the "=" operator.
	 */
	@PropertySetter(role = ASSIGNMENT)
	<T extends CtRHSReceiver<A>> T setAssignment(CtExpression<A> assignment);
}
