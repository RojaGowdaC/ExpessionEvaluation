package main.evaluation;
public  class SubtractionNode implements Evaluator {
    private final Evaluator lhs;
    private final Evaluator rhs;
    public SubtractionNode(final Evaluator lhs, final Evaluator rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }
    public double evaluate() {
        return this.lhs.evaluate() - this.rhs.evaluate();
    }
}