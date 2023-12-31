/**
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.reflect.factory;


import spoon9.reflect.CtModelImpl;
import spoon9.reflect.declaration.*;
import spoon9.reflect.reference.CtModuleReference;
import spoon9.reflect.reference.CtPackageReference;
import spoon9.reflect.reference.CtTypeReference;
import spoon9.reflect.visitor.CtVisitor;
import spoon9.support.reflect.declaration.CtElementImpl;
import spoon9.support.reflect.declaration.CtModuleImpl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class ModuleFactory extends SubFactory {

	public static class CtUnnamedModule extends CtModuleImpl {
		final Set<CtModule> allModules = new HashSet<>();
		final CtElement parent = new CtElementImpl() {
			@Override
			public void accept(CtVisitor visitor) {

			}

			@Override
			public CtElement getParent() throws ParentNotInitializedException {
				return null;
			}

			@Override
			public Factory getFactory() {
				return CtUnnamedModule.this.getFactory();
			}
		};


		{
			this.setSimpleName(CtModule.TOP_LEVEL_MODULE_NAME);
			this.addModule(this);
		}

		public boolean addModule(CtModule module) {
			return this.allModules.add(module);
		}

		public CtModule getModule(String name) {
			for (CtModule module : this.allModules) {
				if (module.getSimpleName().equals(name)) {
					return module;
				}
			}
			return null;
		}

		public Collection<CtModule> getAllModules() {
			return Collections.unmodifiableCollection(allModules);
		}

		@Override
		public <T extends CtNamedElement> T setSimpleName(String name) {
			if (name == null) {
				return (T) this;
			}

			if (name.equals(CtModule.TOP_LEVEL_MODULE_NAME)) {
				return super.setSimpleName(name);
			}

			return (T) this;
		}

		@Override
		public String toString() {
			return CtModule.TOP_LEVEL_MODULE_NAME;
		}

		@Override
		public void accept(CtVisitor visitor) {
			visitor.visitCtModule(this);
		}

		@Override
		public CtElement getParent() {
			return this.parent;
		}
	}

	public ModuleFactory(Factory factory) {
		super(factory);
	}

	public CtUnnamedModule getUnnamedModule() {
		return (CtUnnamedModule) factory.getModel().getUnnamedModule();
	}

	public Collection<CtModule> getAllModules() {
		return getUnnamedModule().getAllModules();
	}

	public CtModule getModule(String moduleName) {
		return getUnnamedModule().getModule(moduleName);
	}

	public CtModule getOrCreate(String moduleName) {
		if (moduleName == null || moduleName.isEmpty()) {
			return getUnnamedModule();
		}

		CtModule ctModule = getUnnamedModule().getModule(moduleName);
		if (ctModule == null) {
			ctModule = factory.Core().createModule().setSimpleName(moduleName);
			ctModule.setRootPackage(new CtModelImpl.CtRootPackage());
			ctModule.setParent(getUnnamedModule());
		}

		return ctModule;
	}

	public CtModuleReference createReference(CtModule module) {
		return factory.Core().createModuleReference().setSimpleName(module.getSimpleName());
	}

	public CtModuleRequirement createModuleRequirement(CtModuleReference moduleReference) {
		return factory.Core().createModuleRequirement().setModuleReference(moduleReference);
	}

	public CtPackageExport createPackageExport(CtPackageReference ctPackageReference) {
		return factory.Core().createPackageExport().setPackageReference(ctPackageReference);
	}

	public CtProvidedService createProvidedService(CtTypeReference typeReference) {
		return factory.Core().createProvidedService().setServiceType(typeReference);
	}

	public CtUsedService createUsedService(CtTypeReference typeReference) {
		return factory.Core().createUsedService().setServiceType(typeReference);
	}
}

