/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support.visitor.clone;

import spoon9.reflect.code.*;
import spoon9.reflect.declaration.*;
import spoon9.reflect.reference.*;
import spoon9.reflect.visitor.CtInheritanceScanner;

/**
 * Used to set all data in the cloned element.
 *
 * This class is generated automatically by the processor spoon.generating.CloneVisitorGenerator.
 */
public class CloneBuilder extends CtInheritanceScanner {
	public void copy(CtElement element, CtElement other) {
		this.setOther(other);
		this.scan(element);
	}

	public static <T extends CtElement> T build(CloneBuilder builder, CtElement element, CtElement other) {
		builder.setOther(other);
		builder.scan(element);
		return ((T) (builder.other));
	}

	private CtElement other;

	public void setOther(CtElement other) {
		this.other = other;
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void visitCtCodeSnippetExpression(CtCodeSnippetExpression<T> e) {
		((CtCodeSnippetExpression<T>) (other)).setValue(e.getValue());
		super.visitCtCodeSnippetExpression(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public void visitCtCodeSnippetStatement(CtCodeSnippetStatement e) {
		((CtCodeSnippetStatement) (other)).setValue(e.getValue());
		super.visitCtCodeSnippetStatement(e);
	}

	/**
	 * Scans an abstract element.
	 */
	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public void scanCtElement(CtElement e) {
		((CtElement) (other)).setPosition(e.getPosition());
		((CtElement) (other)).setAllMetadata(e.getAllMetadata());
		((CtElement) (other)).setImplicit(e.isImplicit());
		super.scanCtElement(e);
	}

	/**
	 * Scans an abstract named element.
	 */
	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public void scanCtNamedElement(CtNamedElement e) {
		((CtNamedElement) (other)).setSimpleName(e.getSimpleName());
		super.scanCtNamedElement(e);
	}

	/**
	 * Scans an abstract reference.
	 */
	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public void scanCtReference(CtReference reference) {
		((CtReference) (other)).setSimpleName(reference.getSimpleName());
		super.scanCtReference(reference);
	}

	/**
	 * Scans an abstract statement.
	 */
	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public void scanCtStatement(CtStatement s) {
		((CtStatement) (other)).setLabel(s.getLabel());
		super.scanCtStatement(s);
	}

	/**
	 * Scans an abstract type.
	 */
	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void scanCtType(CtType<T> type) {
		((CtType<T>) (other)).setModifiers(type.getModifiers());
		((CtType<T>) (other)).setShadow(type.isShadow());
		super.scanCtType(type);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T, A extends T> void visitCtOperatorAssignment(CtOperatorAssignment<T, A> e) {
		((CtOperatorAssignment<T, A>) (other)).setKind(e.getKind());
		super.visitCtOperatorAssignment(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <A extends java.lang.annotation.Annotation> void visitCtAnnotation(CtAnnotation<A> e) {
		((CtAnnotation<A>) (other)).setShadow(e.isShadow());
		super.visitCtAnnotation(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public void visitCtAnonymousExecutable(CtAnonymousExecutable e) {
		((CtAnonymousExecutable) (other)).setModifiers(e.getModifiers());
		super.visitCtAnonymousExecutable(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void visitCtBinaryOperator(CtBinaryOperator<T> e) {
		((CtBinaryOperator<T>) (other)).setKind(e.getKind());
		super.visitCtBinaryOperator(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public void visitCtBreak(CtBreak e) {
		((CtBreak) (other)).setTargetLabel(e.getTargetLabel());
		super.visitCtBreak(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <E> void visitCtCase(CtCase<E> e) {
		((CtCase<E>) (other)).setCaseKind(e.getCaseKind());
		super.visitCtCase(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void visitCtConstructor(CtConstructor<T> e) {
		((CtConstructor<T>) (other)).setModifiers(e.getModifiers());
		((CtConstructor<T>) (other)).setShadow(e.isShadow());
		super.visitCtConstructor(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public void visitCtContinue(CtContinue e) {
		((CtContinue) (other)).setTargetLabel(e.getTargetLabel());
		super.visitCtContinue(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void visitCtExecutableReference(CtExecutableReference<T> e) {
		((CtExecutableReference<T>) (other)).setStatic(e.isStatic());
		super.visitCtExecutableReference(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void visitCtField(CtField<T> e) {
		((CtField<T>) (other)).setModifiers(e.getModifiers());
		((CtField<T>) (other)).setShadow(e.isShadow());
		super.visitCtField(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void visitCtFieldReference(CtFieldReference<T> e) {
		((CtFieldReference<T>) (other)).setFinal(e.isFinal());
		((CtFieldReference<T>) (other)).setStatic(e.isStatic());
		super.visitCtFieldReference(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void visitCtInvocation(CtInvocation<T> e) {
		((CtInvocation<T>) (other)).setLabel(e.getLabel());
		super.visitCtInvocation(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void visitCtLiteral(CtLiteral<T> e) {
		((CtLiteral<T>) (other)).setValue(e.getValue());
		((CtLiteral<T>) (other)).setBase(e.getBase());
		super.visitCtLiteral(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void visitCtLocalVariable(CtLocalVariable<T> e) {
		((CtLocalVariable<T>) (other)).setSimpleName(e.getSimpleName());
		((CtLocalVariable<T>) (other)).setModifiers(e.getModifiers());
		((CtLocalVariable<T>) (other)).setInferred(e.isInferred());
		super.visitCtLocalVariable(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void visitCtCatchVariable(CtCatchVariable<T> e) {
		((CtCatchVariable<T>) (other)).setSimpleName(e.getSimpleName());
		((CtCatchVariable<T>) (other)).setModifiers(e.getModifiers());
		super.visitCtCatchVariable(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void visitCtMethod(CtMethod<T> e) {
		((CtMethod<T>) (other)).setDefaultMethod(e.isDefaultMethod());
		((CtMethod<T>) (other)).setModifiers(e.getModifiers());
		((CtMethod<T>) (other)).setShadow(e.isShadow());
		super.visitCtMethod(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	@java.lang.Override
	public <T> void visitCtConstructorCall(CtConstructorCall<T> e) {
		((CtConstructorCall<T>) (other)).setLabel(e.getLabel());
		super.visitCtConstructorCall(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	@java.lang.Override
	public <T> void visitCtLambda(CtLambda<T> e) {
		((CtLambda<T>) (other)).setSimpleName(e.getSimpleName());
		super.visitCtLambda(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T, A extends T> void visitCtOperatorAssignement(CtOperatorAssignment<T, A> assignment) {
		((CtOperatorAssignment<T, A>) (other)).setKind(assignment.getKind());
		super.visitCtOperatorAssignement(assignment);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public void visitCtPackage(CtPackage e) {
		((CtPackage) (other)).setShadow(e.isShadow());
		super.visitCtPackage(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void visitCtParameter(CtParameter<T> e) {
		((CtParameter<T>) (other)).setVarArgs(e.isVarArgs());
		((CtParameter<T>) (other)).setModifiers(e.getModifiers());
		((CtParameter<T>) (other)).setInferred(e.isInferred());
		((CtParameter<T>) (other)).setShadow(e.isShadow());
		super.visitCtParameter(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	@java.lang.Override
	public void visitCtWildcardReference(CtWildcardReference wildcardReference) {
		((CtWildcardReference) (other)).setUpper(wildcardReference.isUpper());
		super.visitCtWildcardReference(wildcardReference);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void visitCtTypeReference(CtTypeReference<T> e) {
		((CtTypeReference<T>) (other)).setShadow(e.isShadow());
		super.visitCtTypeReference(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	public <T> void visitCtUnaryOperator(CtUnaryOperator<T> e) {
		((CtUnaryOperator<T>) (other)).setKind(e.getKind());
		((CtUnaryOperator<T>) (other)).setLabel(e.getLabel());
		super.visitCtUnaryOperator(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	@java.lang.Override
	public void visitCtComment(CtComment e) {
		((CtComment) (other)).setContent(e.getContent());
		((CtComment) (other)).setCommentType(e.getCommentType());
		super.visitCtComment(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	@java.lang.Override
	public void visitCtJavaDocTag(CtJavaDocTag e) {
		((CtJavaDocTag) (other)).setType(e.getType());
		((CtJavaDocTag) (other)).setRealName(e.getRealName());
		((CtJavaDocTag) (other)).setContent(e.getContent());
		((CtJavaDocTag) (other)).setParam(e.getParam());
		super.visitCtJavaDocTag(e);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	@java.lang.Override
	public void visitCtModule(CtModule module) {
		((CtModule) (other)).setIsOpenModule(module.isOpenModule());
		super.visitCtModule(module);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	@java.lang.Override
	public void visitCtPackageExport(CtPackageExport moduleExport) {
		((CtPackageExport) (other)).setOpenedPackage(moduleExport.isOpenedPackage());
		super.visitCtPackageExport(moduleExport);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	@java.lang.Override
	public void visitCtModuleRequirement(CtModuleRequirement moduleRequirement) {
		((CtModuleRequirement) (other)).setRequiresModifiers(moduleRequirement.getRequiresModifiers());
		super.visitCtModuleRequirement(moduleRequirement);
	}

	// auto-generated, see spoon.generating.CloneVisitorGenerator
	@java.lang.Override
	public void visitCtCompilationUnit(CtCompilationUnit compilationUnit) {
		((CtCompilationUnit) (other)).setFile(compilationUnit.getFile());
		((CtCompilationUnit) (other)).setLineSeparatorPositions(compilationUnit.getLineSeparatorPositions());
		super.visitCtCompilationUnit(compilationUnit);
	}
}
