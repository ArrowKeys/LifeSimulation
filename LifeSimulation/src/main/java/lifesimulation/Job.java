package lifesimulation;

/**
 * 
 * @author punym
 * @param name - The name of the job
 * @param salary - The amount of money the player receives per year (per age)
 *
 */

public class Job {
	
	//TODO pick a list of 9 jobs to display at random each time the year increases

	private String name;
	private int salary;
			
	public Job(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		if (salary < 0) 
			salary = 0;
		this.salary = salary;
	}
	
	public String toString() {
		return "Name: " + this.getName() + "\nSalary: " + this.getSalary();
	}
	
}
