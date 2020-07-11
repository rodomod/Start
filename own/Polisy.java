package own;

public interface Polisy {
	    double eval();
	}
final class NumberPolisy implements Polisy {
 private final double ps;
	
public NumberPolisy(double ps) {
 this.ps = ps;
   }
@Override
public double eval() {
return ps;
  }
@Override
public String toString() {
 return Double.toString(ps);
       }
  }
final class BinaryPolisy implements Polisy {
	
private final Polisy ps1,ps;
private final char operator;
	
public BinaryPolisy(char operator, Polisy ps1, Polisy ps) {
this.operator = operator;
this.ps1 = ps1;
this.ps = ps;
    }
@Override
public double eval() {
 switch(operator){
     case '-': return ps1.eval() - ps.eval();
     case'*' : return ps1.eval() * ps.eval();
     case'/' : return ps1.eval() / ps.eval();
     case'+' :
         default : return ps1.eval() + ps.eval();
                }
    }
@Override
public String toString(){
return String.format("(%s%c%s)", ps1,operator,ps);
      }
  }
final class UnaryPolisy implements Polisy {
	private final Polisy ps;
private final char operator;
	
public UnaryPolisy(char operator, Polisy ps) {
    this.operator = operator;
    this.ps = ps;
     }
   @Override
public double eval() {
    switch (operator) {
        case '-': return -ps.eval();
        case '+':
           default: return ps.eval();
        }
   }
@Override
public String toString(){
    return String.format("%c%s",operator,ps);
          }
  }	