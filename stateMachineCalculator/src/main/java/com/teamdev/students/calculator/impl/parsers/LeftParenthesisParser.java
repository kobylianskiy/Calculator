package com.teamdev.students.calculator.impl.parsers;

import com.teamdev.students.calculator.EvaluationException;
import com.teamdev.students.calculator.impl.*;

import static com.teamdev.students.calculator.impl.parsers.MathExpressionSymbols.*;

public class LeftParenthesisParser implements MathExpressionParser {
    @Override
    public EvaluationCommand parse(EvaluationContext context) {
        final MathExpressionReader expressionReader = context.getExpressionReader();

        if (expressionReader.getCurrentChar() == LEFT_PARENTHESIS.getSymbol()) {
            expressionReader.incrementIndex(1);

            return new EvaluationCommand() {
                @Override
                public void evaluate(EvaluationStack stack) throws EvaluationException {
                    stack.pushLeftParenthesis();
                }
            };
        }

        return null;
    }
}
