import java.util.Random;

public class Player {
	
	private Random r;
	
	private String firstName;
	private String lastName;
	private int age;
	
	private String[] firstNames = {"John", "Joe", "Jimmy"};
	private String[] lastNames = {"Smith", "Doe", "Johnson"};
	
	

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

	public Player() {
		this.r = new Random();
		this.age = 0;
		this.firstName = firstNames[r.nextInt(firstNames.length - 1)];
		this.lastName = lastNames[r.nextInt(lastNames.length - 1)];
		
	}

	public boolean isAlive() {
		
		return this.getAge() < 0 || this.getAge() >= 100;
	}
	
	
	
}
