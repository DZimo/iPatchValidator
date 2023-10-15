/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2023 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) or the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.reflect.code;

import spoon9.reflect.code.CtTextBlock;
import spoon9.reflect.visitor.CtVisitor;

public class CtTextBlockImpl extends CtLiteralImpl<String> implements CtTextBlock {
	private static final long serialVersionUID = 1L;

	@Override
	public CtTextBlock clone() {
		return (CtTextBlock) super.clone();
	}

	@Override
	public void accept(CtVisitor visitor) {
		visitor.visitCtTextBlock(this);
	}
}
