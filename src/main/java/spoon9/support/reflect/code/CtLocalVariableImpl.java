/**
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.reflect.code;

import spoon9.reflect.annotations.MetamodelPropertyField;
import spoon9.reflect.code.CtExpression;
import spoon9.reflect.code.CtLocalVariable;
import spoon9.reflect.code.CtRHSReceiver;
import spoon9.reflect.cu.position.NoSourcePosition;
import spoon9.reflect.declaration.*;
import spoon9.reflect.path.CtRole;
import spoon9.reflect.reference.CtLocalVariableReference;
import spoon9.reflect.reference.CtTypeReference;
import spoon9.reflect.visitor.CtVisitor;
import spoon9.support.DerivedProperty;
import spoon9.support.UnsettableProperty;
import spoon9.support.reflect.CtExtendedModifier;
import spoon9.support.reflect.CtModifierHandler;

import java.util.Set;

public class CtLocalVariableImpl<T> extends CtStatementImpl implements CtLocalVariable<T> {
	private static final long serialVersionUID = 1L;

	@MetamodelPropertyField(role = CtRole.DEFAULT_EXPRESSION)
	CtExpression<T> defaultExpression;

	@MetamodelPropertyField(role = CtRole.NAME)
	String name = "";

	@MetamodelPropertyField(role = CtRole.TYPE)
	CtTypeReference<T> type;

	@MetamodelPropertyField(role = CtRole.MODIFIER)
	private CtModifierHandler modifierHandler = new CtModifierHandler(this);

	@MetamodelPropertyField(role = CtRole.IS_INFERRED)
	private boolean inferred;

	@Override
	public void accept(CtVisitor visitor) {
		visitor.visitCtLocalVariable(this);
	}

	@Override
	public CtExpression<T> getDefaultExpression() {
		return defaultExpression;
	}

	@Override
	public CtLocalVariableReference<T> getReference() {
		return getFactory().Code().createLocalVariableReference(this);
	}

	@Override
	public String getSimpleName() {
		return name;
	}

	@Override
	public CtTypeReference<T> getType() {
		return type;
	}

	@Override
	public <C extends CtVariable<T>> C setDefaultExpression(CtExpression<T> defaultExpression) {
		if (defaultExpression != null) {
			defaultExpression.setParent(this);
		}
		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, CtRole.DEFAULT_EXPRESSION, defaultExpression, this.defaultExpression);
		this.defaultExpression = defaultExpression;
		return (C) this;
	}

	@Override
	public boolean isPartOfJointDeclaration() {
		if (this.getPosition() instanceof NoSourcePosition) {
			return  false;
		}
		for (Object o : getParent().getDirectChildren()) {
			if (!(o instanceof CtLocalVariable)) {
				continue;
			}
			CtLocalVariable<?> f = (CtLocalVariable<?>) o;
			if (f == this) {
				continue;
			}
			if (f.getPosition() == null || f.getPosition() instanceof NoSourcePosition) {
				continue;
			}
			if (f.getPosition().getSourceStart() == this.getPosition().getSourceStart()
					&& f.getPosition().getSourceEnd() == this.getPosition().getSourceEnd()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public <C extends CtNamedElement> C setSimpleName(String simpleName) {
		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, CtRole.NAME, simpleName, this.name);
		this.name = simpleName;
		return (C) this;
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
	public Set<ModifierKind> getModifiers() {
		return modifierHandler.getModifiers();
	}

	@Override
	public boolean hasModifier(ModifierKind modifier) {
		return getModifiers().contains(modifier);
	}

	@Override
	public <C extends CtModifiable> C setModifiers(Set<ModifierKind> modifiers) {
		modifierHandler.setModifiers(modifiers);
		return (C) this;
	}

	@Override
	public <C extends CtModifiable> C addModifier(ModifierKind modifier) {
		modifierHandler.addModifier(modifier);
		return (C) this;
	}

	@Override
	public <C extends CtModifiable> C removeModifier(ModifierKind modifier) {
		modifierHandler.removeModifier(modifier);
		return (C) this;
	}

	@Override
	public <C extends CtModifiable> C setVisibility(ModifierKind visibility) {
		modifierHandler.setVisibility(visibility);
		return (C) this;
	}

	@Override
	public ModifierKind getVisibility() {
		if (getModifiers().contains(ModifierKind.PUBLIC)) {
			return ModifierKind.PUBLIC;
		}
		if (getModifiers().contains(ModifierKind.PROTECTED)) {
			return ModifierKind.PROTECTED;
		}
		if (getModifiers().contains(ModifierKind.PRIVATE)) {
			return ModifierKind.PRIVATE;
		}
		return null;
	}

	@Override
	public Set<CtExtendedModifier> getExtendedModifiers() {
		return this.modifierHandler.getExtendedModifiers();
	}

	@Override
	public <T extends CtModifiable> T setExtendedModifiers(Set<CtExtendedModifier> extendedModifiers) {
		this.modifierHandler.setExtendedModifiers(extendedModifiers);
		return (T) this;
	}

	@Override
	@DerivedProperty
	public CtExpression<T> getAssignment() {
		return getDefaultExpression();
	}

	@Override
	@UnsettableProperty
	public <C extends CtRHSReceiver<T>> C setAssignment(CtExpression<T> assignment) {
		setDefaultExpression(assignment);
		return (C) this;
	}

	@Override
	public boolean isInferred() {
		return this.inferred;
	}

	@Override
	public <U extends CtLocalVariable<T>> U setInferred(boolean inferred) {
		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, CtRole.IS_INFERRED, inferred, this.inferred);
		this.inferred = inferred;
		return (U) this;
	}

	@Override
	public CtLocalVariable<T> clone() {
		return (CtLocalVariable<T>) super.clone();
	}

	@Override
	public boolean isPublic() {
		return this.modifierHandler.isPublic();
	}

	@Override
	public boolean isPrivate() {
		return this.modifierHandler.isPrivate();
	}

	@Override
	public boolean isProtected() {
		return this.modifierHandler.isProtected();
	}

	@Override
	public boolean isFinal() {
		return this.modifierHandler.isFinal();
	}

	@Override
	public boolean isStatic() {
		return this.modifierHandler.isStatic();
	}

	@Override
	public boolean isAbstract() {
		return this.modifierHandler.isAbstract();
	}

	@Override
	public boolean isTransient() {
		return this.modifierHandler.isTransient();
	}

	@Override
	public boolean isVolatile() {
		return this.modifierHandler.isVolatile();
	}

	@Override
	public boolean isSynchronized() {
		return this.modifierHandler.isSynchronized();
	}

	@Override
	public boolean isNative() {
		return this.modifierHandler.isNative();
	}

	@Override
	public boolean isStrictfp() {
		return this.modifierHandler.isStrictfp();
	}
}
