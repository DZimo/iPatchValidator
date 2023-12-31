/**
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.reflect.reference;

import spoon9.reflect.annotations.MetamodelPropertyField;
import spoon9.reflect.declaration.CtAnnotation;
import spoon9.reflect.declaration.CtElement;
import spoon9.reflect.declaration.CtType;
import spoon9.reflect.path.CtRole;
import spoon9.reflect.reference.CtReference;
import spoon9.reflect.reference.CtTypeMemberWildcardImportReference;
import spoon9.reflect.reference.CtTypeReference;
import spoon9.reflect.visitor.CtVisitor;
import spoon9.support.DerivedProperty;
import spoon9.support.Experimental;
import spoon9.support.UnsettableProperty;
import spoon9.support.reflect.declaration.CtElementImpl;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.List;

import static spoon9.reflect.path.CtRole.PACKAGE_REF;

/**
 * This class intends to be used only to represent the reference of a
 * static import of all members of a type:
 *
 * import static org.junit.Assert.*;
 */
@Experimental
public class CtTypeMemberWildcardImportReferenceImpl extends CtElementImpl implements CtTypeMemberWildcardImportReference {
	private static final long serialVersionUID = 1L;

	@MetamodelPropertyField(role = CtRole.TYPE_REF)
	private CtTypeReference<?> typeReference;

	@Override
	public CtTypeReference<?> getTypeReference() {
		return typeReference;
	}

	@Override
	public CtTypeMemberWildcardImportReferenceImpl setTypeReference(CtTypeReference<?> typeReference) {
		if (typeReference != null) {
			typeReference.setParent(this);
		}
		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, PACKAGE_REF, typeReference, this.typeReference);
		this.typeReference = typeReference;
		return this;
	}

	@Override
	public String getSimpleName() {
		return typeReference == null ? null : typeReference.getQualifiedName() + ".*";
	}

	@Override
	@UnsettableProperty
	public <T extends CtReference> T setSimpleName(String simpleName) {
		return (T) this;
	}

	@Override
	public void accept(CtVisitor visitor) {
		visitor.visitCtTypeMemberWildcardImportReference(this);
	}

	@Override
	public CtTypeMemberWildcardImportReferenceImpl clone() {
		return (CtTypeMemberWildcardImportReferenceImpl) super.clone();
	}

	@Override
	@DerivedProperty
	public CtType<?> getDeclaration() {
		return typeReference == null ? null : typeReference.getTypeDeclaration();
	}

	@Override
	@DerivedProperty
	public List<CtAnnotation<? extends Annotation>> getAnnotations() {
		return Collections.emptyList();
	}

	@Override
	@UnsettableProperty
	public <E extends CtElement> E addAnnotation(CtAnnotation<? extends Annotation> annotation) {
		return (E) this;
	}

	@Override
	@UnsettableProperty
	public boolean removeAnnotation(CtAnnotation<? extends Annotation> annotation) {
		return false;
	}

	@Override
	@UnsettableProperty
	public <E extends CtElement> E setAnnotations(List<CtAnnotation<? extends Annotation>> annotations) {
		return (E) this;
	}

	@Override
	@DerivedProperty
	public boolean isImplicit() {
		return false;
	}

	@Override
	@UnsettableProperty
	public <E extends CtElement> E setImplicit(boolean implicit) {
		return (E) this;
	}
}
