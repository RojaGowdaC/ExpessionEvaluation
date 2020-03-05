package main.tokenize;
import java.util.ArrayList;
public class UnaryOperator implements Operator {
     String type = "Unary";
     ArrayList<String> uList = new ArrayList<>();
     public ArrayList operatorList() {
          uList.add("cos");
          uList.add("sin");
          uList.add("tan");
          uList.add("+-");
          uList.add("*-");
          return uList;
     }
}

