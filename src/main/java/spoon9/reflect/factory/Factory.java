/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.reflect.factory;

import spoon9.compiler.Environment;
import spoon9.reflect.CtModel;
import spoon9.reflect.code.BinaryOperatorKind;
import spoon9.reflect.code.CtAnnotationFieldAccess;
import spoon9.reflect.code.CtArrayRead;
import spoon9.reflect.code.CtArrayWrite;
import spoon9.reflect.code.CtAssert;
import spoon9.reflect.code.CtAssignment;
import spoon9.reflect.code.CtBinaryOperator;
import spoon9.reflect.code.CtBlock;
import spoon9.reflect.code.CtBreak;
import spoon9.reflect.code.CtCase;
import spoon9.reflect.code.CtCatch;
import spoon9.reflect.code.CtCatchVariable;
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
import spoon9.reflect.code.CtLambda;
import spoon9.reflect.code.CtLiteral;
import spoon9.reflect.code.CtLocalVariable;
import spoon9.reflect.code.CtNewArray;
import spoon9.reflect.code.CtNewClass;
import spoon9.reflect.code.CtOperatorAssignment;
import spoon9.reflect.code.CtReturn;
import spoon9.reflect.code.CtStatement;
import spoon9.reflect.code.CtStatementList;
import spoon9.reflect.code.CtSuperAccess;
import spoon9.reflect.code.CtSwitch;
import spoon9.reflect.code.CtSwitchExpression;
import spoon9.reflect.code.CtSynchronized;
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
import spoon9.reflect.cu.CompilationUnit;
import spoon9.reflect.cu.SourcePosition;
import spoon9.reflect.cu.position.BodyHolderSourcePosition;
import spoon9.reflect.cu.position.DeclarationSourcePosition;
import spoon9.reflect.declaration.CtAnnotation;
import spoon9.reflect.declaration.CtAnnotationMethod;
import spoon9.reflect.declaration.CtAnnotationType;
import spoon9.reflect.declaration.CtAnonymousExecutable;
import spoon9.reflect.declaration.CtClass;
import spoon9.reflect.declaration.CtConstructor;
import spoon9.reflect.declaration.CtElement;
import spoon9.reflect.declaration.CtEnum;
import spoon9.reflect.declaration.CtEnumValue;
import spoon9.reflect.declaration.CtExecutable;
import spoon9.reflect.declaration.CtField;
import spoon9.reflect.declaration.CtFormalTypeDeclarer;
import spoon9.reflect.declaration.CtInterface;
import spoon9.reflect.declaration.CtMethod;
import spoon9.reflect.declaration.CtModule;
import spoon9.reflect.declaration.CtPackageExport;
import spoon9.reflect.declaration.CtProvidedService;
import spoon9.reflect.declaration.CtModuleRequirement;
import spoon9.reflect.declaration.CtPackage;
import spoon9.reflect.declaration.CtPackageDeclaration;
import spoon9.reflect.declaration.CtParameter;
import spoon9.reflect.declaration.CtType;
import spoon9.reflect.declaration.CtTypeParameter;
import spoon9.reflect.declaration.CtUsedService;
import spoon9.reflect.declaration.CtVariable;
import spoon9.reflect.declaration.ModifierKind;
import spoon9.reflect.eval.PartialEvaluator;
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
import spoon9.reflect.visitor.chain.CtQuery;
import spoon9.support.visitor.GenericTypeAdapter;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;

/**
 * Provides the sub-factories required by Spoon.
 *
 * Most classes provides a method getFactory() that returns the current factory.
 *
 * Otherwise FactoryImpl is a default implementation.
 */
public interface Factory {

	/** returns the Spoon model that has been built with this factory or one of its subfactories */
	CtModel getModel();

	/** Access to {@link CoreFactory} subfactory */
	CoreFactory Core();

	/** Access to {@link TypeFactory} subfactory */
	TypeFactory Type(); // used 107 times

	/** Access to {@link EnumFactory} subfactory */
	EnumFactory Enum();

	/** Access to the {@link Environment} */
	Environment getEnvironment();

	/** Access to {@link PackageFactory} subfactory */
	PackageFactory Package();

