package Ships;

import Abstract.Ship;
import Models.Coordinate;
import Models.State;

public class Patrol extends Ship {
    public Patrol(Coordinate coord1, Coordinate coord2){
        createShip(coord1,coord2,Patrol.Length, State.WithPatrol);
    }
    public static final int Length = 2;
    public static final int Count = 4;
}
