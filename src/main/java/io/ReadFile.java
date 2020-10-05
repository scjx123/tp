package io;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import data.ParentModules;
import data.SingleModule;


/**
 * This class contains parseFile() which is specifically used to read in contents from courselist text file.
 * DO NOT ALTER THE parseFILE() list under any circumstance.
 */
public class ReadFile {
    /**
     * The Module name.
     */
    static String moduleName;
    /**
     * The Module code.
     */
    static String moduleCode;
    /**
     * The Module description.
     */
    static String moduleDescription;
    /**
     * The Module mc.
     */
    static String moduleMC;
    /**
     * The Module prerequisite.
     */
    static String modulePrerequisite;

    /**
     * Temporary stores the file directory and the name of the text file itself given in the filePath.
     */
    static String[] dir = new String[2];

    private static String filename = "courselist11.txt";
    private static String filedir = "data";


    /**
     * Instantiates a new Read file.
     *
     * @param filePath the file path
     */
    public ReadFile(String filePath) {
        dir = filePath.split("/",2);
        filedir = dir[0];
        filename = dir[1];
    }

    /**
     * The P 2.
     */
    static Path p2 = Paths.get(filedir,filename);

    /**
     * The St.
     */
    static StringTokenizer st;
    /**
     * The Temp string.
     */
    static String tempString;

    /**
     * New modules are being created here.
     * Master list of modules are being created here.
     * New modules are being added here to the masterList.
     *
     * @throws IOException are being thrown here.
     */
    public static ArrayList<SingleModule> load() throws IOException {
        if (!Files.exists(p2)) {
            Files.createFile(p2);
        }

        ArrayList<SingleModule> masterList = new ArrayList<>();
        Scanner s = new Scanner(p2);

        while (s.hasNext()) {
            tempString = s.nextLine();
            parseFile(tempString);
            SingleModule m = new SingleModule(moduleCode,moduleName,moduleDescription,moduleMC,modulePrerequisite);
            if (moduleCode != null) {
                masterList.add(m);
            }
            moduleCode = null;
        }
        return masterList;
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
}