	/** Access to {@link CodeFactory} subfactory */
	CodeFactory Code();

	/** Access to {@link ClassFactory} subfactory */
	ClassFactory Class();

	/** Access to {@link FieldFactory} subfactory */
	FieldFactory Field();

	/** Access to {@link ExecutableFactory} subfactory */
	ExecutableFactory Executable();

	/** Access to {@link CompilationUnitFactory} subfactory */
	CompilationUnitFactory CompilationUnit();

	/** Access to {@link InterfaceFactory} subfactory */
	InterfaceFactory Interface();

	/** Access to {@link MethodFactory} subfactory */
	MethodFactory Method();

	/** Access to {@link AnnotationFactory} subfactory */
	AnnotationFactory Annotation();

	/** Access to {@link EvalFactory} subfactory */
	EvalFactory Eval();

	/** Access to {@link ConstructorFactory} subfactory */
	ConstructorFactory Constructor();

	/** Access to {@link QueryFactory} subfactory */
	QueryFactory Query();

	/** Access to {@link ModuleFactory} subfactory for Java 9 modules */
	ModuleFactory Module();

	/** Access to templates */
	Factory Templates();

	/**
	 *  @see CodeFactory#createAnnotation(CtTypeReference)
	 */
	<A extends Annotation> CtAnnotation<A> createAnnotation(CtTypeReference<A> annotationType);

	/**
	 *  @see CodeFactory#createVariableAssignment(CtVariableReference,boolean, CtExpression)
	 */
	<A, T extends A> CtAssignment<A, T> createVariableAssignment(CtVariableReference<A> variable, boolean isStatic, CtExpression<T> expression);

	/**
	 *  @see CodeFactory#createStatementList(CtBlock)
	 */
	<R> CtStatementList createStatementList(CtBlock<R> block);

	/**
	 *  @see CodeFactory#createCtBlock(CtStatement)
	 */
	<T extends CtStatement> CtBlock<?> createCtBlock(T element);

	/**
	 *  @see CodeFactory#createBinaryOperator(CtExpression,CtExpression, BinaryOperatorKind)
	 */
	<T> CtBinaryOperator<T> createBinaryOperator(CtExpression<?> left, CtExpression<?> right, BinaryOperatorKind kind);

	/**
	 *  @see CodeFactory#createCatchVariable(CtTypeReference,String, ModifierKind[])
	 */
	<T> CtCatchVariable<T> createCatchVariable(CtTypeReference<T> type, String name, ModifierKind... modifierKinds);

	/**
	 *  @see CodeFactory#createCodeSnippetExpression(String)
	 */
	<T> CtCodeSnippetExpression<T> createCodeSnippetExpression(String expression);

	/**
	 *  @see CodeFactory#createConstructorCall(CtTypeReference,CtExpression[])
	 */
	<T> CtConstructorCall<T> createConstructorCall(CtTypeReference<T> type, CtExpression<?>... parameters);

	/**
	 *  @see CodeFactory#createClassAccess(CtTypeReference)
	 */
	<T> CtFieldAccess<Class<T>> createClassAccess(CtTypeReference<T> type);

	/**
	 *  @see CodeFactory#createInvocation(CtExpression, CtExecutableReference, List)
	 */
	<T> CtInvocation<T> createInvocation(CtExpression<?> target, CtExecutableReference<T> executable, List<CtExpression<?>> arguments);

	/**
	 *  @see CodeFactory#createInvocation(CtExpression,CtExecutableReference,CtExpression[])
	 */
	<T> CtInvocation<T> createInvocation(CtExpression<?> target, CtExecutableReference<T> executable, CtExpression<?>... arguments);

	/**
	 *  @see CodeFactory#createLiteral(Object)
	 */
	<T> CtLiteral<T> createLiteral(T value);

	/**
	 *  @see CodeFactory#createLocalVariable(CtTypeReference,String,CtExpression)
	 */
	<T> CtLocalVariable<T> createLocalVariable(CtTypeReference<T> type, String name, CtExpression<T> defaultExpression);

	/**
	 *  @see CodeFactory#createLiteralArray(Object[])
	 */
	@SuppressWarnings(value = "unchecked")
	<T> CtNewArray<T[]> createLiteralArray(T[] value);

