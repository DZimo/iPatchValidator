/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.reflect.code;

import spoon9.reflect.annotations.PropertyGetter;
import spoon9.reflect.annotations.PropertySetter;

import static spoon9.reflect.path.CtRole.BODY;
import static spoon9.reflect.path.CtRole.PARAMETER;


/**
 * This code element defines a <code>catch</code> of a <code>try</code>.
 *
 * @see CtTry
 */
public interface CtCatch extends CtCodeElement, CtBodyHolder {

	/**
	 * Gets the catch's parameter (a throwable).
	 */
	@PropertyGetter(role = PARAMETER)
	CtCatchVariable<? extends Throwable> getParameter();

	/**
	 * Sets the catch's parameter (a throwable).
	 */
	@PropertySetter(role = PARAMETER)
	<T extends CtCatch> T setParameter(CtCatchVariable<? extends Throwable> parameter);

	/**
	 * Gets the catch's body.
	 */
	@Override
	@PropertyGetter(role = BODY)
	CtBlock<?> getBody();

	@Override
	CtCatch clone();
}
