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
public final class BinaryPolisy implements Polisy {
            private final Polisy psy,ps;
            private final char operation;

public BinaryPolisy(char operation, Polisy psy, Polisy ps) {
        this.operation = operation;
        this.psy = psy;
        this.ps = ps;
          }
       @Override
public double eval() {
         switch(operation){
             case '-': return psy.eval() - ps.eval();
             case'*' : return psy.eval() * ps.eval();
             case'/' : return psy.eval() / ps.eval();
             case'+' :
                 default : return psy.eval() + ps.eval();
                        }
            }
        @Override
public String toString(){
        return String.format("(%s%c%s)", psy,operation,ps);
    }
  }
