package data;

import visualize.UI;
import java.util.ArrayList;

/**
 * The purpose of this class is to hold a bundle of module, it can be used for selection region, current region.
 * Summary of Commands Available
 * printList : list all module in the list
 * find : find a module by ANY method ( code/ name/ mc/ description/ prerequisite)
 * deleteModule (by moduleCode / index)
 * addModule : add a single module (by object) to the list
 * printMC : prints the total mc in the list
 *
 */
public class ParentModules {
    static ArrayList<SingleModule> moduleList;
    static UI ui = new UI();

    public ParentModules() {
        moduleList = new ArrayList<>();
    }

    /**
     * Prints a complete list of module code with their name.
     */
    public static void printList() {
        for (SingleModule m : moduleList) {
            System.out.println(m.moduleCode + m.moduleName);
        }
    }

    /**
     * Find module by mc, code, name.
     * @param details A string that could be any module related information.
     */
    public static void find(String details) throws NumberFormatException {
        for (SingleModule m : moduleList) {
            if (Integer.parseInt(details.trim()) <= 12) { //search by MC
                ui.printModule(m,"mc");
            } else if (m.moduleCode.toLowerCase().equals(details.toLowerCase())) { //search by name
                ui.printModule(m,"code");
            } else if (m.moduleDescription.contains(details)) { //search by partial description
                ui.printModule(m,"description");
            } else if (m.modulePrerequisite.toLowerCase().contains(details.toLowerCase())) { //search for prereq
                ui.printModule(m,"prereq");
            }
        }
    }

    /**
     * Remove module from module list.
     * Note: Removing multiple module is just repeating this function.
     *
     */
    public void deleteModule(SingleModule moduleToBeDeleted) {
        moduleList.removeIf(m -> m.moduleCode.equals(moduleToBeDeleted.moduleCode));
    }

    //Remove by index
    public void deleteModule(int index) {
        moduleList.remove(index - 1);
    }

    /**
     * Add module to the module list.
     * Note: Adding multiple modules is just repeating this function.
     *
     * @param m the module to be added to the list
     */
    public void addModule(SingleModule m) {
        moduleList.add(m);
    }

    int totalMC = 0;

    public void printMC() {
        for (SingleModule m : moduleList) {
            totalMC += Integer.parseInt(m.moduleMC);
        }
        ui.printMcTitle(totalMC);
    }
}
