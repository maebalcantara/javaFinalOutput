
public class Rank extends Employee{
	private String name, type=this.getClass().getSimpleName();
	
	Rank(String name){
		super(name);
		this.name = name;
	}
	
	@Override
	public void responsibilities() {
		System.out.println(this.type + " " + this.name +"'s responsibilities include: ");
		System.out.println("Do work properly.");
	}
	
	public void displaySalary() {
		super.displaySalary(type);
	}
}
