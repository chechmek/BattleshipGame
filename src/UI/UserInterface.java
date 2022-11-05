package UI;

import Abstract.IMap;
import Abstract.IPlayer;
import Abstract.IUserInterface;
import Models.Cell;
import Models.State;

public class UserInterface implements IUserInterface
{
    public void updateScreen(IMap playerMap, IMap enemyMap) {

        Cell[][] grid= playerMap.getGrid();
        System.out.print("\n===== TARGET GRID =====\n  A B C D E F G H I J");
        for (int i=0; i < grid.length; i++){
            System.out.println();
            System.out.print(i+" ");
            for (int j=0; j < grid[i].length; j++){
                if (grid[i][j].State == State.Available){
                    System.out.print("I ");
                }
                else if (grid[i][j].State == State.Unavailable){
                    System.out.print("X ");
                }
                else if (grid[i][j].State == State.WithBattleship){
                    System.out.print("B ");
                }
                else if (grid[i][j].State == State.WithCarrier){
                    System.out.print("C ");
                }
                else if (grid[i][j].State == State.WithSubmarine){
                    System.out.print("S ");
                }
                else if (grid[i][j].State == State.WithPatrol){
                    System.out.print("P ");
                }
                else {
                    System.out.print("Error");
                }
//                switch (grid[i][j].State) {
//                    case Available: System.out.print("A");
//                    case Unavailable: System.out.print("O");
//                    case WithShip: System.out.print('B');
//                    case DamagedShip: System.out.print('X');}

            }

        }

    }

    public void showVictoryScreen(IPlayer player) {

    }
}
