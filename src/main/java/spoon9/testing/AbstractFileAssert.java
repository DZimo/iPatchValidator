/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2023 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) or the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.testing;

import spoon9.reflect.declaration.CtType;
import spoon9.reflect.factory.Factory;

import java.io.File;
import java.util.List;

import static spoon9.testing.utils.Check.assertExists;
import static spoon9.testing.utils.Check.assertNotNull;
import static spoon9.testing.utils.ModelUtils.build;
import static spoon9.testing.utils.ProcessorUtils.process;

public abstract class AbstractFileAssert<T extends AbstractFileAssert<T>> extends AbstractAssert<T, File> {
	public AbstractFileAssert(File actual, Class<?> selfType) {
		super(actual, selfType);
	}

	/**
	 * Verifies that the actual value is equal to the given one.
	 *
	 * @param expected
	 * 		The expected location of source code.
	 * @return {@code this} assertion object.
	 */
	public T isEqualTo(String expected) {
		return isEqualTo(new File(expected));
	}

	/**
	 * Verifies that the actual value is equal to the given one.
	 *
	 * @param expected
	 * 		The expected location of source code.
	 * @return {@code this} assertion object.
	 */
	public T isEqualTo(File expected) {
		assertNotNull(expected);
		assertExists(expected);

		final Factory actualFactory = build(actual);
		final Factory expectedFactory = build(expected);

		process(actualFactory, processors);
		final List<CtType<?>> allActual = actualFactory.Type().getAll();
		final List<CtType<?>> allExpected = expectedFactory.Type().getAll();
		for (int i = 0; i < allActual.size(); i++) {
			final CtType<?> currentActual = allActual.get(i);
			final CtType<?> currentExpected = allExpected.get(i);
			if (!currentActual.equals(currentExpected)) {
				throw new AssertionError(String.format("%1$s and %2$s aren't equals.", currentActual.getQualifiedName(), currentExpected.getQualifiedName()));
			}
		}
		return this.myself;
	}
}
