/*
 * SPDX-License-Identifier: (MIT OR CECILL-C)
 *
 * Copyright (C) 2006-2019 INRIA and contributors
 *
 * Spoon is available either under the terms of the MIT License (see LICENSE-MIT.txt) of the Cecill-C License (see LICENSE-CECILL-C.txt). You as the user are entitled to choose the terms under which to adopt Spoon.
 */
package spoon9.metamodel;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;

import spoon9.Launcher;
import spoon9.SpoonException;
import spoon9.reflect.annotations.PropertyGetter;
import spoon9.reflect.annotations.PropertySetter;
import spoon9.reflect.declaration.CtAnnotation;
import spoon9.reflect.declaration.CtClass;
import spoon9.reflect.declaration.CtElement;
import spoon9.reflect.declaration.CtInterface;
import spoon9.reflect.declaration.CtMethod;
import spoon9.reflect.declaration.CtModuleDirective;
import spoon9.reflect.declaration.CtPackageExport;
import spoon9.reflect.declaration.CtProvidedService;
import spoon9.reflect.declaration.CtType;
import spoon9.reflect.factory.Factory;
import spoon9.reflect.factory.FactoryImpl;
import spoon9.reflect.path.CtRole;
import spoon9.reflect.reference.CtTypeReference;
import spoon9.reflect.visitor.filter.AllTypeMembersFunction;
import spoon9.reflect.visitor.filter.TypeFilter;
import spoon9.support.DefaultCoreFactory;
import spoon9.support.StandardEnvironment;
import spoon9.support.compiler.FileSystemFolder;
import spoon9.support.visitor.ClassTypingContext;
import spoon9.reflect.code.*;
import spoon9.reflect.declaration.*;
import spoon9.reflect.reference.*;

/**
 * Represents the Spoon metamodel (incl. at runtime)
 */
