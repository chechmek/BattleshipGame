package UI;

import Abstract.IInput;
import Abstract.Ship;
import Models.Coordinate;
import Ships.Battleship;

import java.util.ArrayList;
import java.util.Scanner;

public class Input implements IInput
{
    public Coordinate getCoordinates() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a coordinate: ");

        String coord= input.nextLine();
        String[] parts = coord.split(",");

        String x = parts[0].trim();
        String y = parts[1].trim();
        int X = Integer.parseInt(x);
        int Y = Integer.parseInt(y);
        Coordinate coordinate = new Coordinate(X,Y);
        System.out.println("x: " + x + "\ny: " + y);
        return coordinate;
    }

    public ArrayList<Ship> setShips() {


        return null;
    }

}
