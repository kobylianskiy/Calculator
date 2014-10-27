package com.teamdev.students.fsm;

public interface StateMachineContext<State extends Enum,
        Context extends StateMachineContext<State, Context>> {

    TransitionMatrix<State> getTransitionMatrix();

    StateAcceptor<State, Context> getStateAcceptor();
}
