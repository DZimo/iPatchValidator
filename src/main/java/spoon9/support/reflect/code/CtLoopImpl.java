/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.reflect.code;

import spoon9.reflect.annotations.MetamodelPropertyField;
import spoon9.reflect.code.CtBlock;
import spoon9.reflect.code.CtBodyHolder;
import spoon9.reflect.code.CtCodeElement;
import spoon9.reflect.code.CtLoop;
import spoon9.reflect.code.CtStatement;
import spoon9.reflect.declaration.CtType;
import spoon9.reflect.path.CtRole;

public abstract class CtLoopImpl extends CtStatementImpl implements CtLoop {
	private static final long serialVersionUID = 1L;

	@MetamodelPropertyField(role = CtRole.BODY)
    CtStatement body;

	@Override
	public CtStatement getBody() {
		return body;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends CtBodyHolder> T setBody(CtStatement statement) {
		if (statement != null) {
			CtBlock<?> body = getFactory().Code().getOrCreateCtBlock(statement);
			getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, CtRole.BODY, body, this.body);
			if (body != null) {
				body.setParent(this);
			}
			this.body = body;
		} else {
			getFactory().getEnvironment().getModelChangeListener().onObjectDelete(this, CtRole.BODY, this.body);
			this.body = null;
		}
		return (T) this;
	}

	@Override
	public CtLoop clone() {
		return (CtLoop) super.clone();
	}

	@Override
	public Void S() {
		return null;
	}

	public CtCodeElement getSubstitution(CtType<?> targetType) {
		return clone();
	}
}
