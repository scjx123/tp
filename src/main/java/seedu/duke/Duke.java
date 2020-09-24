package seedu.duke;

import java.util.ArrayList;
import java.util.Scanner;

import command.Command;
import constants.Constants;
import data.Data;
import data.Module;
import io.FileLoader;
import lexical.Lexer;
import lexical.Parser;
import lexical.Token;
import visualize.Bitmap;
import visualize.UI;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */

    public static void testIO() {
        //Test loader
        System.out.println("Loading some commands from a file...");
        final FileLoader loader = new FileLoader(Constants.PATH, Constants.LOAD_FILENAME);
        String[] strings = loader.loadAllLines();
        StringBuilder stringBuilder = new StringBuilder();
        //Test lexer
        System.out.println("Loaded. Now lexing...");
        for (String str: strings) {
            stringBuilder.append(str).append(";");
        }
        Lexer lexer = new Lexer();
        ArrayList<Token> tokens = lexer.analyze(stringBuilder.toString());
        //Test parser
        System.out.println("Lexing done. Now parsing...");
        Parser parser = new Parser();
        ArrayList<Command> parsed = parser.parseTree(tokens);
        System.out.println(parsed);
        //Test saver
        //System.out.println("Saving parsed result as a text file...");
        //FileSaver saver = new FileSaver(Constants.PATH, Constants.SAVE_FILENAME);
        //System.out.println(saver.save(parsed.toString()) ? "Saved." : "Save failed.");
    }

    public static void main(String[] args) {
        Data data = new Data();
        data.addItem(new Module("CS1010", "Mod1"));
        data.addItem(new Module("CS2113", "Mod2"));
        data.addItem(new Module("CS2113T", "Mod2.5"));
        UI ui = new UI(data, new Bitmap(100,12), new Bitmap(100,6));
        ui.initialize();
        ui.drawWelcomeScreen();
        Scanner inputGetter = new Scanner(System.in);
        Lexer lexer = new Lexer();
        Parser parser = new Parser();
        boolean isRunning = true;
        while (isRunning) {
            String input = inputGetter.nextLine();
            ArrayList<Token> tokens = lexer.analyze(input);
            ArrayList<Command> parsed = parser.parseTree(tokens);
            for (Command cmd: parsed) {
                cmd.act(data);
                ui.draw();
            }
        }
    }
}
