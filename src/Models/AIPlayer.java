package Models;

import Abstract.PlayerBase;
import Abstract.Ship;
import Ships.Carrier;

import java.util.ArrayList;

public class AIPlayer extends PlayerBase
{
    public void setShips() {
// Implement Ai
        ArrayList<Ship> ships = new ArrayList<Ship>();
        ships.add(new Carrier(
                new Coordinate(2, 2),
                new Coordinate(2,7)
        ));
        Map.setShips(ships);
    }

    public void Move() {

    }
}
