package com.teamdev.students.calculator.impl.commands;

import com.teamdev.students.calculator.impl.EvaluationCommand;
import com.teamdev.students.calculator.impl.EvaluationStack;

import java.math.BigDecimal;

public class NumberCommand implements EvaluationCommand {
    private BigDecimal value;

    public NumberCommand(BigDecimal value) {
        this.value = value;
    }

    @Override
    public void evaluate(EvaluationStack stack) {
        stack.getOperandStack().push(value);
    }
}
