package com.teamdev.students.view;

import com.teamdev.students.calculator.MathExpressionCalculator;
import com.teamdev.students.calculator.impl.StateMachineCalculator;

import java.io.PrintWriter;
import java.util.Scanner;

public class ConsoleApplication {
    public static void execute() throws Exception {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        MathExpressionCalculator calculator = new StateMachineCalculator();

        String expression = "";
        while (true) {
            System.out.println("Enter expression or '-1' for break:");
            expression = scanner.nextLine();
            if (expression.equals("-1")) {
                break;
            }
            System.out.println("result = " + calculator.evaluate(expression));
        }
    }
}
