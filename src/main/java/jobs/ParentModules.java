package jobs;

import java.util.HashMap;
import java.util.Map;

public class ParentModules {
    static Map<String, String> moduleCodeAndName = new HashMap<>();
    String moduleCode, moduleName;
    static boolean isMultiple;

    public ParentModules(String Code, String Name) {
        moduleCode = Code;
        moduleName = Name;
        moduleCodeAndName.put(moduleCode, moduleName);
        isMultiple = false;
    }

    //This function is used to print all ParentModules
    public static void printList() {
        //Note: Due to memory allocation the module sequence will appear differently as input.
        ParentModules.moduleCodeAndName.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
