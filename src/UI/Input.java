package UI;

import Abstract.IInput;
import Abstract.Ship;
import Models.Cell;
import Models.Coordinate;
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

        while (!gotCoord)
        {
            try {
                Coordinate coordinate = getCoordinateFromStr(input);
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
                ships.add(setCarrierShip(input, localGrid));
                showLocalGrid(localGrid);
            }
            for (int i = 0; i < Battleship.Count; i++) {
                ships.add(setBattleShip(input, localGrid));
                showLocalGrid(localGrid);
            }
            for (int i = 0; i < Submarine.Count; i++) {
                ships.add(setSubmarineShip(input, localGrid));
                showLocalGrid(localGrid);
            }
            for (int i = 0; i < Patrol.Count; i++) {
                ships.add(setPatrolShip(input, localGrid));
                showLocalGrid(localGrid);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ships;
    }

    private void showLocalGrid(Cell[][] grid) {
        System.out.print("\n===== YOUR SHIPS =====\n  A B C D E F G H I J");
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
                } else {
                    System.out.print("Error");
                }
            }
        }
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

    private Coordinate getCoordinateFromStr(Scanner input) throws Exception {
        String coord1 = input.nextLine();
        String[] parts = coord1.split(" ");

        String xStr = parts[0].trim();
        String yStr = parts[1].trim();
        System.out.println("x: " + xStr + "\ny: " + yStr);

        int x = dict.get(parts[0].trim().toUpperCase());
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
        if (coord1.X == coord2.X) {
            if (Math.abs(coord1.Y - coord2.Y) == length - 1) {

                return true;
            }
        } else if (coord1.Y == coord2.Y) {
            if (Math.abs(coord1.X - coord2.X) == length - 1) {
                return true;
            }
        }
        return false;
    }

    private Ship setBattleShip(Scanner input, Cell[][] localGrid) throws Exception {
        boolean isCreated = false;
        Battleship battleship;
        while (!isCreated) {
            try {
                System.out.println("Enter starting coordinates of Battleship ");
                Coordinate begin = getCoordinateFromStr(input);
                System.out.println("Enter ending coordinates of Battleship ");
                Coordinate end = getCoordinateFromStr(input);

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

    private Ship setPatrolShip(Scanner input, Cell[][] localGrid) throws Exception {
        boolean isCreated = false;
        Patrol ship;
        while (!isCreated) {
            try {
                System.out.println("Enter starting coordinates of Patrol ");
                Coordinate begin = getCoordinateFromStr(input);
                System.out.println("Enter ending coordinates of Patrol ");
                Coordinate end = getCoordinateFromStr(input);

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

    private Ship setCarrierShip(Scanner input, Cell[][] localGrid) throws Exception {
        boolean isCreated = false;
        Carrier ship;
        while (!isCreated) {
            try {
                System.out.println("Enter starting coordinates of Carrier ");
                Coordinate begin = getCoordinateFromStr(input);
                System.out.println("Enter ending coordinates of Carrier ");
                Coordinate end = getCoordinateFromStr(input);

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

    private Ship setSubmarineShip(Scanner input, Cell[][] localGrid) throws Exception {
        boolean isCreated = false;
        Submarine ship;
        while (!isCreated) {
            try {
                System.out.println("Enter starting coordinates of Submarine ");
                Coordinate begin = getCoordinateFromStr(input);
                System.out.println("Enter ending coordinates of Submarine ");
                Coordinate end = getCoordinateFromStr(input);

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
            try {
                Cell cell = ship.Array[i];
                localGrid[cell.Coordinate.X][cell.Coordinate.Y] = new Cell(cell.Coordinate.X, cell.Coordinate.Y, state);
                // break around the ship

            } catch (Exception e) {
                // if the ship is on edge of map we will get OutOfArrayEx, so we ignore it
            }
        }
    }

}