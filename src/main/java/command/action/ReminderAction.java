package command.action;

import command.ParamNode;
import constants.Constants;
import data.Data;
import data.Item;
import exceptions.CommandException;

import java.util.ArrayList;
import java.util.Comparator;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Reminder Tasks Action.
 */
public class ReminderAction extends Action {
    private static final Logger LOGGER = Logger.getLogger(ReminderAction.class.getName());
    public static boolean TIMER_TRIGGER = true;
    private String switches;

    @Override
    public String act(Data data) {
        // LOGGER.entering(getClass().getName(), "addReminder");
        final String flag = data.flag;
        StringBuilder builder = new StringBuilder(Constants.REMINDER_HEAD);
        data.setFlag(Constants.EVENT);
        ArrayList<Item> tasks = new ArrayList<>(data.getTarget());
        data.setFlag(Constants.DEADLINE);
        ArrayList<Item> deadlines = new ArrayList<>(data.getTarget());
        LocalDateTime lt = LocalDateTime.now();
        LocalDateTime upper = lt.plusDays(Constants.REMINDER_RANGE);
        tasks.addAll(deadlines);
        tasks.removeIf(x -> x.getDateTime() == null);

        for (int i = 0; i < tasks.size(); i++) {
            if (!(tasks.get(i).getDateTime().isAfter(lt) && tasks.get(i).getDateTime().isBefore(upper))) {
                // LOGGER.log(Level.INFO, "Non-urgent task is eliminated");
                tasks.remove(i);
                i--;
                //assert i != -1 : "i should be non-negative";
            }
        }
        tasks.sort(Comparator.comparing(Item::getDateTime));
        // LOGGER.exiting(getClass().getName(), "addReminder");

        for (Item item : tasks) {
            builder.append(item.toString()).append(Constants.WIN_NEWLINE);
        }
        if (tasks.size() == 0) {
            builder.append(Constants.NO_URGENT_TASKS);
        }
      
        data.setFlag(flag);
        //assert flag != savedData.flag : "flag is different";
        return builder.toString();
    }

    //@author: johanesrafael
    @Override
    public void prepare(ParamNode args) throws Exception {
        super.prepare(args);
        if (args.thisData != null) {
            switches = args.thisData.name;
            String[] options = Constants.optionalParamMap.get(args.name);
            int count = 0;
            for (String opt : options) {
                if (opt.equals(switches)) {
                    if (opt.equals(Constants.REMINDER_ON)) {
                        TIMER_TRIGGER = true;
                    } else if (opt.equals(Constants.REMINDER_OFF)) {
                        TIMER_TRIGGER = false;
                    }
                    break;
                } else {
                    count++;
                }
            }
            if (count == options.length) {
                throw new CommandException();
            }
        }
    }

    /**
     * Gets timer status.
     * @return TIMER_TRIGGER
     */
    public Boolean getTimerStatus() {
        return TIMER_TRIGGER;
    }
}
