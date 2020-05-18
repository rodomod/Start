/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package own.pars;

import java.util.ArrayList;
import java.util.List;
import own.pars.ast.BinaryPolisy;
import own.pars.ast.NumberPolisy;
import own.pars.ast.UnaryPolisy;
import own.pars.ast.Polisy;

/**
 *
 * @author odministrator
 */
public final class Parser {
    private static final Token EXITOF =new Token(TokenType.EXITOF,"");
    private final List<Token> tokens;
    private int pos;
    private final int size;
public Parser(List<Token> tokens) {
        this.tokens = tokens;
        size=tokens.size();
          }
public List<Polisy> parse() {
      final List<Polisy> result = new ArrayList<>();
      while(!match(TokenType.EXITOF)){
          result.add(polisy());
      }
        return result;
    }
private Polisy polisy(){
      return binary();
      }
private Polisy binary(){
      Polisy result = mullary();
      while(true){
    if(match(TokenType.SUMM)){
              result=new BinaryPolisy('+',result,mullary());
              continue;
          }
    if(match(TokenType.SUB)){
              result=new BinaryPolisy('-',result,mullary());
              continue;
          }
          break;
      }
      return result;
      }
private Polisy mullary(){
      Polisy result=unary();
      while(true){
    if(match(TokenType.MULL)){
    result=new BinaryPolisy('*',result,unary());
              continue;
          }
    if(match(TokenType.DIVIDE)){
              result=new BinaryPolisy('/',result,unary());
              continue;
          }
          break;
      }
      return result;
      }
private Polisy unary(){
    if(match(TokenType.SUB)){
          return new UnaryPolisy('-',primary());
      }
    if(match(TokenType.SUMM)){
          return primary();
      }
      return primary();
        }
private Polisy primary(){
      final Token current=get(0);
    if(match(TokenType.NUMBER)){
          return new NumberPolisy(Double.parseDouble(current.getText()));
               }
    if (match(TokenType.HEX_NUMBER)) {
            return new NumberPolisy(Long.parseLong(current.getText(), 16));
        }
    if (match(TokenType.LPAR)) {
            Polisy result = polisy();
            match(TokenType.PPAR);
            return result;
                }
      throw new RuntimeException("Unknoun expression");
       }
private boolean match(TokenType type) {
      final Token current=get(0);
    if(type !=current.getType())return false;
    pos++;
    return true;
        }
private Token get(int realPosition) {
      final int position = pos + realPosition;
    if(position >= size) return EXITOF;
      return tokens.get(position);
    }
}
