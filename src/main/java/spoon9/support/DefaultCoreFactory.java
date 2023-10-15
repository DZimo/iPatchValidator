/**
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.support;


import spoon9.experimental.CtUnresolvedImport;
import spoon9.reflect.code.*;
import spoon9.reflect.cu.CompilationUnit;
import spoon9.reflect.cu.SourcePosition;
import spoon9.reflect.cu.position.BodyHolderSourcePosition;
import spoon9.reflect.cu.position.CompoundSourcePosition;
import spoon9.reflect.cu.position.DeclarationSourcePosition;
import spoon9.reflect.declaration.*;
import spoon9.reflect.factory.CoreFactory;
import spoon9.reflect.factory.Factory;
import spoon9.reflect.factory.SubFactory;
import spoon9.reflect.reference.*;
import spoon9.support.reflect.code.*;
import spoon9.support.reflect.cu.CompilationUnitImpl;
import spoon9.support.reflect.cu.position.BodyHolderSourcePositionImpl;
import spoon9.support.reflect.cu.position.CompoundSourcePositionImpl;
import spoon9.support.reflect.cu.position.DeclarationSourcePositionImpl;
import spoon9.support.reflect.cu.position.SourcePositionImpl;
import spoon9.support.reflect.declaration.*;
import spoon9.support.reflect.reference.*;
import spoon9.support.visitor.equals.CloneHelper;

import java.lang.annotation.Annotation;

/**
 * This class implements a default core factory for Spoon's meta-model. This
 * implementation is done with regular Java classes (POJOs).
 */
public class DefaultCoreFactory extends SubFactory implements CoreFactory {

	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public DefaultCoreFactory() {
		super(null);
	}

	@Override
	public <T extends CtElement> T clone(T object) {
		return CloneHelper.INSTANCE.clone(object);
	}

