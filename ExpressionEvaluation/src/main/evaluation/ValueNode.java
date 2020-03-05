package main.evaluation;
public final class ValueNode implements Evaluator {
    private final double value;
    public ValueNode(final double value) {
        this.value = value;
    }
    public double evaluate() {
        return this.value;
    }
}

