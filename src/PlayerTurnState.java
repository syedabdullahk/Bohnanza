import java.util.Scanner;

public class PlayerTurnState implements GameState {
    private Player player;

    public PlayerTurnState(Player player) {
        this.player = player;
    }

    @Override
    public void execute(Game game) {
        Scanner scanner = new Scanner(System.in);
        boolean turnOver = false;

        while (!turnOver) {
            System.out.println(player);
            System.out.println(game.getDeck());
            System.out.println(player.getName() + "'s turn:");
            System.out.println("1. Plant first card");
            System.out.println("2. Harvest field");
            System.out.println("3. Draw a card");
            System.out.println("4. Trade");
            System.out.println("5. Change turn");
            System.out.println("6. End game");

            int choice = scanner.nextInt();
            Command command;

            switch (choice) {
                case 1:
                    command = new PlantCommand(player);
                    break;
                case 2:
                    System.out.println("Select field to harvest (0 or 1):");
                    int fieldIndex = scanner.nextInt();
                    command = new HarvestCommand(player, fieldIndex);
                    break;
                case 3:
                    command = new DrawCommand(player, game.getDeck());
                    break;
                case 4:
                    command = new TradeCommand(player, game);
                    break;
                case 5:
                    game.setState(new PlayerTurnState(game.getNextPlayer()));
                    turnOver = true;
                    continue;
                case 6:
                    game.setState(new EndGameState());
                    turnOver = true;
                    continue;
                default:
                    System.out.println("Invalid choice, please select again.");
                    continue;
            }

            command.execute();
        }
    }
}
