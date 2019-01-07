package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {

	private final int MAX_AGE = 100;
	private final int MIN_AGE = 0;
	private final int LOTTERY_PRICE = 2;
	private final int ALLOWANCE = 5;

	private Random r;

	private String firstName;
	private String lastName;
	private int age;
	private boolean alive;
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

		this.r = new Random();
		this.age = 0;
		this.alive = true;
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
		this.setAge(this.getAge() + 1);
		System.out.println("\nYou are now " + this.getAge() + " year" + (this.getAge() == 1 ? " " : "s ") + "old.");

		if (this.isInSchool()) {
			this.setEducationLevel(this.getEducationLevel() + this.getEducationIncrement());
			if (this.hasStudiedThisYear()) {
				this.setHasStudiedThisYear(false);
			}
		}
		if (this.isReceivingAllowance()) {
			this.setMoney(this.getMoney() + this.ALLOWANCE);
		}

		switch (this.getAge()) {
		case 6:
			this.startSchool();
			break;
		case 10:
			this.startAllowance();
		default:
			break;
		}
	}

	public boolean isAlive() {
		return ((this.getAge() >= this.MIN_AGE && this.getAge() < this.MAX_AGE) && this.getAlive());
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

	public int getLOTTERY_PRICE() {
		return LOTTERY_PRICE;
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
		this.alive = alive;
	}

	public boolean getAlive() {
		return alive;
	}

	public double getEducationIncrement() {
		return educationIncrement;
	}

	public void setEducationIncrement(double educationIncrement) {
		this.educationIncrement = educationIncrement;
	}

	private void setMoney(int m) {
		this.money = m;

	}

	private int getMoney() {
		return this.money;
	}

	public Random getR() {
		return r;
	}

	public void startSchool() {
		this.setInSchool(true);
		System.out.println("You have started going to school.");
		this.setEducationIncrement(0.3);
	}

	private void startAllowance() {
		System.out.println("You have started receiving a yearly allowance of $" + this.ALLOWANCE);
		this.setIsReceivingAllowance(true);

	}

	private boolean isReceivingAllowance() {
		return this.isReceivingAllowance;
	}

	private void setIsReceivingAllowance(boolean b) {
		this.isReceivingAllowance = b;

	}

	public void statistics() {
		System.out.println("\n" + (this.getFirstName() + " " + this.getLastName() + "\nAge: " + this.getAge()
				+ "\nEducation: " + this.getEducationLevel() + "\nMoney: " + this.getMoney() + "\n"));
	}

	public void showRelationships() {
		System.out.println("\nThis feature has not yet been implemented.");
		// TODO write this

	}

	public void die() {
		this.setAlive(false);
	}

	public boolean canGetJob() {
		return this.getAge() > 16 && this.getAge() < 75;
	}

	public void goForAWalk() {
		// TODO write this

	}

	public void playLottery() {
		this.setHasPlayedLotteryThisYear(true);
		this.setMoney(this.getMoney() - this.getLOTTERY_PRICE());
		if (this.getR().nextFloat() <= 0.01) {
			// Win the lottery
		} else {
			System.out.println("You did not win the lottery. You now have $" + this.getMoney());
		}

	}

	public void browseInternet() {
		System.out.println("You scroll through social media for a bit. You feel like you're wasting your time.");
		//TODO add more Internet things
		
	}

}
