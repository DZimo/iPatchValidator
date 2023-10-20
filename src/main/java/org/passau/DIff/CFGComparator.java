package org.passau.DIff;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static org.passau.SootPathFinder.SootPathSetter.INPUT_LOCATION_PATH;

public class CFGComparator {
    public static Map<String, List<String>> parseCFG(List<String> lines) {
        Map<String, List<String>> cfg = new HashMap<>();
        for (String line : lines) {
            String[] parts = line.split(": Successors : ");
            String node = parts[0].trim();
            String[] successors = parts[1].replaceAll("[\\[\\]]", "").split(", ");
            cfg.put(node, Arrays.asList(successors));
        }
        return cfg;
    }

    public static void compareCFGs(Map<String, List<String>> cfg1, Map<String, List<String>> cfg2,
                                   Map<String, List<String>> differingNodes,
                                   Map<String, Pair<List<String>, List<String>>> differingEdges) {

        for (String node : cfg1.keySet()) {
            if (!cfg2.containsKey(node)) {
                differingNodes.put(node, cfg1.get(node));
            } else if (!cfg1.get(node).equals(cfg2.get(node))) {
                differingEdges.put(node, new Pair<>(cfg1.get(node), cfg2.get(node)));
            }
        }

        for (String node : cfg2.keySet()) {
            if (!cfg1.containsKey(node)) {
                differingNodes.put(node, cfg2.get(node));
            }
        }
    }

    public static void writeDifferencesToFile(Map<String, List<String>> differingNodes,
                                              Map<String, Pair<List<String>, List<String>>> differingEdges,
                                              String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

        writer.write("Differing Nodes:\n");
        for (Map.Entry<String, List<String>> entry : differingNodes.entrySet()) {
            writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
        }

        writer.write("\nDiffering Edges:\n");
        for (Map.Entry<String, Pair<List<String>, List<String>>> entry : differingEdges.entrySet()) {
            writer.write(entry.getKey() + ": " + entry.getValue().getFirst() + " vs. " + entry.getValue().getSecond() + "\n");
        }

        writer.close();
    }
    public static List<String> extractGraphSection(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        List<String> graphSection = new ArrayList<>();
        boolean isRecording = false;

        for (String line : lines) {
            if (line.trim().equals("====== GRAPH DEPENDENCE ======")) {
                isRecording = true;
                continue;  // Skip this line and start recording from next
            }

            if (isRecording) {
                if (line.trim().equals("====== End ======")) {
                    break;  // Stop recording and break out of loop
                }
                graphSection.add(line);
            }
        }
        return graphSection;
    }
    public static void main(String[] args) throws IOException {

        List<String> cfg1Lines = extractGraphSection(INPUT_LOCATION_PATH+"/DynamicClassA1.txt");
        List<String> cfg2Lines = extractGraphSection(INPUT_LOCATION_PATH+"/DynamicClassA2.txt");

        Map<String, List<String>> cfg1 = parseCFG(cfg1Lines);
        Map<String, List<String>> cfg2 = parseCFG(cfg2Lines);

        Map<String, List<String>> differingNodes = new HashMap<>();
        Map<String, Pair<List<String>, List<String>>> differingEdges = new HashMap<>();

        compareCFGs(cfg1, cfg2, differingNodes, differingEdges);
        writeDifferencesToFile(differingNodes, differingEdges, "differences.txt");
    }
}

