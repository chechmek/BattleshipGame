package Ships;

import Abstract.Ship;
import Models.Coordinate;

public class Battleship extends Ship {
    public Battleship(Coordinate begin, Coordinate end){
        super(begin, end);
    }
    public static final int Length = 4;
    public static final int Count = 2;
}
