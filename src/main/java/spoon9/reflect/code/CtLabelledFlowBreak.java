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
import spoon9.support.DerivedProperty;

import static spoon9.reflect.path.CtRole.TARGET_LABEL;

/**
 * This abstract code element represents all the statements that break the
 * control flow of the program and which can support a label.
 */
public interface CtLabelledFlowBreak extends CtCFlowBreak {
	/**
	 * Gets the label from which the control flow breaks (null if no label
	 * defined).
	 */
	@PropertyGetter(role = TARGET_LABEL)
	String getTargetLabel();

	/**
	 * Sets the label from which the control flow breaks (null if no label
	 * defined).
	 */
	@PropertySetter(role = TARGET_LABEL)
	<T extends CtLabelledFlowBreak> T setTargetLabel(String targetLabel);

	@DerivedProperty
	CtStatement getLabelledStatement();
}
