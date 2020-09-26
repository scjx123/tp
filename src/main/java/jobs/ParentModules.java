package jobs;

import java.util.HashMap;
import java.util.Map;


public class ParentModules {
    static Map<String, String[]> ParentModuleList = new HashMap<>();
    String moduleCode;
    String[] moduleContent = new String[4];
    static String[] displayContent;
    static boolean isMultiple;

    public ParentModules(String code,String name,String description,String mc,String prereq) {
        moduleCode = code;
        moduleContent[0] = name; //moduleName;
        moduleContent[1] = description; //moduleDescription;
        moduleContent[2] = mc; //moduleMC;
        moduleContent[3] = prereq; //modulePrerequisite;
        ParentModuleList.put(moduleCode, moduleContent);
        isMultiple = false;
    }

    //This function is used to print all ParentModules
    public static void printList() {
        //Note: Due to memory allocation the module sequence will appear differently as input.
        //moduleCodeAndName.forEach((key, value) -> System.out.println(key + " " + value));
        for (Map.Entry<String, String[]> entry : ParentModuleList.entrySet()) {
            displayContent = entry.getValue();
            System.out.println(entry.getKey() + " " + displayContent[3]);
        }

    }
}
