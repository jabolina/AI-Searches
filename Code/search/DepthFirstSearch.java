package search;

import agent.State;
import agent.VacuumCleaner;
import environment.Environment;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static auxiliary.AuxiliaryFunctions.findColumnOnGraph;
import static auxiliary.AuxiliaryFunctions.findRowOnGraph;

public class DepthFirstSearch {

    private List<State> expanded;
    private List<State> generated;
    private Stack<State> edge;

    public DepthFirstSearch(State initial) {
        this.expanded = new ArrayList<>();
        this.generated = new ArrayList<>();
        this.edge = new Stack<>();

        this.generated.add(initial);
        this.edge.push(initial);
    }

    private List<State> getExpanded() {

        return expanded;
    }

    private Stack<State> getEdge() {

        return edge;
    }

    private List<State> getGenerated() {

        return generated;
    }

    public VacuumCleaner DFS(VacuumCleaner agent, Environment environment) {

        if (!edge.empty()) {
            State actualState = getEdge().pop();

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
                    generateStates(column, environment);
                    expanded.add(actualState);
                }

                environment.actionPerformed(agent, actualState, environment.getInitialState());
                this.DFS(agent, environment);

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
                if (!getExpanded().contains(state) &&
                        !getGenerated().contains(state)) {

                    generated.add(state);
                    edge.push(state);
                }
            }
        }
    }
}
