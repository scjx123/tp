package visualize;

public enum Sprite {

    SQUARE("+",1,1),
    HOLLOWSQUARE("++++`++++",3,3),
    ZERO("++++`++`++`++++",3,5),
    ONE("``+``+``+``+``+",3,5),
    TWO("++++`+`+`+``+++",3,5);

    public static final String IGNORE = "`";
    public static final String SPACE = " ";
    private final String SPRITE;
    public int width, height;

    Sprite(String sprite, int width, int height) {
        SPRITE = sprite;
        this.width = width;
        this.height = height;
    }

    public String toString() {
        return SPRITE;
    }
}
