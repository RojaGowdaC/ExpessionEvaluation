package main.treeCreation;
import main.tokenize.BinaryOperator;
import main.tokenize.Token;
import main.tokenize.UnaryOperator;

import java.util.ArrayList;
import java.util.Stack;
public class  PostfixConverter
{

    BinaryOperator binaryop = new BinaryOperator();
    ArrayList<Token> binary = binaryop.operatorList();
    UnaryOperator unaryoperators = new UnaryOperator();
    ArrayList<Token> unary = unaryoperators.operatorList();

    static int precedence(String ch)
    {
        switch (ch)
        {
            case "+":
            case "-":
                return 1;

            case "*":
            case "/":
                return 2;

            case "^":
                return 3;

            case "sin":
            case "cos":
            case "tan":
              return 4;
            case "*-":
            case "/-":
                return 5;


        }
        return -1;
    }

    public  ArrayList infixtopostfix(ArrayList<Token> tokenList)
    {


        ArrayList<Token>postfixLIst=new ArrayList<>();
        Stack<Token> stack = new Stack<>();

        for (int i = 0; i<tokenList.size(); ++i)
        {

            if (!binary.contains(tokenList.get(i).getName()) && !unary.contains(tokenList.get(i).getName())) {
                postfixLIst.add(tokenList.get(i));
            }
           else if ("(".equals(tokenList.get(i).getName() ))
                stack.push(tokenList.get(i));
            else if (")".equals(tokenList.get(i).getName()))
            {
                while (!stack.isEmpty() &&  !"(".equals(stack.peek().getName()))
                    postfixLIst.add(stack.pop());

                if (!stack.isEmpty() &&  !"(".equals(stack.peek().getName()))
                    System.out.print("Invalid Expression"); // invalid expression
                else
                    stack.pop();
            }
            else
            {
                while (!stack.isEmpty() && precedence(tokenList.get(i).getName()) <= precedence(stack.peek().getName())){
                    if("(".equals(stack.peek().getName()))
                        System.out.print("Invalid Expression");
                    postfixLIst.add(stack.pop());
                }
                stack.push(tokenList.get(i));
            }

        }
        while (!stack.isEmpty()){
            if("(".equals(stack.peek().getName()))
                System.out.print("Invalid Expression");
            postfixLIst.add(stack.pop());
        }
        return postfixLIst;
    }
}