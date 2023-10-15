/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.reflect.reference;

import spoon9.reflect.annotations.MetamodelPropertyField;
import spoon9.reflect.declaration.CtType;
import spoon9.reflect.reference.CtReference;
import spoon9.reflect.reference.CtTypeReference;
import spoon9.reflect.reference.CtWildcardReference;
import spoon9.reflect.visitor.CtVisitor;
import spoon9.support.UnsettableProperty;
import spoon9.reflect.path.CtRole;

public class CtWildcardReferenceImpl extends CtTypeParameterReferenceImpl implements CtWildcardReference {

	@MetamodelPropertyField(role = CtRole.BOUNDING_TYPE)
	private CtTypeReference<?> superType;

	@MetamodelPropertyField(role = CtRole.IS_UPPER)
	boolean upper = true;

	@Override
	public void accept(CtVisitor visitor) {
		visitor.visitCtWildcardReference(this);
	}

	public CtWildcardReferenceImpl() {
		simplename = "?";
	}

	@Override
	public boolean isUpper() {
		return upper;
	}

	@Override
	public <T extends CtWildcardReference> T setUpper(boolean upper) {
		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, CtRole.IS_UPPER, upper, this.upper);
		this.upper = upper;
		return (T) this;
	}

	@Override
	public <T extends CtWildcardReference> T setBoundingType(CtTypeReference<?> superType) {
		if (superType != null) {
			superType.setParent(this);
		}

		// ugly but else make testSetterInNodes failed
		if (superType == null) { // if null, set bounding type to object
			superType = getFactory().Type().objectType();
			superType.setImplicit(true);
			superType.setParent(this);
		}

		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, CtRole.BOUNDING_TYPE, superType, this.superType);
		this.superType = superType;
		return (T) this;
	}

	@Override
	public CtTypeReference<?> getBoundingType() {
		return superType;
	}

	@Override
	@UnsettableProperty
	public <T extends CtReference> T setSimpleName(String simplename) {
		return (T) this;
	}

	@Override
	public CtWildcardReference clone() {
		return (CtWildcardReference) super.clone();
	}

	@Override
	public CtType<Object> getTypeDeclaration() {
		return getFactory().Type().get(Object.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Class<Object> getActualClass() {
		if (isUpper()) {
			return (Class<Object>) getBoundingType().getActualClass();
		}
		return Object.class;
	}

	@Override
	protected boolean isWildcard() {
		return true;
	}
}
