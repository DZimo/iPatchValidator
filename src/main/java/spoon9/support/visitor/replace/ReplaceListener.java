/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.visitor.replace;

import spoon9.reflect.declaration.CtElement;

/** Interface for the AST node replacement infrastructure. The implementing subclasses are generated in internal classes in {@link ReplacementVisitor} */
public interface ReplaceListener<T extends CtElement> {
	void set(T replace);
}
