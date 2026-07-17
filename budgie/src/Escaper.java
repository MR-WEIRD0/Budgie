import java.util.*;

public class Escaper {

    HashMap<Character, Character> escapes = new HashMap<>();

    public String escape(String str) {
        StringBuilder newStr = new StringBuilder();
        boolean escaping = false;

        for (char c : str.toCharArray()) {
            if (c == '\\' && !escaping) {
                escaping = true;
            } else if (escapes.containsKey(c) && escaping) {
                newStr.append(escapes.get(c));
                escaping = false;
            } else {
                newStr.append(c);
            }
        }

        return newStr.toString();
    }

    public Escaper() {
        escapes.put('n', '\n');
        escapes.put('t', '\t');
        escapes.put('\\', '\\');
        escapes.put('"', '"');
        escapes.put('\'', '\'');
        escapes.put('s', ' ');
        escapes.put('b', '\b');
        escapes.put('r', '\r');
    }
}