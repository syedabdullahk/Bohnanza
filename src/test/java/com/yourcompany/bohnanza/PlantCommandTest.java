package test.java.com.yourcompany.bohnanza;

import main.java.com.yourcompany.bohnanza.BeanCard;
import main.java.com.yourcompany.bohnanza.BeanField;
import main.java.com.yourcompany.bohnanza.PlantCommand;
import main.java.com.yourcompany.bohnanza.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlantCommandTest {
    @Test
    void testPlantCommandExecution() {
        BeanField field = new BeanField();
        Player player = new Player("John");
        PlantCommand plantCommand = new PlantCommand(player);

        BeanCard beanCard = new BeanCard("Red Bean", 4);
        player.getHand().add(beanCard);
        plantCommand.execute();
        assertFalse(field.canPlant(beanCard));

    }
}
