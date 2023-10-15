/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.reflect.visitor.filter;

import spoon9.reflect.code.CtCFlowBreak;
import spoon9.reflect.code.CtReturn;
import spoon9.reflect.code.CtThrow;
import spoon9.reflect.visitor.Filter;

/**
 * This simple filter matches all the occurrences of a return or a throw
 * statement (end of execution flow).
 */
public class ReturnOrThrowFilter implements Filter<CtCFlowBreak> {

	@Override
	public boolean matches(CtCFlowBreak cflowBreak) {
		return (cflowBreak instanceof CtReturn)
				|| (cflowBreak instanceof CtThrow);
	}
}
