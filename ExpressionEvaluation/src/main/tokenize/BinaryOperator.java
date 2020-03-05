package main.tokenize;
import java.util.ArrayList;
public class BinaryOperator implements Operator {
     String type = "binary";
     ArrayList<String> bList = new ArrayList<>();
     public ArrayList operatorList() {
          bList.add("+");
          bList.add("-");
          bList.add("*");
          bList.add("/");
          return bList;
     }    }