/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.reflect.code;

import spoon9.reflect.declaration.ParentNotInitializedException;
import spoon9.reflect.annotations.PropertyGetter;
import spoon9.reflect.annotations.PropertySetter;

import static spoon9.reflect.path.CtRole.LABEL;

/**
 * This abstract code element represents all the statements, which can be part
 * of a block.
 *
 * @see CtBlock
 */
public interface CtStatement extends CtCodeElement {

	/**
	 * Inserts a statement after the current statement.
	 */
	<T extends CtStatement> T insertAfter(CtStatement statement) throws ParentNotInitializedException;

	/**
	 * Inserts a statement list before the current statement.
	 */
	<T extends CtStatement> T insertAfter(CtStatementList statements) throws ParentNotInitializedException;

	/**
	 * Inserts a statement given as parameter before the current statement
	 * (this).
	 */
	<T extends CtStatement> T insertBefore(CtStatement statement) throws ParentNotInitializedException;

	/**
	 * Inserts a statement list before the current statement.
	 */
	<T extends CtStatement> T insertBefore(CtStatementList statements) throws ParentNotInitializedException;

	/**
	 * Gets the label of this statement if defined.
	 *
	 * @return the label's name (null if undefined)
	 */
	@PropertyGetter(role = LABEL)
	String getLabel();

	/**
	 * Sets the label of this statement.
	 */
	@PropertySetter(role = LABEL)
	<T extends CtStatement> T setLabel(String label);

	/**
	 * Comments the statement (eg `// call()`). Implemented as a replacement of the statement with a CtComment having the statement as text.
	 */
	void comment();

	@Override
	CtStatement clone();
}
