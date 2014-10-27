package com.teamdev.students.calculator.impl.commands;

import com.teamdev.students.calculator.impl.EvaluationCommand;
import com.teamdev.students.calculator.impl.EvaluationStack;
import com.teamdev.students.calculator.impl.operations.AbstractBinaryOperator;
import com.teamdev.students.calculator.impl.operations.BinaryOperator;

import java.math.BigDecimal;
import java.util.Deque;

public class BinaryOperatorCommand implements EvaluationCommand {
    private BinaryOperator  binaryOperator;

    public BinaryOperatorCommand(BinaryOperator binaryOperator) {
        this.binaryOperator = binaryOperator;
    }

    @Override
    public void evaluate(EvaluationStack stack) {
        final Deque<BinaryOperator> operatorStack = stack.getOperatorStack();
        final Deque<BigDecimal> operandStack = stack.getOperandStack();


        if (operatorStack.isEmpty()) {
            operatorStack.push(binaryOperator);
        } else {
            while (stack.isOperatorOnTheTop()) {
                if ((binaryOperator.compareTo(operatorStack.peek())) < 0 ||
                        (binaryOperator.compareTo(operatorStack.peek()) <= 0 &&
                                ((AbstractBinaryOperator) binaryOperator).isLeftAssociative())) {
                    stack.executeBinaryOperator();
                } else
                    break;
            }
            operatorStack.push(binaryOperator);
        }


    }
}
