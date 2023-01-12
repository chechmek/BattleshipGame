package main.Models;

import main.Abstract.*;
import main.UI.Input;
import java.util.ArrayList;
import java.util.Scanner;


public class Player extends PlayerBase
{
    private IInput Input;
    private String Name = "Player";
    public Player(){
        Input = new Input();
    }

    public void Move() {
        Coordinate attackCoords = Input.getCoordinates();
        Enemy.CheckCell(attackCoords);
    }

    public void setShips() {
        ArrayList<Ship> Ships = Input.setShips();
        Map.setShips(Ships);
    }
    public void setShipsAutomatically(){
        AIPlayer aiPlayer = new AIPlayer();
        Scanner input = new Scanner(System.in);
        ArrayList<Ship> ships = new ArrayList<Ship>();
        Cell[][] localGrid = new Cell[10][10];
        for (int i = 0; i < localGrid.length; i++) {
            for (int j = 0; j < localGrid[i].length; j++) {
                localGrid[i][j] = new Cell(i, j);
            }
        }

        try {
            ships.add(aiPlayer.setCarrierShip(input,localGrid) );
            for (int i = 0; i < 2; i++) {
                ships.add(aiPlayer.setBattleShip(input,localGrid));
            }
            for (int i = 0; i < 3; i++) {
                ships.add(aiPlayer.setSubmarineShip(input,localGrid));
            }
            for (int i = 0; i < 4; i++) {
                ships.add(aiPlayer.setPatrolShip(input, localGrid));
            }

        } catch (Exception e) {
        }
        Map.setShips(ships);
    }

    @Override
    public String getName() {
        return Name;
    }
}
