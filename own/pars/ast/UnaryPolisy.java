/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package own.pars.ast;

/**
 *
 * @author odministrator
 */
public class UnaryPolisy implements Polisy {
        public final Polisy ps;
        public final char operation;

public UnaryPolisy(char operation, Polisy ps) {
        this.operation = operation;
        this.ps = ps;
    }
       @Override
public double eval() {
        switch (operation) {
            case '-': return -ps.eval();
            case '+':
               default: return ps.eval();
        }
    }
    @Override
public String toString(){
        return String.format("%c%s",operation,ps);
    }
    
}
