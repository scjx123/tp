package command;

import constants.Constants;
import lexical.Container;
import lexical.Token;
import lexical.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Parameter extends Container {

    private ArrayList<Container> content;

    public Parameter(String name, ArrayList<Container> content) {
        super(name);
        this.content = content;
    }

    public Parameter(String name) {
        super(name);
        this.content = null;
    }

    @Override
    public Parameter getClone() {
        return new Parameter(name, content);
    }

    public void addContent(Container c) {
        content.add(c);
    }

    public void updateContainer(Token t) {
        for (Container container: content) {
            if (container.name.equals(t.string)) {
                container.changeContent(Constants.DEFAULT);
            } else {
                container.changeContent(Constants.EMPTY);
            }
        }
    }

    public void updateContainer(String name, List<Token> tokens) {
        for (Container c: content) {
            if (c.name.equals(name)) {
                c.updateContent(tokens);
            } else {
                c.changeContent(Constants.EMPTY);
            }
        }
    }

    public void updateContainer(String atomicName) {
        for (Container c: content) {
            if (c.name.equals(Constants.LINE_UNIT)) {
                c.changeContent(atomicName);
            } else {
                c.changeContent(Constants.EMPTY);
            }
        }
    }

    public void changeContent(ArrayList<String> containerNames) {
        for (String str: containerNames) {
            for (Container c: content) {
                if (c.name.equals(str)) {
                    c.changeContent(Constants.DEFAULT);
                } else {
                    c.changeContent(Constants.EMPTY);
                }
            }
        }
    }

    public void changeContent(HashMap<String, ArrayList<String>> containerNames) {
        for (String key: containerNames.keySet()) {
            for (Container c: content) {
                if (c.name.equals(key)) {
                    c.changeContent(Constants.DEFAULT);
                } else {
                    c.changeContent(Constants.EMPTY);
                }
            }
        }
    }

    public String getContentString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < content.size(); i++) {
            Container item = content.get(i);
            stringBuilder.append(Constants.TAB).append(
                    item.toString()).append(Constants.WIN_NEWLINE);
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        if (content == null || content.size() == 0) {
            return name + "{ }";
        } else {
            return name + "{" + Constants.WIN_NEWLINE + getContentString() + "}";
        }
    }
}
