package com.teamdev.students.calculator.impl.commands;

import com.teamdev.students.calculator.EvaluationException;
import com.teamdev.students.calculator.impl.EvaluationCommand;
import com.teamdev.students.calculator.impl.EvaluationStack;

public class RightParenthesisCommand implements EvaluationCommand {
    private int index;

    public RightParenthesisCommand(int index) {
        this.index = index;
    }

    @Override
    public void evaluate(EvaluationStack stack) throws EvaluationException {
        while (!stack.isLeftParenthesisOnTheTop()) {
            //todo
            if (stack.getOperatorStack().size() == 0) {
                throw new EvaluationException("mismatched parenthesis", index);
            }
            stack.executeBinaryOperator();
        }
        stack.getParenthesisStack().pop();
    }
}
