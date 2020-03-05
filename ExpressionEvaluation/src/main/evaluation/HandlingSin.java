package main.evaluation;
import java.lang.Math;
public  class HandlingSin implements Evaluator {
    double rhs;
    public HandlingSin( double rhs) {
        this.rhs = rhs;
    }
    public double evaluate() {
        double val = Math.sin(this.rhs);
        return val;
    }
}