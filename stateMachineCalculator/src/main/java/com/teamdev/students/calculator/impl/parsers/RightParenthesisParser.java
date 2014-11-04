package com.teamdev.students.calculator.impl.parsers;

import com.teamdev.students.calculator.EvaluationException;
import com.teamdev.students.calculator.impl.*;

import java.util.Deque;

import static com.teamdev.students.calculator.impl.parsers.MathExpressionSymbols.RIGHT_PARENTHESIS;

public class RightParenthesisParser implements MathExpressionParser {

    @Override
    public EvaluationCommand parse(EvaluationContext context) {
        final MathExpressionReader expressionReader = context.getExpressionReader();
        final Deque<Integer> functionParenthesisStack =
                context.getEvaluationStack().getFunctionParenthesisStack();

        final int parenthesisStackSize =
                context.getEvaluationStack().getParenthesisStack().size();

        if (!expressionReader.endOfExpression() &&
                expressionReader.getCurrentChar() == RIGHT_PARENTHESIS.getSymbol() &&
                (functionParenthesisStack.isEmpty() || functionParenthesisStack.peek() !=
                        parenthesisStackSize)) {

            expressionReader.incrementIndex(1);

            return new EvaluationCommand() {
                @Override
                public void evaluate(EvaluationStack stack) throws EvaluationException {

                    if (stack.getParenthesisStack().isEmpty()) {
                        throw new EvaluationException("Opening bracket expected at index:",
                                expressionReader.getIndex());
                    }

                    stack.pushRightParenthesis();
                }
            };
        }

        return null;
    }
}