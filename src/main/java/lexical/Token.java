package lexical;

public class Token {

    public Types token;
    public final String string;

    //A token is a small part of the whole command
    public Token(Types t, char c) {
        this.token = t;
        this.string = Character.toString(c);
    }

    public Token(Types t, String s) {
        this.token = t;
        this.string = s;
    }

    public void changeType(Types newType) {
        this.token = newType;
    }

    public String toString() {
        if (token == Types.STR) {
            return "STR\t<" + string + ">";
        } else if (token == Types.PAR) {
            return "PAR\t<" + string + ">";
        } else if (token == Types.COM) {
            return "COM\t<" + string + ">";
        }
        return token.toString();
    }
}