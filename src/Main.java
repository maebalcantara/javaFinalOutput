import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/* Encapsulation */
		// Rectangle rectangle = new Rectangle(1,2);

		/* Inheritance */
		// Manager manager = new Manager("Mae");
		// manager.responsibilities();
		// manager.displaySalary();
		//
		// System.out.println("------------------------------------");
		// Rank rank = new Rank("Mae");
		// rank.responsibilities();
		// rank.displaySalary();
		//
		// System.out.println("------------------------------------");

		/* Method Overloading and Overriding */
		// Calculator calculator = new Calculator();
//		Calc calc = new Calc();
//
//		Double x = 10.6, y = 20.7;
//		Integer a = 15, b = 35;
//		Float c = 30f, d = 50f;


		/* Exception Handling*/
		//#1
		exceptionHandling();
		
		//#2
//		StudentInfo maeStudentInfo = new StudentInfo("mae", 8888, 3);
//		maeStudentInfo.addGrade();
	}

	public static void exceptionHandling() {
		Scanner scan = new Scanner(System.in);
		int userInput = 0;
		ArrayList<Integer> listOfUserInput = new ArrayList<>();
		
		System.out.println("---------------------START-------------------");
		while (true) {
			try {
				System.out.print("Enter an integer: ");
				userInput = scan.nextInt();
				if(listOfUserInput.contains(userInput)) {
					//Created custom exception for duplicate handling
					throw new DuplicateValueException("Duplicate value exception occured. Ending the scan.");
				}
				listOfUserInput.add(userInput);
			} catch (InputMismatchException i) {
				//Input mismatch is catch. This also ends the loop. 
				System.out.println("Input mismatch exception occured. Ending the scan.");
				scan.next();
			} catch (DuplicateValueException e) {
				System.out.println(e.getMessage());
				break;
			}  catch(Exception e) {
				//General exception fall back.
				System.out.println(e);
			}
		}
		scan.close();
		System.out.println("---------------------END-------------------");
	}
}

class DuplicateValueException extends Exception { 
    public DuplicateValueException(String errorMessage) {
        super(errorMessage);
    }
}
