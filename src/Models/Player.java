package Models;

import Abstract.*;
import UI.Input;
import java.util.ArrayList;


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

    @Override
    public String getName() {
        return Name;
    }
}
