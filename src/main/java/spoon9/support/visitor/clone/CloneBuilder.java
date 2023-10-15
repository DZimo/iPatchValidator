/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2023 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) or the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.visitor.clone;
/**
 * Used to set all data in the cloned element.
 *
 * This class is generated automatically by the processor spoon.generating.CloneVisitorGenerator.
 */
public class CloneBuilder extends spoon9.reflect.visitor.CtInheritanceScanner {
	public void copy(spoon9.reflect.declaration.CtElement element, spoon9.reflect.declaration.CtElement other) {
		this.setOther(other);
		this.scan(element);
	}

	public static <T extends spoon9.reflect.declaration.CtElement> T build(CloneBuilder builder, spoon9.reflect.declaration.CtElement element, spoon9.reflect.declaration.CtElement other) {
		builder.setOther(other);
		builder.scan(element);
		return ((T) (builder.other));
	}

	private spoon9.reflect.declaration.CtElement other;

	public void setOther(spoon9.reflect.declaration.CtElement other) {
		this.other = other;
	}

	private java.util.Set<spoon9.support.reflect.CtExtendedModifier> clone(java.util.Set<spoon9.support.reflect.CtExtendedModifier> modifiers) {
		java.util.Set<spoon9.support.reflect.CtExtendedModifier> result = new java.util.HashSet<>();
		for (spoon9.support.reflect.CtExtendedModifier modifier : modifiers) {
			spoon9.support.reflect.CtExtendedModifier clone = new spoon9.support.reflect.CtExtendedModifier(modifier.getKind(), modifier.isImplicit());
			clone.setPosition(modifier.getPosition());
			result.add(clone);
		}
		return result;
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void visitCtCodeSnippetExpression(spoon9.reflect.code.CtCodeSnippetExpression<T> e) {
		((spoon9.reflect.code.CtCodeSnippetExpression<T>) (other)).setValue(e.getValue());
		super.visitCtCodeSnippetExpression(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public void visitCtCodeSnippetStatement(spoon9.reflect.code.CtCodeSnippetStatement e) {
		((spoon9.reflect.code.CtCodeSnippetStatement) (other)).setValue(e.getValue());
		super.visitCtCodeSnippetStatement(e);
	}

	/**
	 * Scans an abstract element.
	 */
	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public void scanCtElement(spoon9.reflect.declaration.CtElement e) {
		((spoon9.reflect.declaration.CtElement) (other)).setPosition(e.getPosition());
		((spoon9.reflect.declaration.CtElement) (other)).setAllMetadata(e.getAllMetadata());
		((spoon9.reflect.declaration.CtElement) (other)).setImplicit(e.isImplicit());
		super.scanCtElement(e);
	}

	/**
	 * Scans an abstract named element.
	 */
	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public void scanCtNamedElement(spoon9.reflect.declaration.CtNamedElement e) {
		((spoon9.reflect.declaration.CtNamedElement) (other)).setSimpleName(e.getSimpleName());
		super.scanCtNamedElement(e);
	}

	/**
	 * Scans an abstract reference.
	 */
	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public void scanCtReference(spoon9.reflect.reference.CtReference reference) {
		((spoon9.reflect.reference.CtReference) (other)).setSimpleName(reference.getSimpleName());
		super.scanCtReference(reference);
	}

	/**
	 * Scans an abstract statement.
	 */
	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public void scanCtStatement(spoon9.reflect.code.CtStatement s) {
		((spoon9.reflect.code.CtStatement) (other)).setLabel(s.getLabel());
		super.scanCtStatement(s);
	}

	/**
	 * Scans an abstract type.
	 */
	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void scanCtType(spoon9.reflect.declaration.CtType<T> type) {
		((spoon9.reflect.declaration.CtType<T>) (other)).setExtendedModifiers(clone(type.getExtendedModifiers()));
		((spoon9.reflect.declaration.CtType<T>) (other)).setShadow(type.isShadow());
		super.scanCtType(type);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T, A extends T> void visitCtOperatorAssignment(spoon9.reflect.code.CtOperatorAssignment<T, A> e) {
		((spoon9.reflect.code.CtOperatorAssignment<T, A>) (other)).setKind(e.getKind());
		super.visitCtOperatorAssignment(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <A extends java.lang.annotation.Annotation> void visitCtAnnotation(spoon9.reflect.declaration.CtAnnotation<A> e) {
		((spoon9.reflect.declaration.CtAnnotation<A>) (other)).setShadow(e.isShadow());
		super.visitCtAnnotation(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public void visitCtAnonymousExecutable(spoon9.reflect.declaration.CtAnonymousExecutable e) {
		((spoon9.reflect.declaration.CtAnonymousExecutable) (other)).setExtendedModifiers(clone(e.getExtendedModifiers()));
		super.visitCtAnonymousExecutable(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void visitCtBinaryOperator(spoon9.reflect.code.CtBinaryOperator<T> e) {
		((spoon9.reflect.code.CtBinaryOperator<T>) (other)).setKind(e.getKind());
		super.visitCtBinaryOperator(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public void visitCtBreak(spoon9.reflect.code.CtBreak e) {
		((spoon9.reflect.code.CtBreak) (other)).setTargetLabel(e.getTargetLabel());
		super.visitCtBreak(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <E> void visitCtCase(spoon9.reflect.code.CtCase<E> e) {
		((spoon9.reflect.code.CtCase<E>) (other)).setCaseKind(e.getCaseKind());
		super.visitCtCase(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void visitCtConstructor(spoon9.reflect.declaration.CtConstructor<T> e) {
		((spoon9.reflect.declaration.CtConstructor<T>) (other)).setExtendedModifiers(clone(e.getExtendedModifiers()));
		((spoon9.reflect.declaration.CtConstructor<T>) (other)).setCompactConstructor(e.isCompactConstructor());
		((spoon9.reflect.declaration.CtConstructor<T>) (other)).setShadow(e.isShadow());
		super.visitCtConstructor(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public void visitCtContinue(spoon9.reflect.code.CtContinue e) {
		((spoon9.reflect.code.CtContinue) (other)).setTargetLabel(e.getTargetLabel());
		super.visitCtContinue(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void visitCtExecutableReference(spoon9.reflect.reference.CtExecutableReference<T> e) {
		((spoon9.reflect.reference.CtExecutableReference<T>) (other)).setStatic(e.isStatic());
		super.visitCtExecutableReference(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void visitCtField(spoon9.reflect.declaration.CtField<T> e) {
		((spoon9.reflect.declaration.CtField<T>) (other)).setExtendedModifiers(clone(e.getExtendedModifiers()));
		((spoon9.reflect.declaration.CtField<T>) (other)).setShadow(e.isShadow());
		super.visitCtField(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void visitCtFieldReference(spoon9.reflect.reference.CtFieldReference<T> e) {
		((spoon9.reflect.reference.CtFieldReference<T>) (other)).setFinal(e.isFinal());
		((spoon9.reflect.reference.CtFieldReference<T>) (other)).setStatic(e.isStatic());
		super.visitCtFieldReference(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void visitCtInvocation(spoon9.reflect.code.CtInvocation<T> e) {
		((spoon9.reflect.code.CtInvocation<T>) (other)).setLabel(e.getLabel());
		super.visitCtInvocation(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void visitCtLiteral(spoon9.reflect.code.CtLiteral<T> e) {
		((spoon9.reflect.code.CtLiteral<T>) (other)).setValue(e.getValue());
		((spoon9.reflect.code.CtLiteral<T>) (other)).setBase(e.getBase());
		super.visitCtLiteral(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void visitCtLocalVariable(spoon9.reflect.code.CtLocalVariable<T> e) {
		((spoon9.reflect.code.CtLocalVariable<T>) (other)).setSimpleName(e.getSimpleName());
		((spoon9.reflect.code.CtLocalVariable<T>) (other)).setExtendedModifiers(clone(e.getExtendedModifiers()));
		((spoon9.reflect.code.CtLocalVariable<T>) (other)).setInferred(e.isInferred());
		super.visitCtLocalVariable(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void visitCtCatchVariable(spoon9.reflect.code.CtCatchVariable<T> e) {
		((spoon9.reflect.code.CtCatchVariable<T>) (other)).setSimpleName(e.getSimpleName());
		((spoon9.reflect.code.CtCatchVariable<T>) (other)).setExtendedModifiers(clone(e.getExtendedModifiers()));
		super.visitCtCatchVariable(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void visitCtMethod(spoon9.reflect.declaration.CtMethod<T> e) {
		((spoon9.reflect.declaration.CtMethod<T>) (other)).setDefaultMethod(e.isDefaultMethod());
		((spoon9.reflect.declaration.CtMethod<T>) (other)).setExtendedModifiers(clone(e.getExtendedModifiers()));
		((spoon9.reflect.declaration.CtMethod<T>) (other)).setShadow(e.isShadow());
		super.visitCtMethod(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	@Override
	public <T> void visitCtConstructorCall(spoon9.reflect.code.CtConstructorCall<T> e) {
		((spoon9.reflect.code.CtConstructorCall<T>) (other)).setLabel(e.getLabel());
		super.visitCtConstructorCall(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	@Override
	public <T> void visitCtLambda(spoon9.reflect.code.CtLambda<T> e) {
		((spoon9.reflect.code.CtLambda<T>) (other)).setSimpleName(e.getSimpleName());
		super.visitCtLambda(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T, A extends T> void visitCtOperatorAssignement(spoon9.reflect.code.CtOperatorAssignment<T, A> assignment) {
		((spoon9.reflect.code.CtOperatorAssignment<T, A>) (other)).setKind(assignment.getKind());
		super.visitCtOperatorAssignement(assignment);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public void visitCtPackage(spoon9.reflect.declaration.CtPackage e) {
		((spoon9.reflect.declaration.CtPackage) (other)).setShadow(e.isShadow());
		super.visitCtPackage(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void visitCtParameter(spoon9.reflect.declaration.CtParameter<T> e) {
		((spoon9.reflect.declaration.CtParameter<T>) (other)).setVarArgs(e.isVarArgs());
		((spoon9.reflect.declaration.CtParameter<T>) (other)).setExtendedModifiers(clone(e.getExtendedModifiers()));
		((spoon9.reflect.declaration.CtParameter<T>) (other)).setInferred(e.isInferred());
		((spoon9.reflect.declaration.CtParameter<T>) (other)).setShadow(e.isShadow());
		super.visitCtParameter(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	@Override
	public void visitCtWildcardReference(spoon9.reflect.reference.CtWildcardReference wildcardReference) {
		((spoon9.reflect.reference.CtWildcardReference) (other)).setUpper(wildcardReference.isUpper());
		super.visitCtWildcardReference(wildcardReference);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void visitCtTypeReference(spoon9.reflect.reference.CtTypeReference<T> e) {
		((spoon9.reflect.reference.CtTypeReference<T>) (other)).setShadow(e.isShadow());
		super.visitCtTypeReference(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void visitCtUnaryOperator(spoon9.reflect.code.CtUnaryOperator<T> e) {
		((spoon9.reflect.code.CtUnaryOperator<T>) (other)).setKind(e.getKind());
		((spoon9.reflect.code.CtUnaryOperator<T>) (other)).setLabel(e.getLabel());
		super.visitCtUnaryOperator(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	@Override
	public void visitCtComment(spoon9.reflect.code.CtComment e) {
		((spoon9.reflect.code.CtComment) (other)).setContent(e.getContent());
		((spoon9.reflect.code.CtComment) (other)).setCommentType(e.getCommentType());
		super.visitCtComment(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	@Override
	public void visitCtJavaDocTag(spoon9.reflect.code.CtJavaDocTag e) {
		((spoon9.reflect.code.CtJavaDocTag) (other)).setType(e.getType());
		((spoon9.reflect.code.CtJavaDocTag) (other)).setRealName(e.getRealName());
		((spoon9.reflect.code.CtJavaDocTag) (other)).setContent(e.getContent());
		((spoon9.reflect.code.CtJavaDocTag) (other)).setParam(e.getParam());
		super.visitCtJavaDocTag(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	@Override
	public void visitCtModule(spoon9.reflect.declaration.CtModule module) {
		((spoon9.reflect.declaration.CtModule) (other)).setIsOpenModule(module.isOpenModule());
		super.visitCtModule(module);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	@Override
	public void visitCtPackageExport(spoon9.reflect.declaration.CtPackageExport moduleExport) {
		((spoon9.reflect.declaration.CtPackageExport) (other)).setOpenedPackage(moduleExport.isOpenedPackage());
		super.visitCtPackageExport(moduleExport);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	@Override
	public void visitCtModuleRequirement(spoon9.reflect.declaration.CtModuleRequirement moduleRequirement) {
		((spoon9.reflect.declaration.CtModuleRequirement) (other)).setRequiresModifiers(moduleRequirement.getRequiresModifiers());
		super.visitCtModuleRequirement(moduleRequirement);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	@Override
	public void visitCtCompilationUnit(spoon9.reflect.declaration.CtCompilationUnit compilationUnit) {
		((spoon9.reflect.declaration.CtCompilationUnit) (other)).setFile(compilationUnit.getFile());
		((spoon9.reflect.declaration.CtCompilationUnit) (other)).setLineSeparatorPositions(compilationUnit.getLineSeparatorPositions());
		super.visitCtCompilationUnit(compilationUnit);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	@Override
	public void visitCtRecordComponent(spoon9.reflect.declaration.CtRecordComponent recordComponent) {
		((spoon9.reflect.declaration.CtRecordComponent) (other)).setShadow(recordComponent.isShadow());
		super.visitCtRecordComponent(recordComponent);
	}
}
