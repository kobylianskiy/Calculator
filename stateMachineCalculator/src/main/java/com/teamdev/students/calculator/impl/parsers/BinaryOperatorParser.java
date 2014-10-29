package com.teamdev.students.calculator.impl.parsers;

import com.teamdev.students.calculator.impl.EvaluationCommand;
import com.teamdev.students.calculator.impl.EvaluationContext;
import com.teamdev.students.calculator.impl.MathExpressionParser;
import com.teamdev.students.calculator.impl.commands.BinaryOperatorCommand;
import com.teamdev.students.calculator.impl.operations.BinaryOperator;
import com.teamdev.students.calculator.impl.operations.BinaryOperatorFactory;

public class BinaryOperatorParser implements MathExpressionParser {
    private BinaryOperatorFactory factory = new BinaryOperatorFactory();

    @Override
    public EvaluationCommand parse(EvaluationContext context) {
        final String mathExpression = context.getMathExpression();
        final int index = context.getExpressionParsingIndex();

        if (index == mathExpression.length()) {
            return null;
        }

        BinaryOperator binaryOperator =
                factory.createBinaryOperator(mathExpression.charAt(index));

        if (binaryOperator == null) {
            return null;
        }

        context.setExpressionParsingIndex(index + 1);
        return new BinaryOperatorCommand(binaryOperator);
    }
}
