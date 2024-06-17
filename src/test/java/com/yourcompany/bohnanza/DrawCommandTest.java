package test.java.com.yourcompany.bohnanza;

import main.java.com.yourcompany.bohnanza.Deck;
import main.java.com.yourcompany.bohnanza.DrawCommand;
import main.java.com.yourcompany.bohnanza.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DrawCommandTest {
    @Test
    void testDrawCommandExecution() {
        Deck deck = new Deck();
        Player player = new Player("John");
        DrawCommand drawCommand = new DrawCommand(player, deck);

        drawCommand.execute();
        assertFalse(player.getHand().isEmpty());
    }
}
