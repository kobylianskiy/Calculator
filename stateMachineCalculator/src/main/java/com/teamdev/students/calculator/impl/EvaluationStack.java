package com.teamdev.students.calculator.impl;

import com.teamdev.students.calculator.impl.operations.AbstractBinaryOperator;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;


public class EvaluationStack {
    private final Deque<BigDecimal> operandStack = new ArrayDeque<>();
    private final Deque<BinaryOperator> operatorStack = new ArrayDeque<>();
    private final Deque<Integer> parenthesisStack = new ArrayDeque<>();

    public Deque<Integer> getParenthesisStack() {
        return parenthesisStack;
    }

    public Deque<BigDecimal> getOperandStack() {
        return operandStack;
    }

    public Deque<BinaryOperator> getOperatorStack() {
        return operatorStack;
    }

    public void executeBinaryOperator() {
        BigDecimal secondOperand = operandStack.pop();
        BigDecimal firstOperand = operandStack.pop();
        BinaryOperator binaryOperator = operatorStack.pop();
        BigDecimal result = binaryOperator.calculate(firstOperand, secondOperand);

        operandStack.push(result);
    }

    public void pushOperator(BinaryOperator operator) {

        while (isOperatorOnTheTop() && ( (operatorStack.peek().compareTo(operator) > 0) ||
                (operatorStack.peek().compareTo(operator) > -1 && ((AbstractBinaryOperator) operator).isLeftAssociative()) )) {
            executeBinaryOperator();
        }

        operatorStack.push(operator);
    }

    public void popAllOperators() {
        while (!operatorStack.isEmpty()) {
            executeBinaryOperator();
        }
    }

    public void pushLeftParenthesis() {
        parenthesisStack.push(operatorStack.size());
    }

    public void pushRightParenthesis() {
        final int previousOperatorStackSize = parenthesisStack.pop();
        while (previousOperatorStackSize < operatorStack.size()) {
            executeBinaryOperator();
        }
    }

    public void pushNumber(BigDecimal number) {
        operandStack.push(number);
    }

    public boolean isOperatorOnTheTop() {
        if (operatorStack.isEmpty()) {
            return false;
        }
        if (parenthesisStack.isEmpty()) {
            return true;
        }
        if (parenthesisStack.peek() < operatorStack.size()) {
            return true;
        }

        return false;
    }
}

