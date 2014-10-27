package com.teamdev.students.calculator.impl;

import com.teamdev.students.calculator.MathExpressionCalculator;
import com.teamdev.students.fsm.FiniteStateMachine;

import java.math.BigDecimal;

public class StateMachineCalculator extends FiniteStateMachine<State, EvaluationContext, BigDecimal>
        implements MathExpressionCalculator {

    @Override
    public BigDecimal evaluate(String mathExpression) throws Exception {
        return run(new EvaluationContext(mathExpression));
    }

    @Override
    protected void deadlock(EvaluationContext context, State currentState) {
        throw new IllegalStateException("Deadlock in state " + currentState + " at position " +
                context.getExpressionParsingIndex());
    }

    @Override
    protected BigDecimal finish(EvaluationContext context) {
        return context.getEvaluationStack().getOperandStack().pop();
    }

    public static void main(String[] args) throws Exception {
        final StateMachineCalculator calculator = new StateMachineCalculator();
        final BigDecimal result = calculator.evaluate("(2^2^3+4*2/(10-2))/257+2");
        System.out.println("result = " + result);
    }
}
