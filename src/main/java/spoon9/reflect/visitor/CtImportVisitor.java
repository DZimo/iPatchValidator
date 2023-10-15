/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.reflect.visitor;

import spoon9.experimental.CtUnresolvedImport;
import spoon9.reflect.reference.CtExecutableReference;
import spoon9.reflect.reference.CtFieldReference;
import spoon9.reflect.reference.CtPackageReference;
import spoon9.reflect.reference.CtTypeReference;
import spoon9.reflect.reference.CtTypeMemberWildcardImportReference;

/**
 * This interface defines the visitor for the different types of CtImport
 */
public interface CtImportVisitor {
	/**
	 * Called for import like:
	 * <code>import apackage.Type;</code>
	 */
	<T> void visitTypeImport(CtTypeReference<T> typeReference);
	/**
	 * Called for import like:
	 * <code>import apackage.Type.staticMethod;</code>
	 */
	<T> void visitMethodImport(CtExecutableReference<T> executableReference);
	/**
	 * Called for import like:
	 * <code>import apackage.Type.staticField;</code>
	 */
	<T> void visitFieldImport(CtFieldReference<T> fieldReference);
	/**
	 * Called for import like:
	 * <code>import apackage.*;</code>
	 */
	void visitAllTypesImport(CtPackageReference packageReference);
	/**
	 * Called for import like:
	 * <code>import apackage.Type.*;</code>
	 */
	<T> void visitAllStaticMembersImport(CtTypeMemberWildcardImportReference typeReference);

	/**
	 * Called for unresolved import
	 */
	<T> void visitUnresolvedImport(CtUnresolvedImport ctUnresolvedImport);
}
