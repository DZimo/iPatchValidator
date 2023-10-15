/**
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.refactoring;

import spoon9.reflect.code.CtConstructorCall;
import spoon9.reflect.code.CtInvocation;
import spoon9.reflect.code.CtLambda;
import spoon9.reflect.declaration.CtExecutable;
import spoon9.reflect.declaration.CtField;
import spoon9.reflect.declaration.CtMethod;
import spoon9.reflect.declaration.CtType;
import spoon9.reflect.visitor.CtScanner;
import spoon9.reflect.visitor.filter.TypeFilter;
import spoon9.support.reflect.code.CtLambdaImpl;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class for creating a mapping from CtExecutable to all known calls from fields
 * and methods.
 */
public class MethodInvocationSearch extends CtScanner {
	private Map<CtExecutable<?>, Collection<CtExecutable<?>>> invocationsOfMethod = new HashMap<>();
	private Map<CtExecutable<?>, Collection<CtType<?>>> invocationsOfField = new HashMap<>();

	@Override
	public <T> void visitCtMethod(CtMethod<T> method) {
		if (!method.getPosition().isValidPosition()) {
			return;
		}
		final CtExecutable<?> transformedMethod;
		if (method instanceof CtLambda) {
			// because lambdas are difficult we transform them
			// in a method public void foo(){ List.of("a").stream().forEach($method)}
			// we need the ref to foo() and not the ref to the lambda expression
			transformedMethod = method.getParent(CtExecutable.class);
		} else {
			transformedMethod = method;
		}
		List<CtInvocation<?>> invocations = method.getElements(new TypeFilter<>(CtInvocation.class));

		List<CtConstructorCall<?>> constructors = method.getElements(new TypeFilter<>(CtConstructorCall.class));
		if (!invocationsOfMethod.containsKey(method) && !method.isImplicit() && !(method instanceof CtLambdaImpl)) {
			// now every method should be key
			invocationsOfMethod.put(method, Collections.emptyList());
		}
		invocations.stream().filter(v -> !v.isImplicit()).map(v -> v.getExecutable().getExecutableDeclaration())
				.filter(Objects::nonNull).filter(v -> v.getPosition().isValidPosition())
				.forEach(v -> invocationsOfMethod.merge(v, new HashSet<>(Arrays.asList(transformedMethod)),
						(o1, o2) -> Stream.concat(o1.stream(), o2.stream()).collect(Collectors.toCollection(HashSet::new))));
		constructors.stream().filter(v -> !v.isImplicit()).map(v -> v.getExecutable().getExecutableDeclaration())
				.filter(Objects::nonNull)
				.forEach(v -> invocationsOfMethod.merge(v, new HashSet<>(Arrays.asList(transformedMethod)),
						(o1, o2) -> Stream.concat(o1.stream(), o2.stream()).collect(Collectors.toCollection(HashSet::new))));
		super.visitCtMethod(method);
	}

	public Collection<MethodCallState> getInvocationsOfMethod() {
		Collection<MethodCallState> transformedResult = new HashSet<>();
		Stream.concat(invocationsOfMethod.keySet().stream(), invocationsOfField.keySet().stream()).map(MethodCallState::new)
				.forEach(transformedResult::add);
		for (MethodCallState methodCallState : transformedResult) {
			invocationsOfField.getOrDefault(methodCallState.getMethod(), Collections.emptyList())
					.forEach(methodCallState::add);
			invocationsOfMethod.getOrDefault(methodCallState.getMethod(), Collections.emptyList())
					.forEach(methodCallState::add);
		}
		return transformedResult;
	}

	@Override
	public <T> void visitCtField(CtField<T> field) {
		field.getElements(new TypeFilter<>(CtInvocation.class)).stream()
				.map(call -> call.getExecutable().getExecutableDeclaration())
				.forEach(method -> invocationsOfField.merge(method, new HashSet<>(Arrays.asList(field.getDeclaringType())),
						(o1, o2) -> Stream.concat(o1.stream(), o2.stream()).collect(Collectors.toCollection(HashSet::new))));
		field.getElements(new TypeFilter<>(CtConstructorCall.class)).stream()
				.map(call -> call.getExecutable().getExecutableDeclaration())
				.forEach(method -> invocationsOfField.merge(method, new HashSet<>(Arrays.asList(field.getDeclaringType())),
						(o1, o2) -> Stream.concat(o1.stream(), o2.stream()).collect(Collectors.toCollection(HashSet::new))));
		super.visitCtField(field);
	}

}
