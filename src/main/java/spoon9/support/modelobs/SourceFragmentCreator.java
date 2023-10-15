/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2023 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) or the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.modelobs;

import spoon9.reflect.cu.CompilationUnit;
import spoon9.reflect.cu.position.NoSourcePosition;
import spoon9.reflect.declaration.CtElement;
import spoon9.reflect.path.CtRole;
import spoon9.support.sniper.internal.ElementSourceFragment;

/**
 * A {@link ChangeCollector}, which builds a tree of {@link ElementSourceFragment}s of {@link CompilationUnit} of the modified element
 * lazily just before the element is changed
 */
public class SourceFragmentCreator extends ChangeCollector {
	@Override
	protected void onChange(CtElement currentElement, CtRole role) {
		if (!currentElement.isParentInitialized()) {
			//parent is not initialized. It is just creation of a temporary element
			//ignore such "change"
			return;
		}
		CompilationUnit cu = currentElement.getPosition().getCompilationUnit();
		if (!(cu instanceof NoSourcePosition.NullCompilationUnit)) {
			//getOriginalSourceFragment is not only a getter, it actually
			//builds a tree of SourceFragments of compilation unit of the modified element
			cu.getOriginalSourceFragment();
		}
		super.onChange(currentElement, role);
	}
}
