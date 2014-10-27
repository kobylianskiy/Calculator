package com.teamdev.students.calculator.impl.commands;

import com.teamdev.students.calculator.impl.EvaluationCommand;
import com.teamdev.students.calculator.impl.EvaluationStack;

public class LeftParenthesisCommand implements EvaluationCommand {
    @Override
    public void evaluate(EvaluationStack stack) {
        stack.getParenthesisStack().push(stack.getOperatorStack().size());
    }
}
