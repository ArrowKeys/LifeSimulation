package lifesimulation;

public class Main {

	public static void main(String[] args) {
		Player player = new Player();
		Game game = new Game(player);

		game.mainMenu();
		// Just in case something fucks up
		game.gameOver();

	}

}
