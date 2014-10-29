package com.teamdev.students.calculator.impl.commands;

import com.teamdev.students.calculator.impl.EvaluationCommand;
import com.teamdev.students.calculator.impl.EvaluationStack;
import com.teamdev.students.calculator.impl.operations.BinaryOperator;

import java.util.Deque;

public class EndOfExpressionCommand implements EvaluationCommand {
    @Override
    public void evaluate(EvaluationStack stack) {
        final Deque<BinaryOperator> operatorStack = stack.getOperatorStack();

        while (!operatorStack.isEmpty()) {
            stack.executeBinaryOperator();
        }
    }
}