	/**
	 * Creates an anonymous class
	 *
	 * @param superClass Anonymous class in the new class.
	 * @param parameters the arguments of the constructor call.
	 */
	CtNewClass<?> createNewClass(CtType<?> superClass, CtExpression<?>... parameters);

	/**
	 *  @see CodeFactory#createVariableAssignments(List,List)
	 */
	<T> CtStatementList createVariableAssignments(List<? extends CtVariable<T>> variables, List<? extends CtExpression<T>> expressions);

	/**
	 *  @see CodeFactory#createThisAccess(CtTypeReference)
	 */
	<T> CtThisAccess<T> createThisAccess(CtTypeReference<T> type);

	/**
	 *  @see CodeFactory#createThisAccess(CtTypeReference,boolean)
	 */
	<T> CtThisAccess<T> createThisAccess(CtTypeReference<T> type, boolean isImplicit);

	/**
	 *  @see CodeFactory#createTypeAccess(CtTypeReference)
	 */
	<T> CtTypeAccess<T> createTypeAccess(CtTypeReference<T> accessedType);

	/**
	 *  @see CodeFactory#createTypeAccess(CtTypeReference,boolean)
	 */
	<T> CtTypeAccess<T> createTypeAccess(CtTypeReference<T> accessedType, boolean isImplicit);

	/**
	 *  @see CodeFactory#createTypeAccessWithoutCloningReference(CtTypeReference)
	 */
	<T> CtTypeAccess<T> createTypeAccessWithoutCloningReference(CtTypeReference<T> accessedType);

	/**
	 *  @see CodeFactory#createVariableRead(CtVariableReference,boolean)
	 */
	<T> CtVariableAccess<T> createVariableRead(CtVariableReference<T> variable, boolean isStatic);

	/**
	 *  @see CodeFactory#createVariableWrite(CtVariableReference,boolean)
	 */
	<T> CtVariableAccess<T> createVariableWrite(CtVariableReference<T> variable, boolean isStatic);

	/**
	 *  @see CodeFactory#createCtField(String,CtTypeReference,String,ModifierKind[])
	 */
	<T> CtField<T> createCtField(String name, CtTypeReference<T> type, String exp, ModifierKind... visibilities);

	/**
	 *  @see CodeFactory#createCatchVariableReference(CtCatchVariable)
	 */
	<T> CtCatchVariableReference<T> createCatchVariableReference(CtCatchVariable<T> catchVariable);

	/**
	 *  @see CodeFactory#createLocalVariableReference(CtLocalVariable)
	 */
	<T> CtLocalVariableReference<T> createLocalVariableReference(CtLocalVariable<T> localVariable);

	/**
	 *  @see CodeFactory#createLocalVariableReference(CtTypeReference,String)
	 */
	<T> CtLocalVariableReference<T> createLocalVariableReference(CtTypeReference<T> type, String name);

	/**
	 *  @see CodeFactory#createCtTypeReference(Class)
	 */
	<T> CtTypeReference<T> createCtTypeReference(Class<?> originalClass);

	/**
	 *  @see CodeFactory#createVariableReads(List)
	 */
	List<CtExpression<?>> createVariableReads(List<? extends CtVariable<?>> variables);

	/**
	 *  @see CodeFactory#createCtCatch(String,Class,CtBlock)
	 */
	CtCatch createCtCatch(String nameCatch, Class<? extends Throwable> exception, CtBlock<?> ctBlock);

	/**
	 *  @see CodeFactory#createCodeSnippetStatement(String)
	 */
	CtCodeSnippetStatement createCodeSnippetStatement(String statement);

	/**
	 *  @see CodeFactory#createComment(String,CtComment.CommentType)
	 */
	CtComment createComment(String content, CtComment.CommentType type);

	/**
	 *  @see CodeFactory#createJavaDocTag(String,CtJavaDocTag.TagType)
	 */
	CtJavaDocTag createJavaDocTag(String content, CtJavaDocTag.TagType type);

	/**
	 *  @see CodeFactory#createJavaDocTag(String,CtJavaDocTag.TagType,String)
	 */
	CtJavaDocTag createJavaDocTag(String content, CtJavaDocTag.TagType type, String realName);

