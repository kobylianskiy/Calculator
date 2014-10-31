package com.teamdev.students.calculator.impl.parsers;

import com.teamdev.students.calculator.EvaluationException;
import com.teamdev.students.calculator.impl.*;

import static com.teamdev.students.calculator.impl.parsers.MathExpressionSymbols.ARGUMENT_SEPARATOR;

public class ArgumentSeparatorParser implements MathExpressionParser {
    @Override
    public EvaluationCommand parse(EvaluationContext context) {
        final MathExpressionReader expressionReader = context.getExpressionReader();
        if (!expressionReader.endOfExpression() &&
                expressionReader.getCurrentChar() == ARGUMENT_SEPARATOR.getSymbol()) {

            expressionReader.incrementIndex(1);

            return new EvaluationCommand() {
                @Override
                public void evaluate(EvaluationStack stack) throws EvaluationException {
                    stack.pushArgumentSeparator();
                }
            };
        }

        return null;
    }
}
