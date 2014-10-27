package com.teamdev.students.calculator.impl;

public enum State {
    START,
    NUMBER,
    BINARY_OPERATOR,
    LEFT_PARENTHESIS,
    RIGHT_PARENTHESIS,
    FINISH
}