package Models;

import Abstract.IMap;
import Abstract.Ship;

import java.util.ArrayList;

public class Map implements IMap
{
    public Map(Cell[][] grid){
        Grid = grid;
    }
    private Cell[][] Grid;
    private ArrayList<Ship> Ships;
    public Cell[][] getGrid(){
        return Grid;
    }
    public ArrayList<Ship> getShips(){
        return Ships;
    }
    public void setShips(ArrayList<Ship> ships) {
        Ships = ships;
    }
}
