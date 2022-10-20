package Abstract;

import Models.Cell;
import Models.Coordinate;
import Models.Map;
import Models.State;
import Static.Properties;

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
                if(grid[i][j].State == State.Available){
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
