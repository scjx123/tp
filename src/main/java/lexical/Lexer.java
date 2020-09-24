package lexical;

import java.util.List;
import java.util.ArrayList;
import constants.Constants;

public class Lexer {

    public String getCommand(String s, int i) {
        int j = i;
        while (j < s.length()) {
            if (Character.isLetter(s.charAt(j))) {
                j++;
            } else {
                break;
            }
        }
        return s.substring(i, j);
    }

    public String getAtom(String s, int i) {
        int j = i;
        while (j < s.length()) {
            char c = s.charAt(j);
            if (c != Constants.SPACE && c != Constants.CMD_END) {
                j++;
            } else {
                break;
            }
        }
        return s.substring(i, j);
    }

    public List<Token> analyze(String input) {
        List<Token> result = new ArrayList<>();
        String inString = input.trim();
        boolean isCommand = true;
        for (int i = 0; i < inString.length(); ) {
            char c = inString.charAt(i);
            switch (c) {
            case Constants.LPAREN:
                result.add(new Token(Types.LPA, c));
                i++;
                break;
            case Constants.RPAREN:
                result.add(new Token(Types.RPN, c));
                i++;
                break;
            case Constants.SPACE:
                i++;
                break;
            case Constants.PARAM:
                i++;
                String command = getCommand(inString, i);
                i += command.length(); //skip away the rest of the commands
                result.add(new Token(Types.PAR, command));
                break;
            case Constants.CMD_END:
                result.add(new Token(Types.END, c));
                i++;
                isCommand = true;
                break;
            default:    //atom or cmd
                String atom = getAtom(inString, i);
                i += atom.length();
                if (isCommand) {
                    result.add(new Token(Types.COM, atom));
                    isCommand = false;
                } else {
                    result.add(new Token(Types.STR, atom));
                }
                break;
            }
        }
        return result;
    }

}