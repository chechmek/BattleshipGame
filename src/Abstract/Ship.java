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
        for(int i = 0; i < Array.length; i++){
            if(Array[i].withShip()){
                return false;
            }
        }
        return true;
    }
}
