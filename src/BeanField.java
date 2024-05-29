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
            totalValue += card.getValue();
        }
        field.clear();
        return totalValue;
    }

    public boolean canPlant(BeanCard card) {
        return field.isEmpty() || field.get(0).getType().equals(card.getType());
    }

    @Override
    public String toString() {
        return "Field: " + field.toString();
    }
}
