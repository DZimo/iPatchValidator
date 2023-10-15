/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2023 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) or the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.reflect.code;

import spoon9.reflect.annotations.MetamodelPropertyField;
import spoon9.reflect.code.CtBlock;
import spoon9.reflect.code.CtBodyHolder;
import spoon9.reflect.code.CtCatch;
import spoon9.reflect.code.CtCatchVariable;
import spoon9.reflect.code.CtStatement;
import spoon9.reflect.visitor.CtVisitor;

import static spoon9.reflect.path.CtRole.BODY;
import static spoon9.reflect.path.CtRole.PARAMETER;

public class CtCatchImpl extends CtCodeElementImpl implements CtCatch {
	private static final long serialVersionUID = 1L;

	@MetamodelPropertyField(role = BODY)
	CtBlock<?> body;

	@MetamodelPropertyField(role = PARAMETER)
	CtCatchVariable<? extends Throwable> parameter;

	@Override
	public void accept(CtVisitor visitor) {
		visitor.visitCtCatch(this);
	}

	@Override
	public CtBlock<?> getBody() {
		return body;
	}

	@Override
	public CtCatchVariable<? extends Throwable> getParameter() {
		return parameter;
	}

	@Override
	public <T extends CtBodyHolder> T setBody(CtStatement statement) {
		if (statement != null) {
			CtBlock<?> body = getFactory().Code().getOrCreateCtBlock(statement);
			getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, BODY, body, this.body);
			if (body != null) {
				body.setParent(this);
			}
			this.body = body;
		} else {
			getFactory().getEnvironment().getModelChangeListener().onObjectDelete(this, BODY, this.body);
			this.body = null;
		}

		return (T) this;
	}

	@Override
	public <T extends CtCatch> T setParameter(CtCatchVariable<? extends Throwable> parameter) {
		if (parameter != null) {
			parameter.setParent(this);
		}
		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, PARAMETER, parameter, this.parameter);
		this.parameter = parameter;
		return (T) this;
	}

	@Override
	public CtCatch clone() {
		return (CtCatch) super.clone();
	}
}
