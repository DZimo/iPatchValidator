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
import spoon9.reflect.declaration.CtElement;

import static spoon9.reflect.path.CtRole.BODY;

/**
 * This abstract code element defines an element, which contains a body
 */
public interface CtBodyHolder extends CtElement {

	/**
	 * Gets the body of this element
	 */
	@PropertyGetter(role = BODY)
	CtStatement getBody();

	/**
	 * Sets the body of this element.
	 * If body is not a block, it is wrapped in a CtBlock which is semantically equivalent and eases transformation afterwards if required.
	 */
	@PropertySetter(role = BODY)
	<T extends CtBodyHolder> T setBody(CtStatement body);
}
