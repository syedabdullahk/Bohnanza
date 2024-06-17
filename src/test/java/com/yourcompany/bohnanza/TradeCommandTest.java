package test.java.com.yourcompany.bohnanza;

import main.java.com.yourcompany.bohnanza.BeanCard;
import main.java.com.yourcompany.bohnanza.Game;
import main.java.com.yourcompany.bohnanza.Player;
import main.java.com.yourcompany.bohnanza.TradeCommand;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

class TradeCommandTest {
    @Test
    void testTradeCommandExecution() {
        Player player1 = new Player("John");
        Player player2 = new Player("Jane");
        Game game = new Game(2);
        BeanCard beanCard = new BeanCard("Red Bean", 4);
        player1.getHand().add(beanCard);
        TradeCommand tradeCommand = new TradeCommand(player1,  game);

        tradeCommand.execute();

        assertFalse(player1.getHand().contains(beanCard));
        assertTrue(player2.getHand().contains(beanCard));
    }

    @Test
    void testTradeCommandWithNoBeanCard() {
        Player player1 = new Player("John");
        Player player2 = new Player("Jane");
        Game game = new Game(2);
        BeanCard beanCard = new BeanCard("Red Bean", 4);
        TradeCommand tradeCommand = new TradeCommand(player1, game);

        tradeCommand.execute();

        assertFalse(player2.getHand().contains(beanCard));
    }

    @Test
    void testTradeCommandWithMultipleBeanCards() {
        Player player1 = new Player("John");
        Player player2 = new Player("Jane");
        Game game = new Game(2);
        BeanCard beanCard1 = new BeanCard("Red Bean", 4);
        BeanCard beanCard2 = new BeanCard("Green Bean", 3);
        player1.getHand().add(beanCard1);
        player1.getHand().add(beanCard2);
        TradeCommand tradeCommand = new TradeCommand(player1,  game);

        tradeCommand.execute();

        assertFalse(player1.getHand().contains(beanCard1));
        assertTrue(player2.getHand().contains(beanCard1));
        assertTrue(player1.getHand().contains(beanCard2));
        assertFalse(player2.getHand().contains(beanCard2));
    }
}
