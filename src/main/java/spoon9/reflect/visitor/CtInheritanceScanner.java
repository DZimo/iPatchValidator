/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.reflect.visitor;

import spoon9.reflect.code.CtAbstractInvocation;
import spoon9.reflect.code.CtAbstractSwitch;
import spoon9.reflect.code.CtAnnotationFieldAccess;
import spoon9.reflect.code.CtArrayAccess;
import spoon9.reflect.code.CtArrayRead;
import spoon9.reflect.code.CtArrayWrite;
import spoon9.reflect.code.CtAssert;
import spoon9.reflect.code.CtAssignment;
import spoon9.reflect.code.CtBinaryOperator;
import spoon9.reflect.code.CtBlock;
import spoon9.reflect.code.CtBodyHolder;
import spoon9.reflect.code.CtBreak;
import spoon9.reflect.code.CtCFlowBreak;
import spoon9.reflect.code.CtCase;
import spoon9.reflect.code.CtCatch;
import spoon9.reflect.code.CtCatchVariable;
import spoon9.reflect.code.CtCodeElement;
import spoon9.reflect.code.CtCodeSnippetExpression;
import spoon9.reflect.code.CtCodeSnippetStatement;
import spoon9.reflect.code.CtComment;
import spoon9.reflect.code.CtConditional;
import spoon9.reflect.code.CtConstructorCall;
import spoon9.reflect.code.CtContinue;
import spoon9.reflect.code.CtDo;
import spoon9.reflect.code.CtExecutableReferenceExpression;
import spoon9.reflect.code.CtExpression;
import spoon9.reflect.code.CtFieldAccess;
import spoon9.reflect.code.CtFieldRead;
import spoon9.reflect.code.CtFieldWrite;
import spoon9.reflect.code.CtFor;
import spoon9.reflect.code.CtForEach;
import spoon9.reflect.code.CtIf;
import spoon9.reflect.code.CtInvocation;
import spoon9.reflect.code.CtJavaDoc;
import spoon9.reflect.code.CtJavaDocTag;
import spoon9.reflect.code.CtLabelledFlowBreak;
import spoon9.reflect.code.CtLambda;
import spoon9.reflect.code.CtLiteral;
import spoon9.reflect.code.CtLocalVariable;
import spoon9.reflect.code.CtLoop;
import spoon9.reflect.code.CtNewArray;
import spoon9.reflect.code.CtNewClass;
import spoon9.reflect.code.CtOperatorAssignment;
import spoon9.reflect.code.CtRHSReceiver;
import spoon9.reflect.code.CtReturn;
import spoon9.reflect.code.CtStatement;
import spoon9.reflect.code.CtStatementList;
import spoon9.reflect.code.CtSuperAccess;
import spoon9.reflect.code.CtSwitch;
import spoon9.reflect.code.CtSwitchExpression;
import spoon9.reflect.code.CtSynchronized;
import spoon9.reflect.code.CtTargetedExpression;
import spoon9.reflect.code.CtTextBlock;
import spoon9.reflect.code.CtThisAccess;
import spoon9.reflect.code.CtThrow;
import spoon9.reflect.code.CtTry;
import spoon9.reflect.code.CtTryWithResource;
import spoon9.reflect.code.CtTypeAccess;
import spoon9.reflect.code.CtUnaryOperator;
import spoon9.reflect.code.CtVariableAccess;
import spoon9.reflect.code.CtVariableRead;
import spoon9.reflect.code.CtVariableWrite;
import spoon9.reflect.code.CtWhile;
import spoon9.reflect.code.CtYieldStatement;
import spoon9.reflect.declaration.CtAnnotation;
import spoon9.reflect.declaration.CtAnnotationMethod;
import spoon9.reflect.declaration.CtAnnotationType;
import spoon9.reflect.declaration.CtAnonymousExecutable;
import spoon9.reflect.declaration.CtClass;
import spoon9.reflect.declaration.CtCodeSnippet;
import spoon9.reflect.declaration.CtCompilationUnit;
import spoon9.reflect.declaration.CtConstructor;
import spoon9.reflect.declaration.CtElement;
import spoon9.reflect.declaration.CtEnum;
import spoon9.reflect.declaration.CtEnumValue;
import spoon9.reflect.declaration.CtExecutable;
import spoon9.reflect.declaration.CtField;
import spoon9.reflect.declaration.CtFormalTypeDeclarer;
import spoon9.reflect.declaration.CtInterface;
import spoon9.reflect.declaration.CtMethod;
import spoon9.reflect.declaration.CtModifiable;
import spoon9.reflect.declaration.CtModule;
import spoon9.reflect.declaration.CtModuleDirective;
import spoon9.reflect.declaration.CtPackageExport;
import spoon9.reflect.declaration.CtProvidedService;
import spoon9.reflect.declaration.CtModuleRequirement;
import spoon9.reflect.declaration.CtMultiTypedElement;
import spoon9.reflect.declaration.CtNamedElement;
import spoon9.reflect.declaration.CtPackage;
import spoon9.reflect.declaration.CtPackageDeclaration;
import spoon9.reflect.declaration.CtParameter;
import spoon9.reflect.declaration.CtShadowable;
import spoon9.reflect.declaration.CtType;
import spoon9.reflect.declaration.CtTypeInformation;
import spoon9.reflect.declaration.CtTypeMember;
import spoon9.reflect.declaration.CtTypeParameter;
import spoon9.reflect.declaration.CtTypedElement;
import spoon9.reflect.declaration.CtUsedService;
import spoon9.reflect.declaration.CtVariable;
import spoon9.reflect.reference.CtActualTypeContainer;
import spoon9.reflect.reference.CtArrayTypeReference;
import spoon9.reflect.reference.CtCatchVariableReference;
import spoon9.reflect.reference.CtExecutableReference;
import spoon9.reflect.reference.CtFieldReference;
import spoon9.reflect.declaration.CtImport;
import spoon9.reflect.reference.CtIntersectionTypeReference;
import spoon9.reflect.reference.CtLocalVariableReference;
import spoon9.reflect.reference.CtModuleReference;
import spoon9.reflect.reference.CtPackageReference;
import spoon9.reflect.reference.CtParameterReference;
import spoon9.reflect.reference.CtReference;
import spoon9.reflect.reference.CtTypeParameterReference;
import spoon9.reflect.reference.CtTypeReference;
import spoon9.reflect.reference.CtUnboundVariableReference;
import spoon9.reflect.reference.CtVariableReference;
import spoon9.reflect.reference.CtWildcardReference;
import spoon9.reflect.reference.CtTypeMemberWildcardImportReference;

