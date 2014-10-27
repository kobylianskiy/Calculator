package com.teamdev.students.calculator.impl;

import com.teamdev.students.fsm.TransitionMatrix;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.teamdev.students.calculator.impl.State.*;
import static java.util.EnumSet.noneOf;
import static java.util.EnumSet.of;


public class EvaluationMatrix implements TransitionMatrix<State> {

    private final Map<State, Set<State>> transitions = new HashMap<State, Set<State>>() {{
        put(START, of(
                NUMBER,
                LEFT_PARENTHESIS
        ));
        put(NUMBER, of(
                BINARY_OPERATOR,
                RIGHT_PARENTHESIS,
                FINISH
        ));
        put(BINARY_OPERATOR, of(
                NUMBER,
                LEFT_PARENTHESIS
        ));
        put(LEFT_PARENTHESIS, of(
                NUMBER,
                LEFT_PARENTHESIS
        ));
        put(RIGHT_PARENTHESIS, of(
                BINARY_OPERATOR,
                RIGHT_PARENTHESIS,
                FINISH
        ));
        put(FINISH, noneOf(State.class));
    }};

    @Override
    public State getStartState() {
        return START;
    }

    @Override
    public State getFinishState() {
        return FINISH;
    }

    @Override
    public Set<State> getPossibleStates(State state) {
        return transitions.get(state);
    }
}

