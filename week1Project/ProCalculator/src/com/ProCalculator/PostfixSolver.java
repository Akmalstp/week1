package com.ProCalculator;

import javax.swing.*;
import java.util.Stack;
import java.lang.Math;


import static javax.swing.JOptionPane.*;

public class PostfixSolver {
    public static int evaluate(String postfix){

        Stack<Integer> cal = new Stack<Integer>();
        char c;
        for (int i = 0; i < postfix.length(); i++) {
            c = postfix.charAt(i);
            if(!Character.isDigit(c)){
                int op2 = cal.pop();
                int op1 = cal.pop();
                int compute = 0;
                switch(c){
                    case '+':
                        compute = op1 + op2;
                        break;
                    case '-':
                        compute = op1 - op2;
                        break;
                    case '*':
                        compute = op1 * op2;
                        break;
                    case '/':
                        compute = op1 / op2;
                        break;
                    case '^':
                        Double dOp1 = Double.valueOf(op1);
                        Double dOp2 = Double.valueOf(op2);
                        compute = (int) Math.pow(dOp1, dOp2);
                        break;
                }
                cal.push(compute);
            }
            else{
                cal.push(Character.getNumericValue(c));
            }
        }
        return cal.pop();
    }
    //method for normal calculation
    public static void normalCal(){
        while (true) {

            String input =  showInputDialog("Let's calculate something!");
            int result = 0;
            try {
                result = evaluate(InfixToPostfix.inf2postf(input));
            } catch (Exception e) {
                System.out.println("Thank you for using my calculator");
                System.exit(0);
            }
            showMessageDialog(null, "Result is" + result);
        }
    }

    //Help method
    public static void helper(){
        JOptionPane.showMessageDialog(null,":::Let me help you:::\n'+' for Addition.\n'-' for Subtraction.\n'*' for Multiplication.\n'/' for Division.\n'^' for exponent.");
    }

    //method for scientific calculation
    public static void sCal(){
        String input =  showInputDialog("Welcome to scientific calculator");


    }

    public static void main(String[] args) {
        String choice =  showInputDialog("::::::Welcome to calculator::::::\n1:- For normal calculator.\n2:- For scientific calculator.");
        //int choice = Integer.parseInt(input);
        String input = "";
        int result = 0;
        if(Integer.parseInt(choice) == 1) {
           //call your normal cal method
            normalCal();
        }
        else if(Integer.parseInt(choice) == 2){
            //call your scientific method
        }
        else if(Integer.parseInt(choice) == 3){
            //show help options
            helper();
        }
    }

}
