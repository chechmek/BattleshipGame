package main.CellState;

public class StateDamagedShip extends State{
    @Override
    public State damage() {
        return this;
    }
}
