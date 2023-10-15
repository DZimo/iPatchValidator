/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2023 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) or the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.reflect.visitor;

import spoon9.reflect.code.CtCatch;
import spoon9.reflect.code.CtFor;
import spoon9.reflect.code.CtForEach;
import spoon9.reflect.code.CtLocalVariable;
import spoon9.reflect.code.CtResource;
import spoon9.reflect.code.CtStatement;
import spoon9.reflect.code.CtStatementList;
import spoon9.reflect.code.CtTryWithResource;
import spoon9.reflect.declaration.CtElement;
import spoon9.reflect.declaration.CtExecutable;
import spoon9.reflect.declaration.CtField;
import spoon9.reflect.declaration.CtMethod;
import spoon9.reflect.declaration.CtPackage;
import spoon9.reflect.declaration.CtType;
import spoon9.reflect.declaration.CtVariable;
import spoon9.reflect.declaration.ModifierKind;
import spoon9.reflect.reference.CtTypeReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Find local variables catch, parameters, fields, super fields
 * @author tdurieux
 */
public class AccessibleVariablesFinder {

	private CtElement expression;

	public AccessibleVariablesFinder(CtElement expression) {
		this.expression = expression;
	}

	public List<CtVariable> find() {
		if (expression.isParentInitialized()) {
			return getVariable(expression.getParent());
		}
		return Collections.emptyList();
	}

	private List<CtVariable> getVariable(final CtElement parent) {
		final List<CtVariable> variables = new ArrayList<>();
		if (parent == null) {
			return variables;
		}
		class VariableScanner extends CtInheritanceScanner {
			@Override
			public void visitCtStatementList(CtStatementList e) {
				for (int i = 0; i < e.getStatements().size(); i++) {
					CtStatement ctStatement = e.getStatements().get(i);

					if (expression.getPosition().isValidPosition() && ctStatement.getPosition().isValidPosition()
							&& ctStatement.getPosition().getSourceStart() > expression.getPosition().getSourceEnd()) {
						break;
					}

					if (ctStatement instanceof CtVariable) {
						variables.add((CtVariable) ctStatement);
					}
				}
				super.visitCtStatementList(e);
			}

			@Override
			public <T> void scanCtType(CtType<T> type) {
				List<CtField<?>> fields = type.getFields();
				for (CtField<?> ctField : fields) {
					if (ctField.hasModifier(ModifierKind.PUBLIC) || ctField.hasModifier(ModifierKind.PROTECTED)) {
						variables.add(ctField);
					} else if (ctField.hasModifier(ModifierKind.PRIVATE)) {
						if (expression.hasParent(type)) {
							variables.add(ctField);
						}
					} else if (expression.getParent(CtPackage.class).equals(type.getParent(CtPackage.class))) {
						// default visibility
						variables.add(ctField);
					}
				}
				CtTypeReference<?> superclass = type.getSuperclass();
				if (superclass != null) {
					variables.addAll(getVariable(superclass.getTypeDeclaration()));
				}
				Set<CtTypeReference<?>> superInterfaces = type.getSuperInterfaces();
				for (CtTypeReference<?> typeReference : superInterfaces) {
					variables.addAll(getVariable(typeReference.getTypeDeclaration()));
				}
				super.scanCtType(type);
			}

			@Override
			public void visitCtTryWithResource(CtTryWithResource e) {
				for (CtResource<?> resource: e.getResources()) {
					if (resource instanceof CtLocalVariable) {
						variables.add((CtLocalVariable<?>) resource);
					}
				}
				super.visitCtTryWithResource(e);
			}

			@Override
			public void scanCtExecutable(CtExecutable e) {
				variables.addAll(e.getParameters());
				super.scanCtExecutable(e);
			}

			@Override
			public void visitCtFor(CtFor e) {
				for (CtStatement ctStatement : e.getForInit()) {
					this.scan(ctStatement);
				}
				super.visitCtFor(e);
			}

			@Override
			public void visitCtForEach(CtForEach e) {
				variables.add(e.getVariable());
				super.visitCtForEach(e);
			}

			@Override
			public void visitCtMethod(CtMethod e) {
				this.scan(e.getBody());
				super.visitCtMethod(e);
			}

			@Override
			public void visitCtLocalVariable(CtLocalVariable e) {
				variables.add(e);
				super.visitCtLocalVariable(e);
			}

			@Override
			public void visitCtCatch(CtCatch e) {
				variables.add(e.getParameter());

				super.visitCtCatch(e);
			}
		}

		new VariableScanner().scan(parent);

		return variables;
	}
}
