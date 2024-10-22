package com.interpreter;

import java.util.Stack;

public class Interpreter {

    public static int interpret(String expression) {
        Stack<Expression> stack = new Stack<>();

        StringBuilder numberBuilder = new StringBuilder();
        char currentOperator = '+';

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);

            if (Character.isDigit(currentChar)) {
                numberBuilder.append(currentChar);
            } else if (isOperator(currentChar)) {
                if (numberBuilder.length() > 0) {
                    int number = Integer.parseInt(numberBuilder.toString());
                    stack.push(new NumberExpression(number));
                    numberBuilder.setLength(0);
                }

                if (stack.size() >= 2) {
                    Expression right = stack.pop();
                    Expression left = stack.pop();
                    stack.push(new OperationExpression(left, right, String.valueOf(currentOperator)));
                }

                currentOperator = currentChar;
            }
        }

        if (numberBuilder.length() > 0) {
            int number = Integer.parseInt(numberBuilder.toString());
            stack.push(new NumberExpression(number));
        }

        if (stack.size() >= 2) {
            Expression right = stack.pop();
            Expression left = stack.pop();
            stack.push(new OperationExpression(left, right, String.valueOf(currentOperator)));
        }

        return stack.pop().interpret();
    }

    private static boolean isOperator(char token) {
        return token == '+' || token == '-';
    }
}
