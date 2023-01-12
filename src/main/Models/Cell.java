package main.Models;

import main.CellState.State;
import main.CellState.StateAvailable;
import main.CellState.StateWithShip;

public class Cell {
    private State state;
    public Coordinate Coordinate;
    public Cell(int x, int y){
        setState(new StateAvailable());
        Coordinate = new Coordinate(x, y);
    }
    public Cell(int x, int y, State state){
        this.setState(state);
        Coordinate = new Coordinate(x, y);
    }
    public void damage(){
        state = state.damage();
    }

    public boolean withShip(){
        if (getState() instanceof StateWithShip){
            return true;
        }
        return false;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
