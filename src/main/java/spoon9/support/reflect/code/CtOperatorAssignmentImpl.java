/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.reflect.code;

import spoon9.reflect.annotations.MetamodelPropertyField;
import spoon9.reflect.code.BinaryOperatorKind;
import spoon9.reflect.code.CtOperatorAssignment;
import spoon9.reflect.visitor.CtVisitor;
import spoon9.reflect.path.CtRole;

public class CtOperatorAssignmentImpl<T, A extends T> extends CtAssignmentImpl<T, A> implements CtOperatorAssignment<T, A> {
	private static final long serialVersionUID = 1L;

	@MetamodelPropertyField(role = CtRole.OPERATOR_KIND)
    BinaryOperatorKind kind;

	@Override
	public void accept(CtVisitor visitor) {
		visitor.visitCtOperatorAssignment(this);
	}

	@Override
	public BinaryOperatorKind getKind() {
		return kind;
	}

	@Override
	public <C extends CtOperatorAssignment<T, A>> C setKind(BinaryOperatorKind kind) {
		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, CtRole.OPERATOR_KIND, kind, this.kind);
		this.kind = kind;
		return (C) this;
	}

	@Override
	public CtOperatorAssignment<T, A> clone() {
		return (CtOperatorAssignment<T, A>) super.clone();
	}
}
