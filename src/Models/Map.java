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
    }
    public void damageCell(Coordinate coordinate) {
        // Damage on Map
        if(grid[coordinate.X][coordinate.Y].withShip()){
            grid[coordinate.X][coordinate.Y].State = State.DamagedShip;
        }
        if(grid[coordinate.X][coordinate.Y].State == State.Available){
            grid[coordinate.X][coordinate.Y].State = State.Unavailable;
        }

        //Damage in Ship array
        for (int i = 0; i < ships.size(); i++) {
            // length returns number of rows
            for (int j = 0; j < ships.get(i).Array.length; j++) {
                // here length returns # of columns corresponding to current row
                var shipArray = ships.get(i).Array;
                if(shipArray[j].Coordinate.X == coordinate.X
                && shipArray[j].Coordinate.Y == coordinate.Y){
                    ships.get(i).Array[j].State = State.DamagedShip;
                }
            }
        }
    }
    private Cell[][] grid;
    private ArrayList<Ship> ships;
}
