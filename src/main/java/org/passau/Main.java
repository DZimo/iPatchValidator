package org.passau;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

import org.passau.Jacoco.XMLParsing;
import org.passau.Parser.ClassModel;
import org.passau.Parser.ClassParser;
import org.passau.Parser.FilePathFinder;
import org.passau.Parser.MethodModel;
import org.passau.SootPathFinder.SootPathSetter;
import org.passau.StaticAnalyzer.ControlFlowGraph;
import org.passau.Writer.IPatchWriter;
import sootup.core.Project;
import sootup.core.graph.*;
import sootup.core.inputlocation.AnalysisInputLocation;
import sootup.core.jimple.common.stmt.Stmt;
import sootup.core.model.SootClass;
import sootup.core.model.SootMethod;
import sootup.core.signatures.MethodSignature;
import sootup.core.types.ClassType;
import sootup.core.views.View;
import sootup.java.bytecode.inputlocation.JavaClassPathAnalysisInputLocation;
import sootup.java.core.JavaProject;
import sootup.java.core.JavaSootClass;
import sootup.java.core.JavaSootClassSource;
import sootup.java.core.language.JavaLanguage;

import static org.passau.Jacoco.HelperMethods.generateAndSaveCoverageReports;

public class Main implements Runnable {
    static String targetDirectory ="targetForDyanmic";

    private static final String INPUT_LOCATION_ENV = "iPatchValidator"; // Please add your target/classes to path with the name of this variable ( // compiled ones )

    private static String INPUT_LOCATION_PATH; // The path that we will get from the INPUT_LOCATION_ENV

    public String logName; // The name of the log file

    //private static final String pathToClasses = "/src/main/java/org/";

    private String pathToClasses;

    private String classToBuildName; // Class that we want to build CFG for

    private String methodToBuildName; // Name of method we want to build

    private List<String> paramToBuildType; // Types of all parameters we want to build

    private String typeToBuildName; // Type of method we want to build

    private ControlFlowGraph controlFlowGraph; // Class that build CFG

    private StmtGraph statementGraph; // Statement graph that contains predecessors and successors

    private List<Stmt> allStatements; // All retrieved statements

    private SootClass<JavaSootClassSource> sootClass; // The class that we want to build CFG for


    /**
     * Main Constructor
     * @param className the class we want to build CFG for
     * @param methodName the method we want to build CFG for
     * @param typeName the type of method we want to build CFG for
     * @param typeParameters the list of type of parameters we want to build CFG for
     */

    public Main(String className, String methodName, String typeName, List<String> typeParameters) {
        constructMethodInformation(className, methodName, typeName, typeParameters);
    }

    public Main(String pathToSourceCode, String LogName) {
        this.pathToClasses = pathToSourceCode;
        this.logName = LogName;
    }


    /**
     * Constructor for main to initialize variables that we will use to build CFG of Sootup
     */
    public void constructMethodInformation(String classToBuildName, String methodToBuildName, String typeToBuildName, List<String> typeParameters){
        this.classToBuildName = classToBuildName;
        this.methodToBuildName = methodToBuildName;
        this.typeToBuildName = typeToBuildName;
        this.paramToBuildType = typeParameters;
    }

    /**
     * Build Graph for SOOTUP
     */

