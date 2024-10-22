package com.interpreter;

public class OperationExpression implements Expression {
    private Expression leftExpression;
    private Expression rightExpression;
    private String operation;

    public OperationExpression(Expression leftExpression, Expression rightExpression, String operation) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operation = operation;
    }

    @Override
    public int interpret() {
        switch (operation) {
            case "+":
                return leftExpression.interpret() + rightExpression.interpret();
            case "-":
                return leftExpression.interpret() - rightExpression.interpret();
            default:
                throw new IllegalArgumentException("Unknown operation: " + operation);
        }
    }
}
