/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.reflect.code;

import spoon9.reflect.reference.CtFieldReference;
import spoon9.reflect.annotations.PropertyGetter;

import static spoon9.reflect.path.CtRole.VARIABLE;

/**
 * This code element defines an access to a field variable (read and write)
 *
 * @param <T>
 * 		Type of this field
 */
public interface CtFieldAccess<T> extends CtVariableAccess<T>, CtTargetedExpression<T, CtExpression<?>> {
	@Override
	@PropertyGetter(role = VARIABLE)
	CtFieldReference<T> getVariable();

	@Override
	CtFieldAccess<T> clone();
}
