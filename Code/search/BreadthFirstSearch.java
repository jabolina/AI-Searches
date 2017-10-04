package search;

import agent.State;
import agent.VacuumCleaner;
import environment.Environment;

import static auxiliary.AuxiliaryFunctions.findColumnOnGraph;
import static auxiliary.AuxiliaryFunctions.findRowOnGraph;


public class BreadthFirstSearch {

    private List<State> expanded;
    private List<State> generated;
    private Queue<State> edge;

    public BreadthFirstSearch(State initial) {
        this.expanded = new ArrayList<>();
        this.generated = new ArrayList<>();
        this.edge = new ArrayDeque<>();

        this.generated.add(initial);
        this.edge.add(initial);
    }

    private List<State> getExpanded() {

        return expanded;
    }

    private List<State> getGenerated() {

        return generated;
    }

    private Queue<State> getEdge() {

        return edge;
    }

    public VacuumCleaner BFS(VacuumCleaner agent, Environment environment) {

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
                    generateStates(column, environment);
                    expanded.add(actualState);
                }

                environment.actionPerformed(agent, actualState, environment.getInitialState());
                this.BFS(agent, environment);

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
                    edge.add(state);
                }
            }
        }
    }
}
