package compiler;

import java.io.*;
import java.util.*;
import util.*;
import lexer.*;

public class Compiler {

    public void compile(List<Token> tokens, String name) throws IOException {
        try (OutputStream output = new BufferedOutputStream(new FileOutputStream(name + ".bb"))) {
            for (Token token : tokens) {
                switch (token.type) {
                    case Token.Type.PRINT -> {
                        output.write(Opcodes.PRINT);
                    }
                    case Token.Type.PRINTLN -> {
                        output.write(Opcodes.PRINT);
                    }
                    case Token.Type.VAR -> {
                        output.write(Opcodes.INT);
                    }
                    case Token.Type.STRING -> {
                        output.write(Opcodes.STRING);
                        output.write(token.value.length());
                        for (int i = 0; i < token.value.length(); i++) {
                            output.write(token.value.charAt(i));
                        }
                    }
                    default -> {
                        IO.print("Undefined opcode");
                    }
                }
            }
        }
    }
}