	/**
	 * @see CoreFactory#createJavaDoc()
	 */
	CtJavaDoc createJavaDoc();


	/**
	 *  @see CodeFactory#createJavaDocTag()
	 */
	CtJavaDocTag createJavaDocTag();

	/**
	 *  @see CodeFactory#createInlineComment(String)
	 */
	CtComment createInlineComment(String content);

	/**
	 *  @see CodeFactory#createCtThrow(String)
	 */
	CtThrow createCtThrow(String thrownExp);

	/**
	 *  @see CodeFactory#createCtPackageReference(Package)
	 */
	CtPackageReference createCtPackageReference(Package originalPackage);

	/**
	 *  @see ConstructorFactory#createDefault(CtClass)
	 */
	<T> CtConstructor<T> createDefault(CtClass<T> target);

	/**
	 *  @see CoreFactory#createAnnotation()
	 */
	<A extends Annotation> CtAnnotation<A> createAnnotation();

	/**
	 *  @see CoreFactory#createBlock()
	 */
	<R> CtBlock<R> createBlock();

	/**
	 *  @see CoreFactory#createReturn()
	 */
	<R> CtReturn<R> createReturn();

	/**
	 *  @see CoreFactory#createStatementList()
	 */
	<R> CtStatementList createStatementList();

	/**
	 *  @see CoreFactory#createCase()
	 */
	<S> CtCase<S> createCase();

	/**
	 *  @see CoreFactory#createSwitch()
	 */
	<S> CtSwitch<S> createSwitch();

	/**
	 * @see CoreFactory#createSwitchExpression()
	 */
	<T, S> CtSwitchExpression<T, S> createSwitchExpression();

	/**
	 *  @see CoreFactory#createEnum()
	 */
	<T extends Enum<?>> CtEnum<T> createEnum();

	/**
	 *  @see CoreFactory#createAnnotationType()
	 */
	<T extends Annotation> CtAnnotationType<T> createAnnotationType();

	/**
	 *  @see CoreFactory#createAssignment()
	 */
	<T, A extends T> CtAssignment<T, A> createAssignment();

	/**
	 *  @see CoreFactory#createOperatorAssignment()
	 */
	<T, A extends T> CtOperatorAssignment<T, A> createOperatorAssignment();

	/**
	 *  @see CoreFactory#createExecutableReferenceExpression()
	 */
	<T, E extends CtExpression<?>> CtExecutableReferenceExpression<T, E> createExecutableReferenceExpression();

	/**
	 *  @see CoreFactory#createAnnotationFieldAccess()
	 */
	<T> CtAnnotationFieldAccess<T> createAnnotationFieldAccess();

	/**
	 *  @see CoreFactory#createArrayRead()
	 */
	<T> CtArrayRead<T> createArrayRead();

	/**
	 *  @see CoreFactory#createArrayWrite()
	 */
	<T> CtArrayWrite<T> createArrayWrite();

	/**
	 *  @see CoreFactory#createAssert()
	 */
	<T> CtAssert<T> createAssert();

	/**
	 *  @see CoreFactory#createBinaryOperator()
	 */
	<T> CtBinaryOperator<T> createBinaryOperator();

	/**
	 *  @see CoreFactory#createCatchVariable()
	 */
	<T> CtCatchVariable<T> createCatchVariable();

	/**
	 *  @see CoreFactory#createCodeSnippetExpression()
	 */
	<T> CtCodeSnippetExpression<T> createCodeSnippetExpression();

	/**
	 *  @see CoreFactory#createConditional()
	 */
	<T> CtConditional<T> createConditional();

	/**
	 *  @see CoreFactory#createConstructorCall()
	 */
	<T> CtConstructorCall<T> createConstructorCall();

	/**
	 *  @see CoreFactory#createFieldRead()
	 */
	<T> CtFieldRead<T> createFieldRead();

	/**
	 *  @see CoreFactory#createFieldWrite()
	 */
	<T> CtFieldWrite<T> createFieldWrite();

	/**
	 *  @see CoreFactory#createInvocation()
	 */
	<T> CtInvocation<T> createInvocation();

