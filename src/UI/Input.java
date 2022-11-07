package UI;

import Abstract.IInput;
import Abstract.Ship;
import Models.Cell;
import Models.Coordinate;
import Models.Map;
import Models.State;
import Ships.Battleship;
import Ships.Carrier;
import Ships.Patrol;
import Ships.Submarine;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class Input implements IInput {
    public Coordinate getCoordinates() {
        Scanner input = new Scanner(System.in);
        boolean gotCoord = false;
        System.out.println("Enter a coordinate to shoot: ");

        while (!gotCoord) {
            try {
                String coordStr = input.nextLine();
                Coordinate coordinate = getCoordinateFromStr(coordStr);
                gotCoord = true;
                return coordinate;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Try again");
            }
        }

        return new Coordinate(0, 0);
    }

    public ArrayList<Ship> setShips() {
        Scanner input = new Scanner(System.in);
        ArrayList<Ship> ships = new ArrayList<Ship>(10);
        Cell[][] localGrid = new Cell[10][10]; // for ships to know where are other ships
        for (int i = 0; i < localGrid.length; i++) {
            for (int j = 0; j < localGrid[i].length; j++) {
                localGrid[i][j] = new Cell(i, j);
            }
        }

        try {
            showLocalGrid(localGrid);
            for (int i = 0; i < Carrier.Count; i++) {
                ships.add(setCarrierShip(input, localGrid, i + 1));
                showLocalGrid(localGrid);
            }

            for (int i = 0; i < Battleship.Count; i++) {
                ships.add(setBattleShip(input, localGrid, i + 1));
                showLocalGrid(localGrid);
            }
            for (int i = 0; i < Submarine.Count; i++) {
                ships.add(setSubmarineShip(input, localGrid, i + 1));
                showLocalGrid(localGrid);
            }
            for (int i = 0; i < Patrol.Count; i++) {
                ships.add(setPatrolShip(input, localGrid, i + 1));
                showLocalGrid(localGrid);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ships;
    }

    private void showLocalGrid(Cell[][] grid) {
        UserInterface.drawGrid(grid, "YOUR SHIPS");
    }

    private final Dictionary<String, Integer> dict = new Hashtable<String, Integer>() {{
        put("A", 0);
        put("B", 1);
        put("C", 2);
        put("D", 3);
        put("E", 4);
        put("F", 5);
        put("G", 6);
        put("H", 7);
        put("I", 8);
        put("J", 9);
    }};

    private Coordinate getCoordinateFromStr(String coord) throws Exception {
        String xStr = coord.substring(0, 1);
        String yStr = coord.substring(1, 2);
        System.out.println("x: " + xStr + "\ny: " + yStr);

        int x = dict.get(xStr.trim().toUpperCase());
        int y = Integer.parseInt(yStr);
        if (!isValidInt(x))
            throw new Exception("X is not valid: " + x);
        if (!isValidInt(y))
            throw new Exception("Y is not valid: " + y);

        return new Coordinate(y, x);
    }

    private boolean isValidInt(int n) {
        if (n < 0 || n > 9)
            return false;
        return true;
    }

    private boolean isValidShip(Coordinate coord1, Coordinate coord2, int length, Cell[][] localGrid) {
        if (coord1.X == coord2.X && coord2.Y - coord1.Y == length - 1) {
            for(int i = 0; i < length; i++){
                if(localGrid[coord1.X][coord1.Y + i].withShip() || localGrid[coord1.X][coord1.Y + i].State == State.Unavailable)
                    return false;
            }
            return true;
        } else if (coord1.Y == coord2.Y && coord2.X - coord1.X == length - 1) {
            for(int i = 0; i < length; i++){
                if(localGrid[coord1.X + i][coord1.Y].withShip() || localGrid[coord1.X + i][coord1.Y].State == State.Unavailable)
                    return false;
            }
            return true;
        }
        return false;
    }

    private Ship setBattleShip(Scanner input, Cell[][] localGrid, int count) throws Exception {
        boolean isCreated = false;
        Battleship battleship;
        while (!isCreated) {
            try {
                System.out.println("Enter coordinates of Battleship " + count);
                String coordsStr = input.nextLine().trim();
                String[] coordsStrArray = coordsStr.split(",");
                Coordinate begin = getCoordinateFromStr(coordsStrArray[0]);
                Coordinate end = getCoordinateFromStr(coordsStrArray[1]);

                if (!isValidShip(begin, end, Battleship.Length, localGrid))
                    throw new Exception("Coordinates are not valid!");

                battleship = new Battleship(begin, end);
                isCreated = true;
                changeLocalGrid(battleship, localGrid, State.WithBattleship);
                return battleship;

            } catch (Exception exception) {
                System.out.println(exception.getMessage());
                System.out.println("Try again");
            }
        }
        throw new Exception("Cannot create a battleship");
    }

    private Ship setPatrolShip(Scanner input, Cell[][] localGrid, int count) throws Exception {
        boolean isCreated = false;
        Patrol ship;
        while (!isCreated) {
            try {
                System.out.println("Enter coordinates of Patrol " + count);
                String coordsStr = input.nextLine().trim();
                String[] coordsStrArray = coordsStr.split(",");
                Coordinate begin = getCoordinateFromStr(coordsStrArray[0]);
                Coordinate end = getCoordinateFromStr(coordsStrArray[1]);

                if (!isValidShip(begin, end, Patrol.Length, localGrid))
                    throw new Exception("Coordinates are not valid!");

                ship = new Patrol(begin, end);
                isCreated = true;
                changeLocalGrid(ship, localGrid, State.WithPatrol);
                return ship;

            } catch (Exception exception) {
                System.out.println(exception.getMessage());
                System.out.println("Try again");
            }
        }
        throw new Exception("Cannot create a ship");
    }

    private Ship setCarrierShip(Scanner input, Cell[][] localGrid, int count) throws Exception {
        boolean isCreated = false;
        Carrier ship;
        while (!isCreated) {
            try {
                System.out.println("Enter coordinates of Carrier " + count);
                String coordsStr = input.nextLine().trim();
                String[] coordsStrArray = coordsStr.split(",");
                Coordinate begin = getCoordinateFromStr(coordsStrArray[0]);
                Coordinate end = getCoordinateFromStr(coordsStrArray[1]);

                if (!isValidShip(begin, end, Carrier.Length, localGrid))
                    throw new Exception("Coordinates are not valid!");

                ship = new Carrier(begin, end);
                isCreated = true;
                changeLocalGrid(ship, localGrid, State.WithCarrier);
                return ship;

            } catch (Exception exception) {
                System.out.println(exception.getMessage());
                System.out.println("Try again");
            }
        }
        throw new Exception("Cannot create a ship");
    }

    private Ship setSubmarineShip(Scanner input, Cell[][] localGrid, int count) throws Exception {
        boolean isCreated = false;
        Submarine ship;
        while (!isCreated) {
            try {
                System.out.println("Enter coordinates of Submarine " + count);
                String coordsStr = input.nextLine().trim();
                String[] coordsStrArray = coordsStr.split(",");
                Coordinate begin = getCoordinateFromStr(coordsStrArray[0]);
                Coordinate end = getCoordinateFromStr(coordsStrArray[1]);

                if (!isValidShip(begin, end, Submarine.Length, localGrid))
                    throw new Exception("Coordinates are not valid!");

                ship = new Submarine(begin, end);
                isCreated = true;
                changeLocalGrid(ship, localGrid, State.WithSubmarine);
                return ship;

            } catch (Exception exception) {
                System.out.println(exception.getMessage());
                System.out.println("Try again");
            }
        }
        throw new Exception("Cannot create a ship");
    }

    private void changeLocalGrid(Ship ship, Cell[][] localGrid, State state) {
        for (int i = 0; i < ship.Array.length; i++) {
            Cell cell = ship.Array[i];
            localGrid[cell.Coordinate.X][cell.Coordinate.Y] = new Cell(cell.Coordinate.X, cell.Coordinate.Y, state);
        }
        Map.breakAroundShip(ship, localGrid);
    }

}