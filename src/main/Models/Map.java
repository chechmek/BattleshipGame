package main.Models;

import main.Abstract.IMap;
import main.Abstract.Ship;
import main.CellState.StateDamagedShip;
import main.CellState.StateUnavailable;

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
    public static void breakAroundShip(Ship ship, Cell[][] grid){
        // break around the ship
        try{
            if(ship.Array[0].Coordinate.X == ship.Array[1].Coordinate.X) // down
                grid[ship.Array[0].Coordinate.X ][ship.Array[0].Coordinate.Y + ship.Array.length].damage();
        }
        catch(Exception e){}
        try{
            if(ship.Array[0].Coordinate.Y == ship.Array[1].Coordinate.Y) // right
                grid[ship.Array[0].Coordinate.X + ship.Array.length][ship.Array[0].Coordinate.Y].damage();
        }

        catch (Exception e){}
        try {
            for (int i = 0; i < ship.Array.length; i++) {
                Cell cell = ship.Array[i];
                int x = cell.Coordinate.X + 1;
                int y = cell.Coordinate.Y;
                if(grid[x][y].withShip())
                    throw new Exception();
                grid[x][y] = new Cell(x, y, new StateUnavailable());
            }
        } catch (Exception e) {}
        try {
            for (int i = 0; i < ship.Array.length; i++) {
                Cell cell = ship.Array[i];
                int x = cell.Coordinate.X - 1;
                int y = cell.Coordinate.Y;
                if(grid[x][y].withShip())
                    throw new Exception();
                grid[x][y] = new Cell(x, y, new StateUnavailable());
            }
        } catch (Exception e) {}
        try {
            for (int i = 0; i < ship.Array.length; i++) {
                Cell cell = ship.Array[i];
                int x = cell.Coordinate.X;
                int y = cell.Coordinate.Y + 1;
                if(grid[x][y].withShip())
                    throw new Exception();
                grid[x][y] = new Cell(x, y, new StateUnavailable());
            }
        } catch (Exception e) {}
        try {
            for (int i = 0; i < ship.Array.length; i++) {
                Cell cell = ship.Array[i];
                int x = cell.Coordinate.X;
                int y = cell.Coordinate.Y - 1;
                if(grid[x][y].withShip())
                    throw new Exception();
                grid[x][y] = new Cell(x, y, new StateUnavailable());
            }
        } catch (Exception e) {}

        try {
            for (int i = 0; i < ship.Array.length; i++) {
                Cell cell = ship.Array[i];
                int x = cell.Coordinate.X + 1;
                int y = cell.Coordinate.Y + 1;
                if(grid[x][y].withShip())
                    throw new Exception();
                grid[x][y] = new Cell(x, y, new StateUnavailable());
            }
        } catch (Exception e) {}
        try {
            for (int i = 0; i < ship.Array.length; i++) {
                Cell cell = ship.Array[i];
                int x = cell.Coordinate.X + 1;
                int y = cell.Coordinate.Y - 1;
                if(grid[x][y].withShip())
                    throw new Exception();
                grid[x][y] = new Cell(x, y, new StateUnavailable());
            }
        } catch (Exception e) {}
        try {
            for (int i = 0; i < ship.Array.length; i++) {
                Cell cell = ship.Array[i];
                int x = cell.Coordinate.X - 1;
                int y = cell.Coordinate.Y + 1;
                if(grid[x][y].withShip())
                    throw new Exception();
                grid[x][y] = new Cell(x, y, new StateUnavailable());
            }
        } catch (Exception e) {}
        try {
            for (int i = 0; i < ship.Array.length; i++) {
                Cell cell = ship.Array[i];
                int x = cell.Coordinate.X - 1;
                int y = cell.Coordinate.Y - 1;
                if(grid[x][y].withShip())
                    throw new Exception();
                grid[x][y] = new Cell(x, y, new StateUnavailable());
            }
        } catch (Exception e) {}
    }
    public void setShips(ArrayList<Ship> ships) {
        this.ships = ships;
        for (int i=0; i < ships.size(); i++){
            for (int j=0; j < ships.get(i).Array.length; j++) {
                Cell[] shipAray = ships.get(i).Array;
                grid[shipAray[j].Coordinate.X][shipAray[j].Coordinate.Y].setState(shipAray[j].getState());
            }
        }
    }
    public void damageCell(Coordinate coordinate) {
        // Damage on Map
        var isShip = tryDamageShip(coordinate);
        if (isShip){
           // grid[coordinate.X][coordinate.Y].State = State.DamagedShip;
        }
        else {
            grid[coordinate.X][coordinate.Y].damage();
        }
    }
    //Damage in Ship array
    private boolean tryDamageShip(Coordinate coordinate){
        for (int i = 0; i < ships.size(); i++) {
            // length returns number of rows
            for (int j = 0; j < ships.get(i).Array.length; j++) {
                // Check if hit
                var shipArray = ships.get(i).Array;
                if(shipArray[j].Coordinate.X == coordinate.X && shipArray[j].Coordinate.Y == coordinate.Y){
                    ships.get(i).Array[j].setState(new StateDamagedShip());
                    grid[coordinate.X][coordinate.Y].setState(new StateDamagedShip());
                    //Check if destroyed
                    if(ships.get(i).isDestroyed()){
                        breakAroundShip(ships.get(i), grid);
//                        for(int c = 0; c < ships.get(i).Array.length; c++){
//                            // show the ship back
//                            grid[ships.get(i).Array[c].Coordinate.X][ships.get(i).Array[c].Coordinate.Y].State
//                                    = state;
//                        }
                    }

                    return true;
                }
            }
        }
        return false;
    }
    private Cell[][] grid;
    private ArrayList<Ship> ships;
}
