package com.teamdev.students.calculator.impl.parsers;

import com.teamdev.students.calculator.EvaluationException;
import com.teamdev.students.calculator.impl.*;

public class EndOfExpressionParser implements MathExpressionParser {

    @Override
    public EvaluationCommand parse(EvaluationContext context) {
        final MathExpressionReader expressionReader = context.getExpressionReader();

        if (expressionReader.endOfExpression()) {
            return new EvaluationCommand() {
                @Override
                public void evaluate(EvaluationStack stack) throws EvaluationException {

                    if (!stack.getParenthesisStack().isEmpty() ||
                            !stack.getFunctionParenthesisStack().isEmpty()) {

                        throw new EvaluationException("Closing bracket expected at index:",
                                expressionReader.getIndex());
                    }

                    stack.popAllOperators();
                }
            };
        }

        return null;
    }
}