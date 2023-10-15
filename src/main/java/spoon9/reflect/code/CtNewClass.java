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
import spoon9.reflect.declaration.CtClass;
import spoon9.reflect.reference.CtActualTypeContainer;
import spoon9.reflect.reference.CtExecutableReference;
import spoon9.reflect.reference.CtTypeReference;
import spoon9.support.DerivedProperty;

import java.util.List;

import static spoon9.reflect.path.CtRole.NESTED_TYPE;
import static spoon9.reflect.path.CtRole.TYPE_ARGUMENT;

/**
 * This code element represents the creation of a anonymous class.
 *
* Example:
 * <pre>
 *    // an anonymous class creation
 *    Runnable r = new Runnable() {
 *     	&#64;Override
 *     	public void run() {
 *     	  System.out.println("foo");
 *     	}
 *    };
 * </pre>
 * @param <T>
 * 		created type
 */
public interface CtNewClass<T> extends CtConstructorCall<T> {
	/**
	 * Delegate to the executable reference of the new class.
	 *
	 * @see CtExecutableReference#getActualTypeArguments()
	 */
	@Override
	@DerivedProperty
	@PropertyGetter(role = TYPE_ARGUMENT)
	List<CtTypeReference<?>> getActualTypeArguments();

	/**
	 * Delegate to the executable reference of the new class.
	 *
	 * @see CtExecutableReference#getActualTypeArguments()
	 */
	@Override
	@PropertySetter(role = TYPE_ARGUMENT)
	<T extends CtActualTypeContainer> T setActualTypeArguments(List<? extends CtTypeReference<?>> actualTypeArguments);

	/**
	 * Delegate to the executable reference of the new class.
	 *
	 * @see CtExecutableReference#getActualTypeArguments()
	 */
	@Override
	@PropertySetter(role = TYPE_ARGUMENT)
	<T extends CtActualTypeContainer> T addActualTypeArgument(CtTypeReference<?> actualTypeArgument);

	/**
	 * Gets the created class.
	 */
	@PropertyGetter(role = NESTED_TYPE)
	CtClass<?> getAnonymousClass();

	/**
	 * Sets the created class.
	 */
	@PropertySetter(role = NESTED_TYPE)
	<N extends CtNewClass> N setAnonymousClass(CtClass<?> anonymousClass);

	@Override
	CtNewClass<T> clone();
}
