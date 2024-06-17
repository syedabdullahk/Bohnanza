package main.java.com.yourcompany.bohnanza;

public class DrawCommand implements Command {
    private Player player;
    private Deck deck;

    public DrawCommand(Player player, Deck deck) {
        this.player = player;
        this.deck = deck;
    }

    @Override
    public void execute() {
        if (!deck.isEmpty()) {
            player.drawCard(deck.draw());
        } else {
            System.out.println("The deck is empty.");
        }
    }
}