	@Override
	public <A extends Annotation> CtAnnotation<A> createAnnotation() {
		CtAnnotation<A> e = new CtAnnotationImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T extends Annotation> CtAnnotationType<T> createAnnotationType() {
		CtAnnotationType<T> e = new CtAnnotationTypeImpl<>();
		e.setFactory(getMainFactory());
		e.setParent(getMainFactory().Package().getRootPackage());
		return e;
	}

	@Override
	public CtAnonymousExecutable createAnonymousExecutable() {
		CtAnonymousExecutable e = new CtAnonymousExecutableImpl();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtArrayRead<T> createArrayRead() {
		CtArrayRead<T> e = new CtArrayReadImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtArrayWrite<T> createArrayWrite() {
		CtArrayWrite<T> e = new CtArrayWriteImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtArrayTypeReference<T> createArrayTypeReference() {
		CtArrayTypeReference<T> e = new CtArrayTypeReferenceImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtAssert<T> createAssert() {
		CtAssert<T> e = new CtAssertImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T, A extends T> CtAssignment<T, A> createAssignment() {
		CtAssignment<T, A> e = new CtAssignmentImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtBinaryOperator<T> createBinaryOperator() {
		CtBinaryOperator<T> e = new CtBinaryOperatorImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <R> CtBlock<R> createBlock() {
		CtBlock<R> e = new CtBlockImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public CtBreak createBreak() {
		CtBreak e = new CtBreakImpl();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <S> CtCase<S> createCase() {
		CtCase<S> e = new CtCaseImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public CtCatch createCatch() {
		CtCatch e = new CtCatchImpl();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtClass<T> createClass() {
		CtClass<T> e = new CtClassImpl<>();
		e.setFactory(getMainFactory());
		e.setParent(getMainFactory().Package().getRootPackage());
		return e;
	}

	@Override
	public CtTypeParameter createTypeParameter() {
		CtTypeParameter e = new CtTypeParameterImpl();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtConditional<T> createConditional() {
		CtConditional<T> e = new CtConditionalImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtConstructor<T> createConstructor() {
		CtConstructor<T> e = new CtConstructorImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtConstructor<T> createInvisibleArrayConstructor() {
		CtConstructor<T> e = new InvisibleArrayConstructorImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public CtContinue createContinue() {
		CtContinue e = new CtContinueImpl();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public CtDo createDo() {
		CtDo e = new CtDoImpl();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T extends Enum<?>> CtEnum<T> createEnum() {
		CtEnum<T> e = new CtEnumImpl<>();
		e.setFactory(getMainFactory());
		e.setParent(getMainFactory().Package().getRootPackage());
		return e;
	}

	@Override
	public <T> CtExecutableReference<T> createExecutableReference() {
		CtExecutableReference<T> e = new CtExecutableReferenceImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtField<T> createField() {
		CtField<T> e = new CtFieldImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtEnumValue<T> createEnumValue() {
		CtEnumValue<T> e = new CtEnumValueImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtFieldRead<T> createFieldRead() {
		CtFieldRead<T> e = new CtFieldReadImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtFieldWrite<T> createFieldWrite() {
		CtFieldWrite<T> e = new CtFieldWriteImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtAnnotationFieldAccess<T> createAnnotationFieldAccess() {
		CtAnnotationFieldAccess<T> e = new CtAnnotationFieldAccessImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtUnboundVariableReference<T> createUnboundVariableReference() {
		CtUnboundVariableReference e = new CtUnboundVariableReferenceImpl<T>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtFieldReference<T> createFieldReference() {
		CtFieldReference<T> e = new CtFieldReferenceImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public CtFor createFor() {
		CtFor e = new CtForImpl();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public CtForEach createForEach() {
		CtForEach e = new CtForEachImpl();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public CtIf createIf() {
		CtIf e = new CtIfImpl();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtInterface<T> createInterface() {
		CtInterface<T> e = new CtInterfaceImpl<>();
		e.setFactory(getMainFactory());
		e.setParent(getMainFactory().Package().getRootPackage());
		return e;
	}

	@Override
	public <T> CtInvocation<T> createInvocation() {
		CtInvocation<T> e = new CtInvocationImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtLiteral<T> createLiteral() {
		CtLiteral<T> e = new CtLiteralImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public CtTextBlock createTextBlock() {
		CtTextBlock textblock = new CtTextBlockImpl();
		textblock.setFactory(getMainFactory());
		return textblock;
	}

	@Override
	public <T> CtLocalVariable<T> createLocalVariable() {
		CtLocalVariable<T> e = new CtLocalVariableImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtLocalVariableReference<T> createLocalVariableReference() {
		CtLocalVariableReference<T> e = new CtLocalVariableReferenceImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtCatchVariable<T> createCatchVariable() {
		CtCatchVariable<T> e = new CtCatchVariableImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtCatchVariableReference<T> createCatchVariableReference() {
		CtCatchVariableReference<T> e = new CtCatchVariableReferenceImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtMethod<T> createMethod() {
		CtMethod<T> e = new CtMethodImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtAnnotationMethod<T> createAnnotationMethod() {
		CtAnnotationMethod<T> e = new CtAnnotationMethodImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtNewArray<T> createNewArray() {
		CtNewArray<T> e = new CtNewArrayImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtConstructorCall<T> createConstructorCall() {
		CtConstructorCall<T> e = new CtConstructorCallImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtNewClass<T> createNewClass() {
		CtNewClass<T> e = new CtNewClassImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtLambda<T> createLambda() {
		CtLambda<T> e = new CtLambdaImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T, E extends CtExpression<?>> CtExecutableReferenceExpression<T, E> createExecutableReferenceExpression() {
		CtExecutableReferenceExpression<T, E> e = new CtExecutableReferenceExpressionImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T, A extends T> CtOperatorAssignment<T, A> createOperatorAssignment() {
		CtOperatorAssignment<T, A> e = new CtOperatorAssignmentImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public CtPackage createPackage() {
		CtPackage e = new CtPackageImpl();
		e.setFactory(getMainFactory());
		e.setParent(getMainFactory().Package().getRootPackage());
		return e;
	}

	@Override
	public CtPackageReference createPackageReference() {
		CtPackageReference e = new CtPackageReferenceImpl();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtParameter<T> createParameter() {
		CtParameter<T> e = new CtParameterImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtParameterReference<T> createParameterReference() {
		CtParameterReference<T> e = new CtParameterReferenceImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <R> CtReturn<R> createReturn() {
		CtReturn<R> e = new CtReturnImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <R> CtStatementList createStatementList() {
		CtStatementList e = new CtStatementListImpl<R>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <S> CtSwitch<S> createSwitch() {
		CtSwitch<S> e = new CtSwitchImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T, S> CtSwitchExpression<T, S> createSwitchExpression() {
		CtSwitchExpression<T, S> e = new CtSwitchExpressionImpl<T, S>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public CtSynchronized createSynchronized() {
		CtSynchronized e = new CtSynchronizedImpl();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public CtThrow createThrow() {
		CtThrow e = new CtThrowImpl();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public CtTry createTry() {
		CtTry e = new CtTryImpl();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public CtTryWithResource createTryWithResource() {
		CtTryWithResource e = new CtTryWithResourceImpl();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public CtTypeParameterReference createTypeParameterReference() {
		CtTypeParameterReference e = new CtTypeParameterReferenceImpl();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public CtWildcardReference createWildcardReference() {
		CtWildcardReference e = new CtWildcardReferenceImpl();
		e.setFactory(getMainFactory());
		e.setBoundingType(null);
		return e;
	}

	@Override
	public <T> CtIntersectionTypeReference<T> createIntersectionTypeReference() {
		CtIntersectionTypeReference<T> e = new CtIntersectionTypeReferenceImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtTypeReference<T> createTypeReference() {
		CtTypeReference<T> e = new CtTypeReferenceImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtTypeAccess<T> createTypeAccess() {
		CtTypeAccess<T> e = new CtTypeAccessImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtUnaryOperator<T> createUnaryOperator() {
		CtUnaryOperator<T> e = new CtUnaryOperatorImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtVariableRead<T> createVariableRead() {
		CtVariableRead<T> e = new CtVariableReadImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtVariableWrite<T> createVariableWrite() {
		CtVariableWrite<T> e = new CtVariableWriteImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtCodeSnippetExpression<T> createCodeSnippetExpression() {
		CtCodeSnippetExpression<T> e = new CtCodeSnippetExpressionImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public CtCodeSnippetStatement createCodeSnippetStatement() {
		CtCodeSnippetStatement e = new CtCodeSnippetStatementImpl();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public CtComment createComment() {
		CtComment e = new CtCommentImpl();
		e.setFactory(getMainFactory());
		e.setCommentType(CtComment.CommentType.BLOCK);
		e.setContent("");
		return e;
	}

	@Override
	public CtJavaDoc createJavaDoc() {
		CtJavaDoc e = new CtJavaDocImpl();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public CtJavaDocTag createJavaDocTag() {
		CtJavaDocTag e = new CtJavaDocTagImpl();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public CtWhile createWhile() {
		CtWhile e = new CtWhileImpl();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public CtImport createImport() {
		CtImport e = new CtImportImpl();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public CtImport createUnresolvedImport() {
		CtImport e = new CtUnresolvedImport();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public CtPackageDeclaration createPackageDeclaration() {
		CtPackageDeclaration e = new CtPackageDeclarationImpl();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public Factory getMainFactory() {
		return factory;
	}

	@Override
	public void setMainFactory(Factory mainFactory) {
		this.factory = mainFactory;
	}

	@Override
	public SourcePosition createSourcePosition(CompilationUnit compilationUnit, int startSource, int end, int[] lineSeparatorPositions) {
		return new SourcePositionImpl(compilationUnit, startSource, end, lineSeparatorPositions);
	}

	@Override
	public SourcePosition createPartialSourcePosition(CompilationUnit compilationUnit) {
		return ((CompilationUnitImpl) compilationUnit).getOrCreatePartialSourcePosition();
	}

	@Override
	public CompoundSourcePosition createCompoundSourcePosition(CompilationUnit compilationUnit, int startSource, int end, int declarationStart, int declarationEnd, int[] lineSeparatorPositions) {
		return new CompoundSourcePositionImpl(compilationUnit, startSource, end, declarationStart, declarationEnd, lineSeparatorPositions);
	}

	@Override
	public DeclarationSourcePosition createDeclarationSourcePosition(CompilationUnit compilationUnit, int startSource, int end, int modifierStart, int modifierEnd, int declarationStart, int declarationEnd, int[] lineSeparatorPositions) {
		return new DeclarationSourcePositionImpl(compilationUnit, startSource, end, modifierStart, modifierEnd, declarationStart, declarationEnd, lineSeparatorPositions);
	}

	@Override
	public BodyHolderSourcePosition createBodyHolderSourcePosition(
			CompilationUnit compilationUnit,
			int nameStart, int nameEnd,
			int modifierStart, int modifierEnd,
			int declarationStart, int declarationEnd,
			int bodyStart, int bodyEnd, int[] lineSeparatorPositions) {
		return new BodyHolderSourcePositionImpl(compilationUnit,
				nameStart, nameEnd,
				modifierStart, modifierEnd,
				declarationStart, declarationEnd,
				bodyStart, bodyEnd,
				lineSeparatorPositions);
	}

	@Override
	public CompilationUnit createCompilationUnit() {
		CompilationUnit cu = new CompilationUnitImpl();
		cu.setFactory(getMainFactory());
		return cu;
	}

	@Override
	public <T> CtThisAccess<T> createThisAccess() {
		CtThisAccess<T> e = new CtThisAccessImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public <T> CtSuperAccess<T> createSuperAccess() {
		CtSuperAccess<T> e = new CtSuperAccessImpl<>();
		e.setFactory(getMainFactory());
		return e;
	}

	@Override
	public CtElement create(Class<? extends CtElement> klass) {
		if (klass.equals(CtAnnotationFieldAccess.class)) {
			return createAnnotationFieldAccess();
		}
		if (klass.equals(CtArrayRead.class)) {
			return createArrayRead();
		}
		if (klass.equals(CtArrayWrite.class)) {
			return createArrayWrite();
		}
		if (klass.equals(CtAssert.class)) {
			return createAssert();
		}
		if (klass.equals(CtAssignment.class)) {
			return createAssignment();
		}
		if (klass.equals(CtBinaryOperator.class)) {
			return createBinaryOperator();
		}
		if (klass.equals(CtBlock.class)) {
			return createBlock();
		}
		if (klass.equals(CtBreak.class)) {
			return createBreak();
		}
		if (klass.equals(CtCase.class)) {
			return createCase();
		}
		if (klass.equals(CtCatch.class)) {
			return createCatch();
		}
		if (klass.equals(CtCatchVariable.class)) {
			return createCatchVariable();
		}
		if (klass.equals(CtCodeSnippetExpression.class)) {
			return createCodeSnippetExpression();
		}
		if (klass.equals(CtCodeSnippetStatement.class)) {
			return createCodeSnippetStatement();
		}
		if (klass.equals(CtComment.class)) {
			return createComment();
		}
		if (klass.equals(CtJavaDoc.class)) {
			return createJavaDoc();
		}
		if (klass.equals(CtJavaDocTag.class)) {
			return createJavaDocTag();
		}
		if (klass.equals(CtConditional.class)) {
			return createConditional();
		}
		if (klass.equals(CtConstructorCall.class)) {
			return createConstructorCall();
		}
		if (klass.equals(CtContinue.class)) {
			return createContinue();
		}
		if (klass.equals(CtDo.class)) {
			return createDo();
		}
		if (klass.equals(CtExecutableReferenceExpression.class)) {
			return createExecutableReferenceExpression();
		}
		if (klass.equals(CtFieldRead.class)) {
			return createFieldRead();
		}
		if (klass.equals(CtFieldWrite.class)) {
			return createFieldWrite();
		}
		if (klass.equals(CtForEach.class)) {
			return createForEach();
		}
		if (klass.equals(CtFor.class)) {
			return createFor();
		}
		if (klass.equals(CtIf.class)) {
			return createIf();
		}
		if (klass.equals(CtInvocation.class)) {
			return createInvocation();
		}
		if (klass.equals(CtLambda.class)) {
			return createLambda();
		}
		if (klass.equals(CtLiteral.class)) {
			return createLiteral();
		}
		if (klass.equals(CtTextBlock.class)) {
			return createTextBlock();
		}
		if (klass.equals(CtLocalVariable.class)) {
			return createLocalVariable();
		}
		if (klass.equals(CtNewArray.class)) {
			return createNewArray();
		}
		if (klass.equals(CtNewClass.class)) {
			return createNewClass();
		}
		if (klass.equals(CtOperatorAssignment.class)) {
			return createOperatorAssignment();
		}
		if (klass.equals(CtReturn.class)) {
			return createReturn();
		}
		if (klass.equals(CtStatementList.class)) {
			return createStatementList();
		}
		if (klass.equals(CtSuperAccess.class)) {
			return createSuperAccess();
		}
		if (klass.equals(CtSwitch.class)) {
			return createSwitch();
		}
		if (klass.equals(CtSwitchExpression.class)) {
			return createSwitchExpression();
		}
		if (klass.equals(CtSynchronized.class)) {
			return createSynchronized();
		}
		if (klass.equals(CtThisAccess.class)) {
			return createThisAccess();
		}
		if (klass.equals(CtThrow.class)) {
			return createThrow();
		}
		if (klass.equals(CtTry.class)) {
			return createTry();
		}
		if (klass.equals(CtTryWithResource.class)) {
			return createTryWithResource();
		}
		if (klass.equals(CtTypeAccess.class)) {
			return createTypeAccess();
		}
		if (klass.equals(CtUnaryOperator.class)) {
			return createUnaryOperator();
		}
		if (klass.equals(CtVariableRead.class)) {
			return createVariableRead();
		}
		if (klass.equals(CtVariableWrite.class)) {
			return createVariableWrite();
		}
		if (klass.equals(CtWhile.class)) {
			return createWhile();
		}
		if (klass.equals(CtAnnotation.class)) {
			return createAnnotation();
		}
		if (klass.equals(CtAnnotationMethod.class)) {
			return createAnnotationMethod();
		}
		if (klass.equals(CtAnnotationType.class)) {
			return createAnnotationType();
		}
		if (klass.equals(CtAnonymousExecutable.class)) {
			return createAnonymousExecutable();
		}
		if (klass.equals(CtClass.class)) {
			return createClass();
		}
		if (klass.equals(CtConstructor.class)) {
			return createConstructor();
		}
		if (klass.equals(CtEnum.class)) {
			return createEnum();
		}
		if (klass.equals(CtEnumValue.class)) {
			return createEnumValue();
		}
		if (klass.equals(CtField.class)) {
			return createField();
		}
		if (klass.equals(CtInterface.class)) {
			return createInterface();
		}
		if (klass.equals(CtMethod.class)) {
			return createMethod();
		}
		if (klass.equals(CtPackage.class)) {
			return createPackage();
		}
		if (klass.equals(CtParameter.class)) {
			return createParameter();
		}
		if (klass.equals(CtTypeParameter.class)) {
			return createTypeParameter();
		}
		if (klass.equals(CtArrayTypeReference.class)) {
			return createArrayTypeReference();
		}
		if (klass.equals(CtCatchVariableReference.class)) {
			return createCatchVariableReference();
		}
		if (klass.equals(CtExecutableReference.class)) {
			return createExecutableReference();
		}
		if (klass.equals(CtFieldReference.class)) {
			return createFieldReference();
		}
		if (klass.equals(CtIntersectionTypeReference.class)) {
			return createIntersectionTypeReference();
		}
		if (klass.equals(CtLocalVariableReference.class)) {
			return createLocalVariableReference();
		}
		if (klass.equals(CtPackageReference.class)) {
			return createPackageReference();
		}
		if (klass.equals(CtParameterReference.class)) {
			return createParameterReference();
		}
		if (klass.equals(CtTypeParameterReference.class)) {
			return createTypeParameterReference();
		}
		if (klass.equals(CtTypeReference.class)) {
			return createTypeReference();
		}
		if (klass.equals(CtUnboundVariableReference.class)) {
			return createUnboundVariableReference();
		}
		if (klass.equals(CtWildcardReference.class)) {
			return createWildcardReference();
		}
		if (klass.equals(CtImport.class)) {
			return createImport();
		}
		if (klass.equals(CtModuleReference.class)) {
			return createModuleReference();
		}
		if (klass.equals(CtTypeMemberWildcardImportReference.class)) {
			return createTypeMemberWildcardImportReference();
		}
		if (klass.equals(CtModule.class)) {
			return createModule();
		}
		if (klass.equals(CtModuleRequirement.class)) {
			return createModuleRequirement();
		}
		if (klass.equals(CtPackageExport.class)) {
			return createPackageExport();
		}
		if (klass.equals(CtProvidedService.class)) {
			return createProvidedService();
		}
		if (klass.equals(CtUsedService.class)) {
			return createUsedService();
		}
		if (klass.equals(spoon9.reflect.declaration.CtCompilationUnit.class)) {
			return createCompilationUnit();
		}
		if (klass.equals(CtPackageDeclaration.class)) {
			return createPackageDeclaration();
		}
		if (klass.equals(CtYieldStatement.class)) {
			return createYieldStatement();
		}
		throw new IllegalArgumentException("not instantiable by CoreFactory(): " + klass);
	}

	@Override
	public CtTypeMemberWildcardImportReference createTypeMemberWildcardImportReference() {
		CtTypeMemberWildcardImportReference result = new CtTypeMemberWildcardImportReferenceImpl();
		result.setFactory(getMainFactory());
		return result;
	}

	@Override
	public CtModule createModule() {
		CtModule module = new CtModuleImpl();
		module.setFactory(getMainFactory());
		this.getMainFactory().Module().getUnnamedModule().addModule(module);
		return module;
	}

	@Override
	public CtModuleReference createModuleReference() {
		CtModuleReference moduleReference = new CtModuleReferenceImpl();
		moduleReference.setFactory(getMainFactory());
		return moduleReference;
	}

	@Override
	public CtModuleRequirement createModuleRequirement() {
		CtModuleRequirement moduleRequirement = new CtModuleRequirementImpl();
		moduleRequirement.setFactory(getMainFactory());
		return moduleRequirement;
	}

	@Override
	public CtPackageExport createPackageExport() {
		CtPackageExport moduleExport = new CtPackageExportImpl();
		moduleExport.setFactory(getMainFactory());
		return moduleExport;
	}

	@Override
	public CtProvidedService createProvidedService() {
		CtProvidedService moduleProvidedService = new CtProvidedServiceImpl();
		moduleProvidedService.setFactory(getMainFactory());
		return moduleProvidedService;
	}

	@Override
	public CtUsedService createUsedService() {
		CtUsedService ctUsedService = new CtUsedServiceImpl();
		ctUsedService.setFactory(getMainFactory());
		return ctUsedService;
	}

	@Override
	public CtYieldStatement createYieldStatement() {
		CtYieldStatement e = new CtYieldStatementImpl();
		e.setFactory(getMainFactory());
		return e;
	}
}
