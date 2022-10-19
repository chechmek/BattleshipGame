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
        player.setEnemy(playerAI);
        playerAI.setEnemy(player);
        ui.updateScreen(player.getMap(), playerAI.getMap());
        GameLoop();
    }

    private void GameLoop(){
        while(!gameIsEnded){
            // GameLoop
            Move(player);
            ui.updateScreen(player.getMap(), playerAI.getMap());
            Move(playerAI);
            ui.updateScreen(player.getMap(), playerAI.getMap());
        }
    }

    private void Move(IPlayer player){
        if(player.isDefeated()){
            gameIsEnded = true;
            ui.showVictoryScreen(player);
            return;
        }
        player.Move();
    }
}