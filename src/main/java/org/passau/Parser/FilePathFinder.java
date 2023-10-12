package org.passau.Parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FilePathFinder {
    /**
     * Finds and returns the paths of all Java files in the specified folder and its subfolders.
     *
     * @param folderPath The path of the folder to search for Java files.
     * @return A List of Strings representing the paths of found Java files.
     * @throws IOException If an I/O error occurs when accessing the file system.
     */
    public List<String> findJavaFilePaths(String folderPath) throws IOException {
        List<String> classPaths = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(Paths.get(folderPath))) {
            paths.filter(path -> path.toString().endsWith(".java"))
                    .forEach(path -> classPaths.add(path.toString()));
        }
        return classPaths;
    }
}
