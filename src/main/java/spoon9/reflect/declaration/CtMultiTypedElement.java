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

import java.util.List;

import static spoon9.reflect.path.CtRole.MULTI_TYPE;

/**
 * Defined an element with several types.
 */
public interface CtMultiTypedElement extends CtElement {
	/**
	 * Adds a type for the element.
	 */
	@PropertySetter(role = MULTI_TYPE)
	<T extends CtMultiTypedElement> T addMultiType(CtTypeReference<?> ref);

	/**
	 * Removes a type for the element.
	 */
	@PropertySetter(role = MULTI_TYPE)
	boolean removeMultiType(CtTypeReference<?> ref);

	/**
	 * Gets all types of the element.
	 */
	@PropertyGetter(role = MULTI_TYPE)
	List<CtTypeReference<?>> getMultiTypes();

	/**
	 * Adds a type for the element.
	 */
	@PropertySetter(role = MULTI_TYPE)
	<T extends CtMultiTypedElement> T setMultiTypes(List<CtTypeReference<?>> types);
}
