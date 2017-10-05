package search;

import agent.State;
import agent.VacuumCleaner;
import auxiliary.CostComparator;
import environment.Environment;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static auxiliary.AuxiliaryFunctions.findColumnOnGraph;
import static auxiliary.AuxiliaryFunctions.findRowOnGraph;

public class AStarSearch {

    private List<State> expanded;
    private PriorityQueue<State> edge;


    public AStarSearch(State initial) {
        this.expanded = new ArrayList<>();
        this.edge = new PriorityQueue<>(10, new CostComparator());

        this.edge.add(initial);
    }

    public List<State> getExpanded() {

        return expanded;
    }

    public PriorityQueue<State> getEdge() {

        return edge;
    }


    public VacuumCleaner AStar(VacuumCleaner agent, Environment environment) {
        if (getEdge().peek() != null) {
            State actualState = getEdge().remove();

            if (!actualState.isObjective()) {
                int column = -1;
                int row;

                System.out.println(actualState.toString());

                if (!actualState.equals(environment.getInitialState())) {
                    column = findColumnOnGraph(actualState, environment);
                }

                if ((actualState.equals(environment.getInitialState()))) {
                    row = findRowOnGraph(actualState, environment);
                    generateStates(row, environment);
                    expanded.add(actualState);
                } else {
                    expanded.add(actualState);
                    generateStates(column, environment);
                }

                environment.actionPerformed(agent, actualState, environment.getInitialState());
                this.AStar(agent, environment);

            } else {
                return agent;
            }
        } else {
            System.out.println("Borda vazia, objetivo não encontrado!");
        }

        return agent;
    }

    private void generateStates(int i, Environment environment) {

        for (State state: environment.getGraph()[i]) {
            if (state != null) {
                if (getExpanded().contains(state) &&
                        !getEdge().contains(state)) {

                    edge.add(state);
                }
            }
        }
    }

}