    private boolean buildGraph() {
       // INPUT_LOCATION_PATH ="/Users/shifatsahariar/Downloads/java/iPatchValidator/target/classes/spoon/compiler/builder/AnnotationProcessingOptions.class";
        if(typeToBuildName.equals("T"))
        {
            // WE HAVE TO DO SOMETHING TO CHANGE THE NAME OF THE TYPE AS IT IS GENERIC
            //typeToBuildName = "classB";
        }
        AnalysisInputLocation<JavaSootClass> inputLocation = new JavaClassPathAnalysisInputLocation(INPUT_LOCATION_PATH);  // Input for binary code
        JavaLanguage language = new JavaLanguage(17);
        Project project =
                JavaProject.builder(language)
                        .addInputLocation(inputLocation).build();

        ClassType classType = project.getIdentifierFactory().getClassType(classToBuildName);  // Set the class we want to work on
        //paramToBuildType.stream().toList()
        MethodSignature methodSignature =
                project.getIdentifierFactory().
                        getMethodSignature(methodToBuildName, classToBuildName, typeToBuildName, paramToBuildType);  // Define the method we want to work on

        View view = project.createView(); // Create a view for the created project
        Optional<JavaSootClass> optClass = view.getClass(classType);


        if (optClass.isPresent()) {
            sootClass = optClass.get();

            /**
             * OUR CURRENT ISSUE STARTS HERE
             */
            Optional<SootMethod> opt = (Optional<SootMethod>) sootClass.getMethods().stream()
                    .filter(a -> {
                        boolean nameMatches = a.getSignature().getSubSignature().getName().equals(methodToBuildName);
                        List<String> sootParamTypes = a.getSignature().getSubSignature().getParameterTypes().stream()
                                .map(Object::toString)
                                .collect(Collectors.toList());
                        boolean paramTypesMatch = sootParamTypes.equals(paramToBuildType);
                        paramTypesMatch = true;
                        return nameMatches && paramTypesMatch;
                    })
                    .findFirst();
            /*Optional<SootMethod> opt = (Optional<SootMethod>) sootClass.getMethods().stream()
                    .filter(a -> a.getSignature().getSubSignature().getName().toString().equals(methodToBuildName) && a.getSignature().getSubSignature().getParameterTypes().equals(paramToBuildType))
                    .findFirst();*/



            if(opt.isPresent()){
                SootMethod method = opt.get();
                if(method.isConcrete())
                {
                    allStatements = method.getBody().getStmts();
                    statementGraph = method.getBody().getStmtGraph();
                    controlFlowGraph = new ControlFlowGraph(controlFlowGraph, statementGraph, allStatements, sootClass);// Class that build CFG
                }
                else {
                    // IF METHOD IS NOT CONCRETE THEN WE SKIP IT
                    return false;
                }
            }
            Optional<? extends SootMethod> optMethod = sootClass.getMethod(methodSignature.getSubSignature());
            // HERE WE ALREADY GETTING NO METHOD
            if (optMethod.isPresent() && ( allStatements == null || statementGraph == null || controlFlowGraph == null) ) { // We try to get them again if null
                SootMethod method = optMethod.get();
                if(method.isConcrete())
                {
                    allStatements = method.getBody().getStmts();
                    statementGraph = method.getBody().getStmtGraph();
                    controlFlowGraph = new ControlFlowGraph(controlFlowGraph, statementGraph, allStatements, sootClass);// Class that build CFG
                }
                else {
                    // IF METHOD IS NOT CONCRETE THEN WE SKIP IT
                    return false;
                }
            }
        }
        else {
           // System.err.println("Class not found: " + classType.getClassName());
            return false; // Class not found
        }
        return true;
    }

