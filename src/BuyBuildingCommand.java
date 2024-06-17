import java.util.List;
import java.util.Scanner;

public class BuyBuildingCommand implements Command {
    private Player player;
    private Game game;

    public BuyBuildingCommand(Player player, Game game) {
        this.player = player;
        this.game = game;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        List<Building> buildings = game.getAvailableBuildings();

        System.out.println("Available buildings:");
        for (int i = 0; i < buildings.size(); i++) {
            System.out.println((i + 1) + ". " + buildings.get(i));
        }

        System.out.println("Select a building to buy (or 0 to cancel):");
        int choice = scanner.nextInt();

        if (choice > 0 && choice <= buildings.size()) {
            Building building = buildings.get(choice - 1);
            player.buyBuilding(building);
        } else {
            System.out.println("Cancelled building purchase.");
        }
    }
}
