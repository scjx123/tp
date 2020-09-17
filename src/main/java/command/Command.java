package command;

import constants.Constants;
import constants.HelpText;
import lexical.Container;
import lexical.Token;
import lexical.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Command extends Parameter implements Help {

    private final String description;
    private final String[] syntax;
    private final String[] usages;
    private final HelpText helpText;
    private ArrayList<Parameter> content;

    public Command(HelpText text, ArrayList<Parameter> values) {
        super(text.name);
        this.content = values;
        this.description = text.description;
        this.syntax = text.syntax;
        this.usages = text.usages;
        helpText = text;
    }

    public void changeContent(HashMap<String, ArrayList<String>> newContent) {
        for (Parameter p: content) {
            p.changeContent(newContent);
        }
    }

    public void updateParams(List<Token> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        Parameter p = null; // the atomic parameter of the command
        for (Parameter par: content) {
            if (par.name.equals(Constants.ATOMIC)) {
                p = par;
            }
        }
        Token head = list.get(0);
        list.remove(head);
        if (head.token.equals(Types.PAR)) { // starts with parameter
            if (list.size() == 0) { // par without container
                for (Parameter parameter: content) {
                    parameter.updateContainer(head);
                }
            } else { // par with container list, update par and then put atoms
                for (Parameter parameter: content) {
                    parameter.updateContainer(head.string, list);
                }
            }
        } else if (p != null) { // not par -> everything must be atomic
            StringBuilder strBuilder = new StringBuilder(head.string).append(Constants.SPACE);
            for (Token t: list) {
                if (!t.token.equals(Types.PAR)) {
                    strBuilder.append(t.string).append(Constants.SPACE);
                }
            }
            String atomText = strBuilder.toString();
            p.updateContainer(atomText);
        }
    }

    @Override
    public String getContentString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Parameter item : content) {
            stringBuilder.append(item.toString()).append(Constants.WIN_NEWLINE);
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        if (content == null || content.size() == 0) {
            return name + "{ }";
        }
        String[] split = getContentString().split(Constants.WIN_NEWLINE);
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : split) {
            if (str.equals("")) {
                continue;
            }
            stringBuilder.append(Constants.TAB).append(
                    str).append(Constants.WIN_NEWLINE);
        }
        return name + "{" + Constants.WIN_NEWLINE + stringBuilder.toString() + "}";
    }

    @Override
    public Command getClone() {
        return new Command(helpText, content);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String[] getSyntax() {
        return syntax;
    }

    @Override
    public String[] getUsages() {
        return usages;
    }

    @Override
    public String getHelp() {
        String output = "";
        return null;
    }
}
