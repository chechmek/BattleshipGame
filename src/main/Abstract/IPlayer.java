package main.Abstract;

public interface IPlayer {
    void Move();
    IMap getMap();
    boolean isDefeated();
    //For initialiaztion
    void setShips();
    void setEnemy(IEnemy enemy);
    //Just for beautiful victoryScreen
    String getName();
}
