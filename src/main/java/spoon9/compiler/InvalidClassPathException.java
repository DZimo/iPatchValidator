/**
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.compiler;

import spoon9.SpoonException;

public class InvalidClassPathException extends SpoonException {
	private static final long serialVersionUID = 1L;
	public InvalidClassPathException() {
	}
	public InvalidClassPathException(String msg) {
		super(msg);
	}
	public InvalidClassPathException(Throwable e) {
		super(e);
	}
	public InvalidClassPathException(String msg, Exception e) {
		super(msg, e);
	}
}
