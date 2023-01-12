package main.Abstract;

import main.Models.Cell;
import main.Models.Coordinate;
import main.Models.Map;
import main.Static.Properties;

public abstract class PlayerBase implements IPlayer, IEnemy {
    public PlayerBase(){
        Cell[][] grid= new Cell[Properties.MapSize][Properties.MapSize];
        for (int i = 0; i < grid.length; i++) {
            // length returns number of rows
            for (int j = 0; j < grid[i].length; j++) {
                // here length returns # of columns corresponding to current row
                grid[i][j] = new Cell(i, j);
            }
        }
        Map = new Map(grid);
    }
    protected IMap Map;
    protected IEnemy Enemy;
    public IMap getMap() {
        return Map;
    }
    public boolean isDefeated() {
        //checking if there are cells with ship
        var grid = Map.getGrid();
        for (int i = 0; i < grid.length; i++) {
            // length returns number of rows
            for (int j = 0; j < grid[i].length; j++) {
                // here length returns # of columns corresponding to current row
                if(grid[i][j].withShip()){
                    return false;
                }
            }
        }
        return true;
    }
    public void setEnemy(IEnemy enemy) {
        Enemy = enemy;
    }
    public void CheckCell(Coordinate coordinate) {
        Map.damageCell(coordinate);
    }
}
