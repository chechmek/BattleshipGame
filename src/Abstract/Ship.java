package Abstract;

import Models.Cell;
import Models.Coordinate;

public abstract class Ship {
    public Cell[] Array;
    public Ship(Coordinate begin, Coordinate end){
        //  Initialize ship
    }

    public boolean isDestroyed(){
        // check if destroyed
        return false;
    }
}