import java.lang.annotation.Annotation;
import java.util.Collection;

/**
 * This class provides an abstract implementation of the visitor that allows its
 * subclasses to scan the metamodel elements by recursively using their
 * (abstract) supertype scanning methods. It declares a scan method for each
 * abstract element of the AST and a visit method for each element of the AST.
 */
public abstract class CtInheritanceScanner implements CtVisitor {

	/**
	 * Default constructor.
	 */
	public CtInheritanceScanner() {
	}

	public <T> void visitCtCodeSnippetExpression(
			CtCodeSnippetExpression<T> e) {
		scanCtCodeSnippet(e);
		scanCtExpression(e);
		scanCtCodeElement(e);
		scanCtTypedElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
	}

	public void visitCtCodeSnippetStatement(CtCodeSnippetStatement e) {
		scanCtCodeSnippet(e);
		scanCtStatement(e);
		scanCtCodeElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
	}

	/**
	 * Generically scans a collection of meta-model elements.
	 */
	public void scan(Collection<? extends CtElement> elements) {
		if (elements != null) {
			for (CtElement e : elements) {
				scan(e);
			}
		}
	}

	/**
	 * Generically scans a meta-model element.
	 */
	public void scan(CtElement element) {
		if (element != null) {
			element.accept(this);
		}
	}

