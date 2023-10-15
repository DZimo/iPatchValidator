/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.reflect.code;

import spoon9.reflect.annotations.MetamodelPropertyField;
import spoon9.reflect.code.CtExpression;
import spoon9.reflect.code.CtTargetedExpression;
import spoon9.reflect.path.CtRole;

public abstract class CtTargetedExpressionImpl<E, T extends CtExpression<?>> extends CtExpressionImpl<E> implements CtTargetedExpression<E, T> {
	private static final long serialVersionUID = 1L;

	@MetamodelPropertyField(role = CtRole.TARGET)
	T target;

	@Override
	public T getTarget() {
		return target;
	}

	@Override
	public <C extends CtTargetedExpression<E, T>> C setTarget(T target) {
		if (target != null) {
			target.setParent(this);
		}
		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, CtRole.TARGET, target, this.target);
		this.target = target;
		return (C) this;
	}

	@Override
	public CtTargetedExpression<E, T> clone() {
		return (CtTargetedExpression<E, T>) super.clone();
	}
}
