package com.teamdev.students.calculator.impl.parsers;

import com.teamdev.students.calculator.EvaluationException;
import com.teamdev.students.calculator.impl.*;
import com.teamdev.students.calculator.impl.BinaryOperatorFactory;

public class BinaryOperatorParser implements MathExpressionParser {

    @Override
    public EvaluationCommand parse(EvaluationContext context) {

        final MathExpressionReader expressionReader = context.getExpressionReader();
        final BinaryOperatorFactory factory = context.getBinaryOperatorFactory();

        final String remainingExpression = expressionReader.getRemainingExpression();

        for (String presentation : factory.getAllOperators()) {
            if (remainingExpression.startsWith(presentation)) {
                final BinaryOperator binaryOperator = factory.create(presentation);
                expressionReader.incrementIndex(presentation.length());

                return new EvaluationCommand() {
                    @Override
                    public void evaluate(EvaluationStack stack) throws EvaluationException {
                        stack.pushOperator(binaryOperator);
                    }
                };
            }
        }

        return null;
    }
}
