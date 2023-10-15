/**
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.reflect.declaration;

import spoon9.reflect.declaration.CtInterface;
import spoon9.reflect.declaration.CtType;
import spoon9.reflect.reference.CtExecutableReference;
import spoon9.reflect.reference.CtTypeReference;
import spoon9.reflect.visitor.CtVisitor;
import spoon9.support.UnsettableProperty;

import java.util.*;

public class CtInterfaceImpl<T> extends CtTypeImpl<T> implements CtInterface<T> {
	private static final long serialVersionUID = 1L;

	@Override
	public void accept(CtVisitor visitor) {
		visitor.visitCtInterface(this);
	}

	@Override
	public boolean isSubtypeOf(CtTypeReference<?> type) {
		return getReference().isSubtypeOf(type);
	}

	@Override
	public boolean isInterface() {
		return true;
	}

	@Override
	public Collection<CtExecutableReference<?>> getDeclaredExecutables() {
		Set<CtTypeReference<?>> superInterfaces = getSuperInterfaces();
		if (superInterfaces.isEmpty()) {
			return super.getDeclaredExecutables();
		}
		List<CtExecutableReference<?>> l = new ArrayList<>(super.getDeclaredExecutables());
		for (CtTypeReference<?> sup : superInterfaces) {
			l.addAll(sup.getAllExecutables());
		}
		return Collections.unmodifiableList(l);
	}

	@Override
	public CtInterface<T> clone() {
		return (CtInterface<T>) super.clone();
	}

	@Override
	@UnsettableProperty
	public <C extends CtType<T>> C setSuperclass(CtTypeReference<?> superClass) {
		// unsettable property
		return (C) this;
	}
}
