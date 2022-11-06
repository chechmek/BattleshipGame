package Models;

import Abstract.PlayerBase;
import Abstract.Ship;
import Ships.Carrier;
import Ships.Battleship;
import Ships.Patrol;
import Ships.Submarine;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

import static Models.Map.breakAroundShip;

public class AIPlayer extends PlayerBase
{
    int counter = 0;
    boolean flag = false;
    public void setShips() {
        Scanner input = new Scanner(System.in);
        ArrayList<Ship> ships = new ArrayList<Ship>();
        Cell[][] localGrid = new Cell[10][10];
        for (int i = 0; i < localGrid.length; i++) {
            for (int j = 0; j < localGrid[i].length; j++) {
                localGrid[i][j] = new Cell(i, j);
            }
        }

        try {
            ships.add(setCarrierShip(input, localGrid));
            for (int i = 0; i < 2; i++) {
                ships.add(setBattleShip(input,localGrid));
            }
            for (int i = 0; i < 3; i++) {
                ships.add(setSubmarineShip(input,localGrid));
            }
            for (int i = 0; i < 4; i++) {
                ships.add(setPatrolShip(input, localGrid));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(counter);
        Map.setShips(ships);
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
    private Ship setCarrierShip(Scanner input, Cell[][] localGrid) throws Exception {
        boolean isCreated = false;
        Carrier ship;
        while (!isCreated) {
            int coordx = (int) ( Math.random() * 5 );
            int coordy = (int) ( Math.random() * 5 );
            int hor_or_vert = (int) ( Math.random() * 2 );

            try {
                Coordinate begin;
                Coordinate end;
                if(hor_or_vert==1)
                {
                    begin = new Coordinate(coordx, coordy);
                    end = new Coordinate(coordx+5, coordy);
                }
                else
                {
                    begin = new Coordinate(coordx, coordy);
                    end = new Coordinate(coordx, coordy+5);
                }
                if (!isValidShip(begin, end, Carrier.Length, localGrid))
                    throw new Exception("Coordinates are not valid!");

                ship = new Carrier(begin, end);
                isCreated = true;
                changeLocalGrid(ship, localGrid, State.WithCarrier);
                return ship;

            } catch (Exception exception) {
                counter++;
                System.out.println(exception.getMessage());
                System.out.println("Try again");
                if(counter>=1000)
                {
                    counter = 0;
                    setShips();
                    break;
                }
            }
        }
        throw new Exception("Cannot create a ship");
    }

    private Ship setSubmarineShip(Scanner input, Cell[][] localGrid) throws Exception {
        boolean isCreated = false;
        Submarine ship;
        while (!isCreated) {
            for(int j=0;j<Submarine.Count;j++)
            {
            int coordx = (int) ( Math.random() * 8 );
            int coordy = (int) ( Math.random() * 8 );
            int hor_or_vert = (int) ( Math.random() * 2 );

            try {
                Coordinate begin;
                Coordinate end;
                if(hor_or_vert==1)
                {
                    begin = new Coordinate(coordx, coordy);
                    end = new Coordinate(coordx+2, coordy);
                }
                else
                {
                    begin = new Coordinate(coordx, coordy);
                    end = new Coordinate(coordx, coordy+2);
                }
                if (!isValidShip(begin, end, Submarine.Length, localGrid))
                {
                    throw new Exception("Coordinates are not valid!");

                }


                ship = new Submarine(begin, end);
                isCreated = true;
                changeLocalGrid(ship, localGrid, State.WithSubmarine);
                return ship;

            }
            catch (Exception exception) {
                counter++;
                System.out.println(exception.getMessage());
                System.out.println("Try again");
                if(counter>=1000)
                {
                    counter = 0;
                    setShips();
                    break;
                }
            }
        }

    }throw new Exception("Cannot create a ship");}


    private Ship setBattleShip(Scanner input, Cell[][] localGrid) throws Exception {
        boolean isCreated = false;
        Battleship ship;
        while (!isCreated) {
            for(int j=0;j<Battleship.Count;j++)
            {
                int coordx = (int) ( Math.random() * 7 );
                int coordy = (int) ( Math.random() * 7 );
                int hor_or_vert = (int) ( Math.random() * 2 );

                try {
                    Coordinate begin;
                    Coordinate end;
                    if(hor_or_vert==1)
                    {
                        begin = new Coordinate(coordx, coordy);
                        end = new Coordinate(coordx+3, coordy);
                    }
                    else
                    {
                        begin = new Coordinate(coordx, coordy);
                        end = new Coordinate(coordx, coordy+3);
                    }
                    if (!isValidShip(begin, end, Battleship.Length, localGrid))
                        throw new Exception("Coordinates are not valid!");

                    ship = new Battleship(begin, end);
                    isCreated = true;
                    changeLocalGrid(ship, localGrid, State.WithSubmarine);
                    return ship;

                }
                catch (Exception exception) {
                    counter++;
                    System.out.println(exception.getMessage());
                    System.out.println("Try again");
                    if(counter>=1000)
                    {
                        counter = 0;
                        setShips();
                        break;
                    }
                }
            }

        }throw new Exception("Cannot create a ship");}


    private Ship setPatrolShip(Scanner input, Cell[][] localGrid) throws Exception {
        boolean isCreated = false;
        Patrol ship;
        while (!isCreated) {
            for(int j=0;j<Patrol.Count;j++)
            {
                int coordx = (int) ( Math.random() * 9 );
                int coordy = (int) ( Math.random() * 9 );
                int hor_or_vert = (int) ( Math.random() * 2 );

                try {
                    Coordinate begin;
                    Coordinate end;
                    if(hor_or_vert==1)
                    {
                        begin = new Coordinate(coordx, coordy);
                        end = new Coordinate(coordx+1, coordy);
                    }
                    else
                    {
                        begin = new Coordinate(coordx, coordy);
                        end = new Coordinate(coordx, coordy+1);
                    }
                    if (!isValidShip(begin, end, Patrol.Length, localGrid))
                        throw new Exception("Coordinates are not valid!");

                    ship = new Patrol(begin, end);
                    isCreated = true;
                    changeLocalGrid(ship, localGrid, State.WithSubmarine);
                    return ship;

                }
                catch (Exception exception) {
                    counter++;
                    System.out.println(exception.getMessage());
                    System.out.println("Try again");
                    if(counter>=1000)
                    {
                        counter = 0;
                        setShips();
                        break;
                    }
                }
            }

        }throw new Exception("Cannot create a ship");}

    public void Move() {
        Coordinate attackCoords = new Coordinate((int) ( Math.random() * 10 ), (int) ( Math.random() * 10 ));
        Enemy.CheckCell(attackCoords);
    }
    private void changeLocalGrid(Ship ship, Cell[][] localGrid, State state) {
        for (int i = 0; i < ship.Array.length; i++) {
            Cell cell = ship.Array[i];
            localGrid[cell.Coordinate.X][cell.Coordinate.Y] = new Cell(cell.Coordinate.X, cell.Coordinate.Y, state);
        }
        breakAroundShip(ship, localGrid);
    }
}
