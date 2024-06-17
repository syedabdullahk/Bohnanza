package test.java.com.yourcompany.bohnanza;

import main.java.com.yourcompany.bohnanza.Game;
import main.java.com.yourcompany.bohnanza.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class GameTest {
    @Test
    void testGameInitialization() {
        Player player1 = new Player("John");
        Player player2 = new Player("Jane");
        Game game = new Game(2);
        assertNotNull(game);
    }

    @Test
    void testGameStart() {
        Player player1 = new Player("John");
        Player player2 = new Player("Jane");
        Game game = new Game(2);

        game.start();
        assertTrue(game.isRunning());
    }
}
