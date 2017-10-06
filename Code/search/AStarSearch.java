package search;

import agent.State;
import agent.VacuumCleaner;
import auxiliary.AuxiliaryFunctions;
import auxiliary.CostComparator;
import environment.Environment;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static auxiliary.AuxiliaryFunctions.*;
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

        if (!getEdge().isEmpty()) {
            State actualState = getEdge().poll();

            if (!actualState.isObjective()) {
                int column;
                int row;

                if ((actualState.equals(environment.getInitialState()))) {
                    row = findRowOnGraph(actualState, environment);
                    expanded.add(actualState);
                    generateStates(actualState, row, environment);
                } else {
                    expanded.add(actualState);
                    column = findColumnOnGraph(actualState, environment);
                    generateStates(actualState, column, environment);
                }

                agent.setState(actualState);
                this.AStar(agent, environment);

            } else {
                agent.setState(actualState);
                return agent;
            }
        } else {
            System.out.println("Borda vazia, objetivo não encontrado!");
        }

        return agent;
    }

    private void generateStates(State actual, int i, Environment environment) {

        for (State state: environment.getGraph()[i]) {
            if (state != null) {
                if (!getExpanded().contains(state) &&
                        !getEdge().contains(state)) {

                    state.setHeuristicCost(heuristic(state) + 1);
                    state.setFather(actual);
                    edge.add(state);
                }
            }
        }
    }

}
