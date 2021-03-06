package com.ProCalculator;

import java.util.EmptyStackException;
import java.util.Stack;

public class InfixToPostfix {

    //method to convert infix to postfix.
    public static String inf2postf(String infix) {

        infix = infix.replaceAll("\\s", "");
        String postfix = "";
        Stack<Character> operator = new Stack<Character>();
        char popped;

        for (int i = 0; i < infix.length(); i++) {

            char get = infix.charAt(i);

            if (!isOperator(get)){
                postfix += get;
            }

            else if (get == ')')
                while ((popped = operator.pop()) != '('){
                    postfix += popped;
                }

            else {
                while (!operator.isEmpty() && get != '(' && precedence(operator.peek()) >= precedence(get)){
                    postfix += operator.pop();
                }

                operator.push(get);
            }
        }
        // pop any remaining operator
        while (!operator.isEmpty())
            postfix += operator.pop();

        return postfix;
    }

    private static boolean isOperator(char i) {
        return precedence(i) > 0;
    }

    private static int precedence(char i) {

        if (i == '(' || i == ')') return 1;
        else if (i == '-' || i == '+') return 2;
        else if (i == '*' || i == '/') return 3;
        else if(i == '^') return 4;
        else return 0;
    }
//    public static void main(String[] args){
//        System.out.println(inf2postf("5+7"));
//    }
}
