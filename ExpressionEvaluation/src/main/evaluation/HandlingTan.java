package main.evaluation;
import java.lang.Math;
public  class HandlingTan implements Evaluator {
    double rhs;
    public HandlingTan( double rhs) {
        this.rhs = rhs;
    }
    public double evaluate() {
        double val = Math.tan(this.rhs);
        return val;
    }
}