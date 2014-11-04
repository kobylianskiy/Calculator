package com.teamdev.students.calculator.impl.parsers;

import com.teamdev.students.calculator.EvaluationException;
import com.teamdev.students.calculator.impl.*;

import static com.teamdev.students.calculator.impl.parsers.MathExpressionSymbols.LEFT_PARENTHESIS;

public class FunctionLeftParenthesisParser implements MathExpressionParser {

    @Override
    public EvaluationCommand parse(EvaluationContext context) {
        final MathExpressionReader expressionReader = context.getExpressionReader();
        final State previousState = context.getPreviousState();

        if (previousState == State.FUNCTION &&
                expressionReader.getCurrentChar() == LEFT_PARENTHESIS.getSymbol()) {

            expressionReader.incrementIndex(1);

            return new EvaluationCommand() {
                @Override
                public void evaluate(EvaluationStack stack) throws EvaluationException {
                    stack.pushFunctionLeftParenthesis();
                }
            };
        }

        return null;
    }
}
