package main.Abstract;

import main.Models.Coordinate;

public interface IEnemy {
    // Needed to allow players attack each other
    void CheckCell(Coordinate coordinate);
}
