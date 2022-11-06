package UI;

import Abstract.IMap;
import Abstract.IPlayer;
import Abstract.IUserInterface;
import Models.Cell;
import Models.State;

public class UserInterface implements IUserInterface
{
    public void updateScreen(IMap playerMap, IMap enemyMap) {

        Cell[][] playerGrid = playerMap.getGrid();
        Cell[][] enemyGrid = enemyMap.getGrid();

        drawGrid(playerGrid, "TARGET GRID");
        drawGrid(enemyGrid, "OCEAN GRID");

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
                    System.out.print("X ");
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

    }
}
