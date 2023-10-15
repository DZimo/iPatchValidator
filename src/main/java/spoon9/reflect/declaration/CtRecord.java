/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2023 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) or the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.reflect.declaration;

import java.util.Collection;
import java.util.Set;
import spoon9.reflect.annotations.PropertyGetter;
import spoon9.reflect.annotations.PropertySetter;
import spoon9.reflect.path.CtRole;
import spoon9.reflect.reference.CtTypeReference;
import spoon9.support.UnsettableProperty;
/**
 * This element represents a record declaration.
 *
 * Example:
 * <pre>
 *    record Point(int x, int y) {
 *    }
 * </pre>
 */
public interface CtRecord extends CtClass<Object> {

	@PropertySetter(role = CtRole.RECORD_COMPONENT)
	CtRecord  addRecordComponent(CtRecordComponent component);
	@PropertySetter(role = CtRole.RECORD_COMPONENT)
	CtRecord  removeRecordComponent(CtRecordComponent component);

	@PropertyGetter(role = CtRole.RECORD_COMPONENT)
	Set<CtRecordComponent> getRecordComponents();
	@PropertySetter(role = CtRole.RECORD_COMPONENT)
	CtRecord setRecordComponents(Set<CtRecordComponent> components);

	@Override
	CtRecord clone();

	@Override
	@UnsettableProperty
	<C extends CtType<Object>> C setSuperclass(CtTypeReference<?> superClass);

	@Override
	Set<CtTypeReference<?>> getPermittedTypes();

	@Override
	@UnsettableProperty
	CtRecord setPermittedTypes(Collection<CtTypeReference<?>> permittedTypes);

	@Override
	@UnsettableProperty
	CtRecord addPermittedType(CtTypeReference<?> type);

	@Override
	@UnsettableProperty
	CtRecord removePermittedType(CtTypeReference<?> type);
}
