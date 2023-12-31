/**
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.reflect.factory;

import spoon9.reflect.code.*;
import spoon9.reflect.cu.CompilationUnit;
import spoon9.reflect.cu.SourcePosition;
import spoon9.reflect.cu.position.BodyHolderSourcePosition;
import spoon9.reflect.cu.position.CompoundSourcePosition;
import spoon9.reflect.cu.position.DeclarationSourcePosition;
import spoon9.reflect.declaration.*;
import spoon9.reflect.reference.*;

import java.lang.annotation.Annotation;

/**
 * This interface defines the core creation methods for the meta-model (to be
 * implemented so that Spoon can manipulate other meta-model implementations).
 * <p>
 * <b>Important</b>: a required post-condition for all the created elements is
 * that the factory (see {@link spoon9.processing.FactoryAccessor#getFactory()})
 * is correctly initialized with the main factory returned by
 * {@link #getMainFactory()}, which cannot be null.
 */
public interface CoreFactory {

	/**
	 * Recursively clones a given element of the metamodel and all its child
	 * elements.
	 *
	 * @param <T>     the element's type
	 * @param element the element
	 * @return a clone of <code>element</code>
	 * @see CtElement#clone()
	 */
	<T extends CtElement> T clone(T element);

	/**
	 * Creates an annotation.
	 */
	<A extends Annotation> CtAnnotation<A> createAnnotation();

	/**
	 * Creates an annotation type.
	 */
	<T extends Annotation> CtAnnotationType<T> createAnnotationType();

	/**
	 * Creates an anonymous executable.
	 */
	CtAnonymousExecutable createAnonymousExecutable();

	/**
	 * Creates an array read access expression.
	 */
	<T> CtArrayRead<T> createArrayRead();

	/**
	 * Creates an array write access expression.
	 */
	<T> CtArrayWrite<T> createArrayWrite();

	/**
	 * Creates an array type reference.
	 */
	<T> CtArrayTypeReference<T> createArrayTypeReference();

	/**
	 * Creates an <code>assert</code> statement.
	 */
	<T> CtAssert<T> createAssert();

	/**
	 * Creates an assignment expression.
	 */
	<T, A extends T> CtAssignment<T, A> createAssignment();

	/**
	 * Creates a binary operator.
	 */
	<T> CtBinaryOperator<T> createBinaryOperator();

	/**
	 * Creates a block.
	 */
	<R> CtBlock<R> createBlock();

	/**
	 * Creates a <code>break</code> statement.
	 */
	CtBreak createBreak();

	/**
	 * Creates a <code>case</code> clause.
	 */
	<S> CtCase<S> createCase();

	/**
	 * Creates a <code>catch</code> clause.
	 */
	CtCatch createCatch();

	/**
	 * Creates a class.
	 */
	<T> CtClass<T> createClass();

	/**
	 * Creates a type parameter declaration.
	 */
	CtTypeParameter createTypeParameter();

	/**
	 * Creates a conditional expression (<code>boolExpr?ifTrue:ifFalse</code>).
	 */
	<T> CtConditional<T> createConditional();

	/**
	 * Creates a constructor.
	 */
	<T> CtConstructor<T> createConstructor();

	/**
	 * Creates an invisible array constructor.
	 */
	<T> CtConstructor<T> createInvisibleArrayConstructor();

	/**
	 * Creates a <code>continue</code> statement.
	 */
	CtContinue createContinue();

	/**
	 * Creates a <code>do</code> loop.
	 */
	CtDo createDo();

	/**
	 * Creates an enum.
	 */
	<T extends Enum<?>> CtEnum<T> createEnum();

	/**
	 * Creates an executable reference.
	 */
	<T> CtExecutableReference<T> createExecutableReference();

	/**
	 * Creates a field.
	 */
	<T> CtField<T> createField();

	/**
	 * Creates an enum value.
	 */
	<T> CtEnumValue<T> createEnumValue();

	/**
	 * Creates a field read access.
	 */
	<T> CtFieldRead<T> createFieldRead();

	/**
	 * Creates a field write access.
	 */
	<T> CtFieldWrite<T> createFieldWrite();

	/**
	 * Creates an access expression to this.
	 */
	<T> CtThisAccess<T> createThisAccess();

	/**
	 * Creates an access expression to super.
	 */
	<T> CtSuperAccess<T> createSuperAccess();

