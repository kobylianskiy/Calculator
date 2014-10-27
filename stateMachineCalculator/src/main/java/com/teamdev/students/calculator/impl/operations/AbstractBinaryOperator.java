package com.teamdev.students.calculator.impl.operations;

public abstract class AbstractBinaryOperator implements BinaryOperator {
    private Priority priority;
    private Associativity associativity;

    @Override
    public int compareTo(BinaryOperator o) {
        return priority.compareTo( ((AbstractBinaryOperator) o).priority );
    }

    public AbstractBinaryOperator(Priority priority, Associativity associativity) {
        this.priority = priority;
        this.associativity = associativity;
    }

    public boolean isLeftAssociative() {
        return associativity == Associativity.LEFT;
    }
}
