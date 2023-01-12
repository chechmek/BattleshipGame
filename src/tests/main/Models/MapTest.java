//package main.Models;
//
//import main.Abstract.Ship;
//import main.Ships.Battleship;
//import main.Ships.Carrier;
//import main.Ships.Patrol;
//import main.Ships.Submarine;
//import org.junit.Test;
//
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class MapTest {
//
//    @Test
//    void getGrid() {
//
//    }
//
//    @Test
//    void getShips() {
//    }
//
//    @Test
//    void breakAroundShip() {
//        Map map = new Map(new Cell[10][10]);
//        Battleship battleship = new Battleship(new Coordinate(5,5),new Coordinate(8,5));
//        ArrayList<Ship> ships = new ArrayList<>();
//        ships.add(battleship);
//        map.setShips(ships);
//
//        map.breakAroundShip(battleship, map.getGrid());
//
//        assertEquals(map.getGrid()[5][6],State.Unavailable);
//        assertEquals(map.getGrid()[6][6],State.Unavailable);
//        assertEquals(map.getGrid()[7][6],State.Unavailable);
//        assertEquals(map.getGrid()[8][6],State.Unavailable);
//        assertEquals(map.getGrid()[5][4],State.Unavailable);
//        assertEquals(map.getGrid()[6][4],State.Unavailable);
//        assertEquals(map.getGrid()[7][4],State.Unavailable);
//        assertEquals(map.getGrid()[8][4],State.Unavailable);
//
//    }
//
//    @Test
//    void setShips() {
//        Map map = new Map(new Cell[10][10]);
//        Battleship battleship = new Battleship(new Coordinate(5,5),new Coordinate(8,5));
//        Submarine submarine = new Submarine(new Coordinate(0,5),new Coordinate(2,5));
//        Patrol patrol = new Patrol(new Coordinate(2,2),new Coordinate(3,2));
//        Carrier carrier = new Carrier(new Coordinate(4,2),new Coordinate(9,2));
//        ArrayList<Ship> ships = new ArrayList<>();
//        ships.add(battleship);
//        ships.add(patrol);
//        ships.add(battleship);
//        ships.add(carrier);
//        map.setShips(ships);
//
//        assertEquals(map.getGrid()[5][5],State.WithBattleship);
//        assertEquals(map.getGrid()[0][5],State.WithSubmarine);
//        assertEquals(map.getGrid()[2][2],State.WithPatrol);
//        assertEquals(map.getGrid()[4][2],State.WithCarrier);
//
//    }
//
//    @Test
//    void damageCell() {
//        Map map = new Map(new Cell[10][10]);
//        Battleship battleship = new Battleship(new Coordinate(5,5),new Coordinate(9,5));
//        ArrayList<Ship> ships = new ArrayList<>();
//        ships.add(battleship);
//        map.setShips(ships);
//        map.damageCell(new Coordinate(5,5));
//        map.damageCell(new Coordinate(6,5));
//
//        assertEquals(map.getGrid()[5][5],State.DamagedShip);
//        assertEquals(map.getGrid()[6][5],State.DamagedShip);
//
//    }
//}