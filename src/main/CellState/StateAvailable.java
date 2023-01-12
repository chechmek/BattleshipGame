package main.CellState;

public class StateAvailable extends State {

    @Override
    public State damage() {
        return new StateUnavailable();
    }
}
