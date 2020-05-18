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
public final class NumberPolisy implements Polisy {
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
