package com.teamdev.students.calculator.impl.parsers;

import com.teamdev.students.calculator.EvaluationException;
import com.teamdev.students.calculator.impl.*;

public class FunctionParser implements MathExpressionParser {

    @Override
    public EvaluationCommand parse(EvaluationContext context) {
        final MathExpressionReader expressionReader = context.getExpressionReader();
        final FunctionFactory factory = context.getFunctionFactory();

        String remainingExpression = expressionReader.getRemainingExpression();

        for (String presentation : factory.getAllFunctions()) {
            if (remainingExpression.startsWith(presentation)) {
                expressionReader.incrementIndex(presentation.length());
                final Function function = factory.create(presentation);

                return new EvaluationCommand() {
                    @Override
                    public void evaluate(EvaluationStack stack) throws EvaluationException {
                        stack.pushFunction(function);
                    }
                };
            }
        }

        return null;
    }
}
