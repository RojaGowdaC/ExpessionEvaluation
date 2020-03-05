package main.evaluation;
import main.tokenize.BinaryOperator;
import main.tokenize.Token;
import main.tokenize.Tokenizer;
import main.tokenize.UnaryOperator;
import main.treeCreation.Node;
import java.lang.System;
import java.util.ArrayList;

public class ExpressionEvaluator {
    ArrayList<Token> token;
   public ExpressionEvaluator(ArrayList<Token> tokenList)
    {
         token=tokenList;
    }
    BinaryOperator binaryop = new BinaryOperator();
     ArrayList<Token> binary = binaryop.operatorList();
    UnaryOperator unaryoperators = new UnaryOperator();
    ArrayList<Token> unary = unaryoperators.operatorList();

    private int toDigit(String ch) {
        return Integer.parseInt(ch);
    }
    Evaluator expr;
    public double evaluator(Node ptr) {
        if (ptr.left == null && ptr.right == null)
            return toDigit(ptr.value);
        else {


            for (int i = 0;i<token.size(); i++) {

                if(binary.contains(ptr.value))

            {double left = evaluator(ptr.left);
            double  right = evaluator(ptr.right);
            String operator = ptr.value;

                switch (operator) {
                    case "+":
                        expr = new AdditionNode(new ValueNode(left), new ValueNode(right));
                        break;
                    case "-":
                        expr = new SubtractionNode(new ValueNode(left), new ValueNode(right));
                        break;
                    case "*":
                        expr = new MultiplicationNode(new ValueNode(left), new ValueNode(right));
                        break;
                    case "/":
                        expr = new DivisionNode(new ValueNode(left), new ValueNode(right));
                        break;
                    case "*-":
                        expr = new MultiplyMinusNode(new ValueNode(left), new ValueNode(right));
                        break;
                    case "/-":
                        expr = new DivideMinus(new ValueNode(left), new ValueNode(right));
                        break;
                    default:
                        System.out.println("Invalid Expression");
                        break;
                }

                }
           if(unary.contains(ptr.value))
            {
                double right=evaluator(ptr.right);
                switch (ptr.value)
                {
                    case "sin":
                        expr = new HandlingSin(right);
                        break;
                    case "cos":
                        expr = new HandlingCos(right);
                        break;
                    case "tan":
                        expr = new HandlingTan(right);
                        break;
                }
            }}
                return expr.evaluate();

        }
    }}


