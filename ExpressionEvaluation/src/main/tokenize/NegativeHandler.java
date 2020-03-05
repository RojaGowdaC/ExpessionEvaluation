package main.tokenize;
import main.validation.MyException;
public class NegativeHandler {
    public  String handleNegation(String expression) {
        String newExpression = "";
        try {
            for (int i = 0; i < expression.length(); i++) {

                //handling Exceptional Cases(ex:-2)
                if (i == 0 && expression.charAt(i) == '-') {
                    newExpression = newExpression + "0" + expression.charAt(i);
                }

                //ex:+- or -+ or(-
                else if (expression.charAt(i) == '-' && ((expression.charAt(i - 1) == '+' || expression.charAt(i - 1) == '-') || expression.charAt(i - 1) == '(')) {
                    newExpression = newExpression + "0" + expression.charAt(i);
                }

                //handling Exceptional Cases(ex:++,--)
                else if (expression.charAt(i) == '+' && ((expression.charAt(i + 1) == '+')) || expression.charAt(i) == '-' && ((expression.charAt(i + 1) == '-'))) {
                    throw new MyException("Found Unusual Token in Expression");
                }
                //ex(2-*3)
                else if ((expression.charAt(i) == '-') && ((expression.charAt(i + 1) == '*'))) {
                    throw new MyException("Found Unusual Token in Expression");
                }

                //Adding Tokens to new Expression
                else {
                    newExpression = newExpression + expression.charAt(i);
                }
            }
        }
        //catch block
        catch (MyException ex) {
            System.out.println("\nInvalid Expression");
            System.out.println(ex.getMessage());
            System.exit(0);
        }
        //Printing new Expression
        System.out.println(newExpression);
        return newExpression;
    }
}

