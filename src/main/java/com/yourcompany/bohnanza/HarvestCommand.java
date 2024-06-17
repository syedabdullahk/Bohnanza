package main.java.com.yourcompany.bohnanza;

public class HarvestCommand implements Command {
    private Player player;
    private int fieldIndex;

    public HarvestCommand(Player player, int fieldIndex) {
        this.player = player;
        this.fieldIndex = fieldIndex;
    }

    @Override
    public void execute() {
        player.harvestField(fieldIndex);
    }
}