	/**
	 * Scans an abstract invocation.
	 */
	public <T> void scanCtAbstractInvocation(CtAbstractInvocation<T> a) {
	}

	/**
	 * Scans an abstract switch (either switch statement or switch expression).
	 */
	public <S> void scanCtAbstractSwitch(CtAbstractSwitch<S> a) {
	}

	/**
	 * Scans an abstract control flow break.
	 */
	public void scanCtCFlowBreak(CtCFlowBreak flowBreak) {
	}

	/**
	 * Scans a labelled control flow break.
	 */
	public void scanCtLabelledFlowBreak(CtLabelledFlowBreak labelledFlowBreak) {
	}

	/**
	 * Scans an abstract code element.
	 */
	public void scanCtCodeElement(CtCodeElement e) {

	}

	public void scanCtTypeMember(CtTypeMember e) {
	}

	public void scanCtModuleDirective(CtModuleDirective e) {

	}

	/**
	 * Scans an abstract element.
	 */
	public void scanCtElement(CtElement e) {
	}

	/**
	 * Scans an abstract executable.
	 */
	public <R> void scanCtExecutable(CtExecutable<R> e) {
	}

	/**
	 * Scans an abstract expression.
	 */
	public <T> void scanCtExpression(CtExpression<T> expression) {
	}

	/**
	 * Scans a formal type declarer.
	 */
	public void scanCtFormalTypeDeclarer(CtFormalTypeDeclarer e) {

	}

	public void scanCtVisitable(CtVisitable e) {

	}

	/**
	 * Scans an actual type container..
	 */
	public void scanCtActualTypeContainer(CtActualTypeContainer reference) {
	}

	/**
	 * Scans an abstract loop.
	 */
	public void scanCtLoop(CtLoop loop) {

	}

	/**
	 * Scans an abstract modifiable element.
	 */
	public void scanCtModifiable(CtModifiable m) {

	}

	/**
	 * Scans an abstract named element.
	 */
	public void scanCtNamedElement(CtNamedElement e) {
	}

	/**
	 * Scans an abstract reference.
	 */
	public void scanCtReference(CtReference reference) {

	}

	/**
	 * Scans an abstract statement.
	 */
	public void scanCtStatement(CtStatement s) {
	}

	/**
	 * Scans an abstract targeted expression.
	 */
	public <T, E extends CtExpression<?>> void scanCtTargetedExpression(
			CtTargetedExpression<T, E> targetedExpression) {
	}

	/**
	 * Scans an abstract type.
	 */
	public <T> void scanCtType(CtType<T> type) {
	}

	/**
	 * Scans an abstract typed element.
	 */
	public <T> void scanCtTypedElement(CtTypedElement<T> e) {
	}

	/**
	 * Scans an abstract variable declaration.
	 */
	public <T> void scanCtVariable(CtVariable<T> v) {
	}


	/**
	 * Scans an array access (read and write).
	 */
	public <T, E extends CtExpression<?>> void scanCtArrayAccess(CtArrayAccess<T, E> arrayAccess) {
	}

	/**
	 * Scans a field access (read and write).
	 */
	public <T> void scanCtFieldAccess(CtFieldAccess<T> fieldAccess) {
	}

	/**
	 * Scans a variable access (read and write).
	 */
	public <T> void scanCtVariableAccess(CtVariableAccess<T> variableAccess) {
	}

	/**
	 * Scans the right-hand side of an assignment
	 */
	public <T> void scanCtRHSReceiver(CtRHSReceiver<T> ctRHSReceiver) {
	}

	/**
	 * Scans a shadowable element
	 */
	public void scanCtShadowable(CtShadowable ctShadowable) {
	}

