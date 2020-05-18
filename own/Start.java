/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package own;

import java.util.List;
import own.pars.Lexer;
import own.pars.Parser;
import own.pars.Token;
import own.pars.ast.Polisy;


/**
 *
 * @author odministrator
 */
public final class Start {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
            final String str1 ="(#f00000/#ffff00)+2.0*6.0+3.0";
            final String str2 ="(#Cafe/3.13*3.13)-3.13/3.13";
     final List <Token> tokens = new Lexer(str1+str2).lexser();
   for(Token token : tokens) {
       System.out.println(token);
    
        }
      final List <Polisy> polisy = new Parser(tokens).parse();
   for(Polisy ps : polisy) {
       System.out.println(ps + " = " + ps.eval());
        }
    }
}

   

