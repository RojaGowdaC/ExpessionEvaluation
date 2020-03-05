package main.validation;
import java.util.ArrayList;
import java.util.regex.Pattern;
import main.tokenize.Token;
import main.tokenize.BinaryOperator;
import main.tokenize.UnaryOperator;
public class ExpressionValidation{
    UnaryOperator unaryoperators = new UnaryOperator();
    ArrayList<Token> unary = unaryoperators.operatorList();
    public void validate(ArrayList<Token> tokenList) {
        String last = tokenList.get(tokenList.size() - 1).getName();
        try {
             for (Token each : tokenList) {

                if (Pattern.matches("[a-zA-Z]*", each.getName()) || Pattern.matches("[\\@\\$\\%\\=\\<\\>\\^]", each.getName()) ) {
                    if(!unary.contains(each.getName()))
                    {
                        throw new MyException("Found Unusual Token in Expression");
                    }

                }
            }
        } catch (MyException ex) {
            System.out.println("\nInvalid Expression");
            System.out.println(ex.getMessage());
            System.exit(0);
        }

    }
}




