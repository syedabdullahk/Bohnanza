package main.java.com.yourcompany.bohnanza;

public class Building {
    private String name;
    private String beanType;
    private int cost;
    private String benefit; // Description of what the building does

    public Building(String name, String beanType, int cost, String benefit) {
        this.name = name;
        this.beanType = beanType;
        this.cost = cost;
        this.benefit = benefit;
    }

    public String getName() {
        return name;
    }

    public String getBeanType() {
        return beanType;
    }

    public int getCost() {
        return cost;
    }

    public String getBenefit() {
        return benefit;
    }

    @Override
    public String toString() {
        return name + " (Cost: " + cost + " " + beanType + " beans) - Benefit: " + benefit;
    }
}
