
public class Main {

	public static void main(String[] args) {
		Player plr = new Player();
		Game game = new Game();
		
		while (plr.isAlive()) {
			game.showMenu();
		}
	}

}
