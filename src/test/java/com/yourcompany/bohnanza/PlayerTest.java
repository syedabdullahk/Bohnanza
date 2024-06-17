package test.java.com.yourcompany.bohnanza;

import main.java.com.yourcompany.bohnanza.BeanField;
import main.java.com.yourcompany.bohnanza.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class PlayerTest {
    @Test
    void testPlayerCreation() {
        Player player = new Player("John");
        assertEquals("John", player.getName());
    }

    @Test
    void testAddField() {
        Player player = new Player("John");
        BeanField field = new BeanField();
        player.harvestField(4);
        List<BeanField> fields = player.getFields();
        assertEquals(1, fields.size());
        assertEquals(field, fields.get(0));
    }

    @Test
    void testGetHand() {
        Player player = new Player("John");
        assertNotNull(player.getHand());
    }
}
