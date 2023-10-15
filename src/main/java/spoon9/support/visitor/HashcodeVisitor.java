/**
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.visitor;

import spoon9.reflect.declaration.CtElement;
import spoon9.reflect.declaration.CtImport;
import spoon9.reflect.declaration.CtNamedElement;
import spoon9.reflect.reference.CtReference;
import spoon9.reflect.visitor.CtInheritanceScanner;

/** Responsible for computing CtElement.hashCode().
 * Version that is fast and compatible with EqualVisitor
 */
public class HashcodeVisitor extends CtInheritanceScanner {

	private int hashCode = 0;

	@Override
	public void scanCtNamedElement(CtNamedElement e) {
		if (e.getSimpleName() != null) {
			hashCode += e.getSimpleName().hashCode();
		}
	}

	@Override
	public void scanCtReference(CtReference e) {
		hashCode += e.getSimpleName().hashCode();
	}

	@Override
	public void visitCtImport(CtImport e) {
		if (e.getReference() != null) {
			scanCtReference(e.getReference());
		}
	}

	@Override
	public void scan(CtElement element) {
		hashCode += 1;
		super.scan(element);
	}

	public int getHasCode() {
		return hashCode;
	}
}