	/**
	 * Scans a body holder
	 */
	public void scanCtBodyHolder(CtBodyHolder ctBodyHolder) {
	}

	@Override
	public <T> void visitCtFieldRead(CtFieldRead<T> fieldRead) {
		visitCtVariableRead(fieldRead);
		scanCtFieldAccess(fieldRead);
		scanCtTargetedExpression(fieldRead);
	}

	@Override
	public <T> void visitCtFieldWrite(CtFieldWrite<T> fieldWrite) {
		visitCtVariableWrite(fieldWrite);
		scanCtFieldAccess(fieldWrite);
		scanCtTargetedExpression(fieldWrite);
	}

	public <T> void visitCtSuperAccess(CtSuperAccess<T> f) {
		visitCtVariableRead(f);
		scanCtTargetedExpression(f);
	}

	public void scanCtMultiTypedElement(CtMultiTypedElement f) {
	}

	public <T, A extends T> void visitCtOperatorAssignment(
			CtOperatorAssignment<T, A> e) {
		visitCtAssignment(e);
	}

	/**
	 * Scans an abstract variable reference.
	 */
	public <T> void scanCtVariableReference(CtVariableReference<T> reference) {
	}

	/**
	 * Scans an abstract variable reference.
	 */
	public <T> void scanCtTypeInformation(CtTypeInformation typeInfo) {
	}

	public <A extends Annotation> void visitCtAnnotation(
			CtAnnotation<A> e) {
		scanCtExpression(e);
		scanCtCodeElement(e);
		scanCtTypedElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
		scanCtShadowable(e);
	}

	public <A extends Annotation> void visitCtAnnotationType(CtAnnotationType<A> e) {
		scanCtType(e);
		scanCtNamedElement(e);
		scanCtTypeInformation(e);
		scanCtTypeMember(e);
		scanCtFormalTypeDeclarer(e);
		scanCtModifiable(e);
		scanCtElement(e);
		scanCtVisitable(e);
		scanCtShadowable(e);
	}

	public void visitCtAnonymousExecutable(CtAnonymousExecutable e) {
		scanCtExecutable(e);
		scanCtNamedElement(e);
		scanCtTypedElement(e);
		scanCtTypeMember(e);
		scanCtModifiable(e);
		scanCtElement(e);
		scanCtVisitable(e);
		scanCtBodyHolder(e);
	}

	@Override
	public <T> void visitCtArrayRead(CtArrayRead<T> arrayRead) {
		scanCtArrayAccess(arrayRead);
		scanCtTargetedExpression(arrayRead);
		scanCtExpression(arrayRead);
		scanCtCodeElement(arrayRead);
		scanCtTypedElement(arrayRead);
		scanCtElement(arrayRead);
		scanCtVisitable(arrayRead);
	}

	@Override
	public <T> void visitCtArrayWrite(CtArrayWrite<T> arrayWrite) {
		scanCtArrayAccess(arrayWrite);
		scanCtTargetedExpression(arrayWrite);
		scanCtExpression(arrayWrite);
		scanCtCodeElement(arrayWrite);
		scanCtTypedElement(arrayWrite);
		scanCtElement(arrayWrite);
		scanCtVisitable(arrayWrite);
	}

	public <T> void visitCtArrayTypeReference(CtArrayTypeReference<T> e) {
		visitCtTypeReference(e);
	}

	public <T> void visitCtAssert(CtAssert<T> e) {
		scanCtStatement(e);
		scanCtCodeElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
	}

	public <T, A extends T> void visitCtAssignment(
			CtAssignment<T, A> e) {
		scanCtStatement(e);
		scanCtExpression(e);
		scanCtCodeElement(e);
		scanCtTypedElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
		scanCtRHSReceiver(e);
	}

	public <T> void visitCtBinaryOperator(CtBinaryOperator<T> e) {
		scanCtExpression(e);
		scanCtCodeElement(e);
		scanCtTypedElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
	}

