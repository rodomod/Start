public interface Polisy {
	    double cvmf();
	}
final class NumberPolisy implements Polisy {
 private final double ps;
	
public NumberPolisy(double ps) {
 this.ps = ps;
   }
@Override
public double cvmf() {
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
public double cvmf() {
 switch(operator){
     case '-': return ps1.cvmf() - ps.cvmf();
     case'*' : return ps1.cvmf() * ps.cvmf();
     case'/' : return ps1.cvmf() / ps.cvmf();
     case'+' :
         default : return ps1.cvmf() + ps.cvmf();
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
public double cvmf() {
    switch (operator) {
        case '-': return -ps.cvmf();
        case '+':
           default: return ps.cvmf();
        }
   }
@Override
public String toString(){
    return String.format("%c%s",operator,ps);
          }
  }	