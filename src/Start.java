import java.util.List;
public final class Start {
public static void main(String[] args) {
            final String str1 ="(#f00000/#ffff00)+2.0*6.0+3.0";
            final String str2 ="(#Cafe/3.13*3.13)-3.13/3.13";
 final List <Token> tokens = new Lexer(str1+str2).lexser();
 for(Token token : tokens) { System.out.println(token); }
 final List <Polisy> polisy = new Parser(tokens).parse();
       for(Polisy ps : polisy) { System.out.println(ps + " = " + ps.eval()); }
    } }