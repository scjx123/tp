package data;

import constants.Constants;
import data.jobs.Task;

import java.lang.reflect.Array;
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
     * The Module mc.
     */
    public String moduleSU;
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

    public boolean isTaken = false;

    public boolean isCompleted = false;

    public boolean hasSU = false;

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
    public SingleModule(String code, String name, String description, String mc, String prereq, String su) {
        super(code); //moduleDescription is handle here.
        this.moduleCode = replaceBlanks(code);
        this.moduleDescription = replaceBlanks(description);
        this.moduleName = replaceBlanks(name);
        this.moduleMC = replaceBlanks(mc);
        this.modulePrerequisite = replaceBlanks(prereq);
        this.moduleSU = replaceBlanks(su);
        taskList = new ArrayList<>();
    }

    public String replaceBlanks(String input) {
        if (input != null) {
            return input.replace(Constants.TAB, Constants.SPACE).replace(Constants.NEWLINE, Constants.SPACE)
                    .replace(Constants.RETURN, Constants.SPACE).replace("  ", Constants.SPACE).trim();
        } else {
            return null;
        }
    }

    @Override
    public String getName() {
        return moduleCode;
    }


    @Override
    public String toString() {
        return (isCompleted ? "[COMPLETED]" : "") + moduleCode + Constants.SPACE + moduleName + Constants.SPACE
                + moduleMC + (isTaken ? "MC Taken" : "MC") + (isSelected ? " Selected" : "");
    }



    @Override
    public String getDetails() {
        StringBuilder builder = new StringBuilder(toString());
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
     * Gets module mc.
     *
     * @return the module mc
     */
    public String getModuleMC() {
        return moduleMC;
    }


    /**
     * Gets module mc.
     *
     * @return the module mc
     */
    public ArrayList<Item> getTaskList() {
        return taskList;
    }

}
