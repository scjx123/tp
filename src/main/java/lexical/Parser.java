package lexical;

import command.Command;
import command.ParamNode;
import java.util.ArrayList;

public class Parser {

    public ArrayList<Command> parseTree(ArrayList<Token> input) {
        ParamNode node = new ParamNode(input);
        ArrayList<ParamNode> flattened = node.flatten();
        ArrayList<Command> commands = new ArrayList<>();
        for (ParamNode args: flattened) {
            commands.add(new Command(args));
        }
        return commands;
    }

}
