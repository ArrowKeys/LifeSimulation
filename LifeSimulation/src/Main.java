
public class Main {

	public static void main(String[] args) {
		Player plr = new Player();
		Game game = new Game(plr);

		while (plr.isAlive()) {
			game.showMenu();
		}
		
		game.gameOver();
	}

}
