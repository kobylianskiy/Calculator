package com.teamdev.students.calculator.impl;

import com.teamdev.students.calculator.impl.operations.BinaryOperator;

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

    public boolean isOperatorOnTheTop() {
        if (isLeftParenthesisOnTheTop())
            return false;
        if (operatorStack.size() != 0)
            return true;
        return false;
    }

    public boolean isLeftParenthesisOnTheTop() {
        if (parenthesisStack.size() != 0 &&
                parenthesisStack.peek() == operatorStack.size())
            return true;
        return false;
    }
}

