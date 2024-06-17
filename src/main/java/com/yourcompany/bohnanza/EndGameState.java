package main.java.com.yourcompany.bohnanza;

public class EndGameState implements GameState {
    @Override
    public void execute(Game game) {
        System.out.println("The game is over.");
        game.determineWinner();
    }
}
