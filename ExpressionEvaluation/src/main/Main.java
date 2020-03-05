package main;
import main.Controller.ExpCtrl;
import java.util.Scanner;
public class Main {
       public static void main(String[] args) {
           for (int i = 0; i < 2; i++) {
               System.out.println("Enter An Expression:");
               Scanner input = new Scanner(System.in);
               String expression = input.nextLine();
               ExpCtrl controller = new ExpCtrl();
               expression = expression.replaceAll("\\s", "");
               controller.evaluateExp(expression);
           }
       }
}