	public <R> void visitCtBlock(CtBlock<R> e) {
		scanCtStatement(e);
		visitCtStatementList(e);
	}

	public void visitCtBreak(CtBreak e) {
		scanCtLabelledFlowBreak(e);
		scanCtCFlowBreak(e);
		scanCtStatement(e);
		scanCtCodeElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
	}

	public <E> void visitCtCase(CtCase<E> e) {
		scanCtStatement(e);
		visitCtStatementList(e);
	}

	public void visitCtCatch(CtCatch e) {
		scanCtCodeElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
		scanCtBodyHolder(e);
	}

	public <T> void visitCtClass(CtClass<T> e) {
		scanCtType(e);
		scanCtStatement(e);
		scanCtTypeInformation(e);
		scanCtFormalTypeDeclarer(e);
		scanCtCodeElement(e);
		scanCtNamedElement(e);
		scanCtTypeMember(e);
		scanCtElement(e);
		scanCtModifiable(e);
		scanCtVisitable(e);
		scanCtShadowable(e);
	}

	@Override
	public void visitCtTypeParameter(CtTypeParameter typeParameter) {
		scanCtType(typeParameter);
		scanCtTypeInformation(typeParameter);
		scanCtFormalTypeDeclarer(typeParameter);
		scanCtNamedElement(typeParameter);
		scanCtTypeMember(typeParameter);
		scanCtElement(typeParameter);
		scanCtModifiable(typeParameter);
		scanCtVisitable(typeParameter);
		scanCtShadowable(typeParameter);
	}

	public <T> void visitCtConditional(CtConditional<T> e) {
		scanCtExpression(e);
		scanCtCodeElement(e);
		scanCtTypedElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
	}

	public <T> void visitCtConstructor(CtConstructor<T> e) {
		scanCtExecutable(e);
		scanCtNamedElement(e);
		scanCtFormalTypeDeclarer(e);
		scanCtTypedElement(e);
		scanCtTypeMember(e);
		scanCtModifiable(e);
		scanCtElement(e);
		scanCtVisitable(e);
		scanCtShadowable(e);
		scanCtBodyHolder(e);
	}

	public void visitCtContinue(CtContinue e) {
		scanCtLabelledFlowBreak(e);
		scanCtCFlowBreak(e);
		scanCtStatement(e);
		scanCtCodeElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
	}

	public void visitCtDo(CtDo e) {
		scanCtLoop(e);
		scanCtStatement(e);
		scanCtCodeElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
		scanCtBodyHolder(e);
	}

	public <T extends Enum<?>> void visitCtEnum(CtEnum<T> e) {
		visitCtClass(e);
	}

	public <T> void visitCtExecutableReference(CtExecutableReference<T> e) {
		scanCtReference(e);
		scanCtElement(e);
		scanCtActualTypeContainer(e);
		scanCtVisitable(e);
	}

	public <T> void visitCtField(CtField<T> e) {
		scanCtNamedElement(e);
		scanCtVariable(e);
		scanCtTypeMember(e);
		scanCtModifiable(e);
		scanCtTypedElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
		scanCtRHSReceiver(e);
		scanCtShadowable(e);
	}

	@Override
	public <T> void visitCtEnumValue(CtEnumValue<T> enumValue) {
		visitCtField(enumValue);
	}

	public <T> void visitCtThisAccess(CtThisAccess<T> e) {
		scanCtTargetedExpression(e);
		scanCtExpression(e);
		scanCtCodeElement(e);
		scanCtTypedElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
	}

	public <T> void visitCtFieldReference(CtFieldReference<T> e) {
		scanCtVariableReference(e);
		scanCtReference(e);
		scanCtElement(e);
		scanCtVisitable(e);
	}

	public void visitCtFor(CtFor e) {
		scanCtLoop(e);
		scanCtStatement(e);
		scanCtCodeElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
		scanCtBodyHolder(e);
	}

