package Ships;

import Abstract.Ship;
import Models.Coordinate;
import Models.State;

public class Carrier extends Ship {
    public Carrier(Coordinate coord1, Coordinate coord2){
        createShip(coord1,coord2,Carrier.Length, State.WithCarrier);
    }
    public static final int Length = 6;
    public static final int Count = 1;
}