	/**
	 *  @see CoreFactory#createLambda()
	 */
	<T> CtLambda<T> createLambda();

	/**
	 *  @see CoreFactory#createLiteral()
	 */
	<T> CtLiteral<T> createLiteral();

	/**
	 *  @see CoreFactory#createTextBlock()
	 */
	CtTextBlock createTextBlock();

	/**
	 *  @see CodeFactory#createTextBlock(String)
	 */
	CtTextBlock createTextBlock(String value);

	/**
	 *  @see CoreFactory#createLocalVariable()
	 */
	<T> CtLocalVariable<T> createLocalVariable();

	/**
	 *  @see CoreFactory#createNewArray()
	 */
	<T> CtNewArray<T> createNewArray();

	/**
	 *  @see CoreFactory#createNewClass()
	 */
	<T> CtNewClass<T> createNewClass();

	/**
	 *  @see CoreFactory#createSuperAccess()
	 */
	<T> CtSuperAccess<T> createSuperAccess();

	/**
	 *  @see CoreFactory#createThisAccess()
	 */
	<T> CtThisAccess<T> createThisAccess();

	/**
	 *  @see CoreFactory#createTypeAccess()
	 */
	<T> CtTypeAccess<T> createTypeAccess();

	/**
	 *  @see CoreFactory#createUnaryOperator()
	 */
	<T> CtUnaryOperator<T> createUnaryOperator();

	/**
	 *  @see CoreFactory#createVariableRead()
	 */
	<T> CtVariableRead<T> createVariableRead();

	/**
	 *  @see CoreFactory#createVariableWrite()
	 */
	<T> CtVariableWrite<T> createVariableWrite();

	/**
	 *  @see CoreFactory#createAnnotationMethod()
	 */
	<T> CtAnnotationMethod<T> createAnnotationMethod();

	/**
	 *  @see CoreFactory#createClass()
	 */
	<T> CtClass<T> createClass();

	/**
	 *  @see CoreFactory#createConstructor()
	 */
	<T> CtConstructor<T> createConstructor();

	/**
	 *  @see CoreFactory#createInvisibleArrayConstructor() ()
	 */
	<T> CtConstructor<T> createInvisibleArrayConstructor();

	/**
	 *  @see CoreFactory#createEnumValue()
	 */
	<T> CtEnumValue<T> createEnumValue();

	/**
	 *  @see CoreFactory#createField()
	 */
	<T> CtField<T> createField();

	/**
	 *  @see CoreFactory#createInterface()
	 */
	<T> CtInterface<T> createInterface();

	/**
	 *  @see CoreFactory#createMethod()
	 */
	<T> CtMethod<T> createMethod();

	/**
	 *  @see CoreFactory#createParameter()
	 */
	<T> CtParameter<T> createParameter();

	/**
	 *  @see CoreFactory#createArrayTypeReference()
	 */
	<T> CtArrayTypeReference<T> createArrayTypeReference();

	/**
	 *  @see CoreFactory#createCatchVariableReference()
	 */
	<T> CtCatchVariableReference<T> createCatchVariableReference();

	/**
	 *  @see CoreFactory#createExecutableReference()
	 */
	<T> CtExecutableReference<T> createExecutableReference();

	/**
	 *  @see CoreFactory#createFieldReference()
	 */
	<T> CtFieldReference<T> createFieldReference();

	/**
	 *  @see CoreFactory#createIntersectionTypeReference()
	 */
	<T> CtIntersectionTypeReference<T> createIntersectionTypeReference();

	/**
	 *  @see CoreFactory#createLocalVariableReference()
	 */
	<T> CtLocalVariableReference<T> createLocalVariableReference();

	/**
	 *  @see CoreFactory#createParameterReference()
	 */
	<T> CtParameterReference<T> createParameterReference();

	/**
	 *  @see CoreFactory#createTypeReference()
	 */
	<T> CtTypeReference<T> createTypeReference();

	/**
	 *  @see CoreFactory#createUnboundVariableReference()
	 */
	<T> CtUnboundVariableReference<T> createUnboundVariableReference();

	/**
	 *  @see CoreFactory#createBreak()
	 */
	CtBreak createBreak();

