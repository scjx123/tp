package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import jobs.ParentModules;

public class ReadFile {
    static String moduleName;
    static String moduleCode;
    /** Get home directory of the user's operating system. */
    static String home = System.getProperty("user.home");
    /** Temporary stores the file directory and the name of the text file itself given in the filePath. */
    static String[] dir = new String[2];

    private static String filename = "courseList.txt";
    private static String filedir = "data";

    public ReadFile(String filePath) {
        dir = filePath.split("/",2);
        System.out.println(dir[0]);
        System.out.println(dir[1]);
        filedir = dir[0];
        filename = dir[1];
    }

    static Path p2 = Paths.get(filedir,filename);

    public static List<String> load() throws IOException {
        if (!Files.exists(p2)) {
            Files.createFile(p2);
        }
        return Files.readAllLines(p2);
    }

    //convert file entry to tasks
    private static void parseFile(List<String> fileContent) {
        for (String modules : fileContent) {
            String[] tempModules = modules.split("_");
            moduleName = tempModules[0];
            moduleCode = tempModules[1];
            new ParentModules(moduleName,moduleCode);
        }
    }

    //retrieve past saved data
    public static void loadModules() {
        try {
            parseFile(load());
            ParentModules.printList();
        } catch (IOException e) {
            System.out.println("Opps");
        }
    }
}
