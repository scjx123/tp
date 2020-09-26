package visualize;

import constants.Constants;
import data.TaskList;
import messages.MessageFormat;
import messages.MessageOptions;
import messages.MessageWrapper;

public class Cli extends UI {

    protected MessageFormat msgFormat;
    protected MessageWrapper msgWrapper;

    public Cli() {
        super();
        msgFormat = new MessageFormat(new MessageOptions[]{
            MessageOptions.LINE_INDENT_1,
            MessageOptions.LINE_BEFORE,
            MessageOptions.INDENTED_2,
            MessageOptions.AUTO_RETURN,
            MessageOptions.LINE_AFTER
        });
        msgWrapper = new MessageWrapper(Constants.LINE_REPETITION, Constants.LINE_UNIT);
    }

    @Override
    public void showWelcome() {
        msgWrapper.show(Constants.WELCOME, msgFormat.getMessageOptions());
    }

    @Override
    public void showText(String input) {
        String[] lines = input.split(Constants.WIN_NEWLINE);
        msgWrapper.show(lines, msgFormat.getMessageOptions());
    }

    @Override
    public void update(String input, TaskList tasks) {
        if (input == null || input.equals(Constants.ZERO_LENGTH_STRING)) {
            showText(input);
        } else {
            msgFormat.addMessageOption(tasks.indexOption);
            showText(input);
            msgFormat.removeMessageOption(tasks.indexOption);
        }
        tasks.indexOption = MessageOptions.NOT_INDEXED;
    }

}
