/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2023 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) or the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.reflect.reference;

import spoon9.reflect.annotations.PropertyGetter;
import spoon9.reflect.annotations.PropertySetter;
import spoon9.reflect.code.CtComment;
import spoon9.reflect.declaration.CtElement;
import spoon9.reflect.path.CtRole;
import spoon9.support.DerivedProperty;
import spoon9.support.UnsettableProperty;

import java.util.List;


/**
 * This is the root interface for named program element references, such as fields, types,
 * variables, and so on.
 * If a reference refers to an element in the shadow model, all introspection methods
 * fall back to reflection where possible, but not all information might be available.
 *
 * @see CtElement
 */
public interface CtReference extends CtElement {

	/**
	 * Gets the simple name of referenced element.
	 */
	@PropertyGetter(role = CtRole.NAME)
	String getSimpleName();

	/**
	 * Sets the name of referenced element.
	 */
	@PropertySetter(role = CtRole.NAME)
	<T extends CtReference> T setSimpleName(String simpleName);

	/**
	 * Returns the declaration that corresponds to the referenced element only
	 * if the declaration is in the analyzed source files.
	 * It is strongly advised to use the more robust {@link CtTypeReference#getTypeDeclaration()} and {@link CtExecutableReference#getExecutableDeclaration()} that never return null.
	 * @return referenced element or null if element is not in the source path (aka input resource).
	 */
	@DerivedProperty
	CtElement getDeclaration();

	@Override
	CtReference clone();

	/** comments are not possible for references */
	@Override
	@UnsettableProperty
	<E extends CtElement> E setComments(List<CtComment> comments);
}