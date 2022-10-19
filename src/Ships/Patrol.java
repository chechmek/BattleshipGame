package Ships;

import Abstract.Ship;
import Models.Coordinate;

public class Patrol extends Ship {
    public Patrol(Coordinate begin, Coordinate end){
        super(begin, end);
    }
    public static final int Length = 2;
    public static final int Count = 4;
}
