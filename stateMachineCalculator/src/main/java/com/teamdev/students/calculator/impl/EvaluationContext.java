package com.teamdev.students.calculator.impl;

import com.teamdev.students.calculator.EvaluationException;
import com.teamdev.students.fsm.StateAcceptor;
import com.teamdev.students.fsm.StateMachineContext;
import com.teamdev.students.fsm.TransitionMatrix;

public class EvaluationContext implements StateMachineContext<State, EvaluationContext, EvaluationException> {

    private final EvaluationMatrix matrix = new EvaluationMatrix();
    private final EvaluationService evaluationService = new EvaluationService();
    private final BinaryOperatorFactory binaryOperatorFactory = new BinaryOperatorFactory();

    private final MathExpressionReader expressionReader;
    private final EvaluationStack evaluationStack = new EvaluationStack();

    public EvaluationContext(String mathExpression) {
        expressionReader = new MathExpressionReader(mathExpression);
    }

    public BinaryOperatorFactory getBinaryOperatorFactory() {
        return binaryOperatorFactory;
    }

    public MathExpressionReader getExpressionReader() {
        return expressionReader;
    }

    public EvaluationStack getEvaluationStack() {
        return evaluationStack;
    }

    @Override
    public TransitionMatrix<State> getTransitionMatrix() {
        return matrix;
    }

    @Override
    public StateAcceptor<State, EvaluationContext, EvaluationException> getStateAcceptor() {
        return evaluationService;
    }
}
