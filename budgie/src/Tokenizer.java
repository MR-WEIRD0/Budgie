import java.util.*;

public class Tokenizer {

    private String input;
    private int pos;
    private boolean endWithLN;
    private final char[] escapeableChars = {'n', 't', '\\', '"', '\'', 's', 'b', 'r'};

    public List<Token> tokenize(String input) {
        this.input= input;
        List<Token> tokens = new ArrayList<>();
        pos = 0;
        endWithLN = false;
        Escaper escaper = new Escaper();


        while (pos < input.length()) {
            char current = input.charAt(pos);

            if (Character.isWhitespace(current)) {
                pos++;
                continue;
            }

            if (Character.isLetter(current)) {
                String word = read();

                switch (word) {
                    case "print" -> {
                        tokens.add(new Token(Token.Type.PRINT, word));
                    }
                    case "println" -> {
                        tokens.add(new Token(Token.Type.PRINTLN, word));
                        endWithLN = true;
                    }
                    case "int" -> {
                        tokens.add(new Token(Token.Type.VAR, word));
                    }
                    default -> {
                        tokens.add(new Token(Token.Type.IDENTIFIER, word));
                    }
                }
                continue;
            }

            if (Character.isDigit(current)) {
                tokens.add(new Token(Token.Type.NUMBER, read()));
                continue;
            }

            if (current == '"') {
                if (endWithLN) {
                    tokens.add(new Token(Token.Type.STRING, escaper.escape(readString()) + "\n"));
                    endWithLN = false;
                } else {
                    tokens.add(new Token(Token.Type.STRING, escaper.escape(readString())));
                }
                continue;
            }

            if (current == '#') {
                while (pos < input.length() && input.charAt(pos) != '\n') {
                    pos++;
                }
                continue;
            }

            switch (current) {
                case '(' -> {
                    tokens.add(new Token(Token.Type.LPAREN, "("));
                }
                case ')' -> {
                    tokens.add(new Token(Token.Type.RPAREN, ")"));
                }
                case '=' -> {
                    tokens.add(new Token(Token.Type.EQUALS, "="));
                }
                case '-' -> {
                    tokens.add(new Token(Token.Type.MINUS, "-"));
                }
                case '+' -> {
                    tokens.add(new Token(Token.Type.PLUS, "+"));
                }
                case '/' -> {
                    tokens.add(new Token(Token.Type.DIV, "/"));
                }
                case '*' -> {
                    tokens.add(new Token(Token.Type.MUL, "*"));
                }
                case '.' -> {
                    tokens.add(new Token(Token.Type.DOT, "."));
                }
                case ';' -> {
                    tokens.add(new Token(Token.Type.SEMICOLON, ";"));
                }
                default -> {
                    new Error("Unexpected character " + current + " was found at position" + pos);
                }
            }

            pos++;

        }

        return tokens;

    }

    public String read() {

        int start = pos;

        while (pos < input.length() && Character.isLetterOrDigit(input.charAt(pos))) {
            pos++;
        }

        return input.substring(start, pos);
    }

    public String readString() {

        pos++;

        int start = pos;

        while (pos < input.length() && input.charAt(pos) != '"') {
            pos++;
            if (input.charAt(pos) == '\\' && input.length() > pos + 2) {
                int num = 0;
                for (char c : escapeableChars) {
                    if (c != input.charAt(pos + 1)) {
                        num++;
                    }
                }
                if (num == escapeableChars.length) {
                    new Error("Unescapable character attempted to be escaped: " + input.charAt(pos + 1));
                }
                pos++;
                pos++;
            }
            if (pos >= input.length()) {
                new Error("Unterminated string");
            }
        }

        pos++;

        return input.substring(start, pos-1);
    }
}
