package visualize;

import constants.Constants;
import data.Data;

public class UI {

    private Data data;
    private Bitmap bmpList;
    private Bitmap bmpSel;
    private final int cellWidth = 9;
    private final int cellWall = 1;
    private final int startHeight = 1;
    private final int cellHeight = 1;
    private final Color listBackground = Color.DarkBlue;
    private final Color selBackground = Color.DarkMagenta;
    private final Color foreground = Color.White;

    public UI(Data data, Bitmap bmpList, Bitmap bmpSel) {
        this.data = data;
        this.bmpList = bmpList;
        this.bmpSel = bmpSel;
    }

    public void initialize() {
        bmpList.flush(listBackground);
        bmpSel.flush(selBackground);
        bmpList.drawLine(0, 0, 99, 0, "Welcome to DomSun! This is the item list.",
                Color.DarkGreen, Color.White, false);
        bmpSel.drawLine(0, 0, 99, 0, "This is the selection list.",
                Color.LightCyan, Color.Black, false);
        updateList(null);
        updateSel(null);
    }

    public void updateList(String list) {
        String strList = list;
        if (strList == null) {
            if (data.isListUpdated) {
                strList = data.getListUI();
                data.isListUpdated = false;
            } else {
                return;
            }
        }
        String[] listItems = strList.split(Constants.LINE_UNIT);
        int x = 0;
        int y = 0;
        for (String string: listItems) {
            if (string.equals(Constants.ZERO_LENGTH_STRING)) {
                continue;
            }
            bmpList.drawLine(x, startHeight + y, x + cellWidth, startHeight + y,
                    string, listBackground, foreground, false);
            x += cellWidth + cellWall;
            if (x >= bmpList.width) {
                x = 0;
                y += cellHeight;
            }
            if (y >= bmpList.height) {
                break;
            }
        }
    }

    public void updateSel(String content) {
        String message = content;
        if (message == null) {
            if (data.isSelUpdated) {
                message = data.getSelUI();
                data.isSelUpdated = false;
            } else {
                return;
            }
        }
        String[] selLines = message.split(Constants.WIN_NEWLINE);
        for (int i = startHeight; i < bmpSel.height; i++) {
            bmpSel.drawLine(0, i, bmpSel.width - 1, i, selLines[i - 1], selBackground, foreground, false);
        }
    }

    public void drawWelcomeScreen() {
        bmpList.drawSprite(0, startHeight, 1, 1, Sprite.W, foreground, foreground);
        bmpList.drawSprite(6, startHeight, 1, 1, Sprite.e, foreground, foreground);
        bmpList.drawSprite(12, startHeight, 1, 1, Sprite.l, foreground, foreground);
        bmpList.drawSprite(18, startHeight, 1, 1, Sprite.c, foreground, foreground);
        bmpList.drawSprite(24, startHeight, 1, 1, Sprite.o, foreground, foreground);
        bmpList.drawSprite(30, startHeight, 1, 1, Sprite.m, foreground, foreground);
        bmpList.drawSprite(36, startHeight, 1, 1, Sprite.e, foreground, foreground);
        bmpList.drawSprite(45, startHeight, 1, 1, Sprite.t, foreground, foreground);
        bmpList.drawSprite(51, startHeight, 1, 1, Sprite.o, foreground, foreground);
        bmpList.drawSprite(60, startHeight, 1, 1, Sprite.D, foreground, foreground);
        bmpList.drawSprite(66, startHeight, 1, 1, Sprite.o, foreground, foreground);
        bmpList.drawSprite(72, startHeight, 1, 1, Sprite.m, foreground, foreground);
        bmpList.drawSprite(78, startHeight, 1, 1, Sprite.S, foreground, foreground);
        bmpList.drawSprite(84, startHeight, 1, 1, Sprite.u, foreground, foreground);
        bmpList.drawSprite(90, startHeight, 1, 1, Sprite.n, foreground, foreground);
        System.out.print(bmpList.get());
        System.out.print(bmpSel.get());
    }

    public void draw() {
        initialize();
        System.out.print(bmpList.get());
        System.out.print(bmpSel.get());
    }
}
