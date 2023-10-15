/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.reflect.code;

import spoon9.reflect.annotations.MetamodelPropertyField;
import spoon9.reflect.code.CtAssert;
import spoon9.reflect.code.CtExpression;
import spoon9.reflect.visitor.CtVisitor;
import spoon9.reflect.path.CtRole;

public class CtAssertImpl<T> extends CtStatementImpl implements CtAssert<T> {
	private static final long serialVersionUID = 1L;

	@MetamodelPropertyField(role = CtRole.CONDITION)
    CtExpression<Boolean> asserted;

	@MetamodelPropertyField(role = CtRole.EXPRESSION)
	CtExpression<T> value;

	@Override
	public void accept(CtVisitor visitor) {
		visitor.visitCtAssert(this);
	}

	@Override
	public CtExpression<Boolean> getAssertExpression() {
		return asserted;
	}

	@Override
	public <A extends CtAssert<T>> A setAssertExpression(CtExpression<Boolean> asserted) {
		if (asserted != null) {
			asserted.setParent(this);
		}
		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, CtRole.CONDITION, asserted, this.asserted);
		this.asserted = asserted;
		return (A) this;
	}

	@Override
	public CtExpression<T> getExpression() {
		return value;
	}

	@Override
	public <A extends CtAssert<T>> A setExpression(CtExpression<T> value) {
		if (value != null) {
			value.setParent(this);
		}
		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, CtRole.EXPRESSION, value, this.value);
		this.value = value;
		return (A) this;
	}

	@Override
	public CtAssert<T> clone() {
		return (CtAssert<T>) super.clone();
	}
}
