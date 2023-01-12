package main;

import main.Abstract.IPlayer;
import main.Abstract.IUserInterface;
import main.Models.AIPlayer;
import main.Models.Player;
import main.UI.UserInterface;

public class Game {
    boolean gameIsEnded;
    Player player;
    Player player2;

    IUserInterface ui;

    public Game(){
        player = new Player();

        player2 = new Player();

        ui = new UserInterface();
    }

    public void Start(){
        gameIsEnded = false;
        player.setShips();
        player2.setShips();
        ui.updateScreen(player.getMap(), player2.getMap());
        player.setEnemy(player2);
        player2.setEnemy(player);
        GameLoop();
    }

    private void GameLoop(){
        while(!gameIsEnded){
            // GameLoop
            if(player.isDefeated()){
                gameIsEnded = true;
                ui.showVictoryScreen(player2);
                return;
            }
            player.Move();
            ui.updateScreen(player.getMap(), player2.getMap());
            if(player2.isDefeated()){
                gameIsEnded = true;
                ui.showVictoryScreen(player);
                return;
            }
            player2.Move();
            ui.updateScreen(player.getMap(), player2.getMap());
        }
    }

    private void Move(IPlayer player){

    }
}