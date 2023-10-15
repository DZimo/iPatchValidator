/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.reflect.visitor;

import spoon9.reflect.declaration.CtElement;
import spoon9.reflect.declaration.CtImport;
import spoon9.reflect.reference.CtReference;
import spoon9.support.Experimental;

import java.util.Set;

/**
 * Used to compute the imports required to write readable code with no fully qualified names.
 * The import scanner API might still change in future release, that's why it is marked as experimental.
 */
@Experimental
public interface ImportScanner {

	/**
	 * Computes import of a {@link CtElement}
	 */
	void computeImports(CtElement element);

	/**
	 * Use computeImports or computeAllImports before getting the different imports.
	 *
	 * @return the list of computed imports or an empty collection if not imports has been computed.
	 */
	Set<CtImport> getAllImports();

	/**
	 * Checks if the type is already imported.
	 */
	boolean isImported(CtReference ref);

	/**
	 * Specify the original imports to use before computing new imports.
	 */
	void initWithImports(Iterable<CtImport> importCollection);
}
