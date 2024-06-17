package main.java.com.yourcompany.bohnanza;

public class BeanCard {
    private String type;
    private int value;

    public BeanCard(String type, int value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return type + " (" + value + ")";
    }


}
