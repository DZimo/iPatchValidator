/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.reflect.code;

import spoon9.reflect.reference.CtTypeReference;
import spoon9.reflect.reference.CtVariableReference;
import spoon9.support.DerivedProperty;
import spoon9.reflect.annotations.PropertyGetter;
import spoon9.reflect.annotations.PropertySetter;

import static spoon9.reflect.path.CtRole.VARIABLE;

/**
 * This code element defines an access to a variable (read and write).
 *
 *
 * @param <T>
 * 		type of the variable
 */
public interface CtVariableAccess<T> extends CtExpression<T> {
	/**
	 * Gets the reference to the accessed variable.
	 */
	@PropertyGetter(role = VARIABLE)
	CtVariableReference<T> getVariable();

	/**
	 * Sets the reference to the accessed variable.
	 */
	@PropertySetter(role = VARIABLE)
	<C extends CtVariableAccess<T>> C setVariable(CtVariableReference<T> variable);

	@Override
	CtVariableAccess<T> clone();

	@Override
	@DerivedProperty
	CtTypeReference<T> getType();
}
