package agent;

public class State {

    private boolean tileA;
    private boolean tileB;
    private char side;
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
}
