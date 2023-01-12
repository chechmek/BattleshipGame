package main.Ships;

import main.Abstract.Ship;
import main.CellState.StateCarrier;
import main.Models.Coordinate;


public class Carrier extends Ship {
    public Carrier(Coordinate coord1, Coordinate coord2){
        Array = createShip(coord1,coord2,Carrier.Length, new StateCarrier());
    }
    public static final int Length = 6;
    public static final int Count = 1;
    @Override
    public String getSign() {
        return "C";
    }
}
