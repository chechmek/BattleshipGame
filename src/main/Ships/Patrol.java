package main.Ships;

import main.Abstract.Ship;
import main.CellState.StatePatrol;
import main.Models.Coordinate;


public class Patrol extends Ship {
    public Patrol(Coordinate coord1, Coordinate coord2){
        Array = createShip(coord1,coord2,Patrol.Length, new StatePatrol());
    }
    public static final int Length = 2;
    public static final int Count = 4;
    @Override
    public String getSign() {
        return "P";
    }
}
