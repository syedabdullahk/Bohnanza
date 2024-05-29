import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<BeanCard> hand;
    private List<BeanField> fields;
    private int coins;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
        fields = new ArrayList<>();
        fields.add(new BeanField());
        fields.add(new BeanField());
        coins = 0;
    }

    public String getName() {
        return name;
    }

    public List<BeanCard> getHand() {
        return hand;
    }

    public List<BeanField> getFields() {
        return fields;
    }

    public int getCoins() {
        return coins;
    }

    public void drawCard(BeanCard card) {
        hand.add(card);
    }

    public void plantFirstCard() {
        if (!hand.isEmpty()) {
            BeanCard card = hand.remove(0);
            for (BeanField field : fields) {
                if (field.canPlant(card)) {
                    field.plantBean(card);
                    return;
                }
            }
            // If no field can accept the card, choose a field to harvest
            fields.get(0).harvest();
            fields.get(0).plantBean(card);
        }
    }

    public void harvestField(int fieldIndex) {
        if (fieldIndex >= 0 && fieldIndex < fields.size()) {
            coins += fields.get(fieldIndex).harvest();
        }
    }

    public BeanCard offerTrade(int cardIndex) {
        if (cardIndex >= 0 && cardIndex < hand.size()) {
            return hand.get(cardIndex);
        }
        return null;
    }

    public void acceptTrade(BeanCard offeredCard) {
        hand.add(offeredCard);
    }

    public void removeFirstCardFromHand() {
        if (!hand.isEmpty()) {
            hand.remove(0);
        }
    }

    @Override
    public String toString() {
        return name + " - Coins: " + coins + "\nHand: " + hand.toString() + "\nFields:\n" + fields.toString();
    }
}
