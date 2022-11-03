package UI;

import Abstract.IInput;
import Abstract.Ship;
import Models.Coordinate;
import Ships.Battleship;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class Input implements IInput
{
    public Coordinate getCoordinates() {
        Scanner input = new Scanner(System.in);
        Dictionary<String, Integer> dict = new Hashtable<String, Integer>() {{
            put("A",0);put("B",1);put("C",2);put("D",3);put("E",4);
            put("F",5);put("G",6);put("H",7);put("I",8);put("J",9);
        }};
        System.out.println("Enter a coordinate: ");

        String coord= input.nextLine();
        String[] parts = coord.split(" ");

        String x = parts[0].trim();
        String y = parts[1].trim();
        int X = dict.get(parts[0].trim().toUpperCase());
        int Y = Integer.parseInt(y);
        Coordinate coordinate = new Coordinate(X,Y-1);
        System.out.println("x: " + x + "\ny: " + y);
        return coordinate;
    }

    public ArrayList<Ship> setShips() {
        // enter begin and end coords for battleship(length 4):

        Scanner input = new Scanner(System.in);
        ArrayList ships = new ArrayList<Ship>(10);
        Dictionary<String, Integer> dict = new Hashtable<String, Integer>() {{
            put("A",0);put("B",1);put("C",2);put("D",3);put("E",4);
            put("F",5);put("G",6);put("H",7);put("I",8);put("J",9);
        }};
try {


        for (int i =0; i<1; i++) {
            System.out.println("Enter starting coordinates of Battleship ");

            String coord1= input.nextLine();
            String[] parts = coord1.split(" ");

            String x1 = parts[0].trim();
            String y1 = parts[1].trim();
            int X1 = dict.get(parts[0].trim().toUpperCase());
            int Y1 = Integer.parseInt(y1);
            Coordinate coordinate1 = new Coordinate(X1,Y1-1);
            System.out.println("x: " + x1 + "\ny: " + y1);

            System.out.println("Enter ending coordinates of Battleship ");

            String coord2= input.nextLine();
            String[] parts2 = coord2.split(" ");

            String x2 = parts2[0].trim();
            String y2 = parts2[1].trim();
            int X2 = dict.get(parts2[0].trim().toUpperCase());
            int Y2 = Integer.parseInt(y2);
            Coordinate coordinate2 = new Coordinate(X2,Y2-1);
            System.out.println("x: " + x2 + "\ny: " + y2);
            Battleship battleship = new Battleship(coordinate1,coordinate2);

            ships.add(battleship);
        }
}
catch (Exception exception){
    exception.getMessage();

}
            return ships;
    }
}

        // enders e g b2, b6
        // ente



