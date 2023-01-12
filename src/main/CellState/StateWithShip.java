package main.CellState;

public abstract class StateWithShip extends State {
    @Override
    public State damage() {
        return new StateDamagedShip();
    }
}
