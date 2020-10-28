//@@author TomLBZ
package io;

import constants.Constants;
import data.Item;
import data.SingleModule;
import data.jobs.Task;

import java.io.Console;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * The type File saver.
 */
public class FileSaver extends IO {

    /**
     * Instantiates a new File saver.
     *
     * @param path     the path
     * @param fileName the file name
     */
    public FileSaver(String path, String fileName) {
        super(path, fileName);
    }

    /**
     * Save tasks to storage.
     *
     * @param tasks the tasks
     * @return the boolean
     */
    public boolean saveTask(ArrayList<Item> tasks) {
        try {
            StringBuilder strBuilder = new StringBuilder();
            for (Item item: tasks) {
                Task task = (Task)item;
                strBuilder.append(task.toString()).append(System.lineSeparator());
            }
            if (isFileInvalid()) {
                throw new IOException();
            }
            Files.writeString(
                    Paths.get(path + "/" + fileName),
                    strBuilder.toString(), StandardCharsets.UTF_8);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Save boolean.
     *
     * @param string the string
     * @return the boolean
     */
    public boolean saveTask(String string) {
        try {
            Files.writeString(Paths.get(path + "/" + fileName),
                string, StandardCharsets.UTF_8);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Save tasks to storage.
     *
     * @param courses the tasks
     * @return the boolean
     */
    public boolean saveCourse(ArrayList<Item> courses) {
        try {
            StringBuilder strBuilder = new StringBuilder();
            for (Item item: courses) {
                SingleModule module = (SingleModule) item;
                strBuilder.append(module.getName()).append(Constants.SPACE)
                    .append(module.grade).append(System.lineSeparator());
            }
            if (isFileInvalid()) {
                throw new IOException();
            }
            Files.writeString(
                Paths.get(path + "/" + fileName),
                strBuilder.toString(), StandardCharsets.UTF_8);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
