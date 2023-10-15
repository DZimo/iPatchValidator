/**
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.reflect.reference;

import spoon9.reflect.code.CtCatchVariable;
import spoon9.support.DerivedProperty;

/**
 * This interface defines a reference to {@link CtCatchVariable}.
 */
public interface CtCatchVariableReference<T> extends CtVariableReference<T> {
	// overriding the return type
	@Override
	@DerivedProperty
	CtCatchVariable<T> getDeclaration();

	@Override
	CtCatchVariableReference<T> clone();
}
