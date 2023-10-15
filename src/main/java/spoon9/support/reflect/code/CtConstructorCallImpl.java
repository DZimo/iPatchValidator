/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.reflect.code;

import spoon9.reflect.annotations.MetamodelPropertyField;
import spoon9.reflect.code.CtAbstractInvocation;
import spoon9.reflect.code.CtConstructorCall;
import spoon9.reflect.code.CtExpression;
import spoon9.reflect.code.CtStatement;
import spoon9.reflect.code.CtStatementList;
import spoon9.reflect.declaration.CtTypedElement;
import spoon9.reflect.reference.CtActualTypeContainer;
import spoon9.reflect.reference.CtExecutableReference;
import spoon9.reflect.reference.CtTypeReference;
import spoon9.reflect.visitor.CtVisitor;
import spoon9.support.DerivedProperty;
import spoon9.support.reflect.declaration.CtElementImpl;
import spoon9.reflect.ModelElementContainerDefaultCapacities;
import spoon9.reflect.path.CtRole;

import java.util.ArrayList;
import java.util.List;

public class CtConstructorCallImpl<T> extends CtTargetedExpressionImpl<T, CtExpression<?>> implements CtConstructorCall<T> {
	private static final long serialVersionUID = 1L;

	@MetamodelPropertyField(role = CtRole.ARGUMENT)
	List<CtExpression<?>> arguments = emptyList();
	@MetamodelPropertyField(role = CtRole.EXECUTABLE_REF)
    CtExecutableReference<T> executable;
	@MetamodelPropertyField(role = CtRole.LABEL)
	String label;

	@Override
	public void accept(CtVisitor visitor) {
		visitor.visitCtConstructorCall(this);
	}

	@Override
	public List<CtExpression<?>> getArguments() {
		return arguments;
	}

	@Override
	public CtExecutableReference<T> getExecutable() {
		if (executable == null) {
			// default reference
			executable = getFactory().Core().createExecutableReference();
			executable.setParent(this);
		}
		return executable;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public <C extends CtStatement> C insertAfter(CtStatement statement) {
		CtStatementImpl.insertAfter(this, statement);
		return (C) this;
	}

	@Override
	public <C extends CtStatement> C insertBefore(CtStatement statement) {
		CtStatementImpl.insertBefore(this, statement);
		return (C) this;
	}

	@Override
	public <C extends CtStatement> C insertAfter(CtStatementList statements) {
		CtStatementImpl.insertAfter(this, statements);
		return (C) this;
	}

	@Override
	public <C extends CtStatement> C insertBefore(CtStatementList statements) {
		CtStatementImpl.insertBefore(this, statements);
		return (C) this;
	}

	@Override
	public <C extends CtAbstractInvocation<T>> C setArguments(List<CtExpression<?>> arguments) {
		if (arguments == null || arguments.isEmpty()) {
			this.arguments = CtElementImpl.emptyList();
			return (C) this;
		}
		if (this.arguments == CtElementImpl.<CtExpression<?>>emptyList()) {
			this.arguments = new ArrayList<>(ModelElementContainerDefaultCapacities.PARAMETERS_CONTAINER_DEFAULT_CAPACITY);
		}
		getFactory().getEnvironment().getModelChangeListener().onListDeleteAll(this, CtRole.ARGUMENT, this.arguments, new ArrayList<>(this.arguments));
		this.arguments.clear();
		for (CtExpression<?> expr : arguments) {
			addArgument(expr);
		}
		return (C) this;
	}

	private <C extends CtAbstractInvocation<T>> C addArgument(int position, CtExpression<?> argument) {
		if (argument == null) {
			return (C) this;
		}
		if (arguments == CtElementImpl.<CtExpression<?>>emptyList()) {
			arguments = new ArrayList<>(ModelElementContainerDefaultCapacities.PARAMETERS_CONTAINER_DEFAULT_CAPACITY);
		}
		argument.setParent(this);
		getFactory().getEnvironment().getModelChangeListener().onListAdd(this, CtRole.ARGUMENT, this.arguments, position, argument);
		arguments.add(position, argument);
		return (C) this;
	}

	@Override
	public <C extends CtAbstractInvocation<T>> C addArgument(CtExpression<?> argument) {
		return addArgument(arguments.size(), argument);
	}

	@Override
	public <C extends CtAbstractInvocation<T>> C addArgumentAt(int position, CtExpression<?> argument) {
		return addArgument(position, argument);
	}

	@Override
	public void removeArgument(CtExpression<?> argument) {
		if (arguments == CtElementImpl.<CtExpression<?>>emptyList()) {
			return;
		}
		getFactory().getEnvironment().getModelChangeListener().onListDelete(this, CtRole.ARGUMENT, arguments, arguments.indexOf(argument), argument);
		arguments.remove(argument);
	}

	@Override
	public <C extends CtAbstractInvocation<T>> C setExecutable(CtExecutableReference<T> executable) {
		if (executable != null) {
			executable.setParent(this);
		}
		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, CtRole.EXECUTABLE_REF, executable, this.executable);
		this.executable = executable;
		return (C) this;
	}

	@Override
	public <C extends CtStatement> C setLabel(String label) {
		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, CtRole.LABEL, label, this.label);
		this.label = label;
		return (C) this;
	}

	@Override
	@DerivedProperty
	public List<CtTypeReference<?>> getActualTypeArguments() {
		return getExecutable() == null ? CtElementImpl.<CtTypeReference<?>>emptyList() : getExecutable().getActualTypeArguments();
	}

	@Override
	@DerivedProperty
	public <T extends CtActualTypeContainer> T setActualTypeArguments(List<? extends CtTypeReference<?>> actualTypeArguments) {
		if (getExecutable() != null) {
			getExecutable().setActualTypeArguments(actualTypeArguments);
		}
		return (T) this;
	}

	@Override
	@DerivedProperty
	public <T extends CtActualTypeContainer> T addActualTypeArgument(CtTypeReference<?> actualTypeArgument) {
		if (getExecutable() != null) {
			getExecutable().addActualTypeArgument(actualTypeArgument);
		}
		return (T) this;
	}

	@Override
	@DerivedProperty
	public boolean removeActualTypeArgument(CtTypeReference<?> actualTypeArgument) {
		if (getExecutable() != null) {
			return getExecutable().removeActualTypeArgument(actualTypeArgument);
		}
		return false;
	}

	@Override
	@DerivedProperty
	public CtTypeReference<T> getType() {
		return getExecutable() == null ? null : getExecutable().getType();
	}

	@Override
	@DerivedProperty
	public <C extends CtTypedElement> C setType(CtTypeReference<T> type) {
		if (type != null) {
			type.setParent(this);
		}
		if (getExecutable() != null) {
			getExecutable().setType(type);
		}
		return (C) this;
	}

	@Override
	public CtConstructorCall<T> clone() {
		return (CtConstructorCall<T>) super.clone();
	}
}
