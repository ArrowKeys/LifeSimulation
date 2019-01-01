import java.util.Random;

public class Player {
	
	private final int MAX_AGE = 100; 
	private final int MIN_AGE = 0; 

	private Random r;

	private String firstName;
	private String lastName;
	private int age;
	private boolean alive;

	private String[] firstNames = { "John", "Joe", "Jimmy" };
	private String[] lastNames = { "Smith", "Doe", "Johnson" };

	public Player() {
		this.r = new Random();
		this.age = 0;
		this.alive = true;
		this.firstName = firstNames[r.nextInt(firstNames.length)];
		this.lastName = lastNames[r.nextInt(lastNames.length)];

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