public class Metamodel {
	/**
	 * Returns all interfaces of the Spoon metamodel.
	 * This method is stateless for sake of maintenance.
	 * If you need to call it several times, you should store the result.
	 */
	public static Set<CtType<?>> getAllMetamodelInterfaces() {
		Set<CtType<?>> result = new HashSet<>();
		Factory factory = new FactoryImpl(new DefaultCoreFactory(), new StandardEnvironment());
		//avoid debug messages: Some annotations might be unreachable from the shadow element:
		//which causes bad meta model creation performance
		factory.getEnvironment().setLevel("INFO");
		result.add(factory.Type().get(BinaryOperatorKind.class));
		result.add(factory.Type().get(CtAbstractInvocation.class));
		result.add(factory.Type().get(CtAbstractSwitch.class));
		result.add(factory.Type().get(CtAnnotationFieldAccess.class));
		result.add(factory.Type().get(CtArrayAccess.class));
		result.add(factory.Type().get(CtArrayRead.class));
		result.add(factory.Type().get(CtArrayWrite.class));
		result.add(factory.Type().get(CtAssert.class));
		result.add(factory.Type().get(CtAssignment.class));
		result.add(factory.Type().get(CtBinaryOperator.class));
		result.add(factory.Type().get(CtBlock.class));
		result.add(factory.Type().get(CtBodyHolder.class));
		result.add(factory.Type().get(CtBreak.class));
		result.add(factory.Type().get(CtCFlowBreak.class));
		result.add(factory.Type().get(CtCase.class));
		result.add(factory.Type().get(CtCatch.class));
		result.add(factory.Type().get(CtCatchVariable.class));
		result.add(factory.Type().get(CtCodeElement.class));
		result.add(factory.Type().get(CtCodeSnippetExpression.class));
		result.add(factory.Type().get(CtCodeSnippetStatement.class));
		result.add(factory.Type().get(CtComment.class));
		result.add(factory.Type().get(CtConditional.class));
		result.add(factory.Type().get(CtConstructorCall.class));
		result.add(factory.Type().get(CtContinue.class));
		result.add(factory.Type().get(CtDo.class));
		result.add(factory.Type().get(CtExecutableReferenceExpression.class));
		result.add(factory.Type().get(CtExpression.class));
		result.add(factory.Type().get(CtFieldAccess.class));
		result.add(factory.Type().get(CtFieldRead.class));
		result.add(factory.Type().get(CtFieldWrite.class));
		result.add(factory.Type().get(CtFor.class));
		result.add(factory.Type().get(CtForEach.class));
		result.add(factory.Type().get(CtIf.class));
		result.add(factory.Type().get(CtInvocation.class));
		result.add(factory.Type().get(CtJavaDoc.class));
		result.add(factory.Type().get(CtJavaDocTag.class));
		result.add(factory.Type().get(CtLabelledFlowBreak.class));
		result.add(factory.Type().get(CtLambda.class));
		result.add(factory.Type().get(CtLiteral.class));
		result.add(factory.Type().get(CtTextBlock.class));
		result.add(factory.Type().get(CtLocalVariable.class));
		result.add(factory.Type().get(CtLoop.class));
		result.add(factory.Type().get(CtNewArray.class));
		result.add(factory.Type().get(CtNewClass.class));
		result.add(factory.Type().get(CtOperatorAssignment.class));
		result.add(factory.Type().get(CtRHSReceiver.class));
		result.add(factory.Type().get(CtReturn.class));
		result.add(factory.Type().get(CtStatement.class));
		result.add(factory.Type().get(CtStatementList.class));
		result.add(factory.Type().get(CtSuperAccess.class));
		result.add(factory.Type().get(CtSwitch.class));
		result.add(factory.Type().get(CtSwitchExpression.class));
		result.add(factory.Type().get(CtSynchronized.class));
		result.add(factory.Type().get(CtTargetedExpression.class));
		result.add(factory.Type().get(CtThisAccess.class));
		result.add(factory.Type().get(CtThrow.class));
		result.add(factory.Type().get(CtTry.class));
		result.add(factory.Type().get(CtTryWithResource.class));
		result.add(factory.Type().get(CtTypeAccess.class));
		result.add(factory.Type().get(CtUnaryOperator.class));
		result.add(factory.Type().get(CtVariableAccess.class));
		result.add(factory.Type().get(CtVariableRead.class));
		result.add(factory.Type().get(CtVariableWrite.class));
		result.add(factory.Type().get(CtWhile.class));
		result.add(factory.Type().get(UnaryOperatorKind.class));
		result.add(factory.Type().get(LiteralBase.class));
		result.add(factory.Type().get(CaseKind.class));
		result.add(factory.Type().get(CtYieldStatement.class));
		result.add(factory.Type().get(CtAnnotatedElementType.class));
		result.add(factory.Type().get(CtAnnotation.class));
		result.add(factory.Type().get(CtAnnotationMethod.class));
		result.add(factory.Type().get(CtAnnotationType.class));
		result.add(factory.Type().get(CtAnonymousExecutable.class));
		result.add(factory.Type().get(CtClass.class));
		result.add(factory.Type().get(CtCodeSnippet.class));
		result.add(factory.Type().get(CtCompilationUnit.class));
		result.add(factory.Type().get(CtConstructor.class));
		result.add(factory.Type().get(CtElement.class));
		result.add(factory.Type().get(CtEnum.class));
		result.add(factory.Type().get(CtEnumValue.class));
		result.add(factory.Type().get(CtExecutable.class));
		result.add(factory.Type().get(CtField.class));
		result.add(factory.Type().get(CtFormalTypeDeclarer.class));
		result.add(factory.Type().get(CtInterface.class));
		result.add(factory.Type().get(CtMethod.class));
		result.add(factory.Type().get(CtModifiable.class));
		result.add(factory.Type().get(CtMultiTypedElement.class));
		result.add(factory.Type().get(CtNamedElement.class));
		result.add(factory.Type().get(CtPackage.class));
		result.add(factory.Type().get(CtParameter.class));
		result.add(factory.Type().get(CtShadowable.class));
		result.add(factory.Type().get(CtType.class));
		result.add(factory.Type().get(CtTypeInformation.class));
		result.add(factory.Type().get(CtTypeMember.class));
		result.add(factory.Type().get(CtTypeParameter.class));
		result.add(factory.Type().get(CtTypedElement.class));
		result.add(factory.Type().get(CtVariable.class));
		result.add(factory.Type().get(ModifierKind.class));
		result.add(factory.Type().get(ParentNotInitializedException.class));
		result.add(factory.Type().get(CtActualTypeContainer.class));
		result.add(factory.Type().get(CtArrayTypeReference.class));
		result.add(factory.Type().get(CtCatchVariableReference.class));
		result.add(factory.Type().get(CtExecutableReference.class));
		result.add(factory.Type().get(CtFieldReference.class));
		result.add(factory.Type().get(CtIntersectionTypeReference.class));
		result.add(factory.Type().get(CtLocalVariableReference.class));
		result.add(factory.Type().get(CtPackageReference.class));
		result.add(factory.Type().get(CtParameterReference.class));
		result.add(factory.Type().get(CtReference.class));
		result.add(factory.Type().get(CtTypeParameterReference.class));
		result.add(factory.Type().get(CtTypeReference.class));
		result.add(factory.Type().get(CtUnboundVariableReference.class));
		result.add(factory.Type().get(CtVariableReference.class));
		result.add(factory.Type().get(CtWildcardReference.class));
		result.add(factory.Type().get(CtTypeMemberWildcardImportReference.class));
		result.add(factory.Type().get(CtImport.class));
		result.add(factory.Type().get(CtImportKind.class));
		result.add(factory.Type().get(CtModule.class));
		result.add(factory.Type().get(CtModuleRequirement.class));
		result.add(factory.Type().get(CtPackageDeclaration.class));
		result.add(factory.Type().get(CtPackageExport.class));
		result.add(factory.Type().get(CtProvidedService.class));
		result.add(factory.Type().get(CtModuleReference.class));
		result.add(factory.Type().get(CtUsedService.class));
		result.add(factory.Type().get(CtModuleDirective.class));
		return result;
	}

