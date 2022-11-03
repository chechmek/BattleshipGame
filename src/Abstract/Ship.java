package Abstract;

import Models.Cell;
import Models.Coordinate;
import Models.State;
import Ships.Battleship;

public abstract class Ship {
    public Cell[] Array;


    public boolean isDestroyed(){
        // check if destroyed
        for(int i = 0; i < Array.length; i++){
            if(Array[i].withShip()){
                return false;
            }
        }
        return true;
    }

    protected Cell[] createShip(Coordinate coord1, Coordinate coord2, int length, State state){

        Cell shipArray [] = new Cell[length];

        //Checking coordinates for a horizontal or vertical positioning
        if (coord1.X == coord2.X ){
            if (Math.abs(coord1.Y-coord2.Y) == length - 1){
                // loop for adding several pieces of ship with attributes to one array
                for (int i =0; i < shipArray.length; i++){
                    shipArray[i] = new Cell(coord1.X, coord1.Y + i, state);
                }
                Array = shipArray;
            }
            else{

            }
        }
        else if ( coord1.Y ==coord2.Y){
            if (Math.abs(coord1.X-coord2.X) == length - 1){
                for (int i =0; i< length; i++){
                    shipArray[i] = new Cell(coord1.X + i, coord1.Y, state);
                }
                Array = shipArray;

            }
            else{
                //error
            }
        }
        else{
            //error
        }
        return shipArray;
    }
}
