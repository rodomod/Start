import java.util.List;
public final class Start {
public static void main(String[] args) {
      final String str ="#Cafe/9.1313*3.1313/2.1313-3.1313/3.1313+987.0*137.0/56.0+2.0*6.0+3.0+#f00000/#ffff00";
 final List <Token> tokens = new Lexer(str).lexser();
 for(Token token : tokens) { System.out.println(token); }
 final List <Polisy> polisy = new Parser(tokens).parse();
       for(Polisy ps : polisy) { System.out.println(ps + " = " + ps.cvmf()); }
    } }