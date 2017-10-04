package auxiliary;

import agent.State;
import environment.Environment;

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
}