	/**
	 * Creates a field reference.
	 */
	<T> CtFieldReference<T> createFieldReference();

	/**
	 * Creates a <code>for</code> loop.
	 */
	CtFor createFor();

	/**
	 * Creates a <code>foreach</code> loop.
	 */
	CtForEach createForEach();

	/**
	 * Creates an <code>if</code> statement.
	 */
	CtIf createIf();

	/**
	 * Creates an interface.
	 */
	<T> CtInterface<T> createInterface();

	/**
	 * Creates an invocation expression.
	 */
	<T> CtInvocation<T> createInvocation();

	/**
	 * Creates a literal expression.
	 */
	<T> CtLiteral<T> createLiteral();

	/**
	 * Creates a local variable declaration statement.
	 */
	<T> CtLocalVariable<T> createLocalVariable();

	/**
	 * Creates a local variable reference.
	 */
	<T> CtLocalVariableReference<T> createLocalVariableReference();

	/**
	 * Creates a catch variable declaration statement.
	 */
	<T> CtCatchVariable<T> createCatchVariable();

	/**
	 * Creates a catch variable reference.
	 */
	<T> CtCatchVariableReference<T> createCatchVariableReference();

	/**
	 * Creates a method.
	 */
	<T> CtMethod<T> createMethod();

	/**
	 * Creates an annotation method.
	 */
	<T> CtAnnotationMethod<T> createAnnotationMethod();

	/**
	 * Creates a new array expression.
	 */
	<T> CtNewArray<T> createNewArray();

	/**
	 * Creates a constructor call expression.
	 *
	 * Example to build "new Foo()":
	 * <pre>
	 *     CtConstructorCall call = spoon.getFactory().Core().createConstructorCall();
	 *     call.setType(spoon.getFactory().Core().createTypeReference().setSimpleName("Foo"));
	 * </pre>
	 */
	<T> CtConstructorCall<T> createConstructorCall();

	/**
	 * Creates a new anonymous class expression.
	 */
	<T> CtNewClass<T> createNewClass();

	/**
	 * Creates a new anonymous method expression.
	 */
	<T> CtLambda<T> createLambda();

	/**
	 * Creates a new executable reference expression.
	 */
	<T, E extends CtExpression<?>> CtExecutableReferenceExpression<T, E> createExecutableReferenceExpression();

	/**
	 * Creates a new operator assignment (like +=).
	 */
	<T, A extends T> CtOperatorAssignment<T, A> createOperatorAssignment();

	/**
	 * Creates a package.
	 */
	CtPackage createPackage();

	/**
	 * Creates a package reference.
	 */
	CtPackageReference createPackageReference();

	/**
	 * Creates a parameter.
	 */
	<T> CtParameter<T> createParameter();

	/**
	 * Creates a parameter reference.
	 */
	<T> CtParameterReference<T> createParameterReference();

	/**
	 * Creates a <code>return</code> statement.
	 */
	<R> CtReturn<R> createReturn();

	/**
	 * Creates a source position.
	 */
	SourcePosition createSourcePosition(
			CompilationUnit compilationUnit,
			int startSource, int end, int[] lineSeparatorPositions);

	/** Creates a source position that points to the given compilation unit */
	SourcePosition createPartialSourcePosition(CompilationUnit compilationUnit);

	/**
	 * Creates a compound source position.
	 */
	CompoundSourcePosition createCompoundSourcePosition(
			CompilationUnit compilationUnit,
			int startSource, int end,
			int declarationStart, int declarationEnd,
			int[] lineSeparatorPositions);

	/**
	 * Creates a declaration source position.
	 */
	DeclarationSourcePosition createDeclarationSourcePosition(
			CompilationUnit compilationUnit,
			int startSource, int end,
			int modifierStart, int modifierEnd,
			int declarationStart, int declarationEnd,
			int[] lineSeparatorPositions);

	/**
	 * Creates a body holder source position.
	 */
	BodyHolderSourcePosition createBodyHolderSourcePosition(
			CompilationUnit compilationUnit,
			int nameSource, int nameEnd,
			int modifierStart, int modifierEnd,
			int declarationStart, int declarationEnd,
			int bodyStart, int bodyEnd, int[] lineSeparatorPositions);

	/**
	 * Creates a statement list.
	 */
	<R> CtStatementList createStatementList();

	/**
	 * Creates a <code>switch</code> statement.
	 */
	<S> CtSwitch<S> createSwitch();

