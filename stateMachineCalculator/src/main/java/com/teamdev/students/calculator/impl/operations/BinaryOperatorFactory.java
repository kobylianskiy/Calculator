package com.teamdev.students.calculator.impl.operations;

import java.util.HashMap;
import java.util.Map;

public class BinaryOperatorFactory {
    private Map<Character, BinaryOperator> operators = new HashMap<Character, BinaryOperator>() {{
        put('+', new PlusBinaryOperator());
        put('/', new DivideBinaryOperator());
        put('-', new MinusBinaryOperator());
        put('*', new MultiplyBinaryOperator());
        put('^', new PowerBinaryOperator());
    }};

    public BinaryOperator createBinaryOperator(Character operator) {
        return operators.get(operator);
    }
}
