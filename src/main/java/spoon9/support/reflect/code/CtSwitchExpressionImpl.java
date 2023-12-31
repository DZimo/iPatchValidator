/**
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.reflect.code;

import spoon9.reflect.annotations.MetamodelPropertyField;
import spoon9.reflect.code.CtAbstractSwitch;
import spoon9.reflect.code.CtCase;
import spoon9.reflect.code.CtExpression;
import spoon9.reflect.code.CtSwitchExpression;
import spoon9.reflect.visitor.CtVisitor;
import spoon9.support.reflect.declaration.CtElementImpl;

import java.util.ArrayList;
import java.util.List;

import static spoon9.reflect.ModelElementContainerDefaultCapacities.SWITCH_CASES_CONTAINER_DEFAULT_CAPACITY;
import static spoon9.reflect.path.CtRole.CASE;
import static spoon9.reflect.path.CtRole.EXPRESSION;

public class CtSwitchExpressionImpl<T, S> extends CtExpressionImpl<T> implements CtSwitchExpression<T, S> {
	private static final long serialVersionUID = 1L;

	@MetamodelPropertyField(role = CASE)
	List<CtCase<? super S>> cases = emptyList();

	@MetamodelPropertyField(role = EXPRESSION)
	CtExpression<S> expression;

	@Override
	public void accept(CtVisitor visitor) {
		visitor.visitCtSwitchExpression(this);
	}

	@Override
	public List<CtCase<? super S>> getCases() {
		return cases;
	}

	@Override
	public CtExpression<S> getSelector() {
		return expression;
	}

	@Override
	public <T extends CtAbstractSwitch<S>> T setCases(List<CtCase<? super S>> cases) {
		if (cases == null || cases.isEmpty()) {
			this.cases = CtElementImpl.emptyList();
			return (T) this;
		}
		getFactory().getEnvironment().getModelChangeListener().onListDeleteAll(this, CASE, this.cases, new ArrayList<>(this.cases));
		this.cases.clear();
		for (CtCase<? super S> aCase : cases) {
			addCase(aCase);
		}
		return (T) this;
	}

	@Override
	public <T extends CtAbstractSwitch<S>> T setSelector(CtExpression<S> selector) {
		if (selector != null) {
			selector.setParent(this);
		}
		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, EXPRESSION, selector, this.expression);
		this.expression = selector;
		return (T) this;
	}

	@Override
	public <T extends CtAbstractSwitch<S>> T addCase(CtCase<? super S> c) {
		if (c == null) {
			return (T) this;
		}
		if (cases == CtElementImpl.<CtCase<? super S>>emptyList()) {
			cases = new ArrayList<>(SWITCH_CASES_CONTAINER_DEFAULT_CAPACITY);
		}
		c.setParent(this);
		getFactory().getEnvironment().getModelChangeListener().onListAdd(this, CASE, this.cases, c);
		cases.add(c);
		return (T) this;
	}

	@Override
	public boolean removeCase(CtCase<? super S> c) {
		if (cases == CtElementImpl.<CtCase<? super S>>emptyList()) {
			return false;
		}
		getFactory().getEnvironment().getModelChangeListener().onListDelete(this, CASE, cases, cases.indexOf(c), c);
		return cases.remove(c);
	}

	@Override
	public CtSwitchExpression<T, S> clone() {
		return (CtSwitchExpression<T, S>) super.clone();
	}
}
