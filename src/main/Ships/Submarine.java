package main.Ships;

import main.Abstract.Ship;
import main.CellState.StateSubmarine;
import main.Models.Coordinate;


public class Submarine extends Ship {
    public Submarine(Coordinate coord1, Coordinate coord2){
        Array = createShip(coord1,coord2,Submarine.Length, new StateSubmarine());
    }
    public static final int Length = 3;
    public static final int Count = 3;
    @Override
    public String getSign() {
        return "S";
    }
}
