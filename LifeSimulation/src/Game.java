import java.util.Scanner;

public class Game {

	private Scanner sc;
	private Player plr;

	public Game(Player plr) {
		this.sc = new Scanner(System.in);
		this.plr = plr;
		System.out.println(startupMessage());
	}

	private String startupMessage() {
		return new String("Your name is " + plr.getFirstName() + " " + plr.getLastName() + ". You are " + plr.getAge()
				+ " years old.\nGood luck.\n");
	}

	public void showMenu() {

		int option = 0;

		System.out.print("\n" + 
				"[1] Age 1 year\n" + 
				"[2] Show character statistics\n" + 
				"[3] Show relationships\n" +
				"[4] Commit suicide (quit)\nChoose an action: ");

		if (sc.hasNextInt()) {
			option = sc.nextInt();

			switch (option) {
			case 1:
				plr.setAge(plr.getAge() + 1);
				break;
			case 2:
				System.out.println(plr.statistics());
				break;
			case 3:
				System.out.println("Feature has not yet been implemented.");
				showMenu();
				break;
			case 4:
				plr.setAlive(false);
				break;
			default:
				showMenu();
				break;
			}
		} else {
			sc.next();
			System.out.println("Invalid option, please enter a valid integer!");
			showMenu();
		}
	}

	public void gameOver() {
		System.out.println("You died!\n" + plr.statistics());

	}
}
