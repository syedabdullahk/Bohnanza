package main.java.com.yourcompany.bohnanza;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private Deck deck;
    private GameState state;
    private int currentPlayerIndex;
    private List<Building> availableBuildings;

    public Game(int numPlayers) {
        players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            players.add(new Player("main.java.com.yourcompany.bohnanza.Player " + i));
        }
        deck = new Deck();
        this.availableBuildings = new ArrayList<>();
        initializeBuildings();
        state = new PlayerTurnState(players.get(0));
        currentPlayerIndex = 0;
    }
    private void initializeBuildings() {
        availableBuildings.add(new Building("Barn", "Kidney", 3, "Allows an extra field"));
        availableBuildings.add(new Building("Market", "Soy Bean", 4, "Gain extra coins from trades"));
        // Add more buildings as needed
    }

    public List<Building> getAvailableBuildings() {
        return availableBuildings;
    }

    public void start() {
        for (Player player : players) {
            for (int i = 0; i < 5 && !deck.isEmpty(); i++) {
                player.drawCard(deck.draw());
            }
        }

        while (!(state instanceof EndGameState)) {
            state.execute(this);
        }
        state.execute(this);
    }

    public Deck getDeck() {
        return deck;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public Player getNextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        return players.get(currentPlayerIndex);
    }

    public void setState(GameState state) {
        this.state = state;
    }


    public void determineWinner() {
        Player winner = players.get(0);
        for (Player player : players) {
            if (player.getTotalCoins() > winner.getTotalCoins()) {
                winner = player;
            }
        }
        System.out.println("The winner is " + winner.getName() + " with " + winner.getCoins() + " coins!");
    }

    public static void main(String[] args) {
        Game game = new Game(2);
        game.start();
    }

    public boolean isRunning() {
        for (Player player : players) {
            for (int i = 0; i < 5 && !deck.isEmpty(); i++) {
                player.drawCard(deck.draw());
            }
        }

        while (!(state instanceof EndGameState)) {
            state.execute(this);
        }
    return true;
    }
}
