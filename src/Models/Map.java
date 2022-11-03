package Models;

import Abstract.IMap;
import Abstract.Ship;

import java.util.ArrayList;

public class Map implements IMap
{
    public Map(Cell[][] grid){
        this.grid = grid;
    }
    public Cell[][] getGrid(){
        return grid;
    }
    public ArrayList<Ship> getShips(){
        return ships;
    }
    public void setShips(ArrayList<Ship> ships) {
        this.ships = ships;
        for (int i=0; i < ships.size(); i++){
            for (int j=0; j < ships.get(i).Array.length; j++) {
                Cell[] shipAray = ships.get(i).Array;
                grid[shipAray[j].Coordinate.X][shipAray[j].Coordinate.Y].State = shipAray[j].State;
            }
        }
    }
    public void damageCell(Coordinate coordinate) {
        // Damage on Map
        var isShip = tryDamageShip(coordinate);
        if (isShip){
            grid[coordinate.X][coordinate.Y].State = State.DamagedShip;
        }
        else {
            grid[coordinate.X][coordinate.Y].State = State.Unavailable;
        }
    }
    //Damage in Ship array
    private boolean tryDamageShip(Coordinate coordinate){
        for (int i = 0; i < ships.size(); i++) {
            // length returns number of rows
            for (int j = 0; j < ships.get(i).Array.length; j++) {
                // here length returns # of columns corresponding to current row
                var shipArray = ships.get(i).Array;
                if(shipArray[j].Coordinate.X == coordinate.X
                        && shipArray[j].Coordinate.Y == coordinate.Y){
                    ships.get(i).Array[j].State = State.DamagedShip;
                    return true;
                }
            }
        }
        return false;
    }
    private Cell[][] grid;
    private ArrayList<Ship> ships;
}
