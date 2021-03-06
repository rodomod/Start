package own;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Lexer {
    public static List<Token> lexser(String str) {
        return new Lexer(str).lexser();
           }
    
    private static final String OPERATOR_CHAR = "+-*/()";
    
    private static final Map<String, TokenType> OPERATOR;
            static {
        OPERATOR = new HashMap<>();
        OPERATOR.put("+", TokenType.SUMM);
        OPERATOR.put("-", TokenType.SUB);
        OPERATOR.put("*", TokenType.MULL);
        OPERATOR.put("/", TokenType.DIVIDE);
        OPERATOR.put("(", TokenType.LPAR);
        OPERATOR.put(")", TokenType.PPAR);
                 }
    
    private final  String str;
    private final  int length;
    private final  List<Token> tokens;
    private final  StringBuilder buffer;
    private int pos;
public Lexer(String str) {
        this.str = str;
        length = str.length();
        tokens = new ArrayList<>();
        buffer = new StringBuilder();
         }
public List<Token> lexser() {
        while(pos < length) {
            final char current = peek(0);
            if(Character.isDigit(current)) lexserNumber();
           else if(current == '#') {
                next();
                lexserHexNumber();
            }
            else if(OPERATOR_CHAR.indexOf(current) != -1) {
                lexserOperator();
            }else{
            next();
            }
        }
        return tokens;
    }
private void lexserNumber() {
        clearBuffer();
        char current = peek(0);
        if(current == '0' && (peek(1) == 'x' || (peek(1) == 'X'))) {
            next();
            next();
            lexserHexNumber();
            return;
              }
        while(true) {
            if(current == '.') {
            if(buffer.indexOf(".") != -1);
            }else if(!Character.isDigit(current)) {
                break;
            }
            buffer.append(current);
            current = next();
            }
        addToken(TokenType.NUMBER, buffer.toString());
          }
private void lexserHexNumber() {
        clearBuffer();
        char current = peek(0);
        while (isHexNumber(current) || (current == '_')) {
            if(current != '_') {
           buffer.append(current);
            }
            current = next();
        }
        if(buffer.length() > 0) {
            addToken(TokenType.HEX_NUMBER, buffer.toString());
        }
    }
private static boolean isHexNumber(char current) {
        return Character.isDigit(current)
                || ('a' <= current && current <= 'f')
                || ('A' <= current && current <= 'F');
                     }
private void lexserOperator() {
        char current = peek(0);
        if(current == '/') {
        if(peek(1) == '/') {
                next();
                next(); return;
       }else if(peek(1) == '*') {
                next();
                next(); return;
            }
        }
        clearBuffer();
        while(true) {
    final String text = buffer.toString();
       if(!text.isEmpty() && !OPERATOR.containsKey(text + current)) {
                addToken(OPERATOR.get(text));
                return;
                }
            buffer.append(current);
            current = next();
             }
    }
private void clearBuffer() {
        buffer.setLength(0);
    }
private char next() {
        pos++;
             return peek(0);                        
    }
private char peek(int realPosition) {
        final int position = pos + realPosition;
        if(position >= length) return '\0';
        return str.charAt(position);
    }
private void addToken(TokenType type) {
        addToken(type, "");
    }
private void addToken(TokenType type, String text) {
        tokens.add(new Token(type, text));
    }
}
