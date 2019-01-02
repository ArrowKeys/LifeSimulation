package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {

	private final int MAX_AGE = 100;
	private final int MIN_AGE = 0;

	private Random r;

	private String firstName;
	private String lastName;
	private int age;
	private boolean alive;
	private boolean isInSchool;
	private double educationLevel;
	private double educationIncrement;

	private ArrayList<String> firstNames = new ArrayList<String>();
	private ArrayList<String> lastNames = new ArrayList<String>();

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

	public boolean isInSchool() {
		return isInSchool;
	}

	public void setInSchool(boolean isInSchool) {
		this.isInSchool = isInSchool;
	}

	public double getEducationLevel() {
		return Double.parseDouble(String.format("%.2f", this.educationLevel));
	}

	public void setEducationLevel(double educationLevel) {
		this.educationLevel = educationLevel;
	}

	public void age() {
		this.setAge(this.getAge() + 1);
		System.out.println("\nYou are now " + this.getAge() + " year" + (this.getAge() == 1 ? " " : "s ") + "old.");

		if (this.isInSchool()) {
			this.setEducationLevel(this.getEducationLevel() + this.getEducationIncrement());
		}

		switch (this.getAge()) {
		case 6:
			this.startSchool();
			break;
		default:
			break;
		}
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public boolean getAlive() {
		return alive;
	}

	private double getEducationIncrement() {
		return educationIncrement;
	}

	public void setEducationIncrement(double educationIncrement) {
		this.educationIncrement = educationIncrement;
	}

	private void startSchool() {
		this.setInSchool(true);
		System.out.println("You have started going to school.");
		this.setEducationIncrement(0.3);
	}

	public void statistics() {
		System.out.println("\n" + (this.getFirstName() + " " + this.getLastName() + "\nAge: " + this.getAge()
				+ "\nEducation: " + this.getEducationLevel() + "\n"));
	}

	public void showRelationships() {
		System.out.println("\nThis feature has not yet been implemented.");

	}

	public void die() {
		this.setAlive(false);
	}

	public boolean canGetJob() {
		return this.getAge() > 16 && this.getAge() < 75;
	}

}
