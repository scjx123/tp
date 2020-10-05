package visualize;

import constants.Constants;
import data.TaskList;
import messages.MessageOptions;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * The type Fancy cli.
 */
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

    private String[] listString;
    private String[] selString;
    private int listIndex;
    private int selIndex;

    /**
     * Instantiates a new Fancy cli.
     *
     * @param stream the stream
     * @param input  the input
     */
    public FancyCli(PrintStream stream, InputStream input) {
        super(stream, input);
        currentColor = 1;
        this.bmpList = new Bitmap(Constants.BITMAP_W, Constants.BITMAP_LIST_H);
        this.bmpSel = new Bitmap(Constants.BITMAP_W, Constants.BITMAP_SEL_H);
        listString = new String[0];
        selString = new String[0];
        listIndex = 0;
        selIndex = 0;
    }

    /**
     * Initialize.
     */
    public void initialize() {
        initializeList();
        initializeSel();
    }

    /**
     * Initialize list.
     */
    public void initializeList() {
        bmpList.flush(listBackground);
        bmpList.drawLine(0, 0, maxX, 0, "Welcome to DomSun! This is the item list.",
                Color.DarkGreen, Color.White, false);
    }

    /**
     * Initialize list.
     *
     * @param text the text
     */
    public void initializeList(String text) {
        bmpList.flush(listBackground);
        bmpList.drawLine(0, 0, maxX, 0, text,
                Color.DarkGreen, Color.White, false);
    }

    /**
     * Initialize sel.
     */
    public void initializeSel() {
        bmpSel.flush(selBackground);
        bmpSel.drawLine(0, 0, maxX, 0, "This is the selection list.",
                Color.LightCyan, Color.Black, false);
    }

    /**
     * Initialize sel.
     *
     * @param text the text
     */
    public void initializeSel(String text) {
        bmpSel.flush(selBackground);
        bmpSel.drawLine(0, 0, maxX, 0, text,
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
        stream.print(bmpList.get());
        stream.print(bmpSel.get());
    }

    /**
     * Show block.
     *
     * @param x             the x
     * @param y             the y
     * @param width         the width
     * @param height        the height
     * @param rawInput      the raw input
     * @param isDisplayMode the is display mode
     */
    public void showBlock(int x, int y, int width, int height, String rawInput, boolean isDisplayMode) {
        int startIndex = 0;
        int deltaY = 0;
        int myWidth = isDisplayMode ? width : maxX - x;
        int myHeight = isDisplayMode ? height : 1;
        int maxY = isDisplayMode ? maxListY : maxSelY;
        int maxLen = Math.min(myWidth * myHeight, rawInput.length());
        String input = rawInput.substring(0, maxLen);
        boolean isBroken = false;
        while (startIndex + myWidth - 1 < input.length()) {
            if (y + deltaY > maxY) {
                isBroken = true;
                break;
            }
            String string = input.substring(startIndex, startIndex + myWidth);
            startIndex += myWidth;
            fillCellLine(x, y + deltaY, myWidth, isDisplayMode, string);
            deltaY++;
            if (deltaY >= myHeight) {
                isBroken = true;
                break;
            }
        }
        if (y + deltaY > maxY) {
            isBroken = true;
        }
        if (!isBroken) {
            String string = input.substring(startIndex);
            fillCellLine(x, y + deltaY, myWidth, isDisplayMode, string);
        }
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

    /**
     * Show text.
     *
     * @param input         the input
     * @param isDisplayMode the is display mode
     * @param indexState    the index state
     */
    public void showText(String input, boolean isDisplayMode, MessageOptions indexState) {
        String[] lines = input.split(Constants.WIN_NEWLINE);
        if (lines.length == 0) {
            return;
        }
        if (isDisplayMode) {
            initializeList(lines[0]);
        } else {
            initializeSel(lines[0]);
        }
        switch (indexState) {
        case INDEXED_NUM:
            for (int i = 1; i < lines.length; i++) {
                lines[i] = i + Constants.DOT + Constants.SPACE + lines[i];
            }
            break;
        case INDEXED_ABC:
            for (int i = 1; i < lines.length; i++) {
                lines[i] = (i + Constants.LETTER_OFFSET) + Constants.DOT + Constants.SPACE + lines[i];
            }
            break;
        default:
            break;
        }
        int y = Constants.BANNER;
        int x = 0;
        int maxY = isDisplayMode ? maxListY : maxSelY;
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
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

    /**
     * Update.
     *
     * @param input         the input
     * @param tasks         the tasks
     */
    public void update(String input, TaskList tasks) {
        if (freshlySwitched) {
            String replay = tasks.lastInput;
            MessageOptions replayOption = tasks.lastIndexOption;
            if (replay == null || replay.equals(Constants.ZERO_LENGTH_STRING)) {
                showWelcome();
            } else {
                boolean displayMode = replayOption != MessageOptions.NOT_INDEXED;
                separatePages(replay, displayMode);
                fixIndex();
                showText(getShownText(displayMode), displayMode, replayOption);
            }
            freshlySwitched = false;
            return;
        }
        if (input == null || input.equals(Constants.ZERO_LENGTH_STRING)) {
            showText(Constants.ZERO_LENGTH_STRING);
        } else if (input.contains(Constants.BMP_LIST_SWITCH) || input.contains(Constants.BMP_SEL_SWITCH)) {
            flipPage(input);
            if (!tasks.lastInput.equals(Constants.ZERO_LENGTH_STRING)) {
                boolean displayMode = tasks.indexOption != MessageOptions.NOT_INDEXED;
                showText(getShownText(displayMode), displayMode, tasks.indexOption);
            }
        } else {
            boolean displayMode = tasks.indexOption != MessageOptions.NOT_INDEXED;
            separatePages(input, displayMode);
            fixIndex();
            showText(getShownText(displayMode), displayMode, tasks.indexOption);
            tasks.lastInput = input;
            tasks.lastIndexOption = tasks.indexOption;
        }
        tasks.indexOption = MessageOptions.NOT_INDEXED;
    }

    private void flipPage(String input) {
        boolean isList = input.contains(Constants.BMP_LIST_SWITCH);
        boolean isSel = input.contains(Constants.BMP_SEL_SWITCH);
        String number = input;
        if (isList) {
            number = number.replace(Constants.BMP_LIST_SWITCH, Constants.ZERO_LENGTH_STRING);
        }
        if (isSel) {
            number = number.replace(Constants.BMP_SEL_SWITCH, Constants.ZERO_LENGTH_STRING);
        }
        int num = Integer.parseInt(number);
        listIndex = flippedNumber(listIndex, isList, num, listString.length);
        selIndex = flippedNumber(selIndex, isSel, num, selString.length);
    }

    private int flippedNumber(int currentNumber, boolean condition, int increment, int max) {
        int result = currentNumber;
        if (condition && max > 1) {
            result += increment;
            if (result > max - 1) {
                result -= max;
            } else if (result < 0) {
                result += max;
            }
        }
        return result;
    }

    private void fixIndex() {
        if (listString == null || listString.length == 0) {
            listIndex = 0;
        } else if (listIndex >= listString.length) {
            listIndex = listString.length - 1;
        }
        if (selString == null || selString.length == 0) {
            selIndex = 0;
        } else if (selIndex >= selString.length) {
            selIndex = selString.length - 1;
        }
    }

    /**
     * Gets shown text.
     *
     * @param isDisplayMode the is display mode
     * @return the shown text
     */
    String getShownText(boolean isDisplayMode) {
        if (isDisplayMode) {
            return listString[listIndex];
        } else {
            return selString[selIndex];
        }
    }

    private void draw() {
        stream.print(bmpList.get());
        stream.print(bmpSel.get());
    }

    private void separatePages(String input, boolean isDisplayMode) {
        if (input == null || input.equals(Constants.ZERO_LENGTH_STRING)) {
            return;
        }
        String[] lines = input.split(Constants.WIN_NEWLINE);
        int numLines = lines.length - 1;
        if (isDisplayMode) {
            int cellNum = (bmpList.width / Constants.CELL_W) * ((bmpList.height - 1) / Constants.CELL_H);
            if (numLines <= cellNum) {
                listString = new String[]{input};
                return;
            }
            int pages = (int) Math.ceil((double) numLines / (double) cellNum);
            listString = groupStrings(lines, pages, cellNum);
        } else {
            int lineNum = bmpSel.height - 1;
            if (numLines <= lineNum) {
                selString = new String[]{input};
                return;
            }
            int pages = (int) Math.ceil((double) numLines / (double) lineNum);
            selString = groupStrings(lines, pages, lineNum);
        }
    }

    private String[] groupStrings(String[] strings, int groups, int groupLength) {
        StringBuilder[] builders = new StringBuilder[groups];
        String heading = strings[0];
        for (int i = 0; i < groups; i++) {
            builders[i] = new StringBuilder(heading).append(Constants.SPACE).append(
                    Constants.PARAM_LEFT).append(i + 1).append(Constants.PARAM_RIGHT).append(Constants.WIN_NEWLINE);
        }
        for (int i = 1; i < strings.length; i++) {
            int currentGroup = (i - 1) / groupLength;
            builders[currentGroup].append(strings[i]).append(Constants.WIN_NEWLINE);
        }
        String[] groupedStrings = new String[groups];
        for (int i = 0; i < groups; i++) {
            groupedStrings[i] = builders[i].toString();
        }
        return groupedStrings;
    }

}
