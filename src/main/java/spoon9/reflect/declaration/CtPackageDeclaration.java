/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.reflect.declaration;

import spoon9.reflect.annotations.PropertyGetter;
import spoon9.reflect.annotations.PropertySetter;
import spoon9.reflect.path.CtRole;
import spoon9.reflect.reference.CtPackageReference;

/**
 * This element represents an package declaration.
 *
 * Example:
 * <pre>
 *     package your.nice.package.name;
 * </pre>
 *
 */
public interface CtPackageDeclaration extends CtElement {

	/**
	 * Returns the reference to the package.
	 */
	@PropertyGetter(role = CtRole.PACKAGE_REF)
    CtPackageReference getReference();

	/**
	 * Sets the reference to the package.
	 */
	@PropertySetter(role = CtRole.PACKAGE_REF)
	CtPackageDeclaration setReference(CtPackageReference reference);

	@Override
	CtPackageDeclaration clone();
}
