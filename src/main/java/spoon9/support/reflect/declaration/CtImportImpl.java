/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2023 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) or the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.reflect.declaration;

import spoon9.SpoonException;
import spoon9.experimental.CtUnresolvedImport;
import spoon9.reflect.annotations.MetamodelPropertyField;
import spoon9.reflect.path.CtRole;
import spoon9.reflect.reference.CtExecutableReference;
import spoon9.reflect.reference.CtFieldReference;
import spoon9.reflect.declaration.CtImport;
import spoon9.reflect.reference.CtPackageReference;
import spoon9.reflect.reference.CtReference;
import spoon9.reflect.declaration.CtImportKind;
import spoon9.reflect.reference.CtTypeReference;
import spoon9.reflect.reference.CtTypeMemberWildcardImportReference;
import spoon9.reflect.visitor.CtImportVisitor;
import spoon9.reflect.visitor.CtVisitor;
import spoon9.support.reflect.reference.CtTypeMemberWildcardImportReferenceImpl;

public class CtImportImpl extends CtElementImpl implements CtImport {
	@MetamodelPropertyField(role = CtRole.IMPORT_REFERENCE)
	private CtReference localReference;

	public CtImportImpl() {
	}

	@Override
	public CtImportKind getImportKind() {
		return getImportKindFor(this.localReference);
	}

	private CtImportKind getImportKindFor(CtReference ref) {
		if (ref == null) {
			return null;
		}

		if (ref instanceof CtFieldReference) {
			return CtImportKind.FIELD;
		} else if (ref instanceof CtExecutableReference) {
			return CtImportKind.METHOD;
		} else if (ref instanceof CtPackageReference) {
			return CtImportKind.ALL_TYPES;
		} else if (ref instanceof CtTypeMemberWildcardImportReferenceImpl) {
			return CtImportKind.ALL_STATIC_MEMBERS;
		} else if (ref instanceof CtTypeReference) {
			return CtImportKind.TYPE;
		} else {
			throw new SpoonException("Only CtFieldReference, CtExecutableReference, CtPackageReference and CtTypeReference are accepted reference types. Given " + ref.getClass());
		}
	}

	@Override
	public <T extends CtImport> T setReference(CtReference reference) {
		if (reference != null) {
			reference.setParent(this);
		}

		// may throw an exception if invalid
		getImportKindFor(reference);

		getFactory().getEnvironment().getModelChangeListener().onObjectUpdate(this, CtRole.IMPORT_REFERENCE, reference, this.localReference);
		this.localReference = reference;
		return (T) this;
	}

	@Override
	public CtReference getReference() {
		return this.localReference;
	}

	@Override
	public void accept(CtVisitor visitor) {
		visitor.visitCtImport(this);
	}

	@Override
	public void accept(CtImportVisitor visitor) {
		switch (getImportKind()) {
		case TYPE:
			visitor.visitTypeImport((CtTypeReference<?>) localReference);
			break;

		case METHOD:
			visitor.visitMethodImport((CtExecutableReference<?>) localReference);
			break;

		case FIELD:
			visitor.visitFieldImport((CtFieldReference<?>) localReference);
			break;

		case ALL_TYPES:
			visitor.visitAllTypesImport((CtPackageReference) localReference);
			break;

		case ALL_STATIC_MEMBERS:
			visitor.visitAllStaticMembersImport((CtTypeMemberWildcardImportReference) localReference);
			break;
		case UNRESOLVED:
			visitor.visitUnresolvedImport((CtUnresolvedImport) localReference);
			break;
		default:
			throw new SpoonException("Unexpected import kind: " + getImportKind());
		}
	}

	@Override
	public CtImportImpl clone() {
		return (CtImportImpl) super.clone();
	}
}
