package UI;

import Abstract.IMap;
import Abstract.IPlayer;
import Abstract.IUserInterface;
import Abstract.Ship;
import Models.Cell;
import Models.State;
import Static.Properties;

import java.util.ArrayList;

public class UserInterface implements IUserInterface
{
    public void updateScreen(IMap playerMap, IMap enemyMap) {

        Cell[][] playerGrid = playerMap.getGrid();


        drawGrid(playerGrid, "TARGET GRID");
        drawGridWithoutShips(enemyMap, "OCEAN GRID");

    }

    private void drawGridWithoutShips(IMap map , String name){
        String[][] gridToDraw = new String[Properties.MapSize][Properties.MapSize];
        Cell[][] grid = map.getGrid();
        ArrayList<Ship> ships = map.getShips();
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].State == State.Available) {
                    gridToDraw[i][j] = "I ";
                } else if (grid[i][j].State == State.Unavailable) {
                    gridToDraw[i][j] = "- ";
                } else if (grid[i][j].State == State.WithBattleship) {
                    gridToDraw[i][j] = "I ";
                } else if (grid[i][j].State == State.WithCarrier) {
                    gridToDraw[i][j] = "I ";
                } else if (grid[i][j].State == State.WithSubmarine) {
                    gridToDraw[i][j] = "I ";
                } else if (grid[i][j].State == State.WithPatrol) {
                    gridToDraw[i][j] = "I ";
                }
                else if (grid[i][j].State == State.DamagedShip){
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
                if (grid[i][j].State == State.Available) {
                    System.out.print("I ");
                } else if (grid[i][j].State == State.Unavailable) {

                    System.out.print("- ");

                } else if (grid[i][j].State == State.WithBattleship) {
                    System.out.print("B ");
                } else if (grid[i][j].State == State.WithCarrier) {
                    System.out.print("C ");
                } else if (grid[i][j].State == State.WithSubmarine) {
                    System.out.print("S ");
                } else if (grid[i][j].State == State.WithPatrol) {
                    System.out.print("P ");
                }
                else if (grid[i][j].State == State.DamagedShip){
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
