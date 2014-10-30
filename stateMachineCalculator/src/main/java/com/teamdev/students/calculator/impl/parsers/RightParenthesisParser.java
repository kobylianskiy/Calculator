package com.teamdev.students.calculator.impl.parsers;

import com.teamdev.students.calculator.EvaluationException;
import com.teamdev.students.calculator.impl.*;

import static com.teamdev.students.calculator.impl.parsers.MathExpressionSymbols.RIGHT_PARENTHESIS;

public class RightParenthesisParser implements MathExpressionParser {
    @Override
    public EvaluationCommand parse(EvaluationContext context) {
        final MathExpressionReader expressionReader = context.getExpressionReader();

        if (!expressionReader.endOfExpression() &&
                expressionReader.getCurrentChar() == RIGHT_PARENTHESIS.getSymbol()) {

            expressionReader.incrementIndex(1);

            return new EvaluationCommand() {
                @Override
                public void evaluate(EvaluationStack stack) throws EvaluationException {

                    if (stack.getParenthesisStack().isEmpty()) {
                        throw new EvaluationException("Opening bracket expected.",
                                expressionReader.getIndex());
                    }

                    stack.pushRightParenthesis();
                }
            };
        }
        return null;
    }
}