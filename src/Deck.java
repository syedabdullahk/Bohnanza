import java.util.Collections;
import java.util.Stack;

public class Deck {
    private Stack<BeanCard> cards;

    public Deck() {
        cards = new Stack<>();
        initializeDeck();
        Collections.shuffle(cards);
    }

    private void initializeDeck() {

        for (int i = 0; i < 7; i++) cards.push(new BeanCard("Chilli", 1));
        for (int i = 0; i < 6; i++) cards.push(new BeanCard("Kidney", 2));
        for (int i = 0; i < 4; i++) cards.push(new BeanCard("Red", 3));
    }

    public BeanCard draw() {
        return cards.isEmpty() ? null : cards.pop();
    }
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    @Override
    public String toString() {
        return "Deck: " + cards.toString();
    }
}
