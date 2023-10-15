/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.reflect.declaration;

import spoon9.reflect.code.CtStatement;
import spoon9.reflect.reference.CtTypeReference;
import spoon9.support.DerivedProperty;
import spoon9.support.UnsettableProperty;
import spoon9.reflect.annotations.PropertyGetter;
import spoon9.reflect.annotations.PropertySetter;
import spoon9.reflect.path.CtRole;

import java.util.List;
import java.util.Set;

/**
 * This element represents a class declaration.
 *
 * <pre>
 *     // a class definition
 *     class Foo {
 *        int x;
 *     }
 * </pre>
 * @author Renaud Pawlak
 */
public interface CtClass<T> extends CtType<T>, CtStatement {
	/**
	 * Returns the anonymous blocks of this class.
	 * Derived from {@link #getTypeMembers()}
	 */
	@DerivedProperty
	@PropertyGetter(role = CtRole.ANNONYMOUS_EXECUTABLE)
	List<CtAnonymousExecutable> getAnonymousExecutables();

	/**
	 * Returns the constructor of the class that takes the given argument types.
	 *
	 * Derived from {@link #getTypeMembers()}
	 */
	@DerivedProperty
	@PropertyGetter(role = CtRole.CONSTRUCTOR)
	CtConstructor<T> getConstructor(CtTypeReference<?>... parameterTypes);

	/**
	 * Returns the constructors of this class. This includes the default
	 * constructor if this class has no constructors explicitly declared.
	 *
	 * Derived from {@link #getTypeMembers()}
	 */
	@DerivedProperty
	@PropertyGetter(role = CtRole.CONSTRUCTOR)
	Set<CtConstructor<T>> getConstructors();

	/**
	 * Sets the anonymous blocks of this class.
	 */
	@PropertySetter(role = CtRole.ANNONYMOUS_EXECUTABLE)
	<C extends CtClass<T>> C setAnonymousExecutables(List<CtAnonymousExecutable> e);

	/**
	 * Add an anonymous block to this class.
	 *
	 * @param e
	 * @return <tt>true</tt> if this element changed as a result of the call
	 */
	@PropertySetter(role = CtRole.ANNONYMOUS_EXECUTABLE)
	<C extends CtClass<T>> C addAnonymousExecutable(CtAnonymousExecutable e);

	/**
	 * Remove an anonymous block to this class.
	 *
	 * @param e
	 * @return <tt>true</tt> if this element changed as a result of the call
	 */
	@PropertySetter(role = CtRole.ANNONYMOUS_EXECUTABLE)
	boolean removeAnonymousExecutable(CtAnonymousExecutable e);

	/**
	 * Sets the constructors for this class.
	 */
	@PropertySetter(role = CtRole.CONSTRUCTOR)
	<C extends CtClass<T>> C setConstructors(Set<CtConstructor<T>> constructors);

	/**
	 * Adds a constructor to this class.
	 */
	@PropertySetter(role = CtRole.CONSTRUCTOR)
	<C extends CtClass<T>> C addConstructor(CtConstructor<T> constructor);

	/**
	 * Removes a constructor from this class.
	 */
	@PropertySetter(role = CtRole.CONSTRUCTOR)
	void removeConstructor(CtConstructor<T> constructor);

	/**
	 * Return {@code true} if the referenced type is a anonymous type
	 */
	@Override
	boolean isAnonymous();

	@Override
	CtClass<T> clone();

	/**
	 * Creates an instance of this class.
	 *
	 * Requirements:
	 * - the class must have a default constructor.
	 * - All dependencies (superclass, super-interfaces, imports) must be in the classpath,
	 * because the code is actually compiled (otherwise an exception is thrown)
	 *
	 * If the class has super-interfaces, the object can be cast to one of them.
	 * Otherwise, if the class has no super-interfaces, the methods can only be called with reflection.
	 *
	 * This instance is meant to be used for quick-testing, it uses a throwable classloader that
	 * will be garbage-collected with the instance.
	 */
	T newInstance();

	@Override
	@UnsettableProperty
	<C extends CtStatement> C setLabel(String label);
}
