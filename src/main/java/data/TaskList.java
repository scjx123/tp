package data;

import jobs.Task;
import messages.MessageOptions;
import java.util.ArrayList;

/**
 * The type Task list.
 */
public class TaskList {

    /**
     * The Tasks.
     */
    public static ArrayList<Task> tasks;

    public static ArrayList<SingleModule> mods;
    /**
     * The Index option.
     */
    public MessageOptions indexOption;
    /**
     * The Indices.
     */
    public ArrayList<Integer> indices;

    /**
     * The Last input.
     */
    public String lastInput;
    /**
     * The Last index option.
     */
    public MessageOptions lastIndexOption;

    /**
     * Instantiates a new Task list.
     */
    public TaskList() {
        lastInput = "";
        lastIndexOption = MessageOptions.NOT_INDEXED;
        tasks = new ArrayList<>();
        indexOption = MessageOptions.NOT_INDEXED;
        indices = new ArrayList<>();
        mods = new ArrayList<>();
    }

    /**
     * Get task.
     *
     * @param index the index
     * @return the task
     */
    public Task get(int index) {
        try {
            return tasks.get(indices.get(index));
        } catch (Exception ignore) {
            return tasks.get(index);
        }
    }

    /**
     * Index of int.
     *
     * @param task the task
     * @return the int
     */
    public int indexOf(Task task) {
        return tasks.indexOf(task);
    }

    /**
     * Load list.
     *
     * @param input the input
     */
    public void loadList(ArrayList<Task> input) {
        tasks = input;
    }


}
