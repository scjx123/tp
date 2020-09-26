package visualize;

public class ColoredString {

    private String string;
    private Color foreColor;
    private Color backColor;

    public ColoredString(String string) {
        setString(string);
        if (!string.equals(Sprite.IGNORE)) {
            setForeColor(Color.White);
            setBackColor(Color.Black);
        }
    }

    public void setString(String string) {
        this.string = string;
    }

    public void setForeColor(Color color) {
        foreColor = color;
    }

    public void setBackColor(Color color) {
        backColor = color;
    }

    public void bold() {
        string = "\u001b[1m" + string;
    }

    public void underline() {
        string = "\u001b[4m" + string;
    }

    public void reversedColor() {
        string = "\u001b[7m" + string;
    }

    public ColoredString subString(int start, int end) {
        ColoredString output = new ColoredString(string.substring(start, end));
        output.setForeColor(foreColor);
        output.setBackColor(backColor);
        return output;
    }

    public String get() {
        String strForeColor = "";
        String strBackColor = "";
        if (foreColor != null) {
            strForeColor = "\u001b[38;5;" + foreColor.code + "m";
        }
        if (backColor != null) {
            strBackColor = "\u001b[48;5;" + backColor.code + "m";
        }
        return strForeColor + strBackColor + string.replace(Sprite.IGNORE, Sprite.SPACE) + "\u001b[0m";
    }
}
