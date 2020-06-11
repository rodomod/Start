public interface Polisy {
	    double eval();
	}
final class NumberPolisy implements Polisy {
 private final double s;
	
public NumberPolisy(double s) {
 this.s = s;
   }
@Override
public double eval() {
return s;
  }
@Override
public String toString() {
 return Double.toString(s);
       }
  }
final class BinaryPolisy implements Polisy {
	
private final Polisy s1,sy;
private final char operation;
	
public BinaryPolisy(char operation, Polisy s1, Polisy sy) {
this.operation = operation;
this.s1 = s1;
this.sy = sy;
    }
@Override
public double eval() {
 switch(operation){
     case '-': return s1.eval() - sy.eval();
     case'*' : return s1.eval() * sy.eval();
     case'/' : return s1.eval() / sy.eval();
     case'+' :
         default : return s1.eval() + sy.eval();
                }
    }
@Override
public String toString(){
return String.format("(%s%c%s)", s1,operation,sy);
      }
  }
final class UnaryPolisy implements Polisy {
	private final Polisy sd;
private final char operation;
	
public UnaryPolisy(char operation, Polisy sd) {
    this.operation = operation;
    this.sd = sd;
     }
   @Override
public double eval() {
    switch (operation) {
        case '-': return -sd.eval();
        case '+':
           default: return sd.eval();
        }
   }
@Override
public String toString(){
    return String.format("%c%s",operation,sd);
          }
  }	