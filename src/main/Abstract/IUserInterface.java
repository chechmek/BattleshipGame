package main.Abstract;

public interface IUserInterface {
    // Will be used in GameLoop to Update screen
// Just put both maps to console and make them beautiful
    void updateScreen(IMap playerMap, IMap enemyMap);
// Victory screen: Ai won or player won
    void showVictoryScreen(IPlayer player);
    // StartMenu() if we will have time
}
