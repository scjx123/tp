package lexical;

import command.Command;
import command.Parameter;
import constants.Constants;
import constants.HelpText;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    private List<List<Token>> splitList(
            List<Token> input, Types key, boolean isKeepKey) {
        int i = 0;
        int lastIndex = 0;
        List<List<Token>> output = new ArrayList<>();
        List<Token> target = new ArrayList<>();
        output.add(target); //output is a list that contains a list of target.
        while (i < input.size()) {
            Token token = input.get(i); //get each token
            if (token.token.equals(key)) { //if key== Types.END, then this is end of line.
                if (output.get(lastIndex).size() > 0) { //if the last index of output is not empty
                    output.add(new ArrayList<>()); //create a new list .
                    lastIndex++; //last index becomes 1
                }
                if (isKeepKey) {
                    output.get(lastIndex).add(token);
                }
            } else {
                output.get(lastIndex).add(token);
            }
            i++;
        }
        output.removeIf(tokenList -> tokenList == null || tokenList.size() == 0);
        return output;
    }

    public List<Command> parseTree(List<Token> input) {
        //trying to detect each semicolon and split commands commands into separate list
        List<List<Token>> splitCommands = splitList(input, Types.END, false);
        List<Command> output = new ArrayList<>();
        for (List<Token> tokenList: splitCommands) { //for each string command,
            int i = 0;
            while (i < tokenList.size()) {
                if (tokenList.get(i).token.equals(Types.COM)) { //locate the command type.
                    break;
                } else {
                    i++;
                }
            }
            Token head = tokenList.get(i); //store command as head
            Command command = getCommand(head.string); //match command
            tokenList.remove(head); //remove head and move on to the next string.
            List<List<Token>> splitParams = splitList(tokenList, Types.PAR, true);
            for (List<Token> paramList: splitParams) {
                command.updateParams(paramList); //give the command, a list of remaining of the string
            }
            output.add(command);
        }
        return output;
    }

    public static Command getCommand(String name) {
        ArrayList<Container> content1 = new ArrayList<>();//eg. -mod
        ArrayList<Container> content2 = new ArrayList<>();//eg. -mod
        ArrayList<Container> content3 = new ArrayList<>();//eg. -mod
        ArrayList<Container> atoms = new ArrayList<>();//eg. -mod
        ArrayList<Parameter> params = new ArrayList<>();//eg. option
        switch (name) {
        case Constants.NEXT:
            content1.add(new Container("i", Constants.DEFAULT));
            content1.add(new Container("s", Constants.EMPTY));
            content1.add(new Container("a", Constants.EMPTY));
            content1.add(new Container("help", Constants.EMPTY));
            params.add(new Parameter("option", content1));
            return new Command(HelpText.NEXT, params); //break unreachable
        case Constants.PREV:
            content1.add(new Container("i", Constants.DEFAULT));
            content1.add(new Container("s", Constants.EMPTY));
            content1.add(new Container("a", Constants.EMPTY));
            content1.add(new Container("help", Constants.EMPTY));
            params.add(new Parameter("option", content1));
            return new Command(HelpText.PREV, params); //break unreachable
        case Constants.SEL:
            content1.add(new Container("s", Constants.DEFAULT));
            content1.add(new Container("m", Constants.EMPTY));
            content1.add(new Container("help", Constants.EMPTY));
            params.add(new Parameter("option", content1));
            atoms.add(new Container(Constants.LINE_UNIT, Constants.EMPTY));
            params.add(new Parameter(Constants.ATOMIC, atoms));
            return new Command(HelpText.SEL, params); //break unreachable
        case Constants.ADD: //all the possible contents for 'add' will be put in here
            content1.add(new Container("s", Constants.DEFAULT));
            content1.add(new Container("m", Constants.EMPTY));
            content1.add(new Container("help", Constants.EMPTY));
            params.add(new Parameter("option", content1)); //under 'options' it contains s,m,help
            content2.add(new Container("mod", Constants.EMPTY));
            content2.add(new Container("task", Constants.EMPTY));
            content2.add(new Container("help", Constants.DEFAULT));
            params.add(new Parameter("type", content2)); //under 'type', it contains, mod,task,help
            atoms.add(new Container(Constants.LINE_UNIT, Constants.EMPTY)); //instantiate atoms.
            params.add(new Parameter(Constants.ATOMIC, atoms)); //add atoms into parameters.
            return new Command(HelpText.ADD, params); //break unreachable
        case Constants.MC:
            content1.add(new Container("c", Constants.DEFAULT));
            content1.add(new Container("p", Constants.EMPTY));
            content1.add(new Container("help", Constants.EMPTY));
            params.add(new Parameter("option", content1));
            content2.add(new Container("t", Constants.DEFAULT));
            content2.add(new Container("d", Constants.EMPTY));
            params.add(new Parameter("details", content2));
            atoms.add(new Container(Constants.LINE_UNIT, Constants.EMPTY));
            params.add(new Parameter(Constants.ATOMIC, atoms));
            return new Command(HelpText.MC, params); //break unreachable
        case Constants.LIST:
            content1.add(new Container("mod", Constants.EMPTY));
            content1.add(new Container("task", Constants.EMPTY));
            content1.add(new Container("cmd", Constants.EMPTY));
            content1.add(new Container("all", Constants.EMPTY));
            content1.add(new Container("help", Constants.DEFAULT));
            params.add(new Parameter("option", content1));
            content2.add(new Container("all", Constants.DEFAULT));
            content2.add(new Container("sel", Constants.EMPTY));
            params.add(new Parameter("range", content2));
            atoms.add(new Container(Constants.LINE_UNIT, Constants.EMPTY));
            params.add(new Parameter(Constants.ATOMIC, atoms));
            return new Command(HelpText.LIST, params); //break unreachable
        default:
            return new Command(HelpText.LIST, params);
        }
    }

}
