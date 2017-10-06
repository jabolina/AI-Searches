package auxiliary;

import agent.State;
import agent.VacuumCleaner;
import environment.Environment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AuxiliaryFunctions {

    public static int findColumnOnGraph(State state, Environment environment) {
        int j = 0;

        for (State[] states: environment.getGraph()) {
            for (State verify: states) {
                if (state.equals(verify))
                    return j;
                j++;
            }
            j = 0;
        }
        return -1;
    }

    public static int findRowOnGraph(State state, Environment environment) {

        int i = 0;

        for (State[] states: environment.getGraph()) {
            for (State verify: states) {
                if (state.equals(verify))
                    return i;
            }
            i++;
        }
        return -1;
    }

    public static List<State> generateStateSequence(State objectiveState) {

        State state = objectiveState.getFather();
        List<State> states = new ArrayList<>();

        while(state != null) {
            states.add(state);
            state = state.getFather();
        }
        Collections.reverse(states);

        states.forEach(state1 -> System.out.println(state1.toString()));

        return states;
    }

    public static void showActionsList(VacuumCleaner vacuumCleaner, List<State> states) {
        for (int i=1; i<states.size(); i++) {
            vacuumCleaner.setCost(vacuumCleaner.getCost() + states.get(i).getAction().valueOf(states.get(i).getAction()));
            System.out.println(states.get(i).getAction());
        }
    }

    public static int heuristic(State state) {
        int count = 0;

        if (state.getTileA()) count++;
        if (state.getTileB()) count++;

        return count * 5;
    }
}
