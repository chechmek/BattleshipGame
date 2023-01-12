package main.UI;

import main.Abstract.IMap;
import main.Abstract.IPlayer;
import main.Abstract.IUserInterface;
import main.Abstract.Ship;
import main.CellState.*;
import main.Models.Cell;
import main.Static.Properties;

import java.util.ArrayList;

public class UserInterface implements IUserInterface
{
    public void updateScreen(IMap playerMap, IMap enemyMap) {

        Cell[][] playerGrid = playerMap.getGrid();

        drawGridWithoutShips(enemyMap, "TARGET GRID");
        drawGridWithoutShips(playerMap, "OCEAN GRID");
    }

    private void drawGridWithoutShips(IMap map , String name){
        String[][] gridToDraw = new String[Properties.MapSize][Properties.MapSize];
        Cell[][] grid = map.getGrid();
        ArrayList<Ship> ships = map.getShips();
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].getState() instanceof  StateAvailable) {
                    gridToDraw[i][j] = "I ";
                } else if (grid[i][j].getState() instanceof StateUnavailable) {
                    gridToDraw[i][j] = "- ";
                } else if (grid[i][j].getState() instanceof StateBattleship) {
                    gridToDraw[i][j] = "I ";
                } else if (grid[i][j].getState() instanceof StateCarrier) {
                    gridToDraw[i][j] = "I ";
                } else if (grid[i][j].getState() instanceof StateSubmarine) {
                    gridToDraw[i][j] = "I ";
                } else if (grid[i][j].getState() instanceof StatePatrol) {
                    gridToDraw[i][j] = "I ";
                }
                else if (grid[i][j].getState() instanceof StateDamagedShip){
                    gridToDraw[i][j] = "X ";
                } else {
                    System.out.print("* ");
                }
            }
        }
        // show only destroyed ships
        for(int i = 0; i < ships.size(); i++){
            if(ships.get(i).isDestroyed()){
                Ship ship = ships.get(i);
                for(int j = 0; j < ship.Array.length; j++){
                    gridToDraw[ship.Array[j].Coordinate.X][ship.Array[j].Coordinate.Y] = ship.getSign() + " ";
                }
            }
        }
        // draw
        System.out.print("\n===== " + name + " =====\n  A B C D E F G H I J");
        for (int i = 0; i < grid.length; i++) {
            System.out.println();
            System.out.print(i + " ");
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(gridToDraw[i][j]);
            }
        }
    }
    public static void drawGrid(Cell[][] grid , String name){
        System.out.print("\n===== " + name + " =====\n  A B C D E F G H I J");
        for (int i = 0; i < grid.length; i++) {
            System.out.println();
            System.out.print(i + " ");
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].getState() instanceof StateAvailable) {
                    System.out.print("I ");
                } else if (grid[i][j].getState() instanceof StateUnavailable) {

                    System.out.print("- ");

                } else if (grid[i][j].getState() instanceof StateBattleship) {
                    System.out.print("B ");
                } else if (grid[i][j].getState() instanceof StateCarrier) {
                    System.out.print("C ");
                } else if (grid[i][j].getState() instanceof StateSubmarine) {
                    System.out.print("S ");
                } else if (grid[i][j].getState() instanceof StatePatrol) {
                    System.out.print("P ");
                }
                else if (grid[i][j].getState() instanceof StateDamagedShip){
                    System.out.print("X ");
                } else {
                    System.out.print("* ");
                }
            }
        }
    }

    public void showVictoryScreen(IPlayer player) {
        System.out.println(player.getName() + " wins!!!");
    }
}
