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

	private ArrayList<String> firstNames = new ArrayList<String>();
	private ArrayList<String> lastNames = new ArrayList<String>();

	public Player() {

		try {
			String firstNamesFile = "Names/FirstNames";
			String lastNamesFile = "Names/LastNames";
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

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public boolean getAlive() {
		return alive;
	}

	public String statistics() {

		return new String(this.getFirstName() + " " + this.getLastName() + "\nAge: " + this.getAge());
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

}