	private static final String CLASS_SUFFIX = "Impl";
	/**
	 * qualified names of packages which contain interfaces of spoon model
	 */
	public static final Set<String> MODEL_IFACE_PACKAGES = new HashSet<>(Arrays.asList(
			"spoon.reflect.code",
			"spoon.reflect.declaration",
			"spoon.reflect.reference"));

	/**
	 * qualified names of packages which contain classes (implementations) of spoon model
	 */
	public static final Set<String> MODEL_CLASS_PACKAGES = new HashSet<>(Arrays.asList(
			"spoon.support.reflect.code",
			"spoon.support.reflect.declaration",
			"spoon.support.reflect.reference"));

	/**
	 * {@link MetamodelConcept}s by name
	 */
	private final Map<String, MetamodelConcept> nameToConcept = new HashMap<>();

	private static Metamodel instance;

	/**
	 * @return Spoon {@link Metamodel}, which is built once and then returns cached version
	 */
	public static Metamodel getInstance() {
		if (instance == null) {
			try {
				//this is needed just for CtGenerationTest#testGenerateRoleHandler
				//which must not use RoleHandler at time when RoleHandler is generated and Spoon model doesn't fit to old RoleHandlers
				//to avoid egg/chicken problem
				if ("true".equals(System.getProperty(MetamodelProperty.class.getName() + "-noRoleHandler"))) {
					MetamodelProperty.useRuntimeMethodInvocation = true;
				}
			} catch (SecurityException e) {
				//ignore that
			}
			instance = new Metamodel();
		}
		return instance;
	}

	/**
	 *
	 * Not in the public API.
	 *
	 * Parses spoon sources and creates factory with spoon model.
	 *
	 * @param spoonJavaSourcesDirectory the root directory of java sources of spoon model.
	 * 	The directory must contain "spoon" directory.
	 */
	public Metamodel(File spoonJavaSourcesDirectory) {
		this(createFactory(spoonJavaSourcesDirectory));
	}

	/**
	 * @param factory already loaded factory with all Spoon model types
	 */
	protected Metamodel(Factory factory) {
		for (String apiPackage : MODEL_IFACE_PACKAGES) {
			if (factory.Package().get(apiPackage) == null) {
				throw new SpoonException("Spoon Factory model is missing API package " + apiPackage);
			}
			String implPackage = replaceApiToImplPackage(apiPackage);
			if (factory.Package().get(implPackage) == null) {
				throw new SpoonException("Spoon Factory model is missing implementation package " + implPackage);
			}
		}

		//search for all interfaces of spoon model and create MetamodelConcepts for them
		factory.getModel().filterChildren(new TypeFilter<>(CtInterface.class))
			.forEach((CtInterface<?> iface) -> {
				if (MODEL_IFACE_PACKAGES.contains(iface.getPackage().getQualifiedName())) {
					getOrCreateConcept(iface);
				}
			});
	}