	/**
	 *  @see CoreFactory#createCatch()
	 */
	CtCatch createCatch();

	/**
	 *  @see CoreFactory#createCodeSnippetStatement()
	 */
	CtCodeSnippetStatement createCodeSnippetStatement();

	/**
	 *  @see CoreFactory#createComment()
	 */
	CtComment createComment();

	/**
	 *  @see CoreFactory#createContinue()
	 */
	CtContinue createContinue();

	/**
	 *  @see CoreFactory#createDo()
	 */
	CtDo createDo();

	/**
	 *  @see CoreFactory#createFor()
	 */
	CtFor createFor();

	/**
	 *  @see CoreFactory#createForEach()
	 */
	CtForEach createForEach();

	/**
	 *  @see CoreFactory#createIf()
	 */
	CtIf createIf();

	/**
	 *  @see CoreFactory#createSynchronized()
	 */
	CtSynchronized createSynchronized();

	/**
	 *  @see CoreFactory#createThrow()
	 */
	CtThrow createThrow();

	/**
	 *  @see CoreFactory#createTry()
	 */
	CtTry createTry();

	/**
	 *  @see CoreFactory#createTryWithResource()
	 */
	CtTryWithResource createTryWithResource();

	/**
	 *  @see CoreFactory#createWhile()
	 */
	CtWhile createWhile();

	/**
	 *  @see CoreFactory#createCompilationUnit()
	 */
	CompilationUnit createCompilationUnit();

	/**
	 *  @see CoreFactory#createSourcePosition(CompilationUnit,int,int,int[])
	 */
	SourcePosition createSourcePosition(CompilationUnit compilationUnit, int startSource, int end, int[] lineSeparatorPositions);

	/**
	 *  @see CoreFactory#createBodyHolderSourcePosition(CompilationUnit,int,int,int,int,int,int,int,int,int[])
	 */
	BodyHolderSourcePosition createBodyHolderSourcePosition(CompilationUnit compilationUnit, int startSource, int end, int modifierStart, int modifierEnd, int declarationStart, int declarationEnd, int bodyStart, int bodyEnd, int[] lineSeparatorPositions);

	/**
	 *  @see CoreFactory#createDeclarationSourcePosition(CompilationUnit,int,int,int,int,int,int,int[])
	 */
	DeclarationSourcePosition createDeclarationSourcePosition(CompilationUnit compilationUnit, int startSource, int end, int modifierStart, int modifierEnd, int declarationStart, int declarationEnd, int[] lineSeparatorPositions);

	/**
	 *  @see CoreFactory#createAnonymousExecutable()
	 */
	CtAnonymousExecutable createAnonymousExecutable();

	/**
	 *  @see CoreFactory#createPackage()
	 */
	CtPackage createPackage();

	/**
	 *  @see CoreFactory#createTypeParameter()
	 */
	CtTypeParameter createTypeParameter();

	/**
	 *  @see CoreFactory#createPackageReference()
	 */
	CtPackageReference createPackageReference();

	/**
	 *  @see CoreFactory#createTypeParameterReference()
	 */
	CtTypeParameterReference createTypeParameterReference();

	/**
	 *  @see CoreFactory#createWildcardReference()
	 */
	CtWildcardReference createWildcardReference();

	/**
	 *  @see EvalFactory#createPartialEvaluator()
	 */
	PartialEvaluator createPartialEvaluator();

	/**
	 *  @see ExecutableFactory#createParameter(CtExecutable,CtTypeReference,String)
	 */
	<T> CtParameter<T> createParameter(CtExecutable<?> parent, CtTypeReference<T> type, String name);

	/**
	 *  @see ExecutableFactory#createParameterReference(CtParameter)
	 */
	<T> CtParameterReference<T> createParameterReference(CtParameter<T> parameter);

	/**
	 *  @see ExecutableFactory#createAnonymous(CtClass,CtBlock)
	 */
	CtAnonymousExecutable createAnonymous(CtClass<?> target, CtBlock<Void> body);

	/**
	 *  @see TypeFactory#createArrayReference(String)
	 */
	<T> CtArrayTypeReference<T> createArrayReference(String qualifiedName);

