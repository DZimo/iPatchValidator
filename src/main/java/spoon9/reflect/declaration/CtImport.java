/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.reflect.declaration;

import spoon9.reflect.annotations.PropertyGetter;
import spoon9.reflect.annotations.PropertySetter;
import spoon9.reflect.reference.CtReference;
import spoon9.reflect.visitor.CtImportVisitor;
import spoon9.support.DerivedProperty;
import spoon9.reflect.path.CtRole;
import spoon9.reflect.reference.*;
import spoon9.support.reflect.reference.CtTypeMemberWildcardImportReferenceImpl;

/**
 * This element represents an import declaration.
 * The given reference should be of type {@link CtTypeReference},
 * {@link CtPackageReference}, {@link CtExecutableReference},
 * {@link CtFieldReference} or {@link CtTypeMemberWildcardImportReferenceImpl}
 *
 * <pre>
 *     import static import static org.junit.Assert.*;
 * </pre>
 *
 * It will be ignored in all other cases.
 *
 * Example:
 * <pre>
 *     import java.io.File;
 * </pre>
 */
public interface CtImport extends CtElement {
	/**
	 * Returns the kind of import (see {@link CtImportKind})
	 */
	@DerivedProperty
	CtImportKind getImportKind();

	/**
	 * Returns the reference of the import.
	 */
	@PropertyGetter(role = CtRole.IMPORT_REFERENCE)
    CtReference getReference();

	/**
	 * Sets the reference of the import.
	 * The import kind will be computed based on this reference.
	 */
	@PropertySetter(role = CtRole.IMPORT_REFERENCE)
	<T extends CtImport> T setReference(CtReference reference);

	/**
	 * Accepts a {@link CtImportVisitor}
	 */
	void accept(CtImportVisitor visitor);

	@Override
	CtImport clone();
}
