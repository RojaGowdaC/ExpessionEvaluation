package main.treeCreation;
import java.util.Stack;

import main.tokenize.*;

import java.util.ArrayList;
public class ExpressionTree {
    BinaryOperator binaryop = new BinaryOperator();
    ArrayList<Token> binary = binaryop.operatorList();
    UnaryOperator unaryoperators = new UnaryOperator();
    ArrayList<Token> unary = unaryoperators.operatorList();
    Node root;

    static void inorder(Node t) {
        if (t != null) {
            inorder(t.left);
            System.out.print(t.value + " ");
            inorder(t.right);
        }
    }

    public void constructTree(ArrayList<Token> postfix) {
        Stack<Node> stack = new Stack();
        Node t, t1, t2;
        for (int i = 0; i < postfix.size(); i++) {

            if (!binary.contains(postfix.get(i).getName()) && !unary.contains(postfix.get(i).getName())) {
                t = new Node(postfix.get(i).getName());
                stack.push(t);
            } else {

                if (binary.contains(postfix.get(i).getName()))
                {
                    t = new Node(postfix.get(i).getName());
                    // Pop two top nodes

                    if (!stack.isEmpty()) {
                        t1 = stack.peek();
                        stack.pop();
                        t2 = stack.peek();
                        stack.pop();

                        //  make them children
                        t.right = t1;
                        t.left = t2;
                        // Add this subexpression to stack
                        stack.push(t);
                    }
                } else {
                    t = new Node(postfix.get(i).getName());
                    // Pop two top nodes

                    if (!stack.isEmpty()) {
                        t1 = stack.peek();
                        stack.pop();
                        t.right = t1;
                        t.left = null;
                        // Add this subexpression to stack
                        stack.push(t);
                    }
                }
            }

        }
        t = stack.peek();
        root = t;
        inorder(root);
        stack.pop();
    }

    public Node getroot() {
        return root;
    }
}