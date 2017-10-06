package auxiliary;

import agent.State;

import java.util.Comparator;

public class CostComparator implements Comparator<State> {

    @Override
    public int compare(State state, State t1) {

        if (state.getHeuristicCost() < t1.getHeuristicCost()) return -1;
        if (state.getHeuristicCost() > t1.getHeuristicCost()) return 1;
        return 0;
    }
}
