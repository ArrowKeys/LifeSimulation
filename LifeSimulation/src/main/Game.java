package main;

import java.util.Scanner;

public class Game {

	private Scanner sc;
	private Player player;

	private static final int LOTTERY_PRICE = 2;

	public Game(Player player) {
		this.sc = new Scanner(System.in);
		this.player = player;
		System.out.println(startupMessage());
	}

	private String startupMessage() {
		return new String("Your name is " + player.getFirstName() + " " + player.getLastName() + ". You are "
				+ player.getAge() + " years old.\nGood luck.\n");
	}

	public void displayMenu() {

		int option;

		System.out.print("\nMAIN MENU\n" + "[1] Age 1 year\n" + "[2] Show character statistics\n" + "[3] Show relationships\n"
				+ "[4] Show Actions\n" + "Choose an option: ");

		if (sc.hasNextInt()) {
			option = sc.nextInt();

			switch (option) {
			case 1:
				player.age();
				break;
			case 2:
				player.statistics();
				break;
			case 3:
				player.showRelationships();
				break;
			case 4:
				this.displayActions();
				break;
			default:
				System.out.println("Invalid option, please enter a valid integer!");
				break;
			}

		} else {
			sc.next();
			System.out.println("Invalid option, please enter a valid integer!");

		}
		
		//Checks if the player is alive after the switch statement is broken out of
		if (player.isAlive())
			displayMenu();
		else
			gameOver();

	}

	private void displayActions() {

		int option;

		System.out.print("\nACTIONS\n" + "[1] Open Belongings Menu\n" + "[2] Open Employment Menu\n"
				+ "[3] Open Education Menu\n" + "[4] Open Activities Menu\n" + "[0] Back\n" + "Choose an option: ");

		if (sc.hasNextInt()) {
			option = sc.nextInt();

			switch (option) {
			case 1:
				this.displayBelongings();
				break;
			case 2:
				this.displayEmployment();
				break;
			case 3:
				this.displayEducation();
				break;
			case 4:
				this.displayActivities();
				break;
			case 0:
				this.displayMenu();
				break;
			default:
				System.out.println("Invalid option, please enter a valid integer!");
				break;
			}

		} else {
			sc.next();
			System.out.println("Invalid option, please enter a valid integer!");
		}
		displayActions();
	}

	private void displayActivities() {
		int option;

		System.out.print("\nACTIVITIES\n" + "[1] Go for a walk\n" + "[2] Study\n" + "[3] Play the lottery ($"
				+ LOTTERY_PRICE + ")\n" + "[4] Browse the Internet\n" + "[5] Commit Suicide (Quit)\n" + "[0] Back\n" + "Choose an option: ");

		if (sc.hasNextInt()) {
			option = sc.nextInt();

			switch (option) {
			case 1:
				player.goForAWalk();
				break;
			case 2:
				player.study();
				break;
			case 3:
				player.gamble(LOTTERY_PRICE);
				break;
			case 4:
				player.browseInternet();
				break;
			case 5:
				player.commitSuicide();
				this.gameOver();
			case 0:
				this.displayActions();
				break;
			default:
				System.out.println("Invalid option, please enter a valid integer!");
				break;
			}

		} else {
			sc.next();
			System.out.println("Invalid option, please enter a valid integer!");

		}
		displayActivities();
	}

	private void displayEducation() {
		int option;
		System.out.println("EDUCATION\n" + "Current education: " + player.getEducationLevel() + "\n"
				+ "[1] Drop out of school\n" + "[0] Back");
		if (sc.hasNextInt()) {
			option = sc.nextInt();

			switch (option) {
			case 1:
				player.dropOutOfSchool();
				this.displayEducation();
				break;
			case 0:
				this.displayActions();
				break;
			default:
				System.out.println("Invalid option, please enter a valid integer!");
				break;
			}
			displayEducation();
		}
	}

	private void displayEmployment() {
		if (player.canGetJob())
			System.out.println("Jobs will be added Soon™");
		// TODO add jobs etc
		else
			System.out.println("You are unable to get a job right now.");
		displayActions();
	}

	private void displayBelongings() {
		// TODO add inventory? properties like houses, cars, etc?
		displayActions();
	}

	public void gameOver() {
		System.out.println("\nGame Over!\nPLAYER STATISTICS");
		player.statistics();
		System.exit(0);

	}
}