    public void run () {
        try{
            MutableStmtGraph graph = new MutableBlockStmtGraph();
            IPatchWriter iPatchWriter = new IPatchWriter(logName);
            String lastClassName = null;
            ClassParser classParser = new ClassParser();
            FilePathFinder filePathFinder = new FilePathFinder();
            List<String> classPaths = filePathFinder.findJavaFilePaths(INPUT_LOCATION_PATH + pathToClasses);
            for (String filePath : classPaths) {
                List<MethodModel> methods = classParser.extractMethods(filePath);
                classToBuildName = ClassParser.extractPackageName(filePath) + "." + ClassParser.extractClassNameFromPath(filePath); // We concatenate package name with class name
                if (ClassParser.extractPackageName(filePath) != lastClassName && controlFlowGraph!=null)
                {
                    lastClassName = ClassParser.extractPackageName(filePath); // We only print the package when it changes
                    controlFlowGraph.printPackagName(lastClassName, iPatchWriter);
                }
                ClassModel classModel = new ClassModel(methods, classToBuildName);
                for (MethodModel method : methods) {
                    methodToBuildName = method.getMethodName() ;
                    typeToBuildName = method.getMethodReturnType();
                    paramToBuildType = method.getListOfParamType();
                    constructMethodInformation("target.classes." + classToBuildName , methodToBuildName, typeToBuildName, paramToBuildType);  // This will initialize the variables
                    if(!buildGraph())
                    {
                        continue; // Skip to next method if there is no graph
                    }
                    if (statementGraph != null) {
                        graph.setStartingStmt(statementGraph.getStartingStmt());
                        Iterator<Stmt> iterator = statementGraph.iterator();
                        System.out.println("CFG for SOURCE CODE : " + sootClass.getName());
                        controlFlowGraph.printMethodName(methodToBuildName, iPatchWriter); // Print the Method name
                        controlFlowGraph.printTheControlFlowGraph(iPatchWriter); // Print the CFG
                    }
//                else {
//                    System.err.println("Error: statementGraph is null for " + methodToBuildName + " in class " + classToBuildName);
//                }

                }
            }
            System.out.println("WORK DONE!");
            iPatchWriter.closeFiles();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main (String[] args) { try {
        // SET THE PATH
        SootPathSetter sootPathSetter = new SootPathSetter();  // We first set the path and then validate it
        INPUT_LOCATION_PATH = SootPathSetter.INPUT_LOCATION_PATH;
         /*
        // STATIC CFG
        System.out.println("RUNNING STATIC ANALYSIS");

        Main mainInstanceOriginalPassau = new Main("/src/main/java/org/passau/CodeExamples/OriginalCode","OriginallCodeLogPassau"); // Instance for the original code
        Thread t1 = new Thread(mainInstanceOriginalPassau, "originalCodePassau");

        Main mainInstancePatchedPassau = new Main("/src/main/java/org/passau/CodeExamples/PatchedCode","PatchedlCodeLogPassau"); // Instance for the original code
        Thread t2 = new Thread(mainInstancePatchedPassau, "patchedCodePassau");

        Main mainInstanceOriginaldSpoon = new Main("/src/main/java/spoon","OriginalLogSpoon"); // Instance for the patched code
        Thread t3 = new Thread(mainInstanceOriginaldSpoon, "originalCodeSpoon");

        Main mainInstancePatchedSpoon = new Main("/src/main/java/spoon9","PatchedCodeLogSpoon"); // Instance for the patched code
        Thread t4 = new Thread(mainInstancePatchedSpoon, "patchedCodeSpoon");

        t1.start(); // Start Original code passau thread
        t2.start(); // Start Patched code passau thread

        t3.start(); // Start Original code spoon thread
        t4.start(); // Start Patched code spoon thread

        t1.join();
        t2.join();

        t3.join();
        t4.join();
        */


        // DYNAMIC CFG
        // run a test case and get jimpl Code or Bytecode
        System.out.println("RUNNING DYNAMIC ANALYSIS");
        /**
         * :: >> LETS THINK WE WILL LOOP FOR EACH CLASS AND REMOVE THE TEMP FILES AFTER THE OPERATION HAS BEEN DONE
         * we will work on this later , now only for original code we are processing
         * we have to do this same process through loop for patched code
         * LOOP : original and patched code
         */
        // >>>>>>>>>>>>>>> STEP 1 <<<<<<<<<<<<<<<
        // GENERATE REPORT AS XML
        XMLParsing xmlParsingInstance = new XMLParsing();
        xmlParsingInstance.main(null);
        generateAndSaveCoverageReports(INPUT_LOCATION_PATH);
        Main mainInstanceTestcasePassPassau = new Main("/TemporaryClasses/SourceCode","TestCasePass"); // Instance for the original code
        Thread t1 = new Thread(mainInstanceTestcasePassPassau, "mainInstanceTestcasePassPassau");
        t1.start(); t1.join();

        //>>>>>>>>>>>>>> STEP 2 <<<<<<<<<<<<<< byte buddy code ..
        // GENERATE BYTECODE
        // ITERATE OVER THE FOLDER AND GET THE CLASS BYTECODE FOR EACH REPORT
        //List<byte[]> tempClassBytesList = generateByteArrayListFromReports(INPUT_LOCATION_PATH+"/Coverage_Reports", classA.class);
       // storeByteArrayListAsClasses(tempClassBytesList, INPUT_LOCATION_PATH + "/TemporaryClasses");
        // >>>>>>>>>>>> STEP 3 <<<<<<<<<
        /**
         * WE HAVE TO FIND THE CLASS DYNAMICALLY
         * POSSIBILITY 1 : PARSE XML > EASY TO FIND THE CLASS NAME
         */
        /*
         * 1. XML file location to read and parse >> first one is enough to read
         * 2. Base Directory from where the source file will retrieve
         * 3. FOLDER name where we want to copy the file temporarily
         * N>B : each iteration we will remove all files from this folder after getting CFG
         */
      //  copyClassFromXMLReportInDirectory(INPUT_LOCATION_PATH+"/Coverage_Reports",
       //         INPUT_LOCATION_PATH+"/src/main/java", targetDirectory);
        // >>>>>>>>>>>> STEP 4 + 5 <<<<<<<<<
        // Copy each classfile[Bytecode] to that temporary folder
        // loop start here for each class file from the TEMPORARY-CLASS FOLDER
        // CFG

        // Call the CFG builder on that JimplCode for each class file and generate separate log file for each
      //  processFilesInFolder(INPUT_LOCATION_PATH+"/TemporaryClasses",INPUT_LOCATION_PATH+"/targetForDyanmic");
        // Compute Differences in LOG
    }
    catch (Exception e) {
        throw new RuntimeException(e);
    }
    }

    /**
     * Processes and copies `.class` files from the source folder to the target folder.
     * Before copying each `.class` file, existing `.class` files in the target folder are removed.
     * A new thread is started for each `.class` file to run the Main class.
     *
     * @param sourceFolder The path to the source folder containing `.class` files.
     * @param targetFolder The path to the target folder where `.class` files will be copied to.
     */
    public static void processFilesInFolder(String sourceFolder, String targetFolder) throws IOException {
        Path sourcePath = Paths.get(sourceFolder);
        Path targetPath = Paths.get(targetFolder);

        // Ensure LogFiles directory exists
        Path logFilesPath = Paths.get("LogFiles");
        if (!Files.exists(logFilesPath)) {
            Files.createDirectories(logFilesPath);
        }

        // Ensure target directory exists
        if (!Files.exists(targetPath)) {
            Files.createDirectories(targetPath);
        }

        // Iterate through each .class file in the source directory
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(sourcePath, "*.class")) {
            for (Path file : stream) {

                // Remove any existing .class files in the target directory before copying new one
                try (DirectoryStream<Path> targetStream = Files.newDirectoryStream(targetPath, "*.class")) {
                    for (Path existingFile : targetStream) {
                        Files.deleteIfExists(existingFile);
                    }
                }

                // Copy the file to target directory
                Path dest = targetPath.resolve(file.getFileName());
                Files.copy(file, dest, StandardCopyOption.REPLACE_EXISTING);

                // Execute your code
                String logName = dest.getFileName().toString().replace(".class", "");
                // Specify the path for the log files
                String logFilePath = logFilesPath.resolve(logName).toString();
                Main testDynamic = new Main("/targetForDyanmic", logFilePath);
                Thread t5 = new Thread(testDynamic, logName);
                t5.start();
                try {
                    t5.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
