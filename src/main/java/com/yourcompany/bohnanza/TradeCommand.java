package main.java.com.yourcompany.bohnanza;

import java.util.Scanner;

public class TradeCommand implements Command {
    private Player player;
    private Game game;

    public TradeCommand(Player player, Game game) {
        this.player = player;
        this.game = game;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select player to trade with (1 to " + game.getPlayers().size() + "):");
        int tradePlayerIndex = scanner.nextInt() - 1;
        if (tradePlayerIndex >= 0 && tradePlayerIndex < game.getPlayers().size() && tradePlayerIndex != game.getCurrentPlayerIndex()) {
            Player tradePartner = game.getPlayers().get(tradePlayerIndex);
            System.out.println(tradePartner.getName() + "'s hand: " + tradePartner.getHand());
            System.out.println("Select card to offer for trade from " + tradePartner.getName() + "'s hand (0 to " + (tradePartner.getHand().size() - 1) + "):");
            int cardIndex = scanner.nextInt();
            BeanCard offeredCard = tradePartner.offerTrade(cardIndex);
            if (offeredCard != null) {
                System.out.println(player.getName() + ", do you accept the trade? (y/n)");
                String response = scanner.next();
                if (response.equalsIgnoreCase("y")) {
                    tradePartner.acceptTrade(player.getHand().get(0));
                    player.acceptTrade(offeredCard);
                    player.removeFirstCardFromHand();
                    System.out.println(player.getName() + " traded with " + tradePartner.getName());
                } else {
                    System.out.println(player.getName() + " rejected the trade.");
                }
            } else {
                System.out.println("Invalid card selection.");
            }
        } else {
            System.out.println("Invalid player selection.");
        }
    }
}
