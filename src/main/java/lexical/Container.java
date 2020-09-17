package lexical;

import constants.Constants;
import java.util.List;

public class Container {

    private String content;
    public String name;

    public Container(String name, String content) {
        this.content = content;
        this.name = name;
    }

    public Container(String name) {
        this.content = null;
        this.name = name;
    }

    public void changeContent(String newContent) {
        content = newContent;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void updateContent(List<Token> tokens) {
        content = "";
        for (Token t: tokens) {
            content += t.string + " ";
        }
    }

    public Container getClone() {
        return new Container(name, content);
    }

    @Override
    public String toString() {
        return name + ":" + Constants.TAB + content;
    }
}
