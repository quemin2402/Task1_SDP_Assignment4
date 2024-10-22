package com.interpreter.test;

import com.interpreter.Interpreter;

public class Main {
    public static void main(String[] args) {
        String expression = "100-99+11";

        try {
            int result = Interpreter.interpret(expression);
            System.out.println("Result of expression '" + expression + "' is: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
