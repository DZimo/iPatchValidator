/**
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.reflect.code;

import spoon9.reflect.annotations.MetamodelPropertyField;
import spoon9.reflect.code.CtBreak;
import spoon9.reflect.code.CtLabelledFlowBreak;
import spoon9.reflect.code.CtStatement;
import spoon9.reflect.declaration.CtElement;
import spoon9.reflect.visitor.CtVisitor;
import spoon9.reflect.visitor.filter.ParentFunction;

import java.util.List;

import static spoon9.reflect.path.CtRole.TARGET_LABEL;

public class CtBreakImpl extends CtStatementImpl implements CtBreak {
	private static final long serialVersionUID = 1L;

	@MetamodelPropertyField(role = TARGET_LABEL)
	String targetLabel;


	@Override
	public void accept(CtVisitor visitor) {
		visitor.visitCtBreak(this);
	}

	@Override
	public String getTargetLabel() {
		return targetLabel;
	}

	@Override
	public <T extends CtLabelledFlowBreak> T setTargetLabel(String targetLabel) {
		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, TARGET_LABEL, targetLabel, this.targetLabel);
		this.targetLabel = targetLabel;
		return (T) this;
	}

	@Override
	public CtStatement getLabelledStatement() {
		List<CtStatement> listParents = this.map(new ParentFunction().includingSelf(true)).list();

		for (CtElement parent : listParents) {
			if (parent instanceof CtStatement) {
				CtStatement statement = (CtStatement) parent;

				if (statement.getLabel() != null && statement.getLabel().equals(this.getTargetLabel())) {
					return statement;
				}
			}
		}
		return null;
	}


	@Override
	public CtBreak clone() {
		return (CtBreak) super.clone();
	}
}