	public void visitCtForEach(CtForEach e) {
		scanCtLoop(e);
		scanCtStatement(e);
		scanCtCodeElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
		scanCtBodyHolder(e);
	}

	public void visitCtIf(CtIf e) {
		scanCtStatement(e);
		scanCtCodeElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
	}

	public <T> void visitCtInterface(CtInterface<T> e) {
		scanCtType(e);
		scanCtTypeInformation(e);
		scanCtFormalTypeDeclarer(e);
		scanCtNamedElement(e);
		scanCtTypeMember(e);
		scanCtElement(e);
		scanCtModifiable(e);
		scanCtVisitable(e);
		scanCtShadowable(e);
	}

	public <T> void visitCtInvocation(CtInvocation<T> e) {
		scanCtAbstractInvocation(e);
		scanCtStatement(e);
		scanCtActualTypeContainer(e);
		scanCtTargetedExpression(e);
		scanCtElement(e);
		scanCtCodeElement(e);
		scanCtExpression(e);
		scanCtVisitable(e);
		scanCtTypedElement(e);
	}

	public <T> void visitCtLiteral(CtLiteral<T> e) {
		scanCtExpression(e);
		scanCtCodeElement(e);
		scanCtTypedElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
	}

	public void visitCtTextBlock(CtTextBlock e) {
		visitCtLiteral(e);
	}

	public <T> void visitCtLocalVariable(CtLocalVariable<T> e) {
		scanCtStatement(e);
		scanCtVariable(e);
		scanCtCodeElement(e);
		scanCtNamedElement(e);
		scanCtTypedElement(e);
		scanCtElement(e);
		scanCtModifiable(e);
		scanCtVisitable(e);
		scanCtRHSReceiver(e);
	}

	public <T> void visitCtLocalVariableReference(
			CtLocalVariableReference<T> e) {
		scanCtVariableReference(e);
		scanCtReference(e);
		scanCtElement(e);
		scanCtVisitable(e);
	}

	public <T> void visitCtCatchVariable(CtCatchVariable<T> e) {
		scanCtVariable(e);
		scanCtMultiTypedElement(e);
		scanCtCodeElement(e);
		scanCtNamedElement(e);
		scanCtTypedElement(e);
		scanCtElement(e);
		scanCtModifiable(e);
		scanCtVisitable(e);
	}

	public <T> void visitCtCatchVariableReference(CtCatchVariableReference<T> e) {
		scanCtVariableReference(e);
		scanCtReference(e);
		scanCtElement(e);
		scanCtVisitable(e);
	}

	public <T> void visitCtMethod(CtMethod<T> e) {
		scanCtExecutable(e);
		scanCtTypedElement(e);
		scanCtNamedElement(e);
		scanCtFormalTypeDeclarer(e);
		scanCtTypeMember(e);
		scanCtElement(e);
		scanCtModifiable(e);
		scanCtVisitable(e);
		scanCtShadowable(e);
		scanCtBodyHolder(e);
	}

	@Override
	public <T> void visitCtAnnotationMethod(CtAnnotationMethod<T> annotationMethod) {
		visitCtMethod(annotationMethod);
	}

	public <T> void visitCtNewArray(CtNewArray<T> e) {
		scanCtExpression(e);
		scanCtCodeElement(e);
		scanCtTypedElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
	}

	@Override
	public <T> void visitCtConstructorCall(CtConstructorCall<T> e) {
		scanCtTargetedExpression(e);
		scanCtAbstractInvocation(e);
		scanCtStatement(e);
		scanCtActualTypeContainer(e);
		scanCtExpression(e);
		scanCtElement(e);
		scanCtCodeElement(e);
		scanCtTypedElement(e);
		scanCtVisitable(e);
	}

	public <T> void visitCtNewClass(CtNewClass<T> e) {
		visitCtConstructorCall(e);
	}

