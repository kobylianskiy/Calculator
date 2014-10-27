package com.teamdev.students.fsm;

public interface StateAcceptor<State extends Enum,
        Context extends StateMachineContext<State, Context>> {

    boolean acceptState(Context context, State possibleState) throws Exception;
}
