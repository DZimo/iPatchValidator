/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.reflect.declaration;

import spoon9.reflect.reference.CtTypeReference;
import spoon9.reflect.annotations.PropertyGetter;
import spoon9.support.UnsettableProperty;
import spoon9.reflect.path.CtRole;

/**
 * This element defines a constructor declaration.
 */
public interface CtConstructor<T> extends CtExecutable<T>, CtTypeMember, CtFormalTypeDeclarer, CtShadowable {

	/**
	 * Always returns "&lt;init&gt;".
	 */
	@Override
	@PropertyGetter(role = CtRole.NAME)
	String getSimpleName();

	@Override
	CtConstructor<T> clone();

	@Override
	@UnsettableProperty
	<C extends CtTypedElement> C setType(CtTypeReference<T> type);

	@Override
	@UnsettableProperty
	<C extends CtNamedElement> C setSimpleName(String simpleName);
}
