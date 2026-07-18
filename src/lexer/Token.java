package lexer;

public class Token {

    public Type type;
    public String value;

    public enum Type {
        PRINT, NUMBER, STRING, CLASS,
        IDENTIFIER, VAR, EQUALS,
        LPAREN, RPAREN, PLUS, MINUS,
        DIV, MUL, PRINTLN, DOT, SEMICOLON
    }
    
    public Token(Type type, String value) {
        this.type = type;
        this.value = value;
    }

}
 