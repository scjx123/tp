package data;

import constants.Constants;
import jobs.Deadline;
import jobs.Event;
import jobs.Task;
import jobs.ToDo;
import messages.MessageOptions;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * The type Task list.
 */
public class Data {

    public String flag;
    /**
     * The Tasks.
     */
    public ArrayList<Item> tasks;

    public ArrayList<Item> mods;
    /**
     * The Index option.
     */
    public MessageOptions indexOption;

    public ArrayList<Item> target;

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
    public Data() {
        lastInput = "";
        lastIndexOption = MessageOptions.NOT_INDEXED;
        tasks = new ArrayList<>();
        indexOption = MessageOptions.NOT_INDEXED;
        target = tasks;
        mods = new ArrayList<>();
        flag = Constants.TASK;
    }

    public void setFlag(String flag) {
        this.flag = flag;
        target = getTarget();
    }

    public ArrayList<Item> getTarget() {
        return getTarget(flag);
    }

    public ArrayList<Item> getTarget(String flag) {
        refreshTarget(flag);
        return target;
    }

    public void refreshTarget() {
        refreshTarget(flag);
    }

    public void refreshTarget(String flag) {
        switch (flag) {
        case Constants.DEADLINE: // break is unreachable
            target = tasks.stream().filter(x -> x instanceof Deadline).collect(Collectors.toCollection(ArrayList::new));
            break;
        case Constants.EVENT: // break is unreachable
            target = tasks.stream().filter(x -> x instanceof Event).collect(Collectors.toCollection(ArrayList::new));
            break;
        case Constants.TODO: // break is unreachable
            target = tasks.stream().filter(x -> x instanceof ToDo).collect(Collectors.toCollection(ArrayList::new));
            break;
        case Constants.MOD:
            target = mods;
            break;
        default:
            target = tasks;
            break;
        }
    }

    public void addTask(Task task) {
        tasks.add(task);
        refreshTarget();
    }

    public void removeItem(int index) {
        Item currentItem = target.get(index);
        refreshTarget();
        target.remove(currentItem);
        refreshTarget();
    }

    public void updateItem(int index, Item newItem) {
        Item currentItem = target.get(index);
        refreshTarget();
        target.set(target.indexOf(currentItem), newItem);
        refreshTarget();
    }

    /**
     * Get task.
     *
     * @param index the index
     * @return the task
     */
    public Item get(int index) {
        return target.get(index);
    }


}
