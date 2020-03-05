package main.tokenize;
import java.util.ArrayList;
public class Tokenizer {
    ArrayList<Token> tokenList=new ArrayList<Token>();
    public void  Tokenize(String expression)
        {
            String token = "";
                String val = "";
                for (int i = 0; i < expression.length(); i++) {

                    //Tokenize Numbers
                    if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9' || expression.charAt(i) == '.') {
                        token = token + expression.charAt(i);
                        if (i + 1 < expression.length() && ((expression.charAt(i + 1) >= '0' && expression.charAt(i + 1) <= '9') || expression.charAt(i + 1) == '.')) {
                            continue;
                        } else
                        val = token;
                        token = "";
                    }

                    //Tokenize
                    else if (expression.charAt(i) == '(' || expression.charAt(i) == ')' || expression.charAt(i) == '[' || expression.charAt(i) == ']') {
                        token = token + expression.charAt(i);
                        val = token;
                        token = "";
                    }


                    //Tokenize Characters
                    else if (expression.charAt(i) >= 'a' && expression.charAt(i) <= 'z') {
                        token = token + expression.charAt(i);
                        if (i + 1 < expression.length() && expression.charAt(i + 1) >= 'a' && expression.charAt(i + 1) <= 'z')
                            continue;
                        else {
                            val = token;
                            token = "";
                        }
                    }


                    //Tokenize Operators
                    else if (expression.charAt(i) >= '*' && expression.charAt(i) <= '/') {
                        if((expression.charAt(i)=='*') && (expression.charAt(i+1) =='-'))
                        {
                            token=token+expression.charAt(i)+expression.charAt(i+1);
                            i++;
                            val = token;
                            token = "";

                        }
                        else if((expression.charAt(i)=='/') && (expression.charAt(i+1) =='-'))
                        {
                            token=token+expression.charAt(i)+expression.charAt(i+1);
                            i++;
                            val = token;
                            token = "";

                        }
                        else if(expression.charAt(i) =='+' && expression.charAt(i-1) == '-' && expression.charAt(i+1)=='0')
                        {
                            System.out.println("\nExpression not valid");
                            System.exit(0);
                        }
                    else{
                        token = token + expression.charAt(i);
                        val = token;
                        token = "";
                    }
                    }

                    else {
                        token = token + expression.charAt(i);
                        val = token;
                    }

                    //Add Tokens to list
                    Token tok = new Token(val);
                    tokenList.add(tok);

                }

            }

    public ArrayList getTokenList()
    {
        return tokenList;
    }
}