	/**
	 * Creates a {@link Metamodel} in runtime mode when spoon sources are not available.
	 *
	 * See also {@link #getInstance()}.
	 */
	private Metamodel() {
		for (CtType<?> iface : getAllMetamodelInterfaces()) {
			if (iface instanceof CtInterface) {
				getOrCreateConcept(iface);
			}
		}
	}

	/**
	 * @param clazz a {@link Class} of Spoon model
	 * @return {@link MetamodelConcept} which describes the `clazz`
	 */
	public MetamodelConcept getConcept(Class<? extends CtElement> clazz) {
		MetamodelConcept mc = nameToConcept.get(getConceptName(clazz));
		if (mc == null) {
			throw new SpoonException("There is no Spoon metamodel concept for class " + clazz.getName());
		}
		return mc;
	}

	/**
	 * @return all {@link MetamodelConcept}s of spoon meta model
	 */
	public Collection<MetamodelConcept> getConcepts() {
		return Collections.unmodifiableCollection(nameToConcept.values());
	}

	/**
	 * @return List of Spoon model interfaces, which represents instantiable leafs of Spoon metamodel
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CtType<? extends CtElement>> getAllInstantiableMetamodelInterfaces() {
		List<CtType<? extends CtElement>> result = new ArrayList<>();
		for (MetamodelConcept mmConcept : getConcepts()) {
			if (mmConcept.getKind() == ConceptKind.LEAF) {
				result.add((CtType) mmConcept.getMetamodelInterface());
			}
		}
		return result;
	}

	/**
	 * @param type a spoon model class or interface, whose concept name has to be returned
	 * @return name of {@link MetamodelConcept}, which represents Spoon model {@link CtType}
	 */
	public static String getConceptName(CtType<?> type) {
		return getConceptName(type.getSimpleName());
	}

	public static String getConceptName(Class<? extends CtElement> conceptClass) {
		return getConceptName(conceptClass.getSimpleName());
	}

	/**
	 * @param simpleName a spoon model class or interface, whose concept name has to be returned
	 * @return name of {@link MetamodelConcept}, which represents Spoon model {@link CtType}
	 */
	private static String getConceptName(String simpleName) {
		if (simpleName.endsWith(CLASS_SUFFIX)) {
			simpleName = simpleName.substring(0, simpleName.length() - CLASS_SUFFIX.length());
		}
		return simpleName;
	}

	/**
	 * @param iface the interface of spoon model element
	 * @return {@link CtClass} of Spoon model which implements the spoon model interface. null if there is no implementation.
	 */
	public static CtClass<?> getImplementationOfInterface(CtInterface<?> iface) {
		String impl = replaceApiToImplPackage(iface.getQualifiedName()) + CLASS_SUFFIX;
		return (CtClass<?>) getType(impl, iface);
	}

	/**
	 * @param impl the implementation class of a Spoon element
	 * @return {@link CtInterface} of Spoon model which represents API of the spoon model class. null if there is no implementation.
	 */
	public static CtInterface<?> getInterfaceOfImplementation(CtClass<?> impl) {
		String iface = impl.getQualifiedName();
		if (iface.endsWith(CLASS_SUFFIX) == false || iface.startsWith("spoon.support.reflect.") == false) {
			throw new SpoonException("Unexpected spoon model implementation class: " + impl.getQualifiedName());
		}
		iface = iface.substring(0, iface.length() - CLASS_SUFFIX.length());
		iface = iface.replace("spoon.support.reflect", "spoon.reflect");
		return (CtInterface<?>) getType(iface, impl);
	}

