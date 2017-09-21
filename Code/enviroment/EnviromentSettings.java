package enviroment;

import agent.Actions;
import agent.State;

public class EnviromentSettings {

    private State[][] graph;

    public EnviromentSettings() {
        this.setGraph();
    }

    public State[][] getGraph() {
        return graph;
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
                .side('E');
        graph[0][1] = new State()
                .tileA(true)
                .tileB(true)
                .action(Actions.RIGHT)
                .side('D');
        graph[0][2] = new State()
                .tileA(false)
                .tileB(true)
                .action(Actions.ASPIRATE)
                .side('E');

        graph[1][0] = new State()
                .tileA(true)
                .tileB(true)
                .action(Actions.LEFT)
                .side('E');
        graph[1][1] = new State()
                .tileA(true)
                .tileB(true)
                .action(Actions.RIGHT)
                .side('D');
        graph[1][3] = new State()
                .tileA(true)
                .tileB(false)
                .action(Actions.ASPIRATE)
                .side('D');


        graph[2][2] = new State()
                .tileA(false)
                .tileB(true)
                .action(Actions.LEFT)
                .side('E');
        graph[2][4] = new State()
                .tileA(false)
                .tileB(true)
                .action(Actions.RIGHT)
                .side('D');


        graph[3][3] = new State()
                .tileA(true)
                .tileB(false)
                .action(Actions.RIGHT)
                .side('D');
        graph[3][5] = new State()
                .tileA(true)
                .tileB(false)
                .action(Actions.ASPIRATE)
                .side('E');


        graph[4][2] = new State()
                .tileA(false)
                .tileB(true)
                .action(Actions.LEFT)
                .side('E');
        graph[4][4] = new State()
                .tileA(false)
                .tileB(true)
                .action(Actions.RIGHT)
                .side('D');
        graph[4][6] = new State()
                .tileA(false)
                .tileB(false)
                .action(Actions.ASPIRATE)
                .side('D');


        graph[5][3] = new State()
                .tileA(true)
                .tileB(false)
                .action(Actions.RIGHT)
                .side('D');
        graph[5][5] = new State()
                .tileA(true)
                .tileB(false)
                .action(Actions.LEFT)
                .side('E');
        graph[5][7] = new State()
                .tileA(false)
                .tileB(false)
                .action(Actions.ASPIRATE)
                .side('E');


        graph[6][6] = new State()
                .tileA(false)
                .tileB(false)
                .action(Actions.RIGHT)
                .side('D');
        graph[6][7] = new State()
                .tileA(false)
                .tileB(false)
                .action(Actions.LEFT)
                .side('E');


        graph[7][6] = new State()
                .tileA(false)
                .tileB(false)
                .action(Actions.RIGHT)
                .side('D');
        graph[7][7] = new State()
                .tileA(false)
                .tileB(false)
                .action(Actions.LEFT)
                .side('E');
    }

}
