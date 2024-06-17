package test.java.com.yourcompany.bohnanza;

import main.java.com.yourcompany.bohnanza.BeanCard;
import main.java.com.yourcompany.bohnanza.Deck;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    @Test
    void testDeckCreation() {
        Deck deck = new Deck();
        assertNotNull(deck);
    }

    @Test
    void testDrawCard() {
        Deck deck = new Deck();
        BeanCard card = deck.draw();
        assertNotNull(card);
    }

    @Test
    void testDeckIsEmpty() {
        Deck deck = new Deck();

    }

}
