package seedu.duke;

import java.util.List;

import command.Command;
import constants.Constants;
import io.FileLoader;
import io.FileSaver;
import lexical.Lexer;
import lexical.Parser;
import lexical.Token;
import visualize.Bitmap;
import visualize.Color;
import visualize.Sprite;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void testBitmap(){
        final int W = 60;
        final int H = 10;
        Bitmap bmp = new Bitmap(W,H);
        bmp.flush(Color.Maroon);
        for (int i = 0; i < 256; i++) {
            int x = i % 60;
            int y = (i - x) / 60;
            bmp.setPixelColor(x,y,Color.getFromCode(i));
        }
        bmp.drawLine(0,9,59,9,"0-`+`-",Color.White,Color.Black);
        bmp.setPixelColor(29,9,Color.Red);
        bmp.setPixelText(30,9,"+");
        bmp.setPixelTextColor(30,9,Color.Blue);
        bmp.drawSprite(0,7,1,1,
                Sprite.HOLLOWSQUARE,Color.Blue3,Color.Yellow);
        bmp.drawSprite(57,5,1,1,Sprite.ONE,Color.Lime,Color.MistyRose1);
        bmp.drawSprite(20,4,1,1,Sprite.TWO,Color.White,null);
        bmp.drawSprite(28,4,1,1,Sprite.ZERO,Color.Grey7,null);
        bmp.drawSprite(36,4,1,1,Sprite.TWO,Color.White,null);
        bmp.drawSprite(44,4,1,1,Sprite.ZERO,Color.Grey7,null);
        System.out.print(bmp.get());
    }

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
        List<Token> tokens = lexer.analyze(stringBuilder.toString());
        for(Token t: tokens) {
            System.out.println(t);
        }
        //Test parser
        System.out.println("Lexing done. Now parsing...");
        Parser parser = new Parser();
        List<Command> parsed = parser.parseTree(tokens);
        System.out.println(parsed);
        //Test saver
        System.out.println("Saving parsed result as a text file...");
        FileSaver saver = new FileSaver(Constants.PATH, Constants.SAVE_FILENAME);
        System.out.println(saver.save(parsed.toString()) ? "Saved." : "Save failed.");
    }

    public static void main(String[] args) {
        //testBitmap();
        testIO();
    }
}
