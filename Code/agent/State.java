package agent;

public class State {

    private boolean tileA;
    private boolean tileB;
    private char side;
    private boolean objective;
    private State father;
    private int heuristicCost;
    private Actions action;

    public boolean getTileA() {

        return tileA;
    }

    public State tileA(boolean tileA) {
        this.tileA = tileA;
        return this;
    }

    public boolean getTileB() {

        return tileB;
    }

    public State tileB(boolean tileB) {
        this.tileB = tileB;
        return this;
    }

    public char getSide() {

        return side;
    }

    public State getFather() {

        return father;
    }

    public void setFather(State father) {

        this.father = father;
    }

    public State father(State state) {
        this.father = state;
        return this;
    }

    public int getHeuristicCost() {

        return heuristicCost;
    }

    public void setHeuristicCost(int heuristicCost) {

        this.heuristicCost = heuristicCost;
    }

    public State heuristicCost(int heuristicCost) {
        this.heuristicCost = heuristicCost;
        return this;
    }

    public Actions getAction() {

        return action;
    }

    public State action(Actions action) {
        this.action = action;
        return this;
    }

    public State side(char side) {
        this.side = side;
        return this;
    }

    public boolean isObjective() {

        return objective;
    }

    public State objective(boolean objective) {
        this.objective = objective;
        return this;
    }

    @Override
    public String toString() {
        return "State: {" +
                "\n\tTile A dirty: " + tileA +
                ",\n\tTile B dirty: " + tileB +
                ",\n\tAgent position: " + side +
                "\n}\n\n";
    }
}