	/**
	 * @param method to be checked method
	 * @return {@link CtRole} of spoon model method. Looking into all super class/interface implementations of this method
	 */
	public static CtRole getRoleOfMethod(CtMethod<?> method) {
		Factory f = method.getFactory();
		CtAnnotation<PropertyGetter> getter = getInheritedAnnotation(method, f.createCtTypeReference(PropertyGetter.class));
		if (getter != null) {
			return getter.getActualAnnotation().role();
		}
		CtAnnotation<PropertySetter> setter = getInheritedAnnotation(method, f.createCtTypeReference(PropertySetter.class));
		if (setter != null) {
			return setter.getActualAnnotation().role();
		}
		return null;
	}

	private static CtType<?> getType(String qualifiedName, CtElement anElement) {
		Class aClass;
		try {
			aClass = anElement.getClass().getClassLoader().loadClass(qualifiedName);
		} catch (ClassNotFoundException e) {
			//OK, that interface has no implementation class
			return null;
		}
		return anElement.getFactory().Type().get(aClass);
	}

	private static final String modelApiPackage = "spoon.reflect";
	private static final String modelApiImplPackage = "spoon.support.reflect";

	private static String replaceApiToImplPackage(String modelInterfaceQName) {
		if (modelInterfaceQName.startsWith(modelApiPackage) == false) {
			throw new SpoonException("The qualified name " + modelInterfaceQName + " doesn't belong to Spoon model API package: " + modelApiPackage);
		}
		return modelApiImplPackage + modelInterfaceQName.substring(modelApiPackage.length());
	}

	private static Factory createFactory(File spoonJavaSourcesDirectory) {
		final Launcher launcher = new Launcher();
		launcher.getEnvironment().setNoClasspath(true);
		launcher.getEnvironment().setCommentEnabled(true);
//		// Spoon model interfaces
		Arrays.asList("spoon/reflect/code",
				"spoon/reflect/declaration",
				"spoon/reflect/reference",
				"spoon/support/reflect/declaration",
				"spoon/support/reflect/code",
				"spoon/support/reflect/reference").forEach(path ->
			launcher.addInputResource(new FileSystemFolder(new File(spoonJavaSourcesDirectory, path))));
		launcher.buildModel();
		return launcher.getFactory();
	}

	/**
	 * @param type can be class or interface of Spoon model element
	 * @return existing or creates and initializes new {@link MetamodelConcept} which represents the `type`
	 */
	private MetamodelConcept getOrCreateConcept(CtType<?> type) {
		String conceptName = getConceptName(type);
		return getOrCreate(nameToConcept, conceptName,
				() -> new MetamodelConcept(conceptName),
				mmConcept -> initializeConcept(type, mmConcept));
	}

	/**
	 * is called once for each {@link MetamodelConcept}, to initialize it.
	 * @param type a class or inteface of the spoon model element
	 * @param mmConcept to be initialize {@link MetamodelConcept}
	 */
	private void initializeConcept(CtType<?> type, MetamodelConcept mmConcept) {
		//it is not initialized yet. Do it now
		if (type instanceof CtInterface<?>) {
			CtInterface<?> iface = (CtInterface<?>) type;
			mmConcept.setModelClass(getImplementationOfInterface(iface));
			mmConcept.setModelInterface(iface);
		} else if (type instanceof CtClass<?>) {
			CtClass<?> clazz = (CtClass<?>) type;
			mmConcept.setModelClass(clazz);
			mmConcept.setModelInterface(getInterfaceOfImplementation(clazz));
		} else {
			throw new SpoonException("Unexpected spoon model type: " + type.getQualifiedName());
		}

		//add fields of interface
		if (mmConcept.getMetamodelInterface() != null) {
			//add fields of interface too. They are not added by above call of addFieldsOfType, because the MetamodelConcept already exists in nameToConcept
			addFieldsOfType(mmConcept, mmConcept.getMetamodelInterface());
		}
		//initialize all fields
		mmConcept.getRoleToProperty().forEach((role, mmField) -> {
			//if there are more methods for the same field then choose the one which best matches the field type
			mmField.sortByBestMatch();
			//finally initialize value type of this field
			mmField.setValueType(mmField.detectValueType());
		});
	}

