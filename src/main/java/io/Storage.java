package io;

import command.Command;
import data.Item;
import data.SingleModule;
import lexical.Parser;
import constants.Constants;
import data.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * The type Storage.
 */
public class Storage {

    private FileLoader taskLoader;
    private FileSaver taskSaver;
    private FileLoader courseLoader;
    private FileSaver courseSaver;
    private Parser parser;
    private ModuleParser moduleloader;

    /**
     * Instantiates a new Storage.
     *
     * @param directory    the directory
     * @param taskFileName the file name
     * @param parser       the parser
     */
    public Storage(String directory, String taskFileName, String courseFileName, Parser parser) {
        taskLoader = new FileLoader(directory, taskFileName);
        taskSaver = new FileSaver(directory, taskFileName);
        courseLoader = new FileLoader(directory, courseFileName);
        courseSaver = new FileSaver(directory, courseFileName);
        this.parser = parser;
        this.moduleloader = new ModuleParser();
    }

    /**
     * Save user's data.
     *
     * @param tasks user's tasks
     */
    public void save(ArrayList<Item> tasks, ArrayList<Item> courses) {
        ArrayList<Item> takenCourses = (ArrayList<Item>) courses.stream()
            .filter(course -> (course instanceof SingleModule) && ((SingleModule) course).isTaken)
            .collect(Collectors.toList());
        taskSaver.saveTask(tasks);
        courseSaver.saveCourse(takenCourses);
    }

    /**
     * Load all storage data.
     *
     * @return the task list
     */
    public Data load() {
        String[] lines = taskLoader.loadAllLines();
        int index = 0;
        Data list = new Data();

        //load stored tasks
        for (String line : lines) {
            String output = taskDataToCommand(line, index);
            if (!output.equals(Constants.ZERO_LENGTH_STRING)) {
                index++;
                ArrayList<Command> commands = parser.parse(output);
                for (Command c : commands) {
                    c.execute(list);
                }
            }
        }

        //load module list
        try {
            list.mods = moduleloader.load();
        } catch (IOException e) {
            e.addSuppressed(new IOException());
        }

        //load stored courses
        String[] coursesWithGrades = courseLoader.loadAllLines();
        String dataInput = Constants.ZERO_LENGTH_STRING;
        for (String course : coursesWithGrades) {
            dataInput = dataInput + course + Constants.SPACE;
        }
        String output = courseDataToCommand(dataInput);
        if (!output.equals(Constants.ZERO_LENGTH_STRING)) {
            ArrayList<Command> commands = parser.parse(output);
            for (Command c : commands) {
                c.execute(list);
            }
        }

        return list;
    }

    private String taskDataToCommand(String input, int index) {
        boolean isDone = false;
        String output = Constants.ZERO_LENGTH_STRING;
        String iconCleared = input.replace(Constants.ICON_SIGNATURE, Constants.ICON_SEPARATOR);
        String[] iconSeparated = iconCleared.split(Constants.LINE_UNIT);
        switch (iconSeparated[0]) {
        case Constants.TODO_ICON:
            output = Constants.TODO + Constants.SPACE;
            break;
        case Constants.EVENT_ICON:
            output = Constants.EVENT + Constants.SPACE;
            break;
        case Constants.DDL_ICON:
            output = Constants.DEADLINE + Constants.SPACE;
            break;
        default:
            return output; //break is unreachable
        }
        String statusCleared = iconSeparated[1].replace(Constants.BODY_SIGNATURE, Constants.BODY_SEPARATOR);
        String[] statusSeparated = statusCleared.split(Constants.LINE_UNIT);
        if (statusSeparated[0].equals(Constants.TICK_ICON)) {
            isDone = true;
        }
        String bodyCleared = statusSeparated[1].replace(Constants.PARAM_SIGNATURE, Constants.PARAM_SEPARATOR);
        String[] bodySeparated = bodyCleared.split(Constants.LINE_UNIT);
        if (bodySeparated.length == 1) { // no params
            output += bodyCleared;
        } else {
            output += bodySeparated[0] + Constants.SPACE;
            String params = bodySeparated[1].replace(Constants.PARAM_LEFT, Constants.ZERO_LENGTH_STRING).replace(
                Constants.PARAM_RIGHT, Constants.ZERO_LENGTH_STRING).trim();
            output += Constants.PARAM + params.replace(Constants.DETAILS_SIGNATURE, Constants.SPACE);
        }
        if (isDone) {
            output += Constants.CMD_END + Constants.DONE + Constants.SPACE + (index + 1);
        }
        return output;
    }

    private String courseDataToCommand(String input) {
        String output = Constants.ZERO_LENGTH_STRING;
        String[] iconSeparated = input.split(Constants.SPACE);
        String courseName = iconSeparated[0];
        String grade = iconSeparated[1];
        if (!courseName.isBlank()) {
            output = Constants.GRADE + Constants.SPACE + "-t" + Constants.SPACE + input;
        }
        return output;
    }
}
