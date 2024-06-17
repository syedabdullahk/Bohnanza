package test.java.com.yourcompany.bohnanza;

import main.java.com.yourcompany.bohnanza.BeanCard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BeanCardTest {
    @Test
    void testBeanCardCreation() {
        BeanCard beanCard = new BeanCard("Red Bean", 4);
        assertEquals("Red Bean", beanCard.getType());
        assertEquals(4, beanCard.getValue());
    }

    @Test
    void testBeanCardEquality() {
        BeanCard beanCard1 = new BeanCard("Red Bean", 4);
        BeanCard beanCard2 = new BeanCard("Red Bean", 4);
        assertEquals(beanCard1, beanCard2);
    }
}

