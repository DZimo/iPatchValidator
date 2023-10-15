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

import java.util.List;

/**
 * This abstract element defines a declaration that accepts formal type
 * parameters (aka generics), such as a CtType (<code>class A&lt;E&gt;</code>), CtMethod or CtConstructor.
 */
public interface CtFormalTypeDeclarer extends CtTypeMember {

	/**
	 * Returns the formal type parameters of this generic element.
	 */
	@PropertyGetter(role = CtRole.TYPE_PARAMETER)
	List<CtTypeParameter> getFormalCtTypeParameters();

	/**
	 * Sets the type parameters of this generic element.
	 */
	@PropertySetter(role = CtRole.TYPE_PARAMETER)
	<T extends CtFormalTypeDeclarer> T setFormalCtTypeParameters(List<CtTypeParameter> formalTypeParameters);

	/**
	 * Add a type parameter to this generic element.
	 */
	@PropertySetter(role = CtRole.TYPE_PARAMETER)
	<T extends CtFormalTypeDeclarer> T addFormalCtTypeParameter(CtTypeParameter formalTypeParameter);

	/**
	 * Add a type parameter at a specific position.
	 *
	 * @param position Position to insert the type parameter at
	 * @param formalTypeParameter The type parameter to insert
	 * @return The receiver
	 */
	@PropertySetter(role = CtRole.TYPE_PARAMETER)
	<T extends CtFormalTypeDeclarer> T addFormalCtTypeParameterAt(int position, CtTypeParameter formalTypeParameter);

	/**
	 * Removes a type parameters from this generic element.
	 */
	@PropertySetter(role = CtRole.TYPE_PARAMETER)
	boolean removeFormalCtTypeParameter(CtTypeParameter formalTypeParameter);
}
