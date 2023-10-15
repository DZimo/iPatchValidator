/**
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.reflect.declaration;

import spoon9.reflect.annotations.PropertyGetter;
import spoon9.reflect.annotations.PropertySetter;
import spoon9.reflect.reference.CtTypeReference;

import static spoon9.reflect.path.CtRole.TYPE;

/**
 * This abstract element defines a typed element.
 */
public interface CtTypedElement<T> extends CtElement {
	/**
	 * Gets this element's type.
	 */
	@PropertyGetter(role = TYPE)
	CtTypeReference<T> getType();

	/**
	 * Sets this element's type.
	 */
	@PropertySetter(role = TYPE)
	<C extends CtTypedElement> C setType(CtTypeReference<T> type);
}
