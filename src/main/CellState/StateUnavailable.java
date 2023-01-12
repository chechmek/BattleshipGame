package main.CellState;

public class StateUnavailable extends State {

    @Override
    public State damage() {

        return this;
    }
}
