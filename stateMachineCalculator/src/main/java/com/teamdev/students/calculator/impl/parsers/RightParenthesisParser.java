package com.teamdev.students.calculator.impl.parsers;

import com.teamdev.students.calculator.impl.EvaluationCommand;
import com.teamdev.students.calculator.impl.EvaluationContext;
import com.teamdev.students.calculator.impl.MathExpressionParser;
import com.teamdev.students.calculator.impl.commands.RightParenthesisCommand;

public class RightParenthesisParser implements MathExpressionParser {
    @Override
    public EvaluationCommand parse(EvaluationContext context) {
        final String mathExpression = context.getMathExpression();
        final int index = context.getExpressionParsingIndex();

        if (index == mathExpression.length()) {
            return null;
        }
        if (mathExpression.charAt(index) != ')') {
            return null;
        }
        context.setExpressionParsingIndex(index+1);
        return new RightParenthesisCommand(index);
    }
}