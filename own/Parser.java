import java.util.ArrayList;
import java.util.List;

public final class Parser {
    private static final Token EXIT =new Token(TokenType.EXIT,"");
    private final List<Token> tokens;
    private int num;
    private final int size;
public Parser(List<Token> tokens) {
        this.tokens = tokens;
        size=tokens.size();
          }
public List<Polisy> parse() {
      final List<Polisy> result = new ArrayList<>();
      while(!match(TokenType.EXIT)){
          result.add(polisy());
      }
        return result;
    }
private Polisy polisy(){
      return binary();
      }
private Polisy binary(){
      Polisy result = ownary();
      while(true){
          if(match(TokenType.SUM)){
              result=new BinaryPolisy('+',result, ownary());
              continue;
          }
          if(match(TokenType.SUB)){
              result=new BinaryPolisy('-',result, ownary());
              continue;
          }
          break;
      }
      return result;
      }
private Polisy ownary(){
      Polisy result= unary();
      while(true){
    if(match(TokenType.MUL)){
    result=new BinaryPolisy('*',result, unary());
              continue;
          }
          if(match(TokenType.DIV)){
              result=new BinaryPolisy('/',result, unary());
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
      if(match(TokenType.SUM)){
          return primary();
      }
      return primary();
        }
private Polisy primary(){
      final Token current=get(0);
      if(match(TokenType.NUM)){
          return new NumberPolisy(Double.parseDouble(current.getText()));
               }
      if(match(TokenType.HEX_NUM)) {
            return new NumberPolisy(Long.parseLong(current.getText(), 16));
        }
      if(match(TokenType.LP)) {
            Polisy result = polisy();
            match(TokenType.PP);
            return result;
                }
      throw new RuntimeException("Unknoun expression");
       }
private boolean match(TokenType type) {
    final Token current=get(0);
    if(type !=current.getType())return false;
    num++;
    return true;
        }
private Token get(int col) {
      final int ix = num + col;
      if(ix >= size) return EXIT;
      return tokens.get(ix);
    }
}