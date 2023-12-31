/**
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.reflect.code;

import spoon9.reflect.annotations.MetamodelPropertyField;
import spoon9.reflect.code.CtExpression;
import spoon9.reflect.code.CtSuperAccess;
import spoon9.reflect.code.CtTargetedExpression;
import spoon9.reflect.visitor.CtVisitor;

import static spoon9.reflect.path.CtRole.TARGET;

public class CtSuperAccessImpl<T> extends CtVariableReadImpl<T> implements CtSuperAccess<T> {

	private static final long serialVersionUID = 1L;

	@Override
	public void accept(CtVisitor visitor) {
		visitor.visitCtSuperAccess(this);
	}

	@MetamodelPropertyField(role = TARGET)
	CtExpression<?> target;

	@Override
	public CtExpression<?> getTarget() {
		return target;
	}

	@Override
	public <C extends CtTargetedExpression<T, CtExpression<?>>> C setTarget(CtExpression<?> target) {
		if (target != null) {
			target.setParent(this);
		}
		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, TARGET, target, this.target);
		this.target = target;
		return null;
	}

	@Override
	public CtSuperAccess<T> clone() {
		return (CtSuperAccess<T>) super.clone();
	}
}
