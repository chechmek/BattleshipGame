package Models;

import Abstract.PlayerBase;
import Abstract.Ship;
import Ships.Carrier;
import Ships.Submarine;

import java.util.ArrayList;

public class AIPlayer extends PlayerBase
{
    public void setShips() {
// Implement Ai
        ArrayList<Ship> ships = new ArrayList<Ship>();
        ships.add(new Submarine(
                new Coordinate(2, 2),
                new Coordinate(2,4)
        ));
        Map.setShips(ships);
    }

    @Override
    public String getName() {
        return "AIPlayer";
    }

    public void Move() {

    }
}
