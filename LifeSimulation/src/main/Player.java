package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {

	private static final int MAX_AGE = 100;
	private static final int YEARLY_ALLOWANCE = 5;

	private static final Random r = new Random();

	private String firstName;
	private String lastName;
	private int age;
	private boolean isAlive;
	private boolean isInSchool;
	private boolean hasStudiedThisYear;
	private boolean hasPlayedLotteryThisYear;
	private double educationLevel;
	private double educationIncrement;

	private ArrayList<String> firstNames = new ArrayList<String>();
	private ArrayList<String> lastNames = new ArrayList<String>();
	private int money;
	private boolean isReceivingAllowance;

	public Player() {

		try {
			String firstNamesFile = "names/FirstNames.txt";
			String lastNamesFile = "names/LastNames.txt";
			firstNames = populateNames(firstNamesFile);
			lastNames = populateNames(lastNamesFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		this.age = 0;
		this.isAlive = true;
		this.firstName = firstNames.get(r.nextInt(firstNames.size()));
		this.lastName = lastNames.get(r.nextInt(lastNames.size()));
		this.isInSchool = false;
		this.educationLevel = 0.0;
		this.educationIncrement = 0.0;
		this.money = 0;
		this.isReceivingAllowance = false;

	}

	private ArrayList<String> populateNames(String fileName) throws FileNotFoundException {

		ArrayList<String> names = new ArrayList<String>();

		Scanner sc = new Scanner(new File(fileName));
		while (sc.hasNextLine()) {
			names.add(sc.nextLine());
		}
		sc.close();
		return names;

	}

	public void age() {
		age++;
		System.out.println("\nYou are now " + age + " year" + (age == 1 ? " " : "s ") + "old.");

		if (isInSchool) {
			educationLevel += educationIncrement;
			if (hasStudiedThisYear) {
				hasStudiedThisYear = false;
			}
		}
		if (isReceivingAllowance) {
			money += YEARLY_ALLOWANCE;
		}

		switch (age) {
		case 6:
			this.startSchool();
			break;
		case 10:
			this.startAllowance();
			break;
		case MAX_AGE:
			this.dieOfOldAge();
		default:
			break;
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isInSchool() {
		return isInSchool;
	}

	public void setInSchool(boolean isInSchool) {
		this.isInSchool = isInSchool;
	}

	public boolean hasStudiedThisYear() {
		return hasStudiedThisYear;
	}

	public void setHasStudiedThisYear(boolean hasStudiedThisYear) {
		this.hasStudiedThisYear = hasStudiedThisYear;
	}

	public boolean hasPlayedLotteryThisYear() {
		return hasPlayedLotteryThisYear;
	}

	public void setHasPlayedLotteryThisYear(boolean hasPlayedLotteryThisYear) {
		this.hasPlayedLotteryThisYear = hasPlayedLotteryThisYear;
	}

	public double getEducationLevel() {
		return Double.parseDouble(String.format("%.2f", this.educationLevel));
	}

	public void setEducationLevel(double educationLevel) {
		this.educationLevel = educationLevel;
	}

	public void setAlive(boolean alive) {
		this.isAlive = alive;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public double getEducationIncrement() {
		return educationIncrement;
	}

	public void setEducationIncrement(double educationIncrement) {
		this.educationIncrement = educationIncrement;
	}

	public void startSchool() {
		isInSchool = true;
		System.out.println("You have started going to school.");
		educationIncrement = 0.3;
	}

	private void startAllowance() {
		System.out.printf("You have started receiving a yearly allowance of $%d.\n", YEARLY_ALLOWANCE);
		isReceivingAllowance = true;

	}

	public void statistics() {
		System.out.println("\n" + (firstName + " " + lastName + "\nAge: " + age + "\nEducation: " + getEducationLevel()
				+ "\nMoney: " + money + "\n")); // getEducationLevel instead of educationLevel because the function
												// formats the decimal to prevent #.#9999999etc.
	}

	public void showRelationships() {
		System.out.println("\nThis feature has not yet been implemented.");
		// TODO write this

	}

	public boolean canGetJob() {
		return age > 16 && age < 75;
	}

	public void goForAWalk() {
		if (age <= 2)
			System.out.println("You are too young to walk.");
		else
			System.out.println("You go for a nice walk.");

	}

	public void playLottery(int lotteryPrice, Random r) {
		hasPlayedLotteryThisYear = true;
		money -= lotteryPrice;
		if (r.nextFloat() <= 0.01) {
			// Win the lottery
		} else {
			System.out.println("You did not win the lottery. You now have $" + money);
		}

	}

	public void browseInternet() {

		// TODO add more Internet things
		if (age >= 8)
			System.out.println("You scroll through social media for a bit. You feel like you're wasting your time.");
		else
			System.out.println("You are too young to use the Internet.");

	}

	public void study() {
		// TODO organize these if statements if possible
		if (isInSchool) {
			if (!hasStudiedThisYear) {
				if (r.nextFloat() >= 0.7) {
					System.out.println("You stay focused for a few hours and learn a lot.\nYou feel smarter.");
					educationIncrement += 0.5;
				} else {
					System.out.println(
							"No matter how hard you try to focus, you can't grasp the subject. Nothing happens.");
				}
				hasStudiedThisYear = true;
			} else {
				System.out.println("You've already studied this year.");
			}
		} else {
			System.out.println("You aren't in school; you can't study!");
		}

	}

	public void gamble(int lotteryPrice) {
		// TODO organize these if statements if possible
		if (age >= 18) {
			if (hasPlayedLotteryThisYear) {
				if (money - lotteryPrice < 0) {
					System.out.println("You don't have enough money to gamble. You need at least $" + lotteryPrice);
				} else {
					playLottery(lotteryPrice, r);
				}
			} else {
				System.out.println("You have already played the lottery this year.");
			}
		} else {
			System.out.println("You are too young to gamble. You need to be at least 18 years old.");
		}

	}

	public void dropOutOfSchool() {
		if (isInSchool)
			isInSchool = false;
		else
			System.out.println("You are not in school!");

	}

	public void commitSuicide() {
		System.out.println("You commited suicide via hanging.");
		isAlive = false;

	}

	private void dieOfOldAge() {
		System.out.println("You died of old age.");
		isAlive = false;

	}

}