	@Override
	public <T> void visitCtLambda(CtLambda<T> e) {
		scanCtExpression(e);
		scanCtCodeElement(e);
		scanCtTypedElement(e);
		scanCtExecutable(e);
		scanCtNamedElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
		scanCtBodyHolder(e);
	}

	@Override
	public <T, E extends CtExpression<?>> void visitCtExecutableReferenceExpression(
			CtExecutableReferenceExpression<T, E> e) {
		scanCtTargetedExpression(e);
		scanCtExpression(e);
		scanCtCodeElement(e);
		scanCtTypedElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
	}

	public <T, A extends T> void visitCtOperatorAssignement(
			CtOperatorAssignment<T, A> assignment) {
	}

	public void visitCtPackage(CtPackage e) {
		scanCtNamedElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
		scanCtShadowable(e);
	}

	public void visitCtPackageReference(CtPackageReference e) {
		scanCtReference(e);
		scanCtElement(e);
		scanCtVisitable(e);
	}

	public <T> void visitCtParameter(CtParameter<T> e) {
		scanCtNamedElement(e);
		scanCtVariable(e);
		scanCtModifiable(e);
		scanCtTypedElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
		scanCtShadowable(e);
	}

	public <T> void visitCtParameterReference(CtParameterReference<T> e) {
		scanCtVariableReference(e);
		scanCtReference(e);
		scanCtElement(e);
		scanCtVisitable(e);
	}

	public <R> void visitCtReturn(CtReturn<R> e) {
		scanCtCFlowBreak(e);
		scanCtStatement(e);
		scanCtCodeElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
	}

	public <R> void visitCtStatementList(CtStatementList e) {
		scanCtCodeElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
	}

	public <E> void visitCtSwitch(CtSwitch<E> e) {
		scanCtAbstractSwitch(e);
		scanCtStatement(e);
		scanCtCodeElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
	}

	public <T, S> void visitCtSwitchExpression(CtSwitchExpression<T, S> e) {
		scanCtAbstractSwitch(e);
		scanCtExpression(e);
		scanCtCodeElement(e);
		scanCtTypedElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
	}

	public void visitCtSynchronized(CtSynchronized e) {
		scanCtStatement(e);
		scanCtCodeElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
	}

	public void visitCtThrow(CtThrow e) {
		scanCtCFlowBreak(e);
		scanCtStatement(e);
		scanCtCodeElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
	}

	public void visitCtTry(CtTry e) {
		scanCtStatement(e);
		scanCtCodeElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
		scanCtBodyHolder(e);
	}

	@Override
	public void visitCtTryWithResource(CtTryWithResource e) {
		visitCtTry(e);
	}

	public void visitCtTypeParameterReference(CtTypeParameterReference e) {
		visitCtTypeReference(e);
	}

	@Override
	public void visitCtWildcardReference(CtWildcardReference wildcardReference) {
		visitCtTypeParameterReference(wildcardReference);
	}

	@Override
	public <T> void visitCtIntersectionTypeReference(CtIntersectionTypeReference<T> e) {
		visitCtTypeReference(e);
	}

	public <T> void visitCtTypeReference(CtTypeReference<T> e) {
		scanCtReference(e);
		scanCtTypeInformation(e);
		scanCtActualTypeContainer(e);
		scanCtElement(e);
		scanCtVisitable(e);
		scanCtShadowable(e);
	}

	@Override
	public <T> void visitCtTypeAccess(CtTypeAccess<T> e) {
		scanCtExpression(e);
		scanCtCodeElement(e);
		scanCtTypedElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
	}

	public <T> void visitCtUnaryOperator(CtUnaryOperator<T> e) {
		scanCtExpression(e);
		scanCtStatement(e);
		scanCtCodeElement(e);
		scanCtTypedElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
	}

