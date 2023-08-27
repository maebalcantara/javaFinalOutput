
abstract class Employee {
	private String name;

	public Employee(String name) {
		this.name = name;
	}
	
	public abstract void responsibilities();
	
	private float salaryCalculator(String type) {
		int hourly = 0;
		switch (type) {
			case "Manager": {
				hourly =  625;
				break;
			} 
			case "Rank" : {
				hourly =  300; 
				break;
			} 
		}
		//Returns 1 day salary
		return 8 * hourly; 
	}
	
	public void displaySalary(String type) {
		System.out.println("Salary of "+ type + " " + this.name + " is Php " + salaryCalculator(type));
	}
}
