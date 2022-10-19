package Ships;

import Abstract.Ship;
import Models.Coordinate;

public class Submarine extends Ship {
    public Submarine(Coordinate begin, Coordinate end){
        super(begin, end);
    }
    public static final int Length = 3;
    public static final int Count = 3;
}
