package com.teamdev.students.calculator.impl.parsers;

import com.teamdev.students.calculator.impl.EvaluationCommand;
import com.teamdev.students.calculator.impl.EvaluationContext;
import com.teamdev.students.calculator.impl.MathExpressionParser;
import com.teamdev.students.calculator.impl.commands.LeftParenthesisCommand;

public class LeftParenthesisParser implements MathExpressionParser {
    @Override
    public EvaluationCommand parse(EvaluationContext context) {
        final String mathExpression = context.getMathExpression();
        final int index = context.getExpressionParsingIndex();

        if (index == mathExpression.length()) {
            return null;
        }

        context.setExpressionParsingIndex(index+1);
        return new LeftParenthesisCommand();
    }
}
