package Ships;

import Abstract.Ship;
import Models.Coordinate;
import Models.Cell;
import Models.State;

import java.lang.reflect.Array;


public class Battleship extends Ship {
    public Battleship (Coordinate coord1, Coordinate coord2){
        createShip(coord1,coord2,Battleship.Length, State.WithBattleship);
    }

    public static final int Length = 4;
    public static final int Count = 2;
}
