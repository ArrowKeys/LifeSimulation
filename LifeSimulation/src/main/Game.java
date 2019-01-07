package main;

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

	public void displayMenu() {

		int option;

		System.out.print("\n" + "[1] Age 1 year\n" + "[2] Show character statistics\n" + "[3] Show relationships\n"
				+ "[4] Show Actions\n" + "Choose an option: ");

		if (sc.hasNextInt()) {
			option = sc.nextInt();

			switch (option) {
			case 1:
				plr.age();
				break;
			case 2:
				plr.statistics();
				break;
			case 3:
				plr.showRelationships();
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
		this.displayMenu();
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
				if (plr.canGetJob())
					this.displayEmployment();
				else
					System.out.println("You are unable to get a job right now.");
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
				+ plr.getLOTTERY_PRICE() + ")\n" + "[4] Browse the Internet\n" + "[0] Back\n" + "Choose an option: ");

		if (sc.hasNextInt()) {
			option = sc.nextInt();

			switch (option) {
			case 1:
				if (plr.getAge() >= 2)
					plr.goForAWalk();
				else
					System.out.println("You can't walk yet.");
				break;
			case 2:
				if (plr.isInSchool()) {
					if (!plr.hasStudiedThisYear()) {
						if (plr.getR().nextFloat() >= 0.7) {
							System.out.println("You stay focused for a few hours and learn a lot.\nYou feel smarter.");
							plr.setEducationIncrement(plr.getEducationIncrement() + 0.5);
						} else {
							System.out.println("No matter how hard you try to focus, you can't grasp the subject. Nothing happens.");
						}
						plr.setHasStudiedThisYear(true);
					} else {
						System.out.println("You've already studied this year.");
					}
				} else {
					System.out.println("You aren't in school; you can't study!");
				}
				break;
			case 3:
				if (plr.getAge() >= 18)
					if (!plr.hasPlayedLotteryThisYear())
						plr.playLottery();
					else
						System.out.println("You have already played the lottery this year");
				else
					System.out.println("You are too young to gamble. You need to be at least 18 years old.");
				break;
			case 4:
				if (plr.getAge() >= 8)
					plr.browseInternet();
				else
					System.out.println("You are too young to use the Internet.");
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
		displayActivities();
	}

	private void displayEducation() {
		int option;
		System.out.println("EDUCATION\n" + "Current education: " + plr.getEducationLevel() + "\n"
				+ "[1] Drop out of school\n" + "[0] Back");
		if (sc.hasNextInt()) {
			option = sc.nextInt();

			switch (option) {
			case 1:
				if (plr.isInSchool())
					plr.setInSchool(false);
				else
					System.out.println("You are not in school!");
				this.displayEducation();
				break;
			case 0:
				this.displayActions();
				break;
			}
			this.displayEducation();
		}
	}

	private void displayEmployment() {

	}

	private void displayBelongings() {

	}

	public void gameOver() {
		System.out.println("\nYou died!\nPLAYER STATISTICS");
		plr.statistics();

	}
}
