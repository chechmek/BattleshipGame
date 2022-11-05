package Ships;

import Abstract.Ship;
import Models.Coordinate;
import Models.State;

public class Submarine extends Ship {
    public Submarine(Coordinate coord1, Coordinate coord2){
        Array = createShip(coord1,coord2,Submarine.Length, State.WithSubmarine);
    }
    public static final int Length = 3;
    public static final int Count = 3;
}
