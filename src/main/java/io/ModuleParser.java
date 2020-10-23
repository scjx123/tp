package io;

import java.io.IOException;
import java.io.InputStream;
import java.lang.module.ModuleDescriptor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import data.Item;
import data.SingleModule;

import javax.swing.event.ListDataEvent;


/**
 * This class contains parseFile() which is specifically used to read in contents from courselist text file.
 * DO NOT ALTER THE parseFILE() list under any circumstance.
 */
public class ModuleParser {
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
     * The Module SU.
     */
    static String moduleSU;
    /**
     * The Module prerequisite.
     */
    static String modulePrerequisite;
    /**
     * The St.
     */
    static StringTokenizer st;
    /**
     * The Temp string.
     */
    static String tempString;
    static StringBuilder descriptionBuilder = new StringBuilder();
    static boolean isDescriptionBuilder = false;
    static StringBuilder prereqBuilder;
    static boolean isPrereqBuilder = false;
    String[] input;
    /**
     * DO NOT ALTER THIS FUNCTION UNDER ANY CIRCUMSTANCES.
     * Processes the data of course list into its module code, name, description, mc and prerequisite.
     *
     * @param tempString A single line of data read from the content list text file.
     */
    int sum = 0;

    /**
     * Constructor of ModuleParser.
     */
    public ModuleParser() {

    }

    /**
     * New modules are being created here.
     * Master list of modules are being created here.
     * New modules are being added here to the masterList.
     */
    public ArrayList<Item> load() throws IOException {
        InputStream is = getClass().getResourceAsStream("finalcourselist.txt");
        ArrayList<Item> masterList = new ArrayList<>();
        Scanner s = new Scanner(is);

        while (s.hasNext()) {
            tempString = s.nextLine();
            parseFile(tempString);
            SingleModule m = new SingleModule(moduleCode, moduleName, "", moduleMC, "", moduleSU);
            if (moduleCode != null) {
                if (moduleSU.equals("true")) {
                    m.hasSU = true;
                } else {
                    m.hasSU = false;
                }
                masterList.add(m);
            }
            moduleCode = null;
            moduleSU = "false";
        }
        return masterList;
    }

    private boolean checkValidInput(String input, String useCase) {
        if (useCase.equals("code")) {
            if (input.length() >= 9
                    || input.length() < 5
                    || input.contains(" ")
                    || input.contains(":")) {
                return false;
            }
        }
        if (useCase.equals("mc")) {

            return false;
        }
        if (useCase.equals("name")) {
            if (input.contains(",")
                    || input.contains("\"")
                    || input.contains("/")
                    || input.contains(".")
                    || input.contains("(")
                    || input.contains("?")
                    || input.contains("'")) {
                return true;
            }
        }
        if (!input.contains(".")
                && !input.contains("(")
                && !input.contains("\"")
                && !input.contains("OR")
                && !input.contains("?")) {
            return true;
        } else {
            return false;
        }
    }

    private void parseFile(String tempString) {
        if (tempString != null) {
            input = tempString.split("\t");
            //sum+=1;
            //System.out.println(sum);
        }

        if (input.length >= 1) {
            for (int i = 0; i < input.length; i++) {
                if (input[i].matches("[0-9]+")) {
                    moduleMC = input[i];
                    isDescriptionBuilder = false;
                    //System.out.println(input[i]);
                    //sum += 1;
                    //System.out.println(sum);
                    if (i + 1 != input.length && input[i + 1].equals("TRUE")) {
                        moduleSU = "true";
                        //System.out.println("true");
                    }
                }
            }
        }

        if (checkValidInput(input[0], "code")) {
            //System.out.println(input[0]);
            //sum += 1;
            //System.out.println(sum);
            moduleCode = input[0];
            if (input.length > 1 && checkValidInput(input[1], "name")) {
                //System.out.println(input[1]);
                //sum+=1;
                //System.out.println(input[2]+sum);
                moduleName = input[1];
            }
        }
    }
}
