package Ships;

import Abstract.Ship;
import Models.Coordinate;

public class Carrier extends Ship {
    public Carrier(Coordinate begin, Coordinate end){
        super(begin, end);
    }
    public static final int Length = 6;
    public static final int Count = 1;
}
