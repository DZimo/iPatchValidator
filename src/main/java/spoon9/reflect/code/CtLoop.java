/**
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.reflect.code;

import spoon9.reflect.annotations.PropertyGetter;
import spoon9.template.TemplateParameter;

import static spoon9.reflect.path.CtRole.BODY;

/**
 * This abstract code element defines a loop.
 */
public interface CtLoop extends CtStatement, TemplateParameter<Void>, CtBodyHolder {

	/**
	 * Gets the body of this loop.
	 */
	@Override
	@PropertyGetter(role = BODY)
	CtStatement getBody();

	@Override
	CtLoop clone();
}
