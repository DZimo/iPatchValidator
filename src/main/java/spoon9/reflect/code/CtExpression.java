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
import spoon9.reflect.declaration.CtTypedElement;
import spoon9.reflect.reference.CtTypeReference;
import spoon9.template.TemplateParameter;

import java.util.List;

import static spoon9.reflect.path.CtRole.CAST;

/**
 * This abstract code element defines a typed expression.
 *
 * @param <T>
 * 		the "return type" of this expression
 */
public interface CtExpression<T> extends CtCodeElement, CtTypedElement<T>, TemplateParameter<T> {

	/**
	 * Returns the type casts if any.
	 */
	@PropertyGetter(role = CAST)
	List<CtTypeReference<?>> getTypeCasts();

	/**
	 * Sets the type casts.
	 */
	@PropertySetter(role = CAST)
	<C extends CtExpression<T>> C setTypeCasts(List<CtTypeReference<?>> types);

	/**
	 * Adds a type cast.
	 */
	@PropertySetter(role = CAST)
	<C extends CtExpression<T>> C addTypeCast(CtTypeReference<?> type);

	@Override
	CtExpression<T> clone();
}
