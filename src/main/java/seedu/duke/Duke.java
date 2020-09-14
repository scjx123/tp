package seedu.duke;

import java.util.Scanner;

import visualize.Bitmap;
import visualize.Color;
import visualize.Sprite;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    private static final int W = 60;
    private static final int H = 10;

    public static void main(String[] args) {
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
        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());
        bmp.flush(Color.Purple);
        System.out.print(bmp.get());
    }
}
