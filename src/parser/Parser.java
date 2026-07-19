package parser;

import java.util.*;
import ast.*;
import ast.expression.StringLiteral;
import ast.statement.PrintNode;
import lexer.*;
import util.Error;

public class Parser {

    Node curNode;
    ProgramNode program;
    boolean inSystem = false;
    int pgrCnt;

    public void parse(List<Token> tokens) {
        program = new ProgramNode();
        curNode = program;
        pgrCnt = 0;
        for (Token token : tokens) {
            switch (token.type) {
                case Token.Type.SYSTEM -> {
                    inSystem = true;
                }
                case Token.Type.PRINT, Token.Type.PRINTLN -> {
                    if (inSystem) {
                        inSystem = !inSystem;
                        makeCur(new PrintNode(null));
                    } else {
                        new Error("Unknown method");
                    }
                }
                case Token.Type.STRING -> {
                    makeCur(new StringLiteral(token.value));
                }
            }
        }
    }

    private void makeCur(Node node) {
        curNode.addChild(node);
        curNode = curNode.getChild(pgrCnt);
        pgrCnt = 0;
    }
}
