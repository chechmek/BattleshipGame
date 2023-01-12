package main.Ships;

import main.Abstract.Ship;
import main.CellState.StateBattleship;
import main.Models.Coordinate;


public class Battleship extends Ship {
    public Battleship (Coordinate coord1, Coordinate coord2){
        Array = createShip(coord1,coord2,Battleship.Length, new StateBattleship());
    }

    public static final int Length = 4;
    public static final int Count = 2;

    @Override
    public String getSign() {
        return "B";
    }
}
