package environment;

import agent.Actions;
import agent.State;

import java.util.ArrayList;
import java.util.List;

public class EnvironmentSettings {

    private State[][] graph = new State[8][8];
    private List<State> possibleStates = new ArrayList<>();

    public EnvironmentSettings() {
        this.setGraph();
        this.setPossibleStates();
    }

    public State[][] getGraph() {

        return graph;
    }

    public List<State> getPossibleStates() {

        return possibleStates;
    }

    private void setPossibleStates() {
        possibleStates.add(graph[0][0]);
        possibleStates.add(graph[1][1]);
        possibleStates.add(graph[2][2]);
        possibleStates.add(graph[3][3]);
        possibleStates.add(graph[4][4]);
        possibleStates.add(graph[5][5]);
        possibleStates.add(graph[6][6]);
        possibleStates.add(graph[7][7]);
    }

    private void setGraph() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                graph[i][j] = null;
            }
        }

        graph[0][0] = new State()
                .tileA(true)
                .tileB(true)
                .action(Actions.LEFT)
                .objective(false)
                .side('E');
        graph[0][1] = new State()
                .tileA(true)
                .tileB(true)
                .action(Actions.RIGHT)
                .objective(false)
                .side('D');
        graph[0][2] = new State()
                .tileA(false)
                .tileB(true)
                .action(Actions.ASPIRATE)
                .objective(false)
                .side('E');

        graph[1][0] = new State()
                .tileA(true)
                .tileB(true)
                .action(Actions.LEFT)
                .objective(false)
                .side('E');
        graph[1][1] = new State()
                .tileA(true)
                .tileB(true)
                .action(Actions.RIGHT)
                .objective(false)
                .side('D');
        graph[1][3] = new State()
                .tileA(true)
                .tileB(false)
                .action(Actions.ASPIRATE)
                .objective(false)
                .side('D');


        graph[2][2] = new State()
                .tileA(false)
                .tileB(true)
                .action(Actions.LEFT)
                .objective(false)
                .side('E');
        graph[2][4] = new State()
                .tileA(false)
                .tileB(true)
                .action(Actions.RIGHT)
                .objective(false)
                .side('D');


        graph[3][3] = new State()
                .tileA(true)
                .tileB(false)
                .action(Actions.RIGHT)
                .objective(false)
                .side('D');
        graph[3][5] = new State()
                .tileA(true)
                .tileB(false)
                .action(Actions.LEFT)
                .objective(false)
                .side('E');


        graph[4][2] = new State()
                .tileA(false)
                .tileB(true)
                .action(Actions.LEFT)
                .objective(false)
                .side('E');
        graph[4][4] = new State()
                .tileA(false)
                .tileB(true)
                .action(Actions.RIGHT)
                .objective(false)
                .side('D');
        graph[4][6] = new State()
                .tileA(false)
                .tileB(false)
                .action(Actions.ASPIRATE)
                .objective(false)
                .side('D');


        graph[5][3] = new State()
                .tileA(true)
                .tileB(false)
                .action(Actions.RIGHT)
                .objective(false)
                .side('D');
        graph[5][5] = new State()
                .tileA(true)
                .tileB(false)
                .action(Actions.LEFT)
                .objective(false)
                .side('E');
        graph[5][7] = new State()
                .tileA(false)
                .tileB(false)
                .action(Actions.ASPIRATE)
                .objective(false)
                .side('E');


        graph[6][6] = new State()
                .tileA(false)
                .tileB(false)
                .action(Actions.RIGHT)
                .objective(true)
                .side('D');
        graph[6][7] = new State()
                .tileA(false)
                .tileB(false)
                .action(Actions.LEFT)
                .objective(true)
                .side('E');


        graph[7][6] = new State()
                .tileA(false)
                .tileB(false)
                .action(Actions.RIGHT)
                .objective(true)
                .side('D');
        graph[7][7] = new State()
                .tileA(false)
                .tileB(false)
                .action(Actions.LEFT)
                .objective(true)
                .side('E');
    }

}
