package main.evaluation;
import java.lang.Math;
public  class HandlingCos implements Evaluator {
    double rhs;
    public HandlingCos( double rhs) {
        this.rhs = rhs;
    }
    public double evaluate() {
        double val = Math.cos(this.rhs);
        return val;
    }
}