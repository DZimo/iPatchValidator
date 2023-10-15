/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2023 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) or the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.reflect.visitor;

import spoon9.experimental.CtUnresolvedImport;
import spoon9.reflect.reference.CtExecutableReference;
import spoon9.reflect.reference.CtFieldReference;
import spoon9.reflect.reference.CtPackageReference;
import spoon9.reflect.reference.CtTypeReference;
import spoon9.reflect.reference.CtTypeMemberWildcardImportReference;

/**
 * Provides an empty implementation of {@link CtImportVisitor}.
 */
public class CtAbstractImportVisitor implements CtImportVisitor {

	@Override
	public <T> void visitTypeImport(CtTypeReference<T> typeReference) {
	}

	@Override
	public <T> void visitMethodImport(CtExecutableReference<T> executableReference) {
	}

	@Override
	public <T> void visitFieldImport(CtFieldReference<T> fieldReference) {
	}

	@Override
	public void visitAllTypesImport(CtPackageReference packageReference) {
	}

	@Override
	public <T> void visitAllStaticMembersImport(CtTypeMemberWildcardImportReference typeReference) {
	}
	@Override
	public <T> void visitUnresolvedImport(CtUnresolvedImport unresolvedImport) {
	}
}
