package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.StringTokenizer;

import data.ParentModules;
import data.SingleModule;


/**
 * This class contains parseFile() which is specifically used to read in contents from courselist text file.
 * DO NOT ALTER THE parseFILE() list under any circumstance.
 */
public class ReadFile {
    static String moduleName;
    static String moduleCode;
    static String moduleDescription;
    static String moduleMC;
    static String modulePrerequisite;

    /** Temporary stores the file directory and the name of the text file itself given in the filePath. */
    static String[] dir = new String[2];

    private static String filename = "courselist11.txt";
    private static String filedir = "data";

    public ReadFile(String filePath) {
        dir = filePath.split("/",2);
        filedir = dir[0];
        filename = dir[1];
    }

    static Path p2 = Paths.get(filedir,filename);

    static StringTokenizer st;
    static String tempString;

    /**
     * New modules are being created here.
     * Master list of modules are being created here.
     * New modules are being added here to the masterList.
     *
     * @throws IOException are being thrown here.
     */
    public static void load() throws IOException {
        if (!Files.exists(p2)) {
            Files.createFile(p2);
        }

        ParentModules masterList = new ParentModules();
        Scanner s = new Scanner(p2);

        while (s.hasNext()) {
            tempString = s.nextLine();
            parseFile(tempString);
            SingleModule m = new SingleModule(moduleCode,moduleName,moduleDescription,moduleMC,modulePrerequisite);
            masterList.addModule(m);
        }

    }

    /**
     * DO NOT ALTER THIS FUNCTION UNDER ANY CIRCUMSTANCES.
     * Processes the data of course list into its module code, name, description, mc and prerequisite.
     *
     * @param tempString A single line of data read from the content list text file.
     */
    private static void parseFile(String tempString) {
        if (tempString.indexOf("EE") == 0 || tempString.indexOf("CG") == 0
                || tempString.indexOf("MA") == 0 || tempString.indexOf("CS") == 0 || tempString.indexOf("EG") == 0) {
            st = new StringTokenizer(tempString,"_");
            moduleCode = st.nextToken();
            moduleName = st.nextToken(); //moduleName;
            if (moduleName.contains("\t")) {
                moduleName = moduleName.replace("\t","");
            }
            moduleDescription = st.nextToken(); //moduleDescription;
            moduleMC = st.nextToken(); //moduleMC;
            if (moduleMC.contains("\"")) {
                moduleMC = moduleMC.replace("\"","");
                moduleMC = moduleMC.trim();
            }
            modulePrerequisite = st.nextToken().trim(); //modulePrerequisite;
        }
    }

    /**
     * Master List of module is being created here.
     *
     */
    public static void loadModules() {
        try {
            load();
        } catch (IOException e) {
            System.out.println("Opps");
        }
    }
}
