import java.util.ArrayList;
import java.util.List;

public class BeanField {
    private List<BeanCard> field;

    public BeanField() {
        field = new ArrayList<>();
    }

    public void plantBean(BeanCard card) {
        field.add(card);
    }

    public int harvest() {
        int totalValue = 0;
        for (BeanCard card : field) {
            totalValue += card.getValue(); // Assuming BeanCard has a getValue() method that returns the coin value
        }
        field.clear();
        return totalValue;
    }

    public boolean canPlant(BeanCard card) {
        return field.isEmpty() || field.get(0).getType().equals(card.getType());
    }

    public boolean isEmpty() {
        return field.isEmpty();
    }

    public String getBeanType() {
        if (field.isEmpty()) {
            return null;
        }
        return field.get(0).getType(); // Assuming BeanCard has a getType() method that returns the bean type
    }

    @Override
    public String toString() {
        return "Field: " + field.toString();
    }
}
