/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2023 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) or the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.reflect.code;

import spoon9.reflect.annotations.MetamodelPropertyField;
import spoon9.reflect.code.CtLiteral;
import spoon9.reflect.code.LiteralBase;
import spoon9.reflect.declaration.CtElement;
import spoon9.reflect.path.CtRole;
import spoon9.reflect.visitor.CtVisitor;

import static spoon9.reflect.path.CtRole.EXPRESSION;
import static spoon9.reflect.path.CtRole.LITERAL_BASE;

public class CtLiteralImpl<T> extends CtExpressionImpl<T> implements CtLiteral<T> {
	private static final long serialVersionUID = 1L;

	@MetamodelPropertyField(role = CtRole.VALUE)
	T value;

	@MetamodelPropertyField(role = CtRole.LITERAL_BASE)
	LiteralBase base;

	@Override
	public void accept(CtVisitor visitor) {
		visitor.visitCtLiteral(this);
	}

	@Override
	public T getValue() {
		return value;
	}

	@Override
	public <C extends CtLiteral<T>> C setValue(T value) {
		if (value instanceof CtElement) {
			((CtElement) value).setParent(this);
		}
		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, EXPRESSION, value, this.value);
		this.value = value;
		return (C) this;
	}

	@Override
	public LiteralBase getBase() {
		return base;
	}

	@Override
	public <C extends CtLiteral<T>> C setBase(LiteralBase base) {
		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, LITERAL_BASE, base, this.base);
		this.base = base;
		return (C) this;
	}

	@Override
	public CtLiteral<T> clone() {
		return (CtLiteral<T>) super.clone();
	}
}
