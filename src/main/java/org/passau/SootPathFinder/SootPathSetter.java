package org.passau.SootPathFinder;

import java.io.File;

public class SootPathSetter {

    public static String INPUT_LOCATION_PATH;
    public static String INPUT_LOCATION_ENV = "iPatchValidator";

    public static String PATH_TO_TEMPORARY_PACKAGE = "/TemporaryClasses/SourceCode/"; // The path that we will get from the INPUT_LOCATION_ENV


    public SootPathSetter() {
        setThePath();
    }

    private static void setThePath() {
        // Retrieve the input location path from the environment variable
        //inputLocationPath = "C:/Users/Admin/Desktop/iPatchValidator/target";

        INPUT_LOCATION_PATH = System.getenv(INPUT_LOCATION_ENV);
        validatePath(INPUT_LOCATION_PATH);
    }

    private static void validatePath(String path) {
        File file = new File(path);
        if (path == null) {
            throw new IllegalStateException("Environment variable " + INPUT_LOCATION_ENV + " is not set.");
        }
        if (!file.exists()) {
            throw new IllegalStateException("iPatchValidator is set to a wrong path Shifat :D");
        }
    }

}
