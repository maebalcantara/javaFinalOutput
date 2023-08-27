import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentInfo {
	private String name;
	private int id, yearLevel;
	private ArrayList<Double> grades;
	
	public StudentInfo(String name, int id, int yearLevel) {
		this.name = name;
		this.id = id;
		this.yearLevel = yearLevel;
		grades = new ArrayList<>();
	}
	
	public void addGrade() {
		Scanner gradeInput = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.print("Enter the grade: ");
				grades.add(gradeInput.nextDouble());
			} catch(InputMismatchException e) {
				System.out.println("Ending the scan.");
				break;
			} 
		}
		gradeInput.close();
		checkInfo();
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYearLevel() {
		return yearLevel;
	}
	public void setYearLevel(int yearLevel) {
		this.yearLevel = yearLevel;
	}
	public ArrayList<Double> getGrades() {
		return grades;
	}
	public void setGrades(ArrayList<Double> grades) {
		this.grades = grades;
	}
	
	private void checkInfo() {
		System.out.println("--------------------------------------------------");
		System.out.println("Student " + this.name + "'s info: ");
		System.out.println("ID: " + this.id);
		System.out.println("Year level: " + this.yearLevel);
		System.out.println("Your grades are: ");
		grades.forEach(x -> {
			System.out.println(x);
		});
		System.out.println("--------------------------------------------------");
	}
}
