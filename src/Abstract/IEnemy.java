package Abstract;

import Models.Coordinate;
import Models.State;

public interface IEnemy {
    // Needed to allow players attack each other
    void CheckCell(Coordinate coordinate);
}
