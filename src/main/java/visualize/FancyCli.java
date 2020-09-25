package visualize;

import constants.Constants;
import data.TaskList;
import messages.MessageOptions;

public class FancyCli extends Cli {

    private Bitmap bmpList;
    private Bitmap bmpSel;
    private final Color listBackground = Color.DarkBlue;
    private final Color selBackground = Color.DarkMagenta;
    private final Color foreground = Color.White;
    private final int maxX = Constants.BITMAP_W - 1;
    private final int maxListY = Constants.BITMAP_LIST_H - 1;
    private final int maxSelY = Constants.BITMAP_SEL_H - 1;
    private int currentColor;

    public FancyCli() {
        super();
        currentColor = 1;
        this.bmpList = new Bitmap(Constants.BITMAP_W, Constants.BITMAP_LIST_H);
        this.bmpSel = new Bitmap(Constants.BITMAP_W, Constants.BITMAP_SEL_H);
    }

    public void initialize() {
        initializeList();
        initializeSel();
    }

    public void initializeList() {
        bmpList.flush(listBackground);
        bmpList.drawLine(0, 0, maxX, 0, "Welcome to DomSun! This is the item list.",
                Color.DarkGreen, Color.White, false);
    }

    public void initializeSel() {
        bmpSel.flush(selBackground);
        bmpSel.drawLine(0, 0, maxX, 0, "This is the selection list.",
                Color.LightCyan, Color.Black, false);
    }

    @Override
    public void showWelcome() {
        initialize();
        bmpList.drawSprite(0, Constants.BANNER, 1, 1, Sprite.W, foreground, foreground);
        bmpList.drawSprite(6, Constants.BANNER, 1, 1, Sprite.e, foreground, foreground);
        bmpList.drawSprite(12, Constants.BANNER, 1, 1, Sprite.l, foreground, foreground);
        bmpList.drawSprite(18, Constants.BANNER, 1, 1, Sprite.c, foreground, foreground);
        bmpList.drawSprite(24, Constants.BANNER, 1, 1, Sprite.o, foreground, foreground);
        bmpList.drawSprite(30, Constants.BANNER, 1, 1, Sprite.m, foreground, foreground);
        bmpList.drawSprite(36, Constants.BANNER, 1, 1, Sprite.e, foreground, foreground);
        bmpList.drawSprite(45, Constants.BANNER, 1, 1, Sprite.t, foreground, foreground);
        bmpList.drawSprite(51, Constants.BANNER, 1, 1, Sprite.o, foreground, foreground);
        bmpList.drawSprite(60, Constants.BANNER, 1, 1, Sprite.D, foreground, foreground);
        bmpList.drawSprite(66, Constants.BANNER, 1, 1, Sprite.o, foreground, foreground);
        bmpList.drawSprite(72, Constants.BANNER, 1, 1, Sprite.m, foreground, foreground);
        bmpList.drawSprite(78, Constants.BANNER, 1, 1, Sprite.S, foreground, foreground);
        bmpList.drawSprite(84, Constants.BANNER, 1, 1, Sprite.u, foreground, foreground);
        bmpList.drawSprite(90, Constants.BANNER, 1, 1, Sprite.n, foreground, foreground);
        System.out.print(bmpList.get());
        System.out.print(bmpSel.get());
    }

    public void showBlock(int x, int y, int width, int height, String input, boolean isDisplayMode) {
        int startIndex = 0;
        int deltaY = 0;
        int myWidth = isDisplayMode ? width : maxX - x;
        int myHeight = isDisplayMode ? height : 1;
        int maxY = isDisplayMode ? maxListY : maxSelY;
        while (startIndex + myWidth < input.length()) {
            if (y + deltaY > maxY) {
                return;
            }
            String string = input.substring(startIndex, startIndex + myWidth);
            startIndex += myWidth;
            fillCellLine(x, y + deltaY, myWidth, isDisplayMode, string);
            deltaY++;
            if (deltaY >= myHeight) {
                return;
            }
        }
        if (y + deltaY > maxY) {
            return;
        }
        String string = input.substring(startIndex);
        fillCellLine(x, y + deltaY, myWidth, isDisplayMode, string);
        if (isDisplayMode) {
            currentColor++;
            if (currentColor > 255) {
                currentColor = 1;
            }
        }
    }

    private void fillCellLine(int x, int y, int width, boolean isDisplayMode, String string) {
        Color backColor = isDisplayMode ? Color.getFromCode(currentColor) : selBackground;
        if (isDisplayMode) {
            bmpList.drawLine(x, y, x + width - 1, y, string, backColor, foreground, false);
        } else {
            bmpSel.drawLine(x, y, x + width - 1, y, string, backColor, foreground, false);
        }
    }

    public void showText(String input, boolean isDisplayMode, MessageOptions indexState) {
        if (isDisplayMode) {
            initializeList();
        } else {
            initializeSel();
        }
        String[] lines = input.split(Constants.WIN_NEWLINE);
        switch (indexState) {
        case INDEXED_NUM:
            for (int i = 0; i < lines.length; i++) {
                lines[i] = (i + 1) + Constants.DOT + Constants.SPACE + lines[i];
            }
            break;
        case INDEXED_ABC:
            for (int i = 0; i < lines.length; i++) {
                lines[i] = (i + Constants.LETTER_OFFSET) + Constants.DOT + Constants.SPACE + lines[i];
            }
            break;
        default:
            break;
        }
        int y = Constants.BANNER;
        int x = 0;
        int maxY = isDisplayMode ? maxListY : maxSelY;
        for (String line : lines) {
            showBlock(x, y, Constants.CELL_W, Constants.CELL_H, line, isDisplayMode);
            if (isDisplayMode) {
                x += Constants.CELL_W;
                if (x + Constants.CELL_W - 1 > maxX) {
                    x = 0;
                    y += Constants.CELL_H;
                }
            } else {
                y++;
            }
            if (y > maxY) {
                break;
            }
        }
        draw();
    }

    @Override
    public void showText(String input) {
        showText(input, false, MessageOptions.NOT_INDEXED);
    }

    public void update(String input, TaskList tasks, boolean isDisplayMode) {
        if (input == null || input.equals(Constants.ZERO_LENGTH_STRING)) {
            showText(input, isDisplayMode, MessageOptions.NOT_INDEXED);
        } else {
            showText(input, tasks.indexOption != MessageOptions.NOT_INDEXED, tasks.indexOption);
        }
        tasks.indexOption = MessageOptions.NOT_INDEXED;
    }

    @Override
    public void update(String input, TaskList tasks) {
        update(input, tasks, false);
    }

    private void draw() {
        System.out.print(bmpList.get());
        System.out.print(bmpSel.get());
    }
}
