package main.validation;
import java.util.Stack;
public class ParenthesisCheck {
    public void checkBalancedParentesis(String expr) {
        try {
            if(expr=="")
            {
                throw new MyException("Provide an Expression");
            }
            if (expr.isEmpty())
                return;
            Stack<Character> stack = new Stack<Character>();
            for (int i = 0; i < expr.length(); i++) {
                char current = expr.charAt(i);
                if (current == '{' || current == '(' || current == '[') {
                    stack.push(current);
                }
                if (current == '}' || current == ')' || current == ']') {
                    if (stack.isEmpty())
                        throw new MyException("Parenthesis Not Balanced");
                    char last = stack.peek();
                    if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[')
                        stack.pop();
                    else
                        throw new MyException("Parenthesis Not Balanced");
                }
            }
            if (stack.isEmpty()) {
                return;
            } else {
                throw new MyException("Parenthesis Not Balanced");
            }
        } catch (MyException ex) {
            System.out.println("\nInvalid Expression");
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }
}

