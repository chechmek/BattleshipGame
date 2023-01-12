package main.Abstract;

import main.Models.Coordinate;

import java.util.ArrayList;

// Interface will be used by player to receive coordinates to shoot
public interface IInput {
    // Returns Coordinate instanse
// Example: user types b4, returns Coordinate(1, 3)
// Note that count in array starts from 0, thats why b => 1, 4 => 3
    Coordinate getCoordinates();
    // At start of the game player will set up his ships somehow
    ArrayList<Ship> setShips();
}
