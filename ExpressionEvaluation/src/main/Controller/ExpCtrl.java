package main.Controller;
import main.evaluation.ExpressionEvaluator;
import main.tokenize.NegativeHandler;
import main.tokenize.Token;
import main.tokenize.Tokenizer;
import main.treeCreation.ExpressionTree;
import main.treeCreation.PostfixConverter;
import main.validation.ExpressionValidation;
import java.util.ArrayList;
import main.validation.ParenthesisCheck;

public class ExpCtrl {
    public void evaluateExp(String expression) {

        //Handling Exceptional Cases
        NegativeHandler negative=new NegativeHandler();
        expression= negative.handleNegation(expression);
        ParenthesisCheck check=new ParenthesisCheck();
        check.checkBalancedParentesis(expression);

        //Tokenize Expression
        Tokenizer obj = new Tokenizer();
        obj.Tokenize(expression);
        ArrayList<Token> tokenList = obj.getTokenList();

        //Validate Expression
        ExpressionValidation validate=new ExpressionValidation();
        validate.validate(tokenList);


        //Convert Expression to postfix
        ArrayList<Token> postfix = new ArrayList<>();
        PostfixConverter exp = new PostfixConverter();
        postfix = exp.infixtopostfix(tokenList);
        System.out.println("\nPostfix Expression");
        for (Token each : postfix) {
            System.out.print(each.getName() + " ");
        }
        System.out.println("");


        //Convert Postfix Expression to Tree
        ExpressionTree et = new ExpressionTree();
        System.out.println("Inorder Traversal of Tree");
        et.constructTree(postfix);

        //Evaluate Postfix Expression
        ExpressionEvaluator Eva=new ExpressionEvaluator(tokenList);
        System.out.println("\n\nEvaluated Result : "+Eva.evaluator(et.getroot()));
    }
}




