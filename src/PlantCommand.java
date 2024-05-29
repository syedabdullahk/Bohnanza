public class PlantCommand implements Command {
    private Player player;

    public PlantCommand(Player player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.plantFirstCard();
    }
}
