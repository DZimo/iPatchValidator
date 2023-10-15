/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2023 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) or the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.reflect;

import spoon9.processing.Processor;
import spoon9.reflect.declaration.CtElement;
import spoon9.reflect.declaration.CtModule;
import spoon9.reflect.declaration.CtNamedElement;
import spoon9.reflect.declaration.CtPackage;
import spoon9.reflect.declaration.CtType;
import spoon9.reflect.factory.Factory;
import spoon9.reflect.factory.ModuleFactory;
import spoon9.reflect.visitor.Filter;
import spoon9.reflect.visitor.chain.CtConsumableFunction;
import spoon9.reflect.visitor.chain.CtFunction;
import spoon9.reflect.visitor.chain.CtQuery;
import spoon9.reflect.visitor.filter.TypeFilter;
import spoon9.support.QueueProcessingManager;
import spoon9.support.reflect.declaration.CtPackageImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CtModelImpl implements CtModel {

	private static final long serialVersionUID = 1L;

	private boolean buildModelFinished = false;

	@Override
	public <R extends CtElement> CtQuery filterChildren(Filter<R> filter) {
		return getUnnamedModule().getFactory().Query().createQuery(this.getAllModules().toArray()).filterChildren(filter);
	}

	@Override
	public <I, R> CtQuery map(CtFunction<I, R> function) {
		return getUnnamedModule().getFactory().Query().createQuery(this.getAllModules().toArray()).map(function);
	}

	@Override
	public <I> CtQuery map(CtConsumableFunction<I> queryStep) {
		return getUnnamedModule().getFactory().Query().createQuery(this.getAllModules().toArray()).map(queryStep);
	}

	public static class CtRootPackage extends CtPackageImpl {
		{
			this.setSimpleName(CtPackage.TOP_LEVEL_PACKAGE_NAME);
		}

		@Override
		public <T extends CtNamedElement> T setSimpleName(String name) {
			if (name == null) {
				return (T) this;
			}

			if (name.equals(CtPackage.TOP_LEVEL_PACKAGE_NAME)) {
				return super.setSimpleName(name);
			}

			return (T) this;
		}

		@Override
		public String getQualifiedName() {
			return "";
		}

		@Override
		public String toString() {
			return TOP_LEVEL_PACKAGE_NAME;
		}
	}

	private final CtModule unnamedModule;

	public CtModelImpl(Factory f) {
		this.unnamedModule = new ModuleFactory.CtUnnamedModule();
		this.unnamedModule.setFactory(f);
		this.unnamedModule.setRootPackage(new CtRootPackage());
		getRootPackage().setFactory(f);
	}

	@Override
	public CtPackage getRootPackage() {
		return getUnnamedModule().getRootPackage();
	}


	@Override
	public Collection<CtType<?>> getAllTypes() {
		final List<CtType<?>> result = new ArrayList<>();
		getAllPackages().forEach(ctPackage -> {
			result.addAll(ctPackage.getTypes());
		});
		return result;
	}


	@Override
	public Collection<CtPackage> getAllPackages() {
		return Collections.unmodifiableCollection(getElements(new TypeFilter<>(CtPackage.class)));
	}

	@Override
	public CtModule getUnnamedModule() {
		return this.unnamedModule;
	}

	@Override
	public Collection<CtModule> getAllModules() {
		return ((ModuleFactory.CtUnnamedModule) this.unnamedModule).getAllModules();
	}


	@Override
	public void processWith(Processor<?> processor) {
		QueueProcessingManager processingManager = new QueueProcessingManager(getUnnamedModule().getFactory());
		processingManager.addProcessor(processor);
		processingManager.process(getAllModules());
	}

	@Override
	public <E extends CtElement> List<E> getElements(Filter<E> filter) {
		return filterChildren(filter).list();
	}


	@Override
	public boolean isBuildModelFinished() {
		return this.buildModelFinished;
	}

	@Override
	public <T extends CtModel> T setBuildModelIsFinished(boolean buildModelFinished) {
		this.buildModelFinished = buildModelFinished;
		return (T) this;
	}

}