	/**
	 *  @see TypeFactory#createArrayReference(CtType)
	 */
	<T> CtArrayTypeReference<T[]> createArrayReference(CtType<T> type);

	/**
	 *  @see TypeFactory#createArrayReference(CtTypeReference)
	 */
	<T> CtArrayTypeReference<T[]> createArrayReference(CtTypeReference<T> reference);

	/**
	 *  @see TypeFactory#createIntersectionTypeReferenceWithBounds(List)
	 */
	<T> CtIntersectionTypeReference<T> createIntersectionTypeReferenceWithBounds(List<CtTypeReference<?>> bounds);

	/**
	 * @see TypeFactory#createTypeAdapter(CtFormalTypeDeclarer)
	 */
	GenericTypeAdapter createTypeAdapter(CtFormalTypeDeclarer formalTypeDeclarer);

	/**
	 *  @see TypeFactory#createReferences(List)
	 */
	List<CtTypeReference<?>> createReferences(List<Class<?>> classes);

	/**
	 *  @see TypeFactory#createArrayReference(CtTypeReference,int)
	 */
	CtArrayTypeReference<?> createArrayReference(CtTypeReference<?> reference, int n);

	/**
	 *  @see TypeFactory#createTypeParameterReference(String)
	 */
	CtTypeParameterReference createTypeParameterReference(String name);

	/**
	 *  @see QueryFactory#createQuery()
	 */
	CtQuery createQuery();

	/**
	 *  @see QueryFactory#createQuery(Object)
	 */
	CtQuery createQuery(Object input);

	/**
	 * @see QueryFactory#createQuery(Object...)
	 */
	CtQuery createQuery(Object... input);

	/**
	 * @see QueryFactory#createQuery(Iterable)
	 */
	CtQuery createQuery(Iterable<?> input);

	/**
	 *
	 * @see AnnotationFactory#create(String)
	 */
	CtAnnotationType createAnnotationType(String qualifiedName);

	/**
	 *
	 * @see AnnotationFactory#create(CtPackage, String)
	 */
	CtAnnotationType createAnnotationType(CtPackage owner, String simpleName);

	/**
	 *
	 * @see ClassFactory#create(String)
	 */
	CtClass createClass(String qualifiedName);

	/**
	 *
	 * @see ClassFactory#create(CtClass, String)
	 */
	CtClass createClass(CtClass<?> declaringClass, String simpleName);

	/**
	 *
	 * @see ClassFactory#create(CtPackage, String)
	 */
	CtClass createClass(CtPackage owner, String simpleName);

	/**
	 *
	 * @see ConstructorFactory#create(CtClass, CtConstructor)
	 */
	CtConstructor createConstructor(CtClass target, CtConstructor<?> source);

	/**
	 *
	 * @see ConstructorFactory#create(CtClass, CtMethod)
	 */
	CtConstructor createConstructor(CtClass target, CtMethod<?> source);

	/**
	 *
	 * @see ConstructorFactory#create(CtClass, Set, List, Set)
	 */
	CtConstructor createConstructor(CtClass target, Set<ModifierKind> modifiers, List<CtParameter<?>> parameters, Set<CtTypeReference<? extends Throwable>> thrownTypes);

	/**
	 *
	 * @see ConstructorFactory#create(CtClass, Set, List, Set, CtBlock)
	 */
	CtConstructor createConstructor(CtClass target, Set<ModifierKind> modifiers, List<CtParameter<?>> parameters, Set<CtTypeReference<? extends Throwable>> thrownTypes, CtBlock body);

	/**
	 *
	 * @see EnumFactory#create(String)
	 */
	CtEnum<?> createEnum(String qualifiedName);

	/**
	 *
	 * @see EnumFactory#create(CtPackage, String)
	 */
	CtEnum<?> createEnum(CtPackage owner, String simpleName);

	/**
	 *
	 * @see FieldFactory#create(CtType, Set, CtTypeReference, String)
	 */
	CtField createField(CtType<?> target, Set<ModifierKind> modifiers, CtTypeReference type, String name);

	/**
	 *
	 * @see FieldFactory#create(CtType, Set, CtTypeReference, String, CtExpression)
	 */
	CtField createField(CtType<?> target, Set<ModifierKind> modifiers, CtTypeReference type, String name, CtExpression defaultExpression);

