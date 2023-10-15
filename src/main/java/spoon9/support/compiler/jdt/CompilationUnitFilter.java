/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.compiler.jdt;

import spoon9.SpoonModelBuilder;
import spoon9.compiler.builder.JDTBuilder;
import spoon9.reflect.CtModel;
import spoon9.reflect.cu.CompilationUnit;

/**
 * This interface is used by instances of {@link SpoonModelBuilder} to
 * exclude particular {@link CompilationUnit}s while
 * generating a {@link CtModel} with
 * {@link SpoonModelBuilder#build(JDTBuilder)}.
 *
 * This interface is useful for large sized software system where traversing
 * all files takes several minutes. Unlike the approach of adding a subset of
 * the files to examine, filtering unwanted files produces a more precise
 * {@link CtModel} since all files will be compiled (but not
 * transformed).
 */
public interface CompilationUnitFilter {

	/**
	 * Tests if the file with path {@code path} should be excluded from the
     * {@link CtModel} create by
     * {@link SpoonModelBuilder#build(JDTBuilder)}.
	 *
	 * @param path
	 *      Path to the file that may or may not be excluded.
	 * @return {@code true} if and only if {@code path} should be excluded,
	 *         {@code false} otherwise.
	 */
	boolean exclude(String path);
}
