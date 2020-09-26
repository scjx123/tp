
package seedu.duke;

import java.util.ArrayList;
import java.util.Scanner;

import command.Command;
import constants.Constants;
import data.TaskList;
import io.ReadFile;
import io.Storage;
import lexical.Parser;
import visualize.Cli;
import visualize.FancyCli;

public class Duke {

    private TaskList tasks;
    private final Storage storage;
    private final Cli ui;
    private final Parser parser;

    public Duke(String directory, String fileName) {
        ui = new FancyCli(); //uncomment this to use gui
        //ui = new Cli(); //uncomment this to use normal cli for backup
        ui.showWelcome();
        parser = new Parser();
        storage = new Storage(directory, fileName, parser);
        try {
            tasks = storage.load();
        } catch (Exception e) {
            ui.showText(e.getMessage());
            tasks = new TaskList();
        }
    }

    public void run() {
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.nextLine();
                ArrayList<Command> commands = parser.parse(fullCommand);
                for (Command c: commands) {
                    c.execute(tasks);
                    ui.update(c.result, tasks);
                    isExit = c.isExit();
                    storage.saveTasks(tasks.tasks);
                }
            } catch (Exception e) {
                String message = e.getMessage();
                if (message == null) {
                    message = Constants.INDEX_OUT;
                }
                ui.showText(message);
            }
        }
    }
    static String dummy;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        dummy = in.nextLine();
        new ReadFile("data/courseList.txt");
        ReadFile.loadModules();
        //uncomment this line to run program.
        new Duke(Constants.PATH, Constants.FILENAME).run();
    }
}
