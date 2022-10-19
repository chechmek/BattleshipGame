package Models;

public class Cell {
    public State State;
    public Coordinate Coordinate;
    public Cell(int x, int y){
        State = Models.State.Available;
        Coordinate = new Coordinate(x, y);
    }
    public Cell(int x, int y, State state){
        State = state;
        Coordinate = new Coordinate(x, y);
    }
}