	/**
	 * Creates a <code>switch</code> expression.
	 */
	<T, S> CtSwitchExpression<T, S> createSwitchExpression();

	/**
	 * Creates a <code>synchronized</code> statement.
	 */
	CtSynchronized createSynchronized();

	/**
	 * Creates a <code>throw</code> statement.
	 */
	CtThrow createThrow();

	/**
	 * Creates a <code>try</code> block.
	 */
	CtTry createTry();

	/**
	 * Creates a <code>try</code> with resource block.
	 */
	CtTryWithResource createTryWithResource();

	/**
	 * Creates a type parameter reference.
	 */
	CtTypeParameterReference createTypeParameterReference();

	/**
	 * Creates a wildcard reference.
	 */
	CtWildcardReference createWildcardReference();

	/**
	 * Creates an intersection type reference.
	 */
	<T> CtIntersectionTypeReference<T> createIntersectionTypeReference();

	/**
	 * Creates a type reference.
	 */
	<T> CtTypeReference<T> createTypeReference();

	/**
	 * Creates a type access expression.
	 */
	<T> CtTypeAccess<T> createTypeAccess();

	/**
	 * Creates a unary operator expression.
	 */
	<T> CtUnaryOperator<T> createUnaryOperator();

	/**
	 * Creates a variable read expression.
	 */
	<T> CtVariableRead<T> createVariableRead();

	/**
	 * Creates a variable write expression.
	 */
	<T> CtVariableWrite<T> createVariableWrite();

	/**
	 * Creates a <code>while</code> loop.
	 */
	CtWhile createWhile();

	/**
	 * Creates a code snippet expression.
	 */
	<T> CtCodeSnippetExpression<T> createCodeSnippetExpression();

	/**
	 * Creates a code snippet statement.
	 */
	CtCodeSnippetStatement createCodeSnippetStatement();

	/**
	 * Creates a comment.
	 */
	CtComment createComment();

	/**
	 * Creates a javadoc comment.
	 */
	CtJavaDoc createJavaDoc();

	/**
	 * Creates a javadoc tag.
	 */
	CtJavaDocTag createJavaDocTag();

	/**
	 * Creates an import.
	 */
	CtImport createImport();

	/**
	 * Creates an unresolved import.
	 * CtUnresolvedImport stores the original content of the imort as a String in order to be able
	 * to restituate it when pretty printing.
	 */
	CtImport createUnresolvedImport();

	/**
	 * Creates a package declaration.
	 */
	CtPackageDeclaration createPackageDeclaration();

	/**
	 * Gets the main factory of that core factory (cannot be <code>null</code>).
	 */
	Factory getMainFactory();

	/**
	 * Sets the main factory of that core factory.
	 */
	void setMainFactory(Factory mainFactory);

	/**
	 * Creates a compilation unit.
	 */
	CompilationUnit createCompilationUnit();

	/**
	 * Create an access to annotation value
	 *
	 * @return
	 */
	<T> CtAnnotationFieldAccess<T> createAnnotationFieldAccess();

	/**
	 * Creates an unbound variable used in noclasspath.
	 */
	<T> CtUnboundVariableReference<T> createUnboundVariableReference();

	/**
	 * Creates an instance of the concrete metamodel class given as parameter.
	 *
	 * This is in particular useful when one uses reflection.
	 */
	CtElement create(Class<? extends CtElement> klass);

	/**
	 * Create a wildcard reference to a type member, used in a static import
	 */
	CtTypeMemberWildcardImportReference createTypeMemberWildcardImportReference();

	/** Creates a Java 9 module */
	CtModule createModule();

	/** Creates a reference to a Java 9 module */
	CtModuleReference createModuleReference();

	/** Creates a "requires" directive for a Java 9 module file */
	CtModuleRequirement createModuleRequirement();

	/** Creates a "export" directive for a Java 9 module file */
	CtPackageExport createPackageExport();

	/** Creates a "provides" directive for a Java 9 module file */
	CtProvidedService createProvidedService();

	/** Creates a "uses" directive for a Java 9 module file */
	CtUsedService createUsedService();


	/**
	 * Creates a <code>yield</code> statement
	 * @return yieldStatement
	 */
	CtYieldStatement createYieldStatement();

	/**
	 * Creates a TextBlock String Literal
	 */
	CtTextBlock createTextBlock();
}
