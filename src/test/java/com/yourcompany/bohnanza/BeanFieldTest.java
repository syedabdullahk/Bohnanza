package test.java.com.yourcompany.bohnanza;

import main.java.com.yourcompany.bohnanza.BeanCard;
import main.java.com.yourcompany.bohnanza.BeanField;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BeanFieldTest {
    @Test
    void testBeanFieldInitialization() {
        BeanField beanField = new BeanField();
        assertNotNull(beanField);

    }

    @Test
    void testPlantBean() {
        BeanField beanField = new BeanField();
        BeanCard beanCard = new BeanCard("Red Bean", 4);
        beanField.plantBean(beanCard);
        assertTrue(beanField.canPlant(beanCard));

    }

    @Test
    void testHarvestBeans() {
        BeanField beanField = new BeanField();
        BeanCard beanCard1 = new BeanCard("Red Bean", 4);
        BeanCard beanCard2 = new BeanCard("Red Bean", 4);
        beanField.plantBean(beanCard1);
        beanField.plantBean(beanCard2);
        int coins = beanField.harvest();
        assertEquals(2, coins); // Assuming each bean gives 1 coin
        assertTrue(beanField.canPlant(beanCard2));
    }

    @Test
    void testPlantDifferentBeanType() {
        BeanField beanField = new BeanField();
        BeanCard beanCard1 = new BeanCard("Red Bean", 4);
        BeanCard beanCard2 = new BeanCard("Green Bean", 3);
        beanField.plantBean(beanCard1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            beanField.plantBean(beanCard2);
        });
        assertEquals("Cannot plant different type of bean", exception.getMessage());
    }


}

