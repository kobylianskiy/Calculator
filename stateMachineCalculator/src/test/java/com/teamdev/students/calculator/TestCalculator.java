package com.teamdev.students.calculator;

import com.teamdev.students.calculator.impl.StateMachineCalculator;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TestCalculator {
    private static MathExpressionCalculator calculator;

    @BeforeClass
    public static void init() {
        calculator = new StateMachineCalculator();
    }

    @Test
    public void testSimpleExpression() throws Exception {
        BigDecimal result = calculator.evaluate("2+3");
        BigDecimal expected = new BigDecimal(5);
        assertEquals(expected, result);
    }

    @Test
    public void testSimpleOperators() throws Exception {
        BigDecimal result = calculator.evaluate("2+3*5/15-3");
        BigDecimal expected = new BigDecimal(0);
        assertEquals(expected, result);
    }

    @Test
    public void testPow() throws Exception {
        BigDecimal result = calculator.evaluate("2^2^3^1");
        BigDecimal expected = new BigDecimal(256);
        assertEquals(expected, result);
    }

    @Test
    public void testParentheses() throws Exception {
        BigDecimal result = calculator.evaluate("((3*((1+2)+1))/12+3-2)^10");
        BigDecimal expected = new BigDecimal(1024);
        assertEquals(expected, result);
    }

    @Test(expected = EvaluationException.class)
    public void testMissedLeftParenthesis() throws Exception {
        BigDecimal result = calculator.evaluate("(2+3/3-1))");
    }

    @Test
    public void testInteger() throws Exception {
        BigDecimal result = calculator.evaluate("123");
        BigDecimal expected = new BigDecimal(123);
        assertEquals(expected, result);
    }

    @Test
    public void testFloat() throws Exception {
        BigDecimal result = calculator.evaluate("123.123");
        BigDecimal expected = new BigDecimal(123.123);
        assertEquals(expected, result);
    }

    @Test
    public void testComplicatedExpression() throws Exception {
        BigDecimal result = calculator.evaluate("(2*(1+3)/2^3-1+2^(1+1)-4+2^(10/10+3*3))/1024");
        BigDecimal expected = new BigDecimal(1);
        assertEquals(expected, result);
    }

    @Test(expected = IllegalStateException.class)
    public void testDivisionByZero() throws Exception {
        calculator.evaluate("10/0");
    }

    @Test
    public void tesSimpleMin() throws Exception {
        BigDecimal result = calculator.evaluate("min(5;4;2;7)");
        BigDecimal expected = new BigDecimal(2);
        assertEquals(expected, result);
    }

    @Test
    public void testSimpleMax() throws Exception {
        BigDecimal result = calculator.evaluate("max(5;4;2;7)");
        BigDecimal expected = new BigDecimal(7);
        assertEquals(expected, result);
    }

    @Test
    public void testSimpleSum() throws Exception {
        BigDecimal result = calculator.evaluate("sum(5;4;2;7)");
        BigDecimal expected = new BigDecimal(18);
        assertEquals(expected, result);
    }

    @Test
    public void testSimpleSqrt() throws Exception {
        BigDecimal result = calculator.evaluate("sqrt(4)");
        BigDecimal expected = new BigDecimal(2);
        assertEquals(expected, result);
    }

    @Test
    public void testMinWithInnerFunctions() throws Exception {
        BigDecimal result = calculator.evaluate("min(max(2;0;1);-1;sum(-2;-8))");
        BigDecimal expected = new BigDecimal(-10);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxWithInnerParentheses() throws Exception {
        BigDecimal result = calculator.evaluate("min((2/2);5)");
        BigDecimal expected = new BigDecimal(2);
        assertEquals(expected, result);
    }
}
