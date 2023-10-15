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
import spoon9.reflect.declaration.CtTypedElement;
import spoon9.reflect.reference.CtTypeReference;
import spoon9.support.reflect.declaration.CtElementImpl;
import spoon9.reflect.ModelElementContainerDefaultCapacities;
import spoon9.reflect.path.CtRole;

import java.util.ArrayList;
import java.util.List;

public abstract class CtExpressionImpl<T> extends CtCodeElementImpl implements CtExpression<T> {
	private static final long serialVersionUID = 1L;

	@MetamodelPropertyField(role = CtRole.TYPE)
    CtTypeReference<T> type;

	@MetamodelPropertyField(role = CtRole.CAST)
	List<CtTypeReference<?>> typeCasts = emptyList();

	@Override
	public CtTypeReference<T> getType() {
		return type;
	}

	@Override
	public List<CtTypeReference<?>> getTypeCasts() {
		return typeCasts;
	}

	@Override
	public <C extends CtTypedElement> C setType(CtTypeReference<T> type) {
		if (type != null) {
			type.setParent(this);
		}
		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, CtRole.TYPE, type, this.type);
		this.type = type;
		return (C) this;
	}

	@Override
	public <C extends CtExpression<T>> C setTypeCasts(List<CtTypeReference<?>> casts) {
		getFactory().getEnvironment().getModelChangeListener().onListDeleteAll(this, CtRole.CAST, this.typeCasts, new ArrayList<>(this.typeCasts));
		if (casts == null || casts.isEmpty()) {
			this.typeCasts = CtElementImpl.emptyList();
			return (C) this;
		}
		if (this.typeCasts == CtElementImpl.<CtTypeReference<?>>emptyList()) {
			this.typeCasts = new ArrayList<>(ModelElementContainerDefaultCapacities.CASTS_CONTAINER_DEFAULT_CAPACITY);
		}
		this.typeCasts.clear();
		for (CtTypeReference<?> cast : casts) {
			addTypeCast(cast);
		}
		return (C) this;
	}

	@Override
	public <C extends CtExpression<T>> C addTypeCast(CtTypeReference<?> type) {
		if (type == null) {
			return (C) this;
		}
		if (typeCasts == CtElementImpl.<CtTypeReference<?>>emptyList()) {
			typeCasts = new ArrayList<>(ModelElementContainerDefaultCapacities.CASTS_CONTAINER_DEFAULT_CAPACITY);
		}
		type.setParent(this);
		getFactory().getEnvironment().getModelChangeListener().onListAdd(this, CtRole.CAST, this.typeCasts, type);
		typeCasts.add(type);
		return (C) this;
	}

	@Override
	public T S() {
		return null;
	}

	@Override
	public CtExpression<T> clone() {
		return (CtExpression<T>) super.clone();
	}
}
