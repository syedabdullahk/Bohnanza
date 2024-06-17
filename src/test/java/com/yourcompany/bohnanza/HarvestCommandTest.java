package test.java.com.yourcompany.bohnanza;

import main.java.com.yourcompany.bohnanza.BeanCard;
import main.java.com.yourcompany.bohnanza.BeanField;
import main.java.com.yourcompany.bohnanza.HarvestCommand;
import main.java.com.yourcompany.bohnanza.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HarvestCommandTest {
    @Test
    void testHarvestCommandExecution() {
        BeanField field = new BeanField();
        BeanCard beanCard;
        Player player = new Player("John");
        HarvestCommand harvestCommand = new HarvestCommand(player, 1);

        field.plantBean(new BeanCard("Red Bean", 4));
        field.plantBean(new BeanCard("Red Bean", 4));
        harvestCommand.execute();
        BeanCard beanCard1 = new BeanCard("blue been", 4);
        assertFalse(field.canPlant(beanCard1));
    }
}