	/**
	 *
	 * @see FieldFactory#create(CtType, CtField)
	 */
	CtField createField(CtType<?> target, CtField source);

	/**
	 *
	 * @see InterfaceFactory#create(CtPackage, String)
	 */
	CtInterface createInterface(CtPackage owner, String simpleName);

	/**
	 *
	 * @see InterfaceFactory#create(CtType, String)
	 */
	CtInterface createInterface(CtType owner, String simpleName);

	/**
	 *
	 * @see InterfaceFactory#create(String)
	 */
	CtInterface createInterface(String qualifiedName);

	/**
	 *
	 * @see MethodFactory#create(CtClass, Set, CtTypeReference, String, List, Set, CtBlock)
	 */
	CtMethod createMethod(CtClass<?> target, Set<ModifierKind> modifiers, CtTypeReference returnType, String name, List<CtParameter<?>> parameters, Set<CtTypeReference<? extends Throwable>> thrownTypes, CtBlock body);

	/**
	 *
	 * @see MethodFactory#create(CtType, CtMethod, boolean)
	 */
	CtMethod createMethod(CtType<?> target, CtMethod source, boolean redirectReferences);

	/**
	 *
	 * @see MethodFactory#create(CtType, Set, CtTypeReference, String, List, Set)
	 */
	CtMethod createMethod(CtType<?> target, Set<ModifierKind> modifiers, CtTypeReference returnType, String name, List<CtParameter<?>> parameters, Set<CtTypeReference<? extends Throwable>> thrownTypes);

	/**
	 *
	 * @see PackageFactory#create(CtPackage, String)
	 */
	CtPackage createPackage(CtPackage parent, String simpleName);

	/**
	 * @see CoreFactory#create(Class)
	 */
	CtElement createElement(Class<? extends CtElement> klass);

	/**
	 * @see TypeFactory#createImport(CtReference)
	 */
	CtImport createImport(CtReference reference);

	/**
	 * @see TypeFactory#createUnresolvedImport(String,boolean)
	 */
	CtImport createUnresolvedImport(String reference, boolean isStatic);

	/**
	 * @see TypeFactory#createTypeMemberWildcardImportReference(CtTypeReference)
	 */
	CtTypeMemberWildcardImportReference createTypeMemberWildcardImportReference(CtTypeReference<?> typeReference);

	/**
	 * @see ModuleFactory#createPackageExport(CtPackageReference)
	 */
	CtPackageExport createPackageExport(CtPackageReference ctPackageReference);

	/**
	 * @see ModuleFactory#createProvidedService(CtTypeReference)
	 */
	CtProvidedService createProvidedService(CtTypeReference ctTypeReference);

	/**
	 * @see ModuleFactory#createModuleRequirement(CtModuleReference)
	 */
	CtModuleRequirement createModuleRequirement(CtModuleReference ctModuleReference);

	/**
	 * @see ModuleFactory#getOrCreate(String)
	 */
	CtModule createModule(String moduleName);

	/**
	 * @see ModuleFactory#createReference(CtModule)
	 */
	CtModuleReference createModuleReference(CtModule ctModule);

	/**
	 * @see ModuleFactory#createUsedService(CtTypeReference)
	 */
	CtUsedService createUsedService(CtTypeReference typeReference);

	/**
	 * @see CoreFactory#createPartialSourcePosition(CompilationUnit)
	 */
	SourcePosition createPartialSourcePosition(CompilationUnit compilationUnit);

	/**
	 * @see PackageFactory#createPackageDeclaration(CtPackageReference)
	 */
	CtPackageDeclaration createPackageDeclaration(CtPackageReference packageRef);

	/**
	 * @see TypeFactory#createReference(String)
	 */
	<T> CtTypeReference<T> createReference(String qualifiedName);

	/**
	 * @see TypeFactory#createSimplyQualifiedReference(String)
	 */
	<T> CtTypeReference<T> createSimplyQualifiedReference(String qualifiedName);

	/**
	 *  @see CoreFactory#createYieldStatement()
	 */
	CtYieldStatement createYieldStatement(boolean isImplicit);

}
