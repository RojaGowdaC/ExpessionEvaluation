package main.evaluation;
public class AdditionNode implements Evaluator {
    private final Evaluator lhs;
    private final Evaluator rhs;
    public AdditionNode(final Evaluator lhs, final Evaluator rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }
    public double evaluate() {
        return this.lhs.evaluate() + this.rhs.evaluate();
    }
}