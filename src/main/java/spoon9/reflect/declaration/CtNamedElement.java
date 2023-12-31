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
import spoon9.reflect.reference.CtReference;
import spoon9.support.DerivedProperty;

import static spoon9.reflect.path.CtRole.NAME;

/**
 * Declares an element that has a name (a class, a method, a variable, etc).
 * Hence, all subclasses of CtNamedElement are in package "declaration".
 * Note that references don't define elements, hence are not under CtNamedElement
 * even if they also have methods set/getSimpleName.
 */
public interface CtNamedElement extends CtElement {
	/**
	 * Returns the simple (unqualified) name of this element.
	 */
	@PropertyGetter(role = NAME)
	String getSimpleName();

	/**
	 * Sets the simple (unqualified) name of this element.
	 */
	@PropertySetter(role = NAME)
	<T extends CtNamedElement> T setSimpleName(String simpleName);

	/**
	 * Returns the corresponding reference.
	 */
	@DerivedProperty
	CtReference getReference();

	@Override
	CtNamedElement clone();
}