	/**
	 * adds all {@link MetamodelProperty}s of `ctType`
	 * @param mmConcept the owner of to be created fields
	 * @param ctType to be scanned {@link CtType}
	 */
	private void addFieldsOfType(MetamodelConcept mmConcept, CtType<?> ctType) {
		ctType.getTypeMembers().forEach(typeMember -> {
			if (typeMember instanceof CtMethod<?>) {
				CtMethod<?> method = (CtMethod<?>) typeMember;
				CtRole role = getRoleOfMethod(method);
				if (role != null) {
					MetamodelProperty field = mmConcept.getOrCreateMMField(role);
					field.addMethod(method);
				} else {
					mmConcept.otherMethods.add(method);
				}
			}
		});
		addFieldsOfSuperType(mmConcept, ctType.getSuperclass());
		ctType.getSuperInterfaces().forEach(superIfaceRef -> addFieldsOfSuperType(mmConcept, superIfaceRef));
	}

	private static Set<String> EXPECTED_TYPES_NOT_IN_CLASSPATH = new HashSet<>(Arrays.asList(
			"java.lang.Cloneable",
			"java.lang.Object",
			"spoon.processing.FactoryAccessor",
			"spoon.reflect.cu.SourcePositionHolder",
			"spoon.reflect.visitor.CtVisitable",
			"spoon.reflect.visitor.chain.CtQueryable",
			"spoon.template.TemplateParameter",
			"java.lang.Iterable",
			"java.io.Serializable"));


	/**
	 * add all fields of `superTypeRef` into `mmConcept`
	 * @param concept sub type
	 * @param superTypeRef super type
	 */
	private void addFieldsOfSuperType(MetamodelConcept concept, CtTypeReference<?> superTypeRef) {
		if (superTypeRef == null) {
			return;
		}
		if (EXPECTED_TYPES_NOT_IN_CLASSPATH.contains(superTypeRef.getQualifiedName())) {
			//ignore classes which are not part of spoon model
			return;
		}
		CtType<?> superType = superTypeRef.getTypeDeclaration();
		if (superType == null) {
			throw new SpoonException("Cannot create spoon meta model. The class " + superTypeRef.getQualifiedName() + " is missing class path");
		}
		//call getOrCreateConcept recursively for super concepts
		MetamodelConcept superConcept = getOrCreateConcept(superType);
		if (superConcept != concept) {
			concept.addSuperConcept(superConcept);
		}
	}

	static <K, V> V getOrCreate(Map<K, V> map, K key, Supplier<V> valueCreator) {
		return getOrCreate(map, key, valueCreator, null);
	}
	/**
	 * @param initializer is called immediately after the value is added to the map
	 */
	static <K, V> V getOrCreate(Map<K, V> map, K key, Supplier<V> valueCreator, Consumer<V> initializer) {
		V value = map.get(key);
		if (value == null) {
			value = valueCreator.get();
			map.put(key, value);
			if (initializer != null) {
				initializer.accept(value);
			}
		}
		return value;
	}
	static <T> boolean addUniqueObject(Collection<T> col, T o) {
		if (containsObject(col, o)) {
			return false;
		}
		col.add(o);
		return true;
	}
	static boolean containsObject(Iterable<?> iter, Object o) {
		for (Object object : iter) {
			if (object == o) {
				return true;
			}
		}
		return false;
	}


	/**
	 * @param method a start method
	 * @param annotationType a searched annotation type
	 * @return annotation from the first method in superClass and superInterface hierarchy for the method with required annotationType
	 */
	private static <A extends Annotation> CtAnnotation<A> getInheritedAnnotation(CtMethod<?> method, CtTypeReference<A> annotationType) {
		CtAnnotation<A> annotation = method.getAnnotation(annotationType);
		if (annotation == null) {
			CtType<?> declType = method.getDeclaringType();
			final ClassTypingContext ctc = new ClassTypingContext(declType);
			annotation = declType.map(new AllTypeMembersFunction(CtMethod.class)).map((CtMethod<?> currentMethod) -> {
				if (method == currentMethod) {
					return null;
				}
				if (ctc.isSameSignature(method, currentMethod)) {
					CtAnnotation<A> annotation2 = currentMethod.getAnnotation(annotationType);
					if (annotation2 != null) {
						return annotation2;
					}
				}
				return null;
			}).first();
		}
		return annotation;
	}
}
