import Abstract.IPlayer;
import Abstract.IUserInterface;
import Models.AIPlayer;
import Models.Player;
import UI.UserInterface;

public class Game {
    boolean gameIsEnded;
    Player player;
    AIPlayer playerAI;
    IUserInterface ui;

    public Game(){
        player = new Player();
        playerAI = new AIPlayer();
        ui = new UserInterface();
    }

    public void Start(){
        gameIsEnded = false;
        player.setShips();
        playerAI.setShips();
        ui.updateScreen(player.getMap(), playerAI.getMap());
        player.setEnemy(playerAI);
        playerAI.setEnemy(player);
        GameLoop();
    }

    private void GameLoop(){
        while(!gameIsEnded){
            // GameLoop
            if(player.isDefeated()){
                gameIsEnded = true;
                ui.showVictoryScreen(playerAI);
                return;
            }
            player.Move();
            ui.updateScreen(player.getMap(), playerAI.getMap());

            if(playerAI.isDefeated()){
                gameIsEnded = true;
                ui.showVictoryScreen(player);
                return;
            }
            playerAI.Move();
            ui.updateScreen(player.getMap(), playerAI.getMap());
        }
    }

    private void Move(IPlayer player){

    }
}