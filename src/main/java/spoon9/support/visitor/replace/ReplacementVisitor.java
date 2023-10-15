/**
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.visitor.replace;
/**
 * Used to replace an element by another one.
 *
 * This class is generated automatically by the processor spoon.generating.ReplacementVisitorGenerator.
 */
public class ReplacementVisitor extends spoon9.reflect.visitor.CtScanner {
	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtYieldStatementExpressionReplaceListener implements ReplaceListener<spoon9.reflect.code.CtExpression> {
		private final spoon9.reflect.code.CtYieldStatement element;

		CtYieldStatementExpressionReplaceListener(spoon9.reflect.code.CtYieldStatement element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtExpression replace) {
			this.element.setExpression(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtTypeMemberWildcardImportReferenceTypeReferenceReplaceListener implements ReplaceListener<spoon9.reflect.reference.CtTypeReference> {
		private final spoon9.reflect.reference.CtTypeMemberWildcardImportReference element;

		CtTypeMemberWildcardImportReferenceTypeReferenceReplaceListener(spoon9.reflect.reference.CtTypeMemberWildcardImportReference element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.reference.CtTypeReference replace) {
			this.element.setTypeReference(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtPackageDeclarationReferenceReplaceListener implements ReplaceListener<spoon9.reflect.reference.CtPackageReference> {
		private final spoon9.reflect.declaration.CtPackageDeclaration element;

		CtPackageDeclarationReferenceReplaceListener(spoon9.reflect.declaration.CtPackageDeclaration element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.reference.CtPackageReference replace) {
			this.element.setReference(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtCompilationUnitDeclaredTypeReferencesReplaceListener implements ReplaceListListener<java.util.List> {
		private final spoon9.reflect.declaration.CtCompilationUnit element;

		CtCompilationUnitDeclaredTypeReferencesReplaceListener(spoon9.reflect.declaration.CtCompilationUnit element) {
			this.element = element;
		}

		@Override
		public void set(java.util.List replace) {
			this.element.setDeclaredTypeReferences(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtCompilationUnitDeclaredModuleReferenceReplaceListener implements ReplaceListener<spoon9.reflect.reference.CtModuleReference> {
		private final spoon9.reflect.declaration.CtCompilationUnit element;

		CtCompilationUnitDeclaredModuleReferenceReplaceListener(spoon9.reflect.declaration.CtCompilationUnit element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.reference.CtModuleReference replace) {
			this.element.setDeclaredModuleReference(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtCompilationUnitImportsReplaceListener implements ReplaceListListener<java.util.Collection> {
		private final spoon9.reflect.declaration.CtCompilationUnit element;

		CtCompilationUnitImportsReplaceListener(spoon9.reflect.declaration.CtCompilationUnit element) {
			this.element = element;
		}

		@Override
		public void set(java.util.Collection replace) {
			this.element.setImports(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtCompilationUnitPackageDeclarationReplaceListener implements ReplaceListener<spoon9.reflect.declaration.CtPackageDeclaration> {
		private final spoon9.reflect.declaration.CtCompilationUnit element;

		CtCompilationUnitPackageDeclarationReplaceListener(spoon9.reflect.declaration.CtCompilationUnit element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.declaration.CtPackageDeclaration replace) {
			this.element.setPackageDeclaration(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtUsedServiceServiceTypeReplaceListener implements ReplaceListener<spoon9.reflect.reference.CtTypeReference> {
		private final spoon9.reflect.declaration.CtUsedService element;

		CtUsedServiceServiceTypeReplaceListener(spoon9.reflect.declaration.CtUsedService element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.reference.CtTypeReference replace) {
			this.element.setServiceType(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtProvidedServiceImplementationTypesReplaceListener implements ReplaceListListener<java.util.List> {
		private final spoon9.reflect.declaration.CtProvidedService element;

		CtProvidedServiceImplementationTypesReplaceListener(spoon9.reflect.declaration.CtProvidedService element) {
			this.element = element;
		}

		@Override
		public void set(java.util.List replace) {
			this.element.setImplementationTypes(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtProvidedServiceServiceTypeReplaceListener implements ReplaceListener<spoon9.reflect.reference.CtTypeReference> {
		private final spoon9.reflect.declaration.CtProvidedService element;

		CtProvidedServiceServiceTypeReplaceListener(spoon9.reflect.declaration.CtProvidedService element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.reference.CtTypeReference replace) {
			this.element.setServiceType(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtModuleRequirementModuleReferenceReplaceListener implements ReplaceListener<spoon9.reflect.reference.CtModuleReference> {
		private final spoon9.reflect.declaration.CtModuleRequirement element;

		CtModuleRequirementModuleReferenceReplaceListener(spoon9.reflect.declaration.CtModuleRequirement element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.reference.CtModuleReference replace) {
			this.element.setModuleReference(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtPackageExportTargetExportReplaceListener implements ReplaceListListener<java.util.List> {
		private final spoon9.reflect.declaration.CtPackageExport element;

		CtPackageExportTargetExportReplaceListener(spoon9.reflect.declaration.CtPackageExport element) {
			this.element = element;
		}

		@Override
		public void set(java.util.List replace) {
			this.element.setTargetExport(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtPackageExportPackageReferenceReplaceListener implements ReplaceListener<spoon9.reflect.reference.CtPackageReference> {
		private final spoon9.reflect.declaration.CtPackageExport element;

		CtPackageExportPackageReferenceReplaceListener(spoon9.reflect.declaration.CtPackageExport element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.reference.CtPackageReference replace) {
			this.element.setPackageReference(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtModuleRootPackageReplaceListener implements ReplaceListener<spoon9.reflect.declaration.CtPackage> {
		private final spoon9.reflect.declaration.CtModule element;

		CtModuleRootPackageReplaceListener(spoon9.reflect.declaration.CtModule element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.declaration.CtPackage replace) {
			this.element.setRootPackage(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtModuleModuleDirectivesReplaceListener implements ReplaceListListener<java.util.List> {
		private final spoon9.reflect.declaration.CtModule element;

		CtModuleModuleDirectivesReplaceListener(spoon9.reflect.declaration.CtModule element) {
			this.element = element;
		}

		@Override
		public void set(java.util.List replace) {
			this.element.setModuleDirectives(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtImportReferenceReplaceListener implements ReplaceListener<spoon9.reflect.reference.CtReference> {
		private final spoon9.reflect.declaration.CtImport element;

		CtImportReferenceReplaceListener(spoon9.reflect.declaration.CtImport element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.reference.CtReference replace) {
			this.element.setReference(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtJavaDocTagsReplaceListener implements ReplaceListListener<java.util.List> {
		private final spoon9.reflect.code.CtJavaDoc element;

		CtJavaDocTagsReplaceListener(spoon9.reflect.code.CtJavaDoc element) {
			this.element = element;
		}

		@Override
		public void set(java.util.List replace) {
			this.element.setTags(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtFieldAccessVariableReplaceListener implements ReplaceListener<spoon9.reflect.reference.CtFieldReference> {
		private final spoon9.reflect.code.CtVariableAccess element;

		CtFieldAccessVariableReplaceListener(spoon9.reflect.code.CtVariableAccess element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.reference.CtFieldReference replace) {
			this.element.setVariable(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtWhileLoopingExpressionReplaceListener implements ReplaceListener<spoon9.reflect.code.CtExpression> {
		private final spoon9.reflect.code.CtWhile element;

		CtWhileLoopingExpressionReplaceListener(spoon9.reflect.code.CtWhile element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtExpression replace) {
			this.element.setLoopingExpression(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtVariableAccessVariableReplaceListener implements ReplaceListener<spoon9.reflect.reference.CtVariableReference> {
		private final spoon9.reflect.code.CtVariableAccess element;

		CtVariableAccessVariableReplaceListener(spoon9.reflect.code.CtVariableAccess element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.reference.CtVariableReference replace) {
			this.element.setVariable(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtUnaryOperatorOperandReplaceListener implements ReplaceListener<spoon9.reflect.code.CtExpression> {
		private final spoon9.reflect.code.CtUnaryOperator element;

		CtUnaryOperatorOperandReplaceListener(spoon9.reflect.code.CtUnaryOperator element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtExpression replace) {
			this.element.setOperand(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtTypeAccessAccessedTypeReplaceListener implements ReplaceListener<spoon9.reflect.reference.CtTypeReference> {
		private final spoon9.reflect.code.CtTypeAccess element;

		CtTypeAccessAccessedTypeReplaceListener(spoon9.reflect.code.CtTypeAccess element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.reference.CtTypeReference replace) {
			this.element.setAccessedType(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtIntersectionTypeReferenceBoundsReplaceListener implements ReplaceListListener<java.util.List> {
		private final spoon9.reflect.reference.CtIntersectionTypeReference element;

		CtIntersectionTypeReferenceBoundsReplaceListener(spoon9.reflect.reference.CtIntersectionTypeReference element) {
			this.element = element;
		}

		@Override
		public void set(java.util.List replace) {
			this.element.setBounds(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtWildcardReferenceBoundingTypeReplaceListener implements ReplaceListener<spoon9.reflect.reference.CtTypeReference> {
		private final spoon9.reflect.reference.CtWildcardReference element;

		CtWildcardReferenceBoundingTypeReplaceListener(spoon9.reflect.reference.CtWildcardReference element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.reference.CtTypeReference replace) {
			this.element.setBoundingType(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtTryWithResourceResourcesReplaceListener implements ReplaceListListener<java.util.List> {
		private final spoon9.reflect.code.CtTryWithResource element;

		CtTryWithResourceResourcesReplaceListener(spoon9.reflect.code.CtTryWithResource element) {
			this.element = element;
		}

		@Override
		public void set(java.util.List replace) {
			this.element.setResources(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtTryFinalizerReplaceListener implements ReplaceListener<spoon9.reflect.code.CtBlock> {
		private final spoon9.reflect.code.CtTry element;

		CtTryFinalizerReplaceListener(spoon9.reflect.code.CtTry element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtBlock replace) {
			this.element.setFinalizer(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtTryCatchersReplaceListener implements ReplaceListListener<java.util.List> {
		private final spoon9.reflect.code.CtTry element;

		CtTryCatchersReplaceListener(spoon9.reflect.code.CtTry element) {
			this.element = element;
		}

		@Override
		public void set(java.util.List replace) {
			this.element.setCatchers(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtTryBodyReplaceListener implements ReplaceListener<spoon9.reflect.code.CtBlock> {
		private final spoon9.reflect.code.CtBodyHolder element;

		CtTryBodyReplaceListener(spoon9.reflect.code.CtBodyHolder element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtBlock replace) {
			this.element.setBody(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtThrowThrownExpressionReplaceListener implements ReplaceListener<spoon9.reflect.code.CtExpression> {
		private final spoon9.reflect.code.CtThrow element;

		CtThrowThrownExpressionReplaceListener(spoon9.reflect.code.CtThrow element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtExpression replace) {
			this.element.setThrownExpression(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtSynchronizedBlockReplaceListener implements ReplaceListener<spoon9.reflect.code.CtBlock> {
		private final spoon9.reflect.code.CtSynchronized element;

		CtSynchronizedBlockReplaceListener(spoon9.reflect.code.CtSynchronized element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtBlock replace) {
			this.element.setBlock(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtSynchronizedExpressionReplaceListener implements ReplaceListener<spoon9.reflect.code.CtExpression> {
		private final spoon9.reflect.code.CtSynchronized element;

		CtSynchronizedExpressionReplaceListener(spoon9.reflect.code.CtSynchronized element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtExpression replace) {
			this.element.setExpression(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtAbstractSwitchCasesReplaceListener implements ReplaceListListener<java.util.List> {
		private final spoon9.reflect.code.CtAbstractSwitch element;

		CtAbstractSwitchCasesReplaceListener(spoon9.reflect.code.CtAbstractSwitch element) {
			this.element = element;
		}

		@Override
		public void set(java.util.List replace) {
			this.element.setCases(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtAbstractSwitchSelectorReplaceListener implements ReplaceListener<spoon9.reflect.code.CtExpression> {
		private final spoon9.reflect.code.CtAbstractSwitch element;

		CtAbstractSwitchSelectorReplaceListener(spoon9.reflect.code.CtAbstractSwitch element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtExpression replace) {
			this.element.setSelector(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtReturnReturnedExpressionReplaceListener implements ReplaceListener<spoon9.reflect.code.CtExpression> {
		private final spoon9.reflect.code.CtReturn element;

		CtReturnReturnedExpressionReplaceListener(spoon9.reflect.code.CtReturn element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtExpression replace) {
			this.element.setReturnedExpression(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtPackageTypesReplaceListener implements ReplaceSetListener<java.util.Set> {
		private final spoon9.reflect.declaration.CtPackage element;

		CtPackageTypesReplaceListener(spoon9.reflect.declaration.CtPackage element) {
			this.element = element;
		}

		@Override
		public void set(java.util.Set replace) {
			this.element.setTypes(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtPackagePackagesReplaceListener implements ReplaceSetListener<java.util.Set> {
		private final spoon9.reflect.declaration.CtPackage element;

		CtPackagePackagesReplaceListener(spoon9.reflect.declaration.CtPackage element) {
			this.element = element;
		}

		@Override
		public void set(java.util.Set replace) {
			this.element.setPackages(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtExecutableReferenceExpressionExecutableReplaceListener implements ReplaceListener<spoon9.reflect.reference.CtExecutableReference> {
		private final spoon9.reflect.code.CtExecutableReferenceExpression element;

		CtExecutableReferenceExpressionExecutableReplaceListener(spoon9.reflect.code.CtExecutableReferenceExpression element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.reference.CtExecutableReference replace) {
			this.element.setExecutable(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtLambdaExpressionReplaceListener implements ReplaceListener<spoon9.reflect.code.CtExpression> {
		private final spoon9.reflect.code.CtLambda element;

		CtLambdaExpressionReplaceListener(spoon9.reflect.code.CtLambda element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtExpression replace) {
			this.element.setExpression(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtNewClassAnonymousClassReplaceListener implements ReplaceListener<spoon9.reflect.declaration.CtClass> {
		private final spoon9.reflect.code.CtNewClass element;

		CtNewClassAnonymousClassReplaceListener(spoon9.reflect.code.CtNewClass element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.declaration.CtClass replace) {
			this.element.setAnonymousClass(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtNewArrayDimensionExpressionsReplaceListener implements ReplaceListListener<java.util.List> {
		private final spoon9.reflect.code.CtNewArray element;

		CtNewArrayDimensionExpressionsReplaceListener(spoon9.reflect.code.CtNewArray element) {
			this.element = element;
		}

		@Override
		public void set(java.util.List replace) {
			this.element.setDimensionExpressions(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtNewArrayElementsReplaceListener implements ReplaceListListener<java.util.List> {
		private final spoon9.reflect.code.CtNewArray element;

		CtNewArrayElementsReplaceListener(spoon9.reflect.code.CtNewArray element) {
			this.element = element;
		}

		@Override
		public void set(java.util.List replace) {
			this.element.setElements(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtAnnotationMethodDefaultExpressionReplaceListener implements ReplaceListener<spoon9.reflect.code.CtExpression> {
		private final spoon9.reflect.declaration.CtAnnotationMethod element;

		CtAnnotationMethodDefaultExpressionReplaceListener(spoon9.reflect.declaration.CtAnnotationMethod element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtExpression replace) {
			this.element.setDefaultExpression(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtMultiTypedElementMultiTypesReplaceListener implements ReplaceListListener<java.util.List> {
		private final spoon9.reflect.declaration.CtMultiTypedElement element;

		CtMultiTypedElementMultiTypesReplaceListener(spoon9.reflect.declaration.CtMultiTypedElement element) {
			this.element = element;
		}

		@Override
		public void set(java.util.List replace) {
			this.element.setMultiTypes(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtAbstractInvocationArgumentsReplaceListener implements ReplaceListListener<java.util.List> {
		private final spoon9.reflect.code.CtAbstractInvocation element;

		CtAbstractInvocationArgumentsReplaceListener(spoon9.reflect.code.CtAbstractInvocation element) {
			this.element = element;
		}

		@Override
		public void set(java.util.List replace) {
			this.element.setArguments(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtAbstractInvocationExecutableReplaceListener implements ReplaceListener<spoon9.reflect.reference.CtExecutableReference> {
		private final spoon9.reflect.code.CtAbstractInvocation element;

		CtAbstractInvocationExecutableReplaceListener(spoon9.reflect.code.CtAbstractInvocation element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.reference.CtExecutableReference replace) {
			this.element.setExecutable(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtIfElseStatementReplaceListener implements ReplaceListener<spoon9.reflect.code.CtStatement> {
		private final spoon9.reflect.code.CtIf element;

		CtIfElseStatementReplaceListener(spoon9.reflect.code.CtIf element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtStatement replace) {
			this.element.setElseStatement(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtIfThenStatementReplaceListener implements ReplaceListener<spoon9.reflect.code.CtStatement> {
		private final spoon9.reflect.code.CtIf element;

		CtIfThenStatementReplaceListener(spoon9.reflect.code.CtIf element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtStatement replace) {
			this.element.setThenStatement(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtIfConditionReplaceListener implements ReplaceListener<spoon9.reflect.code.CtExpression> {
		private final spoon9.reflect.code.CtIf element;

		CtIfConditionReplaceListener(spoon9.reflect.code.CtIf element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtExpression replace) {
			this.element.setCondition(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtForEachExpressionReplaceListener implements ReplaceListener<spoon9.reflect.code.CtExpression> {
		private final spoon9.reflect.code.CtForEach element;

		CtForEachExpressionReplaceListener(spoon9.reflect.code.CtForEach element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtExpression replace) {
			this.element.setExpression(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtForEachVariableReplaceListener implements ReplaceListener<spoon9.reflect.code.CtLocalVariable> {
		private final spoon9.reflect.code.CtForEach element;

		CtForEachVariableReplaceListener(spoon9.reflect.code.CtForEach element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtLocalVariable replace) {
			this.element.setVariable(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtForForUpdateReplaceListener implements ReplaceListListener<java.util.List> {
		private final spoon9.reflect.code.CtFor element;

		CtForForUpdateReplaceListener(spoon9.reflect.code.CtFor element) {
			this.element = element;
		}

		@Override
		public void set(java.util.List replace) {
			this.element.setForUpdate(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtForExpressionReplaceListener implements ReplaceListener<spoon9.reflect.code.CtExpression> {
		private final spoon9.reflect.code.CtFor element;

		CtForExpressionReplaceListener(spoon9.reflect.code.CtFor element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtExpression replace) {
			this.element.setExpression(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtForForInitReplaceListener implements ReplaceListListener<java.util.List> {
		private final spoon9.reflect.code.CtFor element;

		CtForForInitReplaceListener(spoon9.reflect.code.CtFor element) {
			this.element = element;
		}

		@Override
		public void set(java.util.List replace) {
			this.element.setForInit(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtVariableReferenceTypeReplaceListener implements ReplaceListener<spoon9.reflect.reference.CtTypeReference> {
		private final spoon9.reflect.reference.CtVariableReference element;

		CtVariableReferenceTypeReplaceListener(spoon9.reflect.reference.CtVariableReference element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.reference.CtTypeReference replace) {
			this.element.setType(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtFieldReferenceDeclaringTypeReplaceListener implements ReplaceListener<spoon9.reflect.reference.CtTypeReference> {
		private final spoon9.reflect.reference.CtFieldReference element;

		CtFieldReferenceDeclaringTypeReplaceListener(spoon9.reflect.reference.CtFieldReference element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.reference.CtTypeReference replace) {
			this.element.setDeclaringType(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtAnnotationFieldAccessVariableReplaceListener implements ReplaceListener<spoon9.reflect.reference.CtFieldReference> {
		private final spoon9.reflect.code.CtVariableAccess element;

		CtAnnotationFieldAccessVariableReplaceListener(spoon9.reflect.code.CtVariableAccess element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.reference.CtFieldReference replace) {
			this.element.setVariable(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtVariableDefaultExpressionReplaceListener implements ReplaceListener<spoon9.reflect.code.CtExpression> {
		private final spoon9.reflect.declaration.CtVariable element;

		CtVariableDefaultExpressionReplaceListener(spoon9.reflect.declaration.CtVariable element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtExpression replace) {
			this.element.setDefaultExpression(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtExecutableReferenceParametersReplaceListener implements ReplaceListListener<java.util.List> {
		private final spoon9.reflect.reference.CtExecutableReference element;

		CtExecutableReferenceParametersReplaceListener(spoon9.reflect.reference.CtExecutableReference element) {
			this.element = element;
		}

		@Override
		public void set(java.util.List replace) {
			this.element.setParameters(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtExecutableReferenceTypeReplaceListener implements ReplaceListener<spoon9.reflect.reference.CtTypeReference> {
		private final spoon9.reflect.reference.CtExecutableReference element;

		CtExecutableReferenceTypeReplaceListener(spoon9.reflect.reference.CtExecutableReference element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.reference.CtTypeReference replace) {
			this.element.setType(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtExecutableReferenceDeclaringTypeReplaceListener implements ReplaceListener<spoon9.reflect.reference.CtTypeReference> {
		private final spoon9.reflect.reference.CtExecutableReference element;

		CtExecutableReferenceDeclaringTypeReplaceListener(spoon9.reflect.reference.CtExecutableReference element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.reference.CtTypeReference replace) {
			this.element.setDeclaringType(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtEnumEnumValuesReplaceListener implements ReplaceListListener<java.util.List> {
		private final spoon9.reflect.declaration.CtEnum element;

		CtEnumEnumValuesReplaceListener(spoon9.reflect.declaration.CtEnum element) {
			this.element = element;
		}

		@Override
		public void set(java.util.List replace) {
			this.element.setEnumValues(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtLoopBodyReplaceListener implements ReplaceListener<spoon9.reflect.code.CtStatement> {
		private final spoon9.reflect.code.CtBodyHolder element;

		CtLoopBodyReplaceListener(spoon9.reflect.code.CtBodyHolder element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtStatement replace) {
			this.element.setBody(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtDoLoopingExpressionReplaceListener implements ReplaceListener<spoon9.reflect.code.CtExpression> {
		private final spoon9.reflect.code.CtDo element;

		CtDoLoopingExpressionReplaceListener(spoon9.reflect.code.CtDo element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtExpression replace) {
			this.element.setLoopingExpression(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtExecutableThrownTypesReplaceListener implements ReplaceSetListener<java.util.Set> {
		private final spoon9.reflect.declaration.CtExecutable element;

		CtExecutableThrownTypesReplaceListener(spoon9.reflect.declaration.CtExecutable element) {
			this.element = element;
		}

		@Override
		public void set(java.util.Set replace) {
			this.element.setThrownTypes(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtExecutableParametersReplaceListener implements ReplaceListListener<java.util.List> {
		private final spoon9.reflect.declaration.CtExecutable element;

		CtExecutableParametersReplaceListener(spoon9.reflect.declaration.CtExecutable element) {
			this.element = element;
		}

		@Override
		public void set(java.util.List replace) {
			this.element.setParameters(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtConditionalElseExpressionReplaceListener implements ReplaceListener<spoon9.reflect.code.CtExpression> {
		private final spoon9.reflect.code.CtConditional element;

		CtConditionalElseExpressionReplaceListener(spoon9.reflect.code.CtConditional element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtExpression replace) {
			this.element.setElseExpression(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtConditionalThenExpressionReplaceListener implements ReplaceListener<spoon9.reflect.code.CtExpression> {
		private final spoon9.reflect.code.CtConditional element;

		CtConditionalThenExpressionReplaceListener(spoon9.reflect.code.CtConditional element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtExpression replace) {
			this.element.setThenExpression(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtConditionalConditionReplaceListener implements ReplaceListener<spoon9.reflect.code.CtExpression> {
		private final spoon9.reflect.code.CtConditional element;

		CtConditionalConditionReplaceListener(spoon9.reflect.code.CtConditional element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtExpression replace) {
			this.element.setCondition(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtFormalTypeDeclarerFormalCtTypeParametersReplaceListener implements ReplaceListListener<java.util.List> {
		private final spoon9.reflect.declaration.CtFormalTypeDeclarer element;

		CtFormalTypeDeclarerFormalCtTypeParametersReplaceListener(spoon9.reflect.declaration.CtFormalTypeDeclarer element) {
			this.element = element;
		}

		@Override
		public void set(java.util.List replace) {
			this.element.setFormalCtTypeParameters(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtTypeInformationSuperInterfacesReplaceListener implements ReplaceSetListener<java.util.Set> {
		private final spoon9.reflect.declaration.CtType element;

		CtTypeInformationSuperInterfacesReplaceListener(spoon9.reflect.declaration.CtType element) {
			this.element = element;
		}

		@Override
		public void set(java.util.Set replace) {
			this.element.setSuperInterfaces(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtTypeInformationSuperclassReplaceListener implements ReplaceListener<spoon9.reflect.reference.CtTypeReference> {
		private final spoon9.reflect.declaration.CtType element;

		CtTypeInformationSuperclassReplaceListener(spoon9.reflect.declaration.CtType element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.reference.CtTypeReference replace) {
			this.element.setSuperclass(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtCatchBodyReplaceListener implements ReplaceListener<spoon9.reflect.code.CtBlock> {
		private final spoon9.reflect.code.CtBodyHolder element;

		CtCatchBodyReplaceListener(spoon9.reflect.code.CtBodyHolder element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtBlock replace) {
			this.element.setBody(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtCatchParameterReplaceListener implements ReplaceListener<spoon9.reflect.code.CtCatchVariable> {
		private final spoon9.reflect.code.CtCatch element;

		CtCatchParameterReplaceListener(spoon9.reflect.code.CtCatch element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtCatchVariable replace) {
			this.element.setParameter(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtCaseCaseExpressionsReplaceListener implements ReplaceListListener<java.util.List> {
		private final spoon9.reflect.code.CtCase element;

		CtCaseCaseExpressionsReplaceListener(spoon9.reflect.code.CtCase element) {
			this.element = element;
		}

		@Override
		public void set(java.util.List replace) {
			this.element.setCaseExpressions(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtStatementListStatementsReplaceListener implements ReplaceListListener<java.util.List> {
		private final spoon9.reflect.code.CtStatementList element;

		CtStatementListStatementsReplaceListener(spoon9.reflect.code.CtStatementList element) {
			this.element = element;
		}

		@Override
		public void set(java.util.List replace) {
			this.element.setStatements(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtBinaryOperatorRightHandOperandReplaceListener implements ReplaceListener<spoon9.reflect.code.CtExpression> {
		private final spoon9.reflect.code.CtBinaryOperator element;

		CtBinaryOperatorRightHandOperandReplaceListener(spoon9.reflect.code.CtBinaryOperator element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtExpression replace) {
			this.element.setRightHandOperand(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtBinaryOperatorLeftHandOperandReplaceListener implements ReplaceListener<spoon9.reflect.code.CtExpression> {
		private final spoon9.reflect.code.CtBinaryOperator element;

		CtBinaryOperatorLeftHandOperandReplaceListener(spoon9.reflect.code.CtBinaryOperator element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtExpression replace) {
			this.element.setLeftHandOperand(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtRHSReceiverAssignmentReplaceListener implements ReplaceListener<spoon9.reflect.code.CtExpression> {
		private final spoon9.reflect.code.CtRHSReceiver element;

		CtRHSReceiverAssignmentReplaceListener(spoon9.reflect.code.CtRHSReceiver element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtExpression replace) {
			this.element.setAssignment(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtAssignmentAssignedReplaceListener implements ReplaceListener<spoon9.reflect.code.CtExpression> {
		private final spoon9.reflect.code.CtAssignment element;

		CtAssignmentAssignedReplaceListener(spoon9.reflect.code.CtAssignment element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtExpression replace) {
			this.element.setAssigned(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtAssertExpressionReplaceListener implements ReplaceListener<spoon9.reflect.code.CtExpression> {
		private final spoon9.reflect.code.CtAssert element;

		CtAssertExpressionReplaceListener(spoon9.reflect.code.CtAssert element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtExpression replace) {
			this.element.setExpression(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtAssertAssertExpressionReplaceListener implements ReplaceListener<spoon9.reflect.code.CtExpression> {
		private final spoon9.reflect.code.CtAssert element;

		CtAssertAssertExpressionReplaceListener(spoon9.reflect.code.CtAssert element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtExpression replace) {
			this.element.setAssertExpression(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtActualTypeContainerActualTypeArgumentsReplaceListener implements ReplaceListListener<java.util.List> {
		private final spoon9.reflect.reference.CtActualTypeContainer element;

		CtActualTypeContainerActualTypeArgumentsReplaceListener(spoon9.reflect.reference.CtActualTypeContainer element) {
			this.element = element;
		}

		@Override
		public void set(java.util.List replace) {
			this.element.setActualTypeArguments(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtArrayTypeReferenceComponentTypeReplaceListener implements ReplaceListener<spoon9.reflect.reference.CtTypeReference> {
		private final spoon9.reflect.reference.CtArrayTypeReference element;

		CtArrayTypeReferenceComponentTypeReplaceListener(spoon9.reflect.reference.CtArrayTypeReference element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.reference.CtTypeReference replace) {
			this.element.setComponentType(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtTypeReferenceDeclaringTypeReplaceListener implements ReplaceListener<spoon9.reflect.reference.CtTypeReference> {
		private final spoon9.reflect.reference.CtTypeReference element;

		CtTypeReferenceDeclaringTypeReplaceListener(spoon9.reflect.reference.CtTypeReference element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.reference.CtTypeReference replace) {
			this.element.setDeclaringType(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtTypeReferencePackageReplaceListener implements ReplaceListener<spoon9.reflect.reference.CtPackageReference> {
		private final spoon9.reflect.reference.CtTypeReference element;

		CtTypeReferencePackageReplaceListener(spoon9.reflect.reference.CtTypeReference element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.reference.CtPackageReference replace) {
			this.element.setPackage(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtArrayAccessIndexExpressionReplaceListener implements ReplaceListener<spoon9.reflect.code.CtExpression> {
		private final spoon9.reflect.code.CtArrayAccess element;

		CtArrayAccessIndexExpressionReplaceListener(spoon9.reflect.code.CtArrayAccess element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtExpression replace) {
			this.element.setIndexExpression(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtTargetedExpressionTargetReplaceListener implements ReplaceListener<spoon9.reflect.code.CtExpression> {
		private final spoon9.reflect.code.CtTargetedExpression element;

		CtTargetedExpressionTargetReplaceListener(spoon9.reflect.code.CtTargetedExpression element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtExpression replace) {
			this.element.setTarget(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtExpressionTypeCastsReplaceListener implements ReplaceListListener<java.util.List> {
		private final spoon9.reflect.code.CtExpression element;

		CtExpressionTypeCastsReplaceListener(spoon9.reflect.code.CtExpression element) {
			this.element = element;
		}

		@Override
		public void set(java.util.List replace) {
			this.element.setTypeCasts(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtExecutableBodyReplaceListener implements ReplaceListener<spoon9.reflect.code.CtBlock> {
		private final spoon9.reflect.code.CtBodyHolder element;

		CtExecutableBodyReplaceListener(spoon9.reflect.code.CtBodyHolder element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.code.CtBlock replace) {
			this.element.setBody(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtTypeTypeMembersReplaceListener implements ReplaceListListener<java.util.List> {
		private final spoon9.reflect.declaration.CtType element;

		CtTypeTypeMembersReplaceListener(spoon9.reflect.declaration.CtType element) {
			this.element = element;
		}

		@Override
		public void set(java.util.List replace) {
			this.element.setTypeMembers(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtAnnotationValuesReplaceListener implements ReplaceMapListener<java.util.Map> {
		private final spoon9.reflect.declaration.CtAnnotation element;

		CtAnnotationValuesReplaceListener(spoon9.reflect.declaration.CtAnnotation element) {
			this.element = element;
		}

		@Override
		public void set(java.util.Map replace) {
			this.element.setValues(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtElementAnnotationsReplaceListener implements ReplaceListListener<java.util.List> {
		private final spoon9.reflect.declaration.CtElement element;

		CtElementAnnotationsReplaceListener(spoon9.reflect.declaration.CtElement element) {
			this.element = element;
		}

		@Override
		public void set(java.util.List replace) {
			this.element.setAnnotations(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtAnnotationAnnotationTypeReplaceListener implements ReplaceListener<spoon9.reflect.reference.CtTypeReference> {
		private final spoon9.reflect.declaration.CtAnnotation element;

		CtAnnotationAnnotationTypeReplaceListener(spoon9.reflect.declaration.CtAnnotation element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.reference.CtTypeReference replace) {
			this.element.setAnnotationType(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtElementCommentsReplaceListener implements ReplaceListListener<java.util.List> {
		private final spoon9.reflect.declaration.CtElement element;

		CtElementCommentsReplaceListener(spoon9.reflect.declaration.CtElement element) {
			this.element = element;
		}

		@Override
		public void set(java.util.List replace) {
			this.element.setComments(replace);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	class CtTypedElementTypeReplaceListener implements ReplaceListener<spoon9.reflect.reference.CtTypeReference> {
		private final spoon9.reflect.declaration.CtTypedElement element;

		CtTypedElementTypeReplaceListener(spoon9.reflect.declaration.CtTypedElement element) {
			this.element = element;
		}

		@Override
		public void set(spoon9.reflect.reference.CtTypeReference replace) {
			this.element.setType(replace);
		}
	}

	public static void replace(spoon9.reflect.declaration.CtElement original, spoon9.reflect.declaration.CtElement replace) {
		try {
			new ReplacementVisitor(original, replace == null ? ReplacementVisitor.EMPTY : new spoon9.reflect.declaration.CtElement[]{ replace }).scan(original.getParent());
		} catch (InvalidReplaceException e) {
			throw e;
		}
	}

	public static <E extends spoon9.reflect.declaration.CtElement> void replace(spoon9.reflect.declaration.CtElement original, java.util.Collection<E> replaces) {
		try {
			new ReplacementVisitor(original, replaces.toArray(new spoon9.reflect.declaration.CtElement[replaces.size()])).scan(original.getParent());
		} catch (InvalidReplaceException e) {
			throw e;
		}
	}

	private spoon9.reflect.declaration.CtElement original;

	private spoon9.reflect.declaration.CtElement[] replace;

	private static final spoon9.reflect.declaration.CtElement[] EMPTY = new spoon9.reflect.declaration.CtElement[0];

	private ReplacementVisitor(spoon9.reflect.declaration.CtElement original, spoon9.reflect.declaration.CtElement... replace) {
		this.original = original;
		this.replace = (replace == null) ? ReplacementVisitor.EMPTY : replace;
	}

	private <K, V extends spoon9.reflect.declaration.CtElement> void replaceInMapIfExist(java.util.Map<K, V> mapProtected, ReplaceMapListener listener) {
		java.util.Map<K, V> map = new java.util.HashMap<>(mapProtected);
		V shouldBeDeleted = null;
		K key = null;
		for (java.util.Map.Entry<K, V> entry : map.entrySet()) {
			if (entry.getValue() == original) {
				shouldBeDeleted = entry.getValue();
				key = entry.getKey();
				break;
			}
		}
		if (shouldBeDeleted != null) {
			if (replace.length > 0) {
				if (replace.length > 1) {
					throw new InvalidReplaceException("Cannot replace single value by multiple values in " + listener.getClass().getSimpleName());
				}
				V val = ((V) (replace[0]));
				if (val != null) {
					map.put(key, val);
					val.setParent(shouldBeDeleted.getParent());
				} else {
					map.remove(key);
				}
			} else {
				map.remove(key);
			}
			listener.set(map);
		}
	}

	private <T extends spoon9.reflect.declaration.CtElement> void replaceInSetIfExist(java.util.Set<T> setProtected, ReplaceSetListener listener) {
		java.util.Set<T> set = new java.util.HashSet<>(setProtected);
		T shouldBeDeleted = null;
		for (T element : set) {
			if (element == original) {
				shouldBeDeleted = element;
				break;
			}
		}
		if (shouldBeDeleted != null) {
			set.remove(shouldBeDeleted);
			for (spoon9.reflect.declaration.CtElement ele : replace) {
				if (ele != null) {
					set.add(((T) (ele)));
					ele.setParent(shouldBeDeleted.getParent());
				}
			}
			listener.set(set);
		}
	}

	private <T extends spoon9.reflect.declaration.CtElement> void replaceInListIfExist(java.util.List<T> listProtected, ReplaceListListener listener) {
		java.util.List<T> list = new java.util.ArrayList<>(listProtected);
		T shouldBeDeleted = null;
		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == original) {
				index = i;
				shouldBeDeleted = list.get(i);
				break;
			}
		}
		if (shouldBeDeleted != null) {
			list.remove(index);
			if (replace.length > 0) {
				for (spoon9.reflect.declaration.CtElement aReplace : replace) {
					T ele = ((T) (aReplace));
					if (ele != null) {
						list.add(index, ele);
						ele.setParent(shouldBeDeleted.getParent());
						index = index + 1;
					}
				}
			}
			listener.set(list);
		}
	}

	private void replaceElementIfExist(spoon9.reflect.declaration.CtElement candidate, ReplaceListener listener) {
		if (candidate == original) {
			spoon9.reflect.declaration.CtElement val = null;
			if (replace.length > 0) {
				if (replace.length > 1) {
					throw new InvalidReplaceException("Cannot replace single value by multiple values in " + listener.getClass().getSimpleName());
				}
				val = replace[0];
			}
			if (val != null) {
				val.setParent(candidate.getParent());
			}
			listener.set(val);
		}
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <A extends java.lang.annotation.Annotation> void visitCtAnnotation(final spoon9.reflect.declaration.CtAnnotation<A> annotation) {
		replaceElementIfExist(annotation.getType(), new CtTypedElementTypeReplaceListener(annotation));
		replaceInListIfExist(annotation.getComments(), new CtElementCommentsReplaceListener(annotation));
		replaceElementIfExist(annotation.getAnnotationType(), new CtAnnotationAnnotationTypeReplaceListener(annotation));
		replaceInListIfExist(annotation.getAnnotations(), new CtElementAnnotationsReplaceListener(annotation));
		replaceInMapIfExist(annotation.getValues(), new CtAnnotationValuesReplaceListener(annotation));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <A extends java.lang.annotation.Annotation> void visitCtAnnotationType(final spoon9.reflect.declaration.CtAnnotationType<A> annotationType) {
		replaceInListIfExist(annotationType.getAnnotations(), new CtElementAnnotationsReplaceListener(annotationType));
		replaceInListIfExist(annotationType.getTypeMembers(), new CtTypeTypeMembersReplaceListener(annotationType));
		replaceInListIfExist(annotationType.getComments(), new CtElementCommentsReplaceListener(annotationType));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtAnonymousExecutable(final spoon9.reflect.declaration.CtAnonymousExecutable anonymousExec) {
		replaceInListIfExist(anonymousExec.getAnnotations(), new CtElementAnnotationsReplaceListener(anonymousExec));
		replaceElementIfExist(anonymousExec.getBody(), new CtExecutableBodyReplaceListener(anonymousExec));
		replaceInListIfExist(anonymousExec.getComments(), new CtElementCommentsReplaceListener(anonymousExec));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtArrayRead(final spoon9.reflect.code.CtArrayRead<T> arrayRead) {
		replaceInListIfExist(arrayRead.getAnnotations(), new CtElementAnnotationsReplaceListener(arrayRead));
		replaceElementIfExist(arrayRead.getType(), new CtTypedElementTypeReplaceListener(arrayRead));
		replaceInListIfExist(arrayRead.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(arrayRead));
		replaceElementIfExist(arrayRead.getTarget(), new CtTargetedExpressionTargetReplaceListener(arrayRead));
		replaceElementIfExist(arrayRead.getIndexExpression(), new CtArrayAccessIndexExpressionReplaceListener(arrayRead));
		replaceInListIfExist(arrayRead.getComments(), new CtElementCommentsReplaceListener(arrayRead));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtArrayWrite(final spoon9.reflect.code.CtArrayWrite<T> arrayWrite) {
		replaceInListIfExist(arrayWrite.getAnnotations(), new CtElementAnnotationsReplaceListener(arrayWrite));
		replaceElementIfExist(arrayWrite.getType(), new CtTypedElementTypeReplaceListener(arrayWrite));
		replaceInListIfExist(arrayWrite.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(arrayWrite));
		replaceElementIfExist(arrayWrite.getTarget(), new CtTargetedExpressionTargetReplaceListener(arrayWrite));
		replaceElementIfExist(arrayWrite.getIndexExpression(), new CtArrayAccessIndexExpressionReplaceListener(arrayWrite));
		replaceInListIfExist(arrayWrite.getComments(), new CtElementCommentsReplaceListener(arrayWrite));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtArrayTypeReference(final spoon9.reflect.reference.CtArrayTypeReference<T> reference) {
		replaceElementIfExist(reference.getPackage(), new CtTypeReferencePackageReplaceListener(reference));
		replaceElementIfExist(reference.getDeclaringType(), new CtTypeReferenceDeclaringTypeReplaceListener(reference));
		replaceElementIfExist(reference.getComponentType(), new CtArrayTypeReferenceComponentTypeReplaceListener(reference));
		replaceInListIfExist(reference.getActualTypeArguments(), new CtActualTypeContainerActualTypeArgumentsReplaceListener(reference));
		replaceInListIfExist(reference.getAnnotations(), new CtElementAnnotationsReplaceListener(reference));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtAssert(final spoon9.reflect.code.CtAssert<T> asserted) {
		replaceInListIfExist(asserted.getAnnotations(), new CtElementAnnotationsReplaceListener(asserted));
		replaceElementIfExist(asserted.getAssertExpression(), new CtAssertAssertExpressionReplaceListener(asserted));
		replaceElementIfExist(asserted.getExpression(), new CtAssertExpressionReplaceListener(asserted));
		replaceInListIfExist(asserted.getComments(), new CtElementCommentsReplaceListener(asserted));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T, A extends T> void visitCtAssignment(final spoon9.reflect.code.CtAssignment<T, A> assignement) {
		replaceInListIfExist(assignement.getAnnotations(), new CtElementAnnotationsReplaceListener(assignement));
		replaceElementIfExist(assignement.getType(), new CtTypedElementTypeReplaceListener(assignement));
		replaceInListIfExist(assignement.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(assignement));
		replaceElementIfExist(assignement.getAssigned(), new CtAssignmentAssignedReplaceListener(assignement));
		replaceElementIfExist(assignement.getAssignment(), new CtRHSReceiverAssignmentReplaceListener(assignement));
		replaceInListIfExist(assignement.getComments(), new CtElementCommentsReplaceListener(assignement));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtBinaryOperator(final spoon9.reflect.code.CtBinaryOperator<T> operator) {
		replaceInListIfExist(operator.getAnnotations(), new CtElementAnnotationsReplaceListener(operator));
		replaceElementIfExist(operator.getType(), new CtTypedElementTypeReplaceListener(operator));
		replaceInListIfExist(operator.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(operator));
		replaceElementIfExist(operator.getLeftHandOperand(), new CtBinaryOperatorLeftHandOperandReplaceListener(operator));
		replaceElementIfExist(operator.getRightHandOperand(), new CtBinaryOperatorRightHandOperandReplaceListener(operator));
		replaceInListIfExist(operator.getComments(), new CtElementCommentsReplaceListener(operator));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <R> void visitCtBlock(final spoon9.reflect.code.CtBlock<R> block) {
		replaceInListIfExist(block.getAnnotations(), new CtElementAnnotationsReplaceListener(block));
		replaceInListIfExist(block.getStatements(), new CtStatementListStatementsReplaceListener(block));
		replaceInListIfExist(block.getComments(), new CtElementCommentsReplaceListener(block));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtBreak(final spoon9.reflect.code.CtBreak breakStatement) {
		replaceInListIfExist(breakStatement.getAnnotations(), new CtElementAnnotationsReplaceListener(breakStatement));
		replaceInListIfExist(breakStatement.getComments(), new CtElementCommentsReplaceListener(breakStatement));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <S> void visitCtCase(final spoon9.reflect.code.CtCase<S> caseStatement) {
		replaceInListIfExist(caseStatement.getAnnotations(), new CtElementAnnotationsReplaceListener(caseStatement));
		replaceInListIfExist(caseStatement.getCaseExpressions(), new CtCaseCaseExpressionsReplaceListener(caseStatement));
		replaceInListIfExist(caseStatement.getStatements(), new CtStatementListStatementsReplaceListener(caseStatement));
		replaceInListIfExist(caseStatement.getComments(), new CtElementCommentsReplaceListener(caseStatement));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtCatch(final spoon9.reflect.code.CtCatch catchBlock) {
		replaceInListIfExist(catchBlock.getAnnotations(), new CtElementAnnotationsReplaceListener(catchBlock));
		replaceElementIfExist(catchBlock.getParameter(), new CtCatchParameterReplaceListener(catchBlock));
		replaceElementIfExist(catchBlock.getBody(), new CtCatchBodyReplaceListener(catchBlock));
		replaceInListIfExist(catchBlock.getComments(), new CtElementCommentsReplaceListener(catchBlock));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtClass(final spoon9.reflect.declaration.CtClass<T> ctClass) {
		replaceInListIfExist(ctClass.getAnnotations(), new CtElementAnnotationsReplaceListener(ctClass));
		replaceElementIfExist(ctClass.getSuperclass(), new CtTypeInformationSuperclassReplaceListener(ctClass));
		replaceInSetIfExist(ctClass.getSuperInterfaces(), new CtTypeInformationSuperInterfacesReplaceListener(ctClass));
		replaceInListIfExist(ctClass.getFormalCtTypeParameters(), new CtFormalTypeDeclarerFormalCtTypeParametersReplaceListener(ctClass));
		replaceInListIfExist(ctClass.getTypeMembers(), new CtTypeTypeMembersReplaceListener(ctClass));
		replaceInListIfExist(ctClass.getComments(), new CtElementCommentsReplaceListener(ctClass));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtTypeParameter(spoon9.reflect.declaration.CtTypeParameter typeParameter) {
		replaceInListIfExist(typeParameter.getAnnotations(), new CtElementAnnotationsReplaceListener(typeParameter));
		replaceElementIfExist(typeParameter.getSuperclass(), new CtTypeInformationSuperclassReplaceListener(typeParameter));
		replaceInListIfExist(typeParameter.getComments(), new CtElementCommentsReplaceListener(typeParameter));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtConditional(final spoon9.reflect.code.CtConditional<T> conditional) {
		replaceElementIfExist(conditional.getType(), new CtTypedElementTypeReplaceListener(conditional));
		replaceInListIfExist(conditional.getAnnotations(), new CtElementAnnotationsReplaceListener(conditional));
		replaceElementIfExist(conditional.getCondition(), new CtConditionalConditionReplaceListener(conditional));
		replaceElementIfExist(conditional.getThenExpression(), new CtConditionalThenExpressionReplaceListener(conditional));
		replaceElementIfExist(conditional.getElseExpression(), new CtConditionalElseExpressionReplaceListener(conditional));
		replaceInListIfExist(conditional.getComments(), new CtElementCommentsReplaceListener(conditional));
		replaceInListIfExist(conditional.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(conditional));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtConstructor(final spoon9.reflect.declaration.CtConstructor<T> c) {
		replaceInListIfExist(c.getAnnotations(), new CtElementAnnotationsReplaceListener(c));
		replaceInListIfExist(c.getParameters(), new CtExecutableParametersReplaceListener(c));
		replaceInSetIfExist(c.getThrownTypes(), new CtExecutableThrownTypesReplaceListener(c));
		replaceInListIfExist(c.getFormalCtTypeParameters(), new CtFormalTypeDeclarerFormalCtTypeParametersReplaceListener(c));
		replaceElementIfExist(c.getBody(), new CtExecutableBodyReplaceListener(c));
		replaceInListIfExist(c.getComments(), new CtElementCommentsReplaceListener(c));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtContinue(final spoon9.reflect.code.CtContinue continueStatement) {
		replaceInListIfExist(continueStatement.getAnnotations(), new CtElementAnnotationsReplaceListener(continueStatement));
		replaceInListIfExist(continueStatement.getComments(), new CtElementCommentsReplaceListener(continueStatement));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtDo(final spoon9.reflect.code.CtDo doLoop) {
		replaceInListIfExist(doLoop.getAnnotations(), new CtElementAnnotationsReplaceListener(doLoop));
		replaceElementIfExist(doLoop.getLoopingExpression(), new CtDoLoopingExpressionReplaceListener(doLoop));
		replaceElementIfExist(doLoop.getBody(), new CtLoopBodyReplaceListener(doLoop));
		replaceInListIfExist(doLoop.getComments(), new CtElementCommentsReplaceListener(doLoop));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T extends Enum<?>> void visitCtEnum(final spoon9.reflect.declaration.CtEnum<T> ctEnum) {
		replaceInListIfExist(ctEnum.getAnnotations(), new CtElementAnnotationsReplaceListener(ctEnum));
		replaceInSetIfExist(ctEnum.getSuperInterfaces(), new CtTypeInformationSuperInterfacesReplaceListener(ctEnum));
		replaceInListIfExist(ctEnum.getTypeMembers(), new CtTypeTypeMembersReplaceListener(ctEnum));
		replaceInListIfExist(ctEnum.getEnumValues(), new CtEnumEnumValuesReplaceListener(ctEnum));
		replaceInListIfExist(ctEnum.getComments(), new CtElementCommentsReplaceListener(ctEnum));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtExecutableReference(final spoon9.reflect.reference.CtExecutableReference<T> reference) {
		replaceElementIfExist(reference.getDeclaringType(), new CtExecutableReferenceDeclaringTypeReplaceListener(reference));
		replaceElementIfExist(reference.getType(), new CtExecutableReferenceTypeReplaceListener(reference));
		replaceInListIfExist(reference.getParameters(), new CtExecutableReferenceParametersReplaceListener(reference));
		replaceInListIfExist(reference.getActualTypeArguments(), new CtActualTypeContainerActualTypeArgumentsReplaceListener(reference));
		replaceInListIfExist(reference.getAnnotations(), new CtElementAnnotationsReplaceListener(reference));
		replaceInListIfExist(reference.getComments(), new CtElementCommentsReplaceListener(reference));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtField(final spoon9.reflect.declaration.CtField<T> f) {
		replaceInListIfExist(f.getAnnotations(), new CtElementAnnotationsReplaceListener(f));
		replaceElementIfExist(f.getType(), new CtTypedElementTypeReplaceListener(f));
		replaceElementIfExist(f.getDefaultExpression(), new CtVariableDefaultExpressionReplaceListener(f));
		replaceInListIfExist(f.getComments(), new CtElementCommentsReplaceListener(f));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtEnumValue(final spoon9.reflect.declaration.CtEnumValue<T> enumValue) {
		replaceInListIfExist(enumValue.getAnnotations(), new CtElementAnnotationsReplaceListener(enumValue));
		replaceElementIfExist(enumValue.getType(), new CtTypedElementTypeReplaceListener(enumValue));
		replaceElementIfExist(enumValue.getDefaultExpression(), new CtVariableDefaultExpressionReplaceListener(enumValue));
		replaceInListIfExist(enumValue.getComments(), new CtElementCommentsReplaceListener(enumValue));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtThisAccess(final spoon9.reflect.code.CtThisAccess<T> thisAccess) {
		replaceInListIfExist(thisAccess.getComments(), new CtElementCommentsReplaceListener(thisAccess));
		replaceInListIfExist(thisAccess.getAnnotations(), new CtElementAnnotationsReplaceListener(thisAccess));
		replaceElementIfExist(thisAccess.getType(), new CtTypedElementTypeReplaceListener(thisAccess));
		replaceInListIfExist(thisAccess.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(thisAccess));
		replaceElementIfExist(thisAccess.getTarget(), new CtTargetedExpressionTargetReplaceListener(thisAccess));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtAnnotationFieldAccess(final spoon9.reflect.code.CtAnnotationFieldAccess<T> annotationFieldAccess) {
		replaceInListIfExist(annotationFieldAccess.getComments(), new CtElementCommentsReplaceListener(annotationFieldAccess));
		replaceInListIfExist(annotationFieldAccess.getAnnotations(), new CtElementAnnotationsReplaceListener(annotationFieldAccess));
		replaceInListIfExist(annotationFieldAccess.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(annotationFieldAccess));
		replaceElementIfExist(annotationFieldAccess.getTarget(), new CtTargetedExpressionTargetReplaceListener(annotationFieldAccess));
		replaceElementIfExist(annotationFieldAccess.getVariable(), new CtAnnotationFieldAccessVariableReplaceListener(annotationFieldAccess));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtFieldReference(final spoon9.reflect.reference.CtFieldReference<T> reference) {
		replaceElementIfExist(reference.getDeclaringType(), new CtFieldReferenceDeclaringTypeReplaceListener(reference));
		replaceElementIfExist(reference.getType(), new CtVariableReferenceTypeReplaceListener(reference));
		replaceInListIfExist(reference.getAnnotations(), new CtElementAnnotationsReplaceListener(reference));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtFor(final spoon9.reflect.code.CtFor forLoop) {
		replaceInListIfExist(forLoop.getAnnotations(), new CtElementAnnotationsReplaceListener(forLoop));
		replaceInListIfExist(forLoop.getForInit(), new CtForForInitReplaceListener(forLoop));
		replaceElementIfExist(forLoop.getExpression(), new CtForExpressionReplaceListener(forLoop));
		replaceInListIfExist(forLoop.getForUpdate(), new CtForForUpdateReplaceListener(forLoop));
		replaceElementIfExist(forLoop.getBody(), new CtLoopBodyReplaceListener(forLoop));
		replaceInListIfExist(forLoop.getComments(), new CtElementCommentsReplaceListener(forLoop));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtForEach(final spoon9.reflect.code.CtForEach foreach) {
		replaceInListIfExist(foreach.getAnnotations(), new CtElementAnnotationsReplaceListener(foreach));
		replaceElementIfExist(foreach.getVariable(), new CtForEachVariableReplaceListener(foreach));
		replaceElementIfExist(foreach.getExpression(), new CtForEachExpressionReplaceListener(foreach));
		replaceElementIfExist(foreach.getBody(), new CtLoopBodyReplaceListener(foreach));
		replaceInListIfExist(foreach.getComments(), new CtElementCommentsReplaceListener(foreach));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtIf(final spoon9.reflect.code.CtIf ifElement) {
		replaceInListIfExist(ifElement.getAnnotations(), new CtElementAnnotationsReplaceListener(ifElement));
		replaceElementIfExist(ifElement.getCondition(), new CtIfConditionReplaceListener(ifElement));
		replaceElementIfExist(((spoon9.reflect.code.CtStatement) (ifElement.getThenStatement())), new CtIfThenStatementReplaceListener(ifElement));
		replaceElementIfExist(((spoon9.reflect.code.CtStatement) (ifElement.getElseStatement())), new CtIfElseStatementReplaceListener(ifElement));
		replaceInListIfExist(ifElement.getComments(), new CtElementCommentsReplaceListener(ifElement));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtInterface(final spoon9.reflect.declaration.CtInterface<T> intrface) {
		replaceInListIfExist(intrface.getAnnotations(), new CtElementAnnotationsReplaceListener(intrface));
		replaceInSetIfExist(intrface.getSuperInterfaces(), new CtTypeInformationSuperInterfacesReplaceListener(intrface));
		replaceInListIfExist(intrface.getFormalCtTypeParameters(), new CtFormalTypeDeclarerFormalCtTypeParametersReplaceListener(intrface));
		replaceInListIfExist(intrface.getTypeMembers(), new CtTypeTypeMembersReplaceListener(intrface));
		replaceInListIfExist(intrface.getComments(), new CtElementCommentsReplaceListener(intrface));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtInvocation(final spoon9.reflect.code.CtInvocation<T> invocation) {
		replaceInListIfExist(invocation.getAnnotations(), new CtElementAnnotationsReplaceListener(invocation));
		replaceInListIfExist(invocation.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(invocation));
		replaceElementIfExist(invocation.getTarget(), new CtTargetedExpressionTargetReplaceListener(invocation));
		replaceElementIfExist(invocation.getExecutable(), new CtAbstractInvocationExecutableReplaceListener(invocation));
		replaceInListIfExist(invocation.getArguments(), new CtAbstractInvocationArgumentsReplaceListener(invocation));
		replaceInListIfExist(invocation.getComments(), new CtElementCommentsReplaceListener(invocation));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtLiteral(final spoon9.reflect.code.CtLiteral<T> literal) {
		replaceInListIfExist(literal.getAnnotations(), new CtElementAnnotationsReplaceListener(literal));
		replaceElementIfExist(literal.getType(), new CtTypedElementTypeReplaceListener(literal));
		replaceInListIfExist(literal.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(literal));
		replaceInListIfExist(literal.getComments(), new CtElementCommentsReplaceListener(literal));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtTextBlock(final spoon9.reflect.code.CtTextBlock literal) {
		replaceInListIfExist(literal.getAnnotations(), new CtElementAnnotationsReplaceListener(literal));
		replaceElementIfExist(literal.getType(), new CtTypedElementTypeReplaceListener(literal));
		replaceInListIfExist(literal.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(literal));
		replaceInListIfExist(literal.getComments(), new CtElementCommentsReplaceListener(literal));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtLocalVariable(final spoon9.reflect.code.CtLocalVariable<T> localVariable) {
		replaceInListIfExist(localVariable.getAnnotations(), new CtElementAnnotationsReplaceListener(localVariable));
		replaceElementIfExist(localVariable.getType(), new CtTypedElementTypeReplaceListener(localVariable));
		replaceElementIfExist(localVariable.getDefaultExpression(), new CtVariableDefaultExpressionReplaceListener(localVariable));
		replaceInListIfExist(localVariable.getComments(), new CtElementCommentsReplaceListener(localVariable));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtLocalVariableReference(final spoon9.reflect.reference.CtLocalVariableReference<T> reference) {
		replaceElementIfExist(reference.getType(), new CtVariableReferenceTypeReplaceListener(reference));
		replaceInListIfExist(reference.getAnnotations(), new CtElementAnnotationsReplaceListener(reference));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtCatchVariable(final spoon9.reflect.code.CtCatchVariable<T> catchVariable) {
		replaceInListIfExist(catchVariable.getComments(), new CtElementCommentsReplaceListener(catchVariable));
		replaceInListIfExist(catchVariable.getAnnotations(), new CtElementAnnotationsReplaceListener(catchVariable));
		replaceInListIfExist(catchVariable.getMultiTypes(), new CtMultiTypedElementMultiTypesReplaceListener(catchVariable));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtCatchVariableReference(final spoon9.reflect.reference.CtCatchVariableReference<T> reference) {
		replaceElementIfExist(reference.getType(), new CtVariableReferenceTypeReplaceListener(reference));
		replaceInListIfExist(reference.getAnnotations(), new CtElementAnnotationsReplaceListener(reference));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtMethod(final spoon9.reflect.declaration.CtMethod<T> m) {
		replaceInListIfExist(m.getAnnotations(), new CtElementAnnotationsReplaceListener(m));
		replaceInListIfExist(m.getFormalCtTypeParameters(), new CtFormalTypeDeclarerFormalCtTypeParametersReplaceListener(m));
		replaceElementIfExist(m.getType(), new CtTypedElementTypeReplaceListener(m));
		replaceInListIfExist(m.getParameters(), new CtExecutableParametersReplaceListener(m));
		replaceInSetIfExist(m.getThrownTypes(), new CtExecutableThrownTypesReplaceListener(m));
		replaceElementIfExist(m.getBody(), new CtExecutableBodyReplaceListener(m));
		replaceInListIfExist(m.getComments(), new CtElementCommentsReplaceListener(m));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtAnnotationMethod(spoon9.reflect.declaration.CtAnnotationMethod<T> annotationMethod) {
		replaceInListIfExist(annotationMethod.getAnnotations(), new CtElementAnnotationsReplaceListener(annotationMethod));
		replaceElementIfExist(annotationMethod.getType(), new CtTypedElementTypeReplaceListener(annotationMethod));
		replaceElementIfExist(annotationMethod.getDefaultExpression(), new CtAnnotationMethodDefaultExpressionReplaceListener(annotationMethod));
		replaceInListIfExist(annotationMethod.getComments(), new CtElementCommentsReplaceListener(annotationMethod));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtNewArray(final spoon9.reflect.code.CtNewArray<T> newArray) {
		replaceInListIfExist(newArray.getAnnotations(), new CtElementAnnotationsReplaceListener(newArray));
		replaceElementIfExist(newArray.getType(), new CtTypedElementTypeReplaceListener(newArray));
		replaceInListIfExist(newArray.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(newArray));
		replaceInListIfExist(newArray.getElements(), new CtNewArrayElementsReplaceListener(newArray));
		replaceInListIfExist(newArray.getDimensionExpressions(), new CtNewArrayDimensionExpressionsReplaceListener(newArray));
		replaceInListIfExist(newArray.getComments(), new CtElementCommentsReplaceListener(newArray));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtConstructorCall(final spoon9.reflect.code.CtConstructorCall<T> ctConstructorCall) {
		replaceInListIfExist(ctConstructorCall.getAnnotations(), new CtElementAnnotationsReplaceListener(ctConstructorCall));
		replaceInListIfExist(ctConstructorCall.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(ctConstructorCall));
		replaceElementIfExist(ctConstructorCall.getExecutable(), new CtAbstractInvocationExecutableReplaceListener(ctConstructorCall));
		replaceElementIfExist(ctConstructorCall.getTarget(), new CtTargetedExpressionTargetReplaceListener(ctConstructorCall));
		replaceInListIfExist(ctConstructorCall.getArguments(), new CtAbstractInvocationArgumentsReplaceListener(ctConstructorCall));
		replaceInListIfExist(ctConstructorCall.getComments(), new CtElementCommentsReplaceListener(ctConstructorCall));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtNewClass(final spoon9.reflect.code.CtNewClass<T> newClass) {
		replaceInListIfExist(newClass.getAnnotations(), new CtElementAnnotationsReplaceListener(newClass));
		replaceInListIfExist(newClass.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(newClass));
		replaceElementIfExist(newClass.getExecutable(), new CtAbstractInvocationExecutableReplaceListener(newClass));
		replaceElementIfExist(newClass.getTarget(), new CtTargetedExpressionTargetReplaceListener(newClass));
		replaceInListIfExist(newClass.getArguments(), new CtAbstractInvocationArgumentsReplaceListener(newClass));
		replaceElementIfExist(newClass.getAnonymousClass(), new CtNewClassAnonymousClassReplaceListener(newClass));
		replaceInListIfExist(newClass.getComments(), new CtElementCommentsReplaceListener(newClass));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtLambda(final spoon9.reflect.code.CtLambda<T> lambda) {
		replaceInListIfExist(lambda.getAnnotations(), new CtElementAnnotationsReplaceListener(lambda));
		replaceElementIfExist(lambda.getType(), new CtTypedElementTypeReplaceListener(lambda));
		replaceInListIfExist(lambda.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(lambda));
		replaceInListIfExist(lambda.getParameters(), new CtExecutableParametersReplaceListener(lambda));
		replaceElementIfExist(lambda.getBody(), new CtExecutableBodyReplaceListener(lambda));
		replaceElementIfExist(lambda.getExpression(), new CtLambdaExpressionReplaceListener(lambda));
		replaceInListIfExist(lambda.getComments(), new CtElementCommentsReplaceListener(lambda));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T, E extends spoon9.reflect.code.CtExpression<?>> void visitCtExecutableReferenceExpression(final spoon9.reflect.code.CtExecutableReferenceExpression<T, E> expression) {
		replaceInListIfExist(expression.getComments(), new CtElementCommentsReplaceListener(expression));
		replaceInListIfExist(expression.getAnnotations(), new CtElementAnnotationsReplaceListener(expression));
		replaceElementIfExist(expression.getType(), new CtTypedElementTypeReplaceListener(expression));
		replaceInListIfExist(expression.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(expression));
		replaceElementIfExist(expression.getExecutable(), new CtExecutableReferenceExpressionExecutableReplaceListener(expression));
		replaceElementIfExist(expression.getTarget(), new CtTargetedExpressionTargetReplaceListener(expression));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T, A extends T> void visitCtOperatorAssignment(final spoon9.reflect.code.CtOperatorAssignment<T, A> assignment) {
		replaceInListIfExist(assignment.getAnnotations(), new CtElementAnnotationsReplaceListener(assignment));
		replaceElementIfExist(assignment.getType(), new CtTypedElementTypeReplaceListener(assignment));
		replaceInListIfExist(assignment.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(assignment));
		replaceElementIfExist(assignment.getAssigned(), new CtAssignmentAssignedReplaceListener(assignment));
		replaceElementIfExist(assignment.getAssignment(), new CtRHSReceiverAssignmentReplaceListener(assignment));
		replaceInListIfExist(assignment.getComments(), new CtElementCommentsReplaceListener(assignment));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtPackage(final spoon9.reflect.declaration.CtPackage ctPackage) {
		replaceInListIfExist(ctPackage.getAnnotations(), new CtElementAnnotationsReplaceListener(ctPackage));
		replaceInSetIfExist(ctPackage.getPackages(), new CtPackagePackagesReplaceListener(ctPackage));
		replaceInSetIfExist(ctPackage.getTypes(), new CtPackageTypesReplaceListener(ctPackage));
		replaceInListIfExist(ctPackage.getComments(), new CtElementCommentsReplaceListener(ctPackage));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtPackageReference(final spoon9.reflect.reference.CtPackageReference reference) {
		replaceInListIfExist(reference.getAnnotations(), new CtElementAnnotationsReplaceListener(reference));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtParameter(final spoon9.reflect.declaration.CtParameter<T> parameter) {
		replaceInListIfExist(parameter.getAnnotations(), new CtElementAnnotationsReplaceListener(parameter));
		replaceElementIfExist(parameter.getType(), new CtTypedElementTypeReplaceListener(parameter));
		replaceInListIfExist(parameter.getComments(), new CtElementCommentsReplaceListener(parameter));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtParameterReference(final spoon9.reflect.reference.CtParameterReference<T> reference) {
		replaceElementIfExist(reference.getType(), new CtVariableReferenceTypeReplaceListener(reference));
		replaceInListIfExist(reference.getAnnotations(), new CtElementAnnotationsReplaceListener(reference));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <R> void visitCtReturn(final spoon9.reflect.code.CtReturn<R> returnStatement) {
		replaceInListIfExist(returnStatement.getAnnotations(), new CtElementAnnotationsReplaceListener(returnStatement));
		replaceElementIfExist(returnStatement.getReturnedExpression(), new CtReturnReturnedExpressionReplaceListener(returnStatement));
		replaceInListIfExist(returnStatement.getComments(), new CtElementCommentsReplaceListener(returnStatement));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <R> void visitCtStatementList(final spoon9.reflect.code.CtStatementList statements) {
		replaceInListIfExist(statements.getAnnotations(), new CtElementAnnotationsReplaceListener(statements));
		replaceInListIfExist(statements.getStatements(), new CtStatementListStatementsReplaceListener(statements));
		replaceInListIfExist(statements.getComments(), new CtElementCommentsReplaceListener(statements));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <S> void visitCtSwitch(final spoon9.reflect.code.CtSwitch<S> switchStatement) {
		replaceInListIfExist(switchStatement.getAnnotations(), new CtElementAnnotationsReplaceListener(switchStatement));
		replaceElementIfExist(switchStatement.getSelector(), new CtAbstractSwitchSelectorReplaceListener(switchStatement));
		replaceInListIfExist(switchStatement.getCases(), new CtAbstractSwitchCasesReplaceListener(switchStatement));
		replaceInListIfExist(switchStatement.getComments(), new CtElementCommentsReplaceListener(switchStatement));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T, S> void visitCtSwitchExpression(final spoon9.reflect.code.CtSwitchExpression<T, S> switchExpression) {
		replaceInListIfExist(switchExpression.getAnnotations(), new CtElementAnnotationsReplaceListener(switchExpression));
		replaceElementIfExist(switchExpression.getSelector(), new CtAbstractSwitchSelectorReplaceListener(switchExpression));
		replaceInListIfExist(switchExpression.getCases(), new CtAbstractSwitchCasesReplaceListener(switchExpression));
		replaceInListIfExist(switchExpression.getComments(), new CtElementCommentsReplaceListener(switchExpression));
		replaceElementIfExist(switchExpression.getType(), new CtTypedElementTypeReplaceListener(switchExpression));
		replaceInListIfExist(switchExpression.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(switchExpression));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtSynchronized(final spoon9.reflect.code.CtSynchronized synchro) {
		replaceInListIfExist(synchro.getAnnotations(), new CtElementAnnotationsReplaceListener(synchro));
		replaceElementIfExist(synchro.getExpression(), new CtSynchronizedExpressionReplaceListener(synchro));
		replaceElementIfExist(synchro.getBlock(), new CtSynchronizedBlockReplaceListener(synchro));
		replaceInListIfExist(synchro.getComments(), new CtElementCommentsReplaceListener(synchro));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtThrow(final spoon9.reflect.code.CtThrow throwStatement) {
		replaceInListIfExist(throwStatement.getAnnotations(), new CtElementAnnotationsReplaceListener(throwStatement));
		replaceElementIfExist(throwStatement.getThrownExpression(), new CtThrowThrownExpressionReplaceListener(throwStatement));
		replaceInListIfExist(throwStatement.getComments(), new CtElementCommentsReplaceListener(throwStatement));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtTry(final spoon9.reflect.code.CtTry tryBlock) {
		replaceInListIfExist(tryBlock.getAnnotations(), new CtElementAnnotationsReplaceListener(tryBlock));
		replaceElementIfExist(tryBlock.getBody(), new CtTryBodyReplaceListener(tryBlock));
		replaceInListIfExist(tryBlock.getCatchers(), new CtTryCatchersReplaceListener(tryBlock));
		replaceElementIfExist(tryBlock.getFinalizer(), new CtTryFinalizerReplaceListener(tryBlock));
		replaceInListIfExist(tryBlock.getComments(), new CtElementCommentsReplaceListener(tryBlock));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtTryWithResource(final spoon9.reflect.code.CtTryWithResource tryWithResource) {
		replaceInListIfExist(tryWithResource.getAnnotations(), new CtElementAnnotationsReplaceListener(tryWithResource));
		replaceInListIfExist(tryWithResource.getResources(), new CtTryWithResourceResourcesReplaceListener(tryWithResource));
		replaceElementIfExist(tryWithResource.getBody(), new CtTryBodyReplaceListener(tryWithResource));
		replaceInListIfExist(tryWithResource.getCatchers(), new CtTryCatchersReplaceListener(tryWithResource));
		replaceElementIfExist(tryWithResource.getFinalizer(), new CtTryFinalizerReplaceListener(tryWithResource));
		replaceInListIfExist(tryWithResource.getComments(), new CtElementCommentsReplaceListener(tryWithResource));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtTypeParameterReference(final spoon9.reflect.reference.CtTypeParameterReference ref) {
		replaceElementIfExist(ref.getPackage(), new CtTypeReferencePackageReplaceListener(ref));
		replaceElementIfExist(ref.getDeclaringType(), new CtTypeReferenceDeclaringTypeReplaceListener(ref));
		replaceInListIfExist(ref.getAnnotations(), new CtElementAnnotationsReplaceListener(ref));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtWildcardReference(spoon9.reflect.reference.CtWildcardReference wildcardReference) {
		replaceElementIfExist(wildcardReference.getPackage(), new CtTypeReferencePackageReplaceListener(wildcardReference));
		replaceElementIfExist(wildcardReference.getDeclaringType(), new CtTypeReferenceDeclaringTypeReplaceListener(wildcardReference));
		replaceInListIfExist(wildcardReference.getAnnotations(), new CtElementAnnotationsReplaceListener(wildcardReference));
		replaceElementIfExist(wildcardReference.getBoundingType(), new CtWildcardReferenceBoundingTypeReplaceListener(wildcardReference));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtIntersectionTypeReference(final spoon9.reflect.reference.CtIntersectionTypeReference<T> reference) {
		replaceElementIfExist(reference.getPackage(), new CtTypeReferencePackageReplaceListener(reference));
		replaceElementIfExist(reference.getDeclaringType(), new CtTypeReferenceDeclaringTypeReplaceListener(reference));
		replaceInListIfExist(reference.getActualTypeArguments(), new CtActualTypeContainerActualTypeArgumentsReplaceListener(reference));
		replaceInListIfExist(reference.getAnnotations(), new CtElementAnnotationsReplaceListener(reference));
		replaceInListIfExist(reference.getBounds(), new CtIntersectionTypeReferenceBoundsReplaceListener(reference));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtTypeReference(final spoon9.reflect.reference.CtTypeReference<T> reference) {
		replaceElementIfExist(reference.getPackage(), new CtTypeReferencePackageReplaceListener(reference));
		replaceElementIfExist(reference.getDeclaringType(), new CtTypeReferenceDeclaringTypeReplaceListener(reference));
		replaceInListIfExist(reference.getActualTypeArguments(), new CtActualTypeContainerActualTypeArgumentsReplaceListener(reference));
		replaceInListIfExist(reference.getAnnotations(), new CtElementAnnotationsReplaceListener(reference));
		replaceInListIfExist(reference.getComments(), new CtElementCommentsReplaceListener(reference));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtTypeAccess(final spoon9.reflect.code.CtTypeAccess<T> typeAccess) {
		replaceInListIfExist(typeAccess.getAnnotations(), new CtElementAnnotationsReplaceListener(typeAccess));
		replaceInListIfExist(typeAccess.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(typeAccess));
		replaceElementIfExist(typeAccess.getAccessedType(), new CtTypeAccessAccessedTypeReplaceListener(typeAccess));
		replaceInListIfExist(typeAccess.getComments(), new CtElementCommentsReplaceListener(typeAccess));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtUnaryOperator(final spoon9.reflect.code.CtUnaryOperator<T> operator) {
		replaceInListIfExist(operator.getAnnotations(), new CtElementAnnotationsReplaceListener(operator));
		replaceElementIfExist(operator.getType(), new CtTypedElementTypeReplaceListener(operator));
		replaceInListIfExist(operator.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(operator));
		replaceElementIfExist(operator.getOperand(), new CtUnaryOperatorOperandReplaceListener(operator));
		replaceInListIfExist(operator.getComments(), new CtElementCommentsReplaceListener(operator));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtVariableRead(final spoon9.reflect.code.CtVariableRead<T> variableRead) {
		replaceInListIfExist(variableRead.getAnnotations(), new CtElementAnnotationsReplaceListener(variableRead));
		replaceInListIfExist(variableRead.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(variableRead));
		replaceElementIfExist(variableRead.getVariable(), new CtVariableAccessVariableReplaceListener(variableRead));
		replaceInListIfExist(variableRead.getComments(), new CtElementCommentsReplaceListener(variableRead));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtVariableWrite(final spoon9.reflect.code.CtVariableWrite<T> variableWrite) {
		replaceInListIfExist(variableWrite.getAnnotations(), new CtElementAnnotationsReplaceListener(variableWrite));
		replaceInListIfExist(variableWrite.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(variableWrite));
		replaceElementIfExist(variableWrite.getVariable(), new CtVariableAccessVariableReplaceListener(variableWrite));
		replaceInListIfExist(variableWrite.getComments(), new CtElementCommentsReplaceListener(variableWrite));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtWhile(final spoon9.reflect.code.CtWhile whileLoop) {
		replaceInListIfExist(whileLoop.getAnnotations(), new CtElementAnnotationsReplaceListener(whileLoop));
		replaceElementIfExist(whileLoop.getLoopingExpression(), new CtWhileLoopingExpressionReplaceListener(whileLoop));
		replaceElementIfExist(whileLoop.getBody(), new CtLoopBodyReplaceListener(whileLoop));
		replaceInListIfExist(whileLoop.getComments(), new CtElementCommentsReplaceListener(whileLoop));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtCodeSnippetExpression(final spoon9.reflect.code.CtCodeSnippetExpression<T> expression) {
		replaceElementIfExist(expression.getType(), new CtTypedElementTypeReplaceListener(expression));
		replaceInListIfExist(expression.getComments(), new CtElementCommentsReplaceListener(expression));
		replaceInListIfExist(expression.getAnnotations(), new CtElementAnnotationsReplaceListener(expression));
		replaceInListIfExist(expression.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(expression));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtCodeSnippetStatement(final spoon9.reflect.code.CtCodeSnippetStatement statement) {
		replaceInListIfExist(statement.getComments(), new CtElementCommentsReplaceListener(statement));
		replaceInListIfExist(statement.getAnnotations(), new CtElementAnnotationsReplaceListener(statement));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtUnboundVariableReference(final spoon9.reflect.reference.CtUnboundVariableReference<T> reference) {
		replaceElementIfExist(reference.getType(), new CtVariableReferenceTypeReplaceListener(reference));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtFieldRead(final spoon9.reflect.code.CtFieldRead<T> fieldRead) {
		replaceInListIfExist(fieldRead.getAnnotations(), new CtElementAnnotationsReplaceListener(fieldRead));
		replaceInListIfExist(fieldRead.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(fieldRead));
		replaceElementIfExist(fieldRead.getTarget(), new CtTargetedExpressionTargetReplaceListener(fieldRead));
		replaceElementIfExist(fieldRead.getVariable(), new CtFieldAccessVariableReplaceListener(fieldRead));
		replaceInListIfExist(fieldRead.getComments(), new CtElementCommentsReplaceListener(fieldRead));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtFieldWrite(final spoon9.reflect.code.CtFieldWrite<T> fieldWrite) {
		replaceInListIfExist(fieldWrite.getAnnotations(), new CtElementAnnotationsReplaceListener(fieldWrite));
		replaceInListIfExist(fieldWrite.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(fieldWrite));
		replaceElementIfExist(fieldWrite.getTarget(), new CtTargetedExpressionTargetReplaceListener(fieldWrite));
		replaceElementIfExist(fieldWrite.getVariable(), new CtFieldAccessVariableReplaceListener(fieldWrite));
		replaceInListIfExist(fieldWrite.getComments(), new CtElementCommentsReplaceListener(fieldWrite));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public <T> void visitCtSuperAccess(final spoon9.reflect.code.CtSuperAccess<T> f) {
		replaceInListIfExist(f.getComments(), new CtElementCommentsReplaceListener(f));
		replaceInListIfExist(f.getAnnotations(), new CtElementAnnotationsReplaceListener(f));
		replaceInListIfExist(f.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(f));
		replaceElementIfExist(f.getTarget(), new CtTargetedExpressionTargetReplaceListener(f));
		replaceElementIfExist(f.getVariable(), new CtVariableAccessVariableReplaceListener(f));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtComment(final spoon9.reflect.code.CtComment comment) {
		replaceInListIfExist(comment.getComments(), new CtElementCommentsReplaceListener(comment));
		replaceInListIfExist(comment.getAnnotations(), new CtElementAnnotationsReplaceListener(comment));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtJavaDoc(final spoon9.reflect.code.CtJavaDoc javaDoc) {
		replaceInListIfExist(javaDoc.getComments(), new CtElementCommentsReplaceListener(javaDoc));
		replaceInListIfExist(javaDoc.getAnnotations(), new CtElementAnnotationsReplaceListener(javaDoc));
		replaceInListIfExist(javaDoc.getTags(), new CtJavaDocTagsReplaceListener(javaDoc));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtJavaDocTag(final spoon9.reflect.code.CtJavaDocTag docTag) {
		replaceInListIfExist(docTag.getComments(), new CtElementCommentsReplaceListener(docTag));
		replaceInListIfExist(docTag.getAnnotations(), new CtElementAnnotationsReplaceListener(docTag));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtImport(final spoon9.reflect.declaration.CtImport ctImport) {
		replaceElementIfExist(ctImport.getReference(), new CtImportReferenceReplaceListener(ctImport));
		replaceInListIfExist(ctImport.getAnnotations(), new CtElementAnnotationsReplaceListener(ctImport));
		replaceInListIfExist(ctImport.getComments(), new CtElementCommentsReplaceListener(ctImport));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtModule(spoon9.reflect.declaration.CtModule module) {
		replaceInListIfExist(module.getComments(), new CtElementCommentsReplaceListener(module));
		replaceInListIfExist(module.getAnnotations(), new CtElementAnnotationsReplaceListener(module));
		replaceInListIfExist(module.getModuleDirectives(), new CtModuleModuleDirectivesReplaceListener(module));
		replaceElementIfExist(module.getRootPackage(), new CtModuleRootPackageReplaceListener(module));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtModuleReference(spoon9.reflect.reference.CtModuleReference moduleReference) {
		replaceInListIfExist(moduleReference.getAnnotations(), new CtElementAnnotationsReplaceListener(moduleReference));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtPackageExport(spoon9.reflect.declaration.CtPackageExport moduleExport) {
		replaceInListIfExist(moduleExport.getComments(), new CtElementCommentsReplaceListener(moduleExport));
		replaceElementIfExist(moduleExport.getPackageReference(), new CtPackageExportPackageReferenceReplaceListener(moduleExport));
		replaceInListIfExist(moduleExport.getTargetExport(), new CtPackageExportTargetExportReplaceListener(moduleExport));
		replaceInListIfExist(moduleExport.getAnnotations(), new CtElementAnnotationsReplaceListener(moduleExport));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtModuleRequirement(spoon9.reflect.declaration.CtModuleRequirement moduleRequirement) {
		replaceInListIfExist(moduleRequirement.getComments(), new CtElementCommentsReplaceListener(moduleRequirement));
		replaceElementIfExist(moduleRequirement.getModuleReference(), new CtModuleRequirementModuleReferenceReplaceListener(moduleRequirement));
		replaceInListIfExist(moduleRequirement.getAnnotations(), new CtElementAnnotationsReplaceListener(moduleRequirement));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtProvidedService(spoon9.reflect.declaration.CtProvidedService moduleProvidedService) {
		replaceInListIfExist(moduleProvidedService.getComments(), new CtElementCommentsReplaceListener(moduleProvidedService));
		replaceElementIfExist(moduleProvidedService.getServiceType(), new CtProvidedServiceServiceTypeReplaceListener(moduleProvidedService));
		replaceInListIfExist(moduleProvidedService.getImplementationTypes(), new CtProvidedServiceImplementationTypesReplaceListener(moduleProvidedService));
		replaceInListIfExist(moduleProvidedService.getAnnotations(), new CtElementAnnotationsReplaceListener(moduleProvidedService));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtUsedService(spoon9.reflect.declaration.CtUsedService usedService) {
		replaceInListIfExist(usedService.getComments(), new CtElementCommentsReplaceListener(usedService));
		replaceElementIfExist(usedService.getServiceType(), new CtUsedServiceServiceTypeReplaceListener(usedService));
		replaceInListIfExist(usedService.getAnnotations(), new CtElementAnnotationsReplaceListener(usedService));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtCompilationUnit(spoon9.reflect.declaration.CtCompilationUnit compilationUnit) {
		replaceInListIfExist(compilationUnit.getComments(), new CtElementCommentsReplaceListener(compilationUnit));
		replaceInListIfExist(compilationUnit.getAnnotations(), new CtElementAnnotationsReplaceListener(compilationUnit));
		replaceElementIfExist(compilationUnit.getPackageDeclaration(), new CtCompilationUnitPackageDeclarationReplaceListener(compilationUnit));
		replaceInListIfExist(compilationUnit.getImports(), new CtCompilationUnitImportsReplaceListener(compilationUnit));
		replaceElementIfExist(compilationUnit.getDeclaredModuleReference(), new CtCompilationUnitDeclaredModuleReferenceReplaceListener(compilationUnit));
		replaceInListIfExist(compilationUnit.getDeclaredTypeReferences(), new CtCompilationUnitDeclaredTypeReferencesReplaceListener(compilationUnit));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtPackageDeclaration(spoon9.reflect.declaration.CtPackageDeclaration packageDeclaration) {
		replaceInListIfExist(packageDeclaration.getComments(), new CtElementCommentsReplaceListener(packageDeclaration));
		replaceInListIfExist(packageDeclaration.getAnnotations(), new CtElementAnnotationsReplaceListener(packageDeclaration));
		replaceElementIfExist(packageDeclaration.getReference(), new CtPackageDeclarationReferenceReplaceListener(packageDeclaration));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtTypeMemberWildcardImportReference(spoon9.reflect.reference.CtTypeMemberWildcardImportReference wildcardReference) {
		replaceElementIfExist(wildcardReference.getTypeReference(), new CtTypeMemberWildcardImportReferenceTypeReferenceReplaceListener(wildcardReference));
	}

	// auto-generated, see spoon.generating.ReplacementVisitorGenerator
	@Override
	public void visitCtYieldStatement(spoon9.reflect.code.CtYieldStatement statement) {
		replaceInListIfExist(statement.getAnnotations(), new CtElementAnnotationsReplaceListener(statement));
		replaceElementIfExist(statement.getExpression(), new CtYieldStatementExpressionReplaceListener(statement));
		replaceInListIfExist(statement.getComments(), new CtElementCommentsReplaceListener(statement));
	}
}