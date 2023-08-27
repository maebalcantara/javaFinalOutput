
public class Manager extends Employee{
	private String name, type=this.getClass().getSimpleName();
	public Manager(String name) {
		super(name);
		this.name = name;
	}
	
	@Override
	public void responsibilities() {
		System.out.println(type + " " + this.name +"'s responsibilities include: ");
		System.out.println("Manage people.");
	}
	
	public void displaySalary() {
		super.displaySalary(type);
	}
}
