/**
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.pattern.internal.node;

import spoon9.pattern.Quantifier;
import spoon9.pattern.internal.DefaultGenerator;
import spoon9.pattern.internal.ResultHolder;
import spoon9.pattern.internal.parameter.ParameterInfo;
import spoon9.support.util.ImmutableMap;

import java.util.function.BiConsumer;

/**
 * Generates/Matches a copy of single template object
 */
public class ConstantNode<T> extends AbstractPrimitiveMatcher {
	protected final T template;

	public ConstantNode(T template) {
		this.template = template;
	}

	public T getTemplateNode() {
		return template;
	}

	@Override
	public boolean replaceNode(RootNode oldNode, RootNode newNode) {
		return false;
	}

	@Override
	public void forEachParameterInfo(BiConsumer<ParameterInfo, RootNode> consumer) {
		//it has no parameters
	}

	@Override
	public <U> void generateTargets(DefaultGenerator generator, ResultHolder<U> result, ImmutableMap parameters) {
		result.addResult((U) template);
	}

	@Override
	public ImmutableMap matchTarget(Object target, ImmutableMap parameters) {
		if (target == null && template == null) {
			return parameters;
		}
		if (target == null || template == null) {
			return null;
		}
		if (target.getClass() != template.getClass()) {
			return null;
		}
		return target.equals(template) ? parameters : null;
	}

	@Override
	public String toString() {
		return String.valueOf(template);
	}

	@Override
	public Quantifier getMatchingStrategy() {
		return Quantifier.POSSESSIVE;
	}

	@Override
	public boolean isTryNextMatch(ImmutableMap parameters) {
		//it always matches only once
		return false;
	}
}

