package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemLoopException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import jobs.ParentModules;

public class ReadFile {
    static String moduleName;
    static String moduleCode;
    private static final String FILE_NAME = "courseList.txt";
    private static final String FILE_PATH = "./data";
    static ArrayList<String> fileContent = new ArrayList<>();
    static ArrayList<ParentModules> moduleList = new ArrayList<>();

    static Path p = Paths.get(FILE_PATH, FILE_NAME);

    //read file content
    public static List<String> readFile() throws IOException {
        //read previous data
        if (!Files.exists(p)) {
            Files.createFile(p);
        }
        return Files.readAllLines(p);
    }

    //convert file entry to tasks
    private static void parseFile(List<String> fileContent) {
        for (String modules : fileContent) {
            String[] tempModules = modules.split("_");
            moduleName = tempModules[0];
            moduleCode = tempModules[1];
            ParentModules module = new ParentModules(tempModules[0], tempModules[1]);
            moduleList.add(module);
        }
    }

    //retrieve past saved data
    public static void loadModules() {
        try {
            parseFile(readFile());
        } catch (IOException e) {
            System.out.println("Unable to read file");
        }
    }

}
