package data;

import constants.Constants;
import data.jobs.Task;

import java.util.ArrayList;


/**
 * The type Single module.
 */
public class SingleModule extends Item {

    /**
     * The Module code.
     */
    public String moduleCode;
    /**
     * The Module mc.
     */
    public String moduleMC;
    /**
     * The Module name.
     */
    public String moduleName;
    /**
     * The Module description.
     */
    public String moduleDescription;
    /**
     * The Module prerequisite.
     */
    public String modulePrerequisite;

    public ArrayList<Item> taskList;

    public boolean isTaken;

    public String grade;

    /**
     * Instantiates a new Single module.
     *
     * @param code        module code
     * @param name        module name
     * @param description module description
     * @param mc          number of mc
     * @param prereq      module prerequisite
     */
    public SingleModule(String code, String name, String description, String mc, String prereq) {
        super(code); //moduleDescription is handle here.
        this.moduleCode = code;
        this.moduleDescription = description;
        this.moduleName = name;
        this.moduleMC = mc;
        this.modulePrerequisite = prereq;
        taskList = new ArrayList<>();
    }

    boolean isSelected = false;

    @Override
    public String getName() {
        return moduleCode;
    }

    @Override
    public String toString() {
        return moduleCode + Constants.SPACE + moduleName + Constants.SPACE
                + moduleMC + (isTaken ? "MC Taken" : "MC") + (isSelected ? " Selected" : "");
    }

    @Override
    public String getDetails() {
        String result = moduleCode + Constants.SPACE + moduleName + Constants.SPACE
                + moduleMC + (isTaken ? "MC Taken" : "MC") + (isSelected ? " Selected" : "");
        StringBuilder builder = new StringBuilder(result);
        builder.append(Constants.WIN_NEWLINE).append(wrap(moduleDescription.trim())).append("Tasks: ");
        if (taskList != null && taskList.size() > 0) {
            for (Item item : taskList) {
                builder.append(((Task)item).getDescription()).append(Constants.SPACE);
            }
        } else {
            builder.append(Constants.NOT_FOUND);
        }
        return builder.toString();
    }

    private String wrap(String input) {
        input = input.replace(Constants.TAB, Constants.SPACE);
        input = input.replace(Constants.NEWLINE, Constants.SPACE);
        StringBuilder builder = new StringBuilder();
        int currentStart = 0;
        while (currentStart < input.length()) {
            int end = Math.min(input.length(), currentStart + Constants.BITMAP_W);
            builder.append(input, currentStart, end).append(Constants.WIN_NEWLINE);
            currentStart += Constants.BITMAP_W;
        }
        return builder.toString();
    }

    /**
     * Gets module description.
     *
     * @return the module description
     */
    public String getModuleDescription() {
        return moduleDescription;
    }

    /**
     * Gets module mc.
     *
     * @return the module mc
     */
    public String getModuleMC() {
        return moduleMC;
    }

    /**
     * Gets module prerequisite.
     *
     * @return the module prerequisite
     */
    public String getModulePrerequisite() {
        return modulePrerequisite;
    }

    public void addTasks(ArrayList<Item> tasks) {
        taskList.addAll(tasks);
    }

}
