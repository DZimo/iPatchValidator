/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2023 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) or the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.reflect.visitor.filter;

import spoon9.reflect.code.CaseKind;
import spoon9.reflect.code.CtBodyHolder;
import spoon9.reflect.code.CtCase;
import spoon9.reflect.code.CtCatch;
import spoon9.reflect.code.CtCatchVariable;
import spoon9.reflect.code.CtLocalVariable;
import spoon9.reflect.code.CtStatement;
import spoon9.reflect.code.CtStatementList;
import spoon9.reflect.code.CtSwitch;
import spoon9.reflect.declaration.CtElement;
import spoon9.reflect.declaration.CtExecutable;
import spoon9.reflect.declaration.CtField;
import spoon9.reflect.declaration.CtModifiable;
import spoon9.reflect.declaration.CtNamedElement;
import spoon9.reflect.declaration.CtPackage;
import spoon9.reflect.declaration.CtParameter;
import spoon9.reflect.declaration.CtType;
import spoon9.reflect.declaration.CtVariable;
import spoon9.reflect.declaration.ModifierKind;
import spoon9.reflect.visitor.chain.CtConsumableFunction;
import spoon9.reflect.visitor.chain.CtConsumer;
import spoon9.reflect.visitor.chain.CtQuery;
import spoon9.reflect.visitor.chain.CtQueryAware;

import java.util.List;

/**
 * This mapping function searches for all {@link CtVariable} instances,
 * which might be a declaration of an input {@link CtElement}.
 * <br>
 * It can be used to search for variable declarations of
 * variable references and for detection of variable name conflicts
 * <br>
 * It returns {@link CtLocalVariable} instances,
 * or it returns {@link CtCatchVariable} instances of catch blocks,
 * or i returns {@link CtParameter} instances of methods, lambdas and catch blocks.
 * or it returns {@link CtField} instances from wrapping classes and their super classes too.
 * <br>
 * The elements are visited in the following order: first elements are thought in the nearest parent blocks,
 * then in the fields of wrapping classes, then in the fields of super classes, etc.
 * <br>
 * Example: Search for all potential {@link CtVariable} declarations<br>
 * <pre> {@code
 * CtVariableReference varRef = ...;
 * varRef.map(new PotentialVariableDeclarationFunction()).forEach(...process result...);
 * }
 * </pre>
 * Example: Search for {@link CtVariable} declaration of variable named `varName` in scope "scope"
 * <pre> {@code
 * CtElement scope = ...;
 * String varName = "anVariableName";
 * CtVariable varOrNull = scope.map(new PotentialVariableDeclarationFunction(varName)).first();
 * }
 * </pre>
 */
public class PotentialVariableDeclarationFunction implements CtConsumableFunction<CtElement>, CtQueryAware {

	private boolean isTypeOnTheWay;
	private final String variableName;
	private CtQuery query;
	private boolean isInStaticScope;

	public PotentialVariableDeclarationFunction() {
		this.variableName = null;
	}

	/**
	 * Searches for a variable with exact name.
	 * @param variableName
	 */
	public PotentialVariableDeclarationFunction(String variableName) {
		this.variableName = variableName;
	}

	@Override
	public void apply(CtElement input, CtConsumer<Object> outputConsumer) {
		isTypeOnTheWay = false;
		isInStaticScope = false;
		//Search previous siblings for element which may represents the declaration of this local variable
		CtQuery siblingsQuery = input.getFactory().createQuery()
				.map(new SiblingsFunction().mode(SiblingsFunction.Mode.PREVIOUS))
				//select only CtVariable nodes
				.select(new TypeFilter<>(CtVariable.class));
		if (variableName != null) {
			//variable name is defined so we have to search only for variables with that name
			siblingsQuery = siblingsQuery.select(new NamedElementFilter<>(CtNamedElement.class, variableName));
		}

		CtElement scopeElement = input;
		//Search input and then all parents until first CtPackage for element which may represents the declaration of this local variable
		while (scopeElement != null && !(scopeElement instanceof CtPackage) && scopeElement.isParentInitialized()) {
			CtElement parent = scopeElement.getParent();
			if (parent instanceof CtType<?>) {
				isTypeOnTheWay = true;
				//visit each CtField of `parent` CtType
				CtQuery q = parent.map(new AllTypeMembersFunction(CtField.class));
				q.forEach((CtField<?> field) -> {
					if (isInStaticScope && !field.hasModifier(ModifierKind.STATIC)) {
						/*
						 * the variable reference is used in static scope,
						 * but the field is not static - ignore it
						 */
						return;
					}
					//else send field as potential variable declaration
					if (sendToOutput(field, outputConsumer)) {
						//and terminate the internal query q if outer query is already terminated
						q.terminate();
					}
				});
				if (query.isTerminated()) {
					return;
				}
			} else if (parent instanceof CtSwitch
					&& scopeElement instanceof CtCase && ((CtCase<?>) scopeElement).getCaseKind() == CaseKind.COLON) {
				SiblingsFunction siblingsFunction = new SiblingsFunction().mode(SiblingsFunction.Mode.PREVIOUS);
				List<CtCase<?>> list = input.getFactory().createQuery()
						.map(siblingsFunction)
						.setInput(scopeElement)
						.filterChildren(new TypeFilter<>(CtCase.class))
						.list();

				for (CtCase<?> c : list) {
					for (CtStatement statement : c.getStatements()) {
						if (statement instanceof CtLocalVariable && ((CtLocalVariable<?>) statement).getSimpleName().equals(variableName)) {
							sendToOutput((CtVariable<?>) statement, outputConsumer);
							return;
						}
					}
				}
			} else if (parent instanceof CtBodyHolder || parent instanceof CtStatementList) {
				//visit all previous CtVariable siblings of scopeElement element in parent BodyHolder or Statement list
				siblingsQuery.setInput(scopeElement).forEach(outputConsumer);
				if (query.isTerminated()) {
					return;
				}
				//visit parameters of CtCatch and CtExecutable (method, lambda)
				if (parent instanceof CtCatch) {
					CtCatch ctCatch = (CtCatch) parent;
					if (sendToOutput(ctCatch.getParameter(), outputConsumer)) {
						return;
					}
				} else if (parent instanceof CtExecutable) {
					CtExecutable<?> exec = (CtExecutable<?>) parent;
					for (CtParameter<?> param : exec.getParameters()) {
						if (sendToOutput(param, outputConsumer)) {
							return;
						}
					}
				}
			}
			if (parent instanceof CtModifiable) {
				isInStaticScope = isInStaticScope || ((CtModifiable) parent).hasModifier(ModifierKind.STATIC);
			}
			scopeElement = parent;
		}
	}

	/**
	 * @param var
	 * @param output
	 * @return true if query processing is terminated
	 */
	private boolean sendToOutput(CtVariable<?> var, CtConsumer<Object> output) {
		if (variableName == null || variableName.equals(var.getSimpleName())) {
			output.accept(var);
		}
		return query.isTerminated();
	}

	/**
	 * This method provides access to current state of this function.
	 * It is intended to be called by other mapping functions at query processing time or after query is finished.
	 *
	 * @return true if there is an local class on the way from the input of this mapping function
	 * to the actually found potential variable declaration
	 */
	public boolean isTypeOnTheWay() {
		return isTypeOnTheWay;
	}

	@Override
	public void setQuery(CtQuery query) {
		this.query = query;
	}
}
