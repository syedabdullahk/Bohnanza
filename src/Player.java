import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    private String name;
    private List<BeanCard> hand;
    private List<BeanField> fields;


    private Map<String, Integer> coins; // Map to keep track of coins by bean type
    private List<Building> buildings; // List of purchased buildings

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.fields = new ArrayList<>();
        this.coins = new HashMap<>();
        this.buildings = new ArrayList<>();


        fields.add(new BeanField());
        fields.add(new BeanField());
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
        if (fieldIndex < 0 || fieldIndex >= fields.size()) {
            System.out.println("Invalid field index.");
            return;
        }

        BeanField field = fields.get(fieldIndex);
        if (field.isEmpty()) {
            System.out.println("The field is empty.");
            return;
        }

        String beanType = field.getBeanType();
        int harvestedCoins = field.harvest();

        // Add harvested coins to the player's coin inventory
        addCoins(beanType, harvestedCoins);
        System.out.println(name + " harvested field " + fieldIndex + " and earned " + harvestedCoins + " " + beanType + " coins.");
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


    public boolean canAffordBuilding(Building building) {
        return coins.getOrDefault(building.getBeanType(), 0) >= building.getCost();
    }

    public void buyBuilding(Building building) {
        if (canAffordBuilding(building)) {
            coins.put(building.getBeanType(), coins.get(building.getBeanType()) - building.getCost());
            buildings.add(building);
            System.out.println(name + " bought " + building.getName());
        } else {
            System.out.println(name + " cannot afford " + building.getName());
        }
    }

    public void addCoins(String beanType, int amount) {
        coins.put(beanType, coins.getOrDefault(beanType, 0) + amount);
    }

    public Map<String, Integer> getCoins() {
        return coins;
    }

    public List<Building> getBuildings() {
        return buildings;
    }
    public int getTotalCoins() {
        int total = 0;
        for (int amount : coins.values()) {
            total += amount;
        }
        return total;
    }

    @Override
    public String toString() {
        return name + " - Hand: " + hand + " - Fields: " + fields + " - Coins: " + coins + " - Buildings: " + buildings;
    }
}
