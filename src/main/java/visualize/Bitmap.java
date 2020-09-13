package visualize;

import java.util.HashMap;

public class Bitmap {

    private ColoredString[] map;
    private int width, height;
    private HashMap<Integer, Integer> colors;
    private HashMap<Integer, Integer> textColors;

    public Bitmap(int width, int height){
        this.width = width;
        this.height = height;
        map = new ColoredString[width * height];
        for (int i = 0; i < map.length; i++) {
            map[i] = new ColoredString(Sprite.IGNORE);
        }
        colors = new HashMap<>();
        textColors = new HashMap<>();
    }

    public void setPixelColor(int x, int y, Color c) throws IndexOutOfBoundsException {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            throw new IndexOutOfBoundsException();
        }
        int index = x + y * width;
        colors.put(index , c.CODE);
        map[index].setBackColor(c);
    }

    public void flush(Color c) {
        for (int i = 0; i < map.length; i++) {
            map[i].setString(Sprite.SPACE);
            colors.put(i,c.CODE);
            textColors.put(i,c.CODE);
            map[i].setBackColor(c);
            map[i].setForeColor(c);
        }
    }

    public void setPixelText(int x, int y, String character) throws  IndexOutOfBoundsException {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            throw new IndexOutOfBoundsException();
        }
        int index = x + y * width;
        map[index].setString(character);
    }

    public void setPixelTextColor(int x, int y, Color c) throws IndexOutOfBoundsException {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            throw new IndexOutOfBoundsException();
        }
        int index = x + y * width;
        textColors.put(x + y * width , c.CODE);
        map[index].setForeColor(c);
    }

    private boolean isInRange(Point p, int width, int height) {
        boolean isXInRange = p.x >= 0 || p.x < width;
        boolean isYInRange = p.y >= 0 || p.y < height;
        return isXInRange && isYInRange;
    }

    private boolean isAllInRange(Point[] points, int width, int height) {
        boolean output = true;
        for(Point p: points){
            output = output && isInRange(p, width, height);
        }
        return output;
    }

    private void checkValidInput(int x1, int y1, int x2, int y2, String string)
            throws IndexOutOfBoundsException, NullPointerException{
        Point start = new Point(x1,y1);
        Point end = new Point(x2,y2);
        if (!isAllInRange(new Point[]{start, end}, width, height)) {
            throw new IndexOutOfBoundsException();
        }
        if (string == null) {
            throw new NullPointerException();
        }
    }

    public void drawLine(
            int x1, int y1, int x2, int y2, String string,
            Color backColor, Color foreColor)
            throws IndexOutOfBoundsException, NullPointerException {
        checkValidInput(x1, y1, x2, y2, string);
        int index = 0;
        int dx, dy, p, x, y;
        dx = x2 - x1;
        dy = y2 - y1;
        x = x1; // set x to initial value
        y = y1; // set y to initial value
        p = 2 * dy - dx; //progression of Bresenham's Line Algorithm
        while(x <= x2){
            setAttributes(string, backColor, foreColor, index, x, y);
            if (p >= 0) {
                y++;
                p = p + 2 * dy - 2 * dx;
            } else {
                p = p + 2 * dy;
            }
            x++;
            index++;
            if (index == string.length()) {
                index -= string.length();
            }
        }
    }

    private void setAttributes(String string, Color backColor, Color foreColor, int index, int x, int y) {
        String target = string.substring(index, index + 1);
        if(!target.equals(Sprite.IGNORE)){
            if(foreColor != null){
                setPixelTextColor(x,y,foreColor);
            }
            if(backColor != null){
                setPixelColor(x,y,backColor);
            }
            setPixelText(x, y, target);
        }
    }

    public void drawSprite (
            int x1, int y1, int scaleX, int scaleY, Sprite sprite,
            Color backColor, Color foreColor)
            throws IndexOutOfBoundsException, NullPointerException{
        int x2 = x1 + sprite.W * scaleX - 1;
        int y2 = y1 + sprite.H * scaleY - 1;
        checkValidInput(x1, y1, x2, y2, sprite.toString());
        if (scaleX == 0) {
            return;
        }
        int spriteX = 0, spriteY = 0;
        for (int y = y1; y <= y2; y++){
            if (y - y1 == (spriteY + 1) * scaleY){
                spriteY++;
            }
            for (int x = x1; x <= x2; x++){
                if (x - x1 == (spriteX + 1) * scaleX){
                    spriteX++;
                }
                int spriteIndex = spriteX + sprite.W * spriteY;
                String strSprite = sprite.toString();
                setAttributes(strSprite, backColor, foreColor, spriteIndex, x, y);
            }
            spriteX = 0;
        }
    }

    public String get() {
        StringBuilder strBuilder = new StringBuilder("");
        for (int i = 0; i < map.length; i++) {
            strBuilder.append(map[i].get());
            if ((i + 1) % width == 0) {
                strBuilder.append("\r\n");
            }
        }
        return strBuilder.toString();
    }
}
