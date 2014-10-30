package com.teamdev.students.calculator.impl;

import com.teamdev.students.calculator.EvaluationException;
import com.teamdev.students.calculator.impl.parsers.*;
import com.teamdev.students.fsm.StateAcceptor;

import java.util.HashMap;
import java.util.Map;

import static com.teamdev.students.calculator.impl.State.*;

public class EvaluationService implements StateAcceptor<State, EvaluationContext, EvaluationException> {

    private final Map<State, MathExpressionParser> parsers = new HashMap<State, MathExpressionParser>() {{
        put(NUMBER, new NumberParser());
        put(BINARY_OPERATOR, new BinaryOperatorParser());
        put(LEFT_PARENTHESIS, new LeftParenthesisParser());
        put(RIGHT_PARENTHESIS, new RightParenthesisParser());
        put(FINISH, new EndOfExpressionParser());
    }};


    @Override
    public boolean acceptState(EvaluationContext context, State possibleState) throws EvaluationException {

        final MathExpressionParser parser = parsers.get(possibleState);

        if (parser == null) {
            throw new EvaluationException("Parser not found for state: " + possibleState,
                    context.getExpressionReader().getIndex());
        }

        context.getExpressionReader().skipWhitespaces();

        final EvaluationCommand evaluationCommand = parser.parse(context);
        if (evaluationCommand == null) {
            return false;
        }

        evaluationCommand.evaluate(context.getEvaluationStack());

        return true;
    }
}
