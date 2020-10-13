package command.action;

import constants.Constants;
import data.Data;
import data.Item;

import java.util.ArrayList;
import java.util.Comparator;
import java.time.LocalDateTime;

/**
 * The type Reminder Tasks Action.
 */
public class ReminderAction extends Action {

    @Override
    public String act(Data data) {
        Data savedData = data;
        final String flag = savedData.flag;
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
                tasks.remove(i);
                i--;
            }
        }
        tasks.sort(Comparator.comparing(Item::getDateTime));

        for (Item item : tasks) {
            builder.append(item.toString()).append(Constants.WIN_NEWLINE);
        }
        if (builder.toString().equals(Constants.ZERO_LENGTH_STRING)) {
            builder.append(Constants.NO_URGENT_TASKS);
        }
      
        data.setFlag(flag);
        return builder.toString();
    }
}