	@Override
	public <T> void visitCtVariableRead(CtVariableRead<T> e) {
		scanCtVariableAccess(e);
		scanCtExpression(e);
		scanCtCodeElement(e);
		scanCtTypedElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
	}

	@Override
	public <T> void visitCtVariableWrite(CtVariableWrite<T> e) {
		scanCtVariableAccess(e);
		scanCtExpression(e);
		scanCtCodeElement(e);
		scanCtTypedElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
	}

	@Override
	public void visitCtComment(CtComment e) {
		scanCtElement(e);
		scanCtVisitable(e);
		scanCtStatement(e);
		scanCtCodeElement(e);
	}

	@Override
	public void visitCtJavaDoc(CtJavaDoc e) {
		visitCtComment(e);
	}

	@Override
	public void visitCtJavaDocTag(CtJavaDocTag e) {
		scanCtElement(e);
		scanCtVisitable(e);
	}

	public <T> void visitCtAnnotationFieldAccess(
			CtAnnotationFieldAccess<T> e) {
		visitCtVariableRead(e);
		scanCtTargetedExpression(e);
	}

	public void visitCtWhile(CtWhile e) {
		scanCtLoop(e);
		scanCtStatement(e);
		scanCtCodeElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
		scanCtBodyHolder(e);
	}

	public <T> void visitCtUnboundVariableReference(CtUnboundVariableReference<T> reference) {
		scanCtVariableReference(reference);
		scanCtReference(reference);
		scanCtElement(reference);
		scanCtVisitable(reference);
	}

	public void scanCtCodeSnippet(CtCodeSnippet snippet) {
	}

	@Override
	public void visitCtImport(CtImport ctImport) {
		scanCtElement(ctImport);
		scanCtVisitable(ctImport);
	}

	@Override
	public void visitCtModule(CtModule module) {
		scanCtNamedElement(module);
		scanCtVisitable(module);
		scanCtElement(module);
	}

	@Override
	public void visitCtModuleReference(CtModuleReference moduleReference) {
		scanCtReference(moduleReference);
		scanCtElement(moduleReference);
		scanCtVisitable(moduleReference);
	}

	@Override
	public void visitCtPackageExport(CtPackageExport moduleExport) {
		scanCtElement(moduleExport);
		scanCtVisitable(moduleExport);
		scanCtModuleDirective(moduleExport);
	}

	@Override
	public void visitCtModuleRequirement(CtModuleRequirement moduleRequirement) {
		scanCtElement(moduleRequirement);
		scanCtVisitable(moduleRequirement);
		scanCtModuleDirective(moduleRequirement);
	}

	@Override
	public void visitCtProvidedService(CtProvidedService moduleProvidedService) {
		scanCtElement(moduleProvidedService);
		scanCtVisitable(moduleProvidedService);
		scanCtModuleDirective(moduleProvidedService);
	}

	@Override
	public void visitCtUsedService(CtUsedService usedService) {
		scanCtElement(usedService);
		scanCtVisitable(usedService);
		scanCtModuleDirective(usedService);
	}

	@Override
	public void visitCtCompilationUnit(CtCompilationUnit compilationUnit) {
		scanCtElement(compilationUnit);
		scanCtVisitable(compilationUnit);
	}

	@Override
	public void visitCtPackageDeclaration(CtPackageDeclaration packageDeclaration) {
		scanCtElement(packageDeclaration);
		scanCtVisitable(packageDeclaration);
	}

	@Override
	public void visitCtTypeMemberWildcardImportReference(CtTypeMemberWildcardImportReference wildcardReference) {
		scanCtReference(wildcardReference);
		scanCtElement(wildcardReference);
		scanCtVisitable(wildcardReference);
	}
	public void visitCtYieldStatement(CtYieldStatement e) {
		scanCtCFlowBreak(e);
		scanCtStatement(e);
		scanCtCodeElement(e);
		scanCtElement(e);
		scanCtVisitable(e);
	}

}
