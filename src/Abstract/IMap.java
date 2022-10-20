package Abstract;

import Models.Cell;
import Models.Coordinate;

import java.util.ArrayList;

public interface IMap {
    Cell[][] getGrid();
    ArrayList<Ship> getShips();
    void setShips(ArrayList<Ship> ships);
    void damageCell(Coordinate coords);
}
