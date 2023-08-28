package FinalOutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static String userCSVPath = "C:\\javaProjects\\resources\\accounts.csv";
	public static String userCSVPathTemp = "C:\\javaProjects\\resources\\accounts_temp.csv";
	
	public static File fileTemp = new File(userCSVPathTemp);
	public static File file = new File(userCSVPath);
	
	public static Path pathTemp = Paths.get(userCSVPathTemp);
	public static Path path = Paths.get(userCSVPath);
	
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(file));
				FileWriter output = new FileWriter(fileTemp);) {
		    String line="", username="";
		    String[] acctInfo = null;
		    
		    System.out.print("Enter your username: ");
		    username = scanner.nextLine();
		    
		    if (username.length() > 0) {
		    	output.write(br.readLine() + "\n");

			    while ((line = br.readLine()) != null) {
			    	if(line.split(",")[0].equals(username)) {
			    		acctInfo = line.split(",");
			    		line=accountProcess(acctInfo);
			    	}
			    	output.write(line + "\n");
			    }
			    scanner.close();
				System.out.println(acctInfo == null ? "Account doesn't exist." : "Exiting...");  
		    }
		}  catch (Exception e) {
			System.out.println(e.getMessage());
		} 
		Files.move(pathTemp, path, StandardCopyOption.REPLACE_EXISTING);
	}
	
	private static String accountProcess(String[] acctInfo) {
		String username=acctInfo[0];
		double savingsBalance=Double.valueOf(acctInfo[1]), currentBalance=Double.valueOf(acctInfo[2]),tempBalance=0;
		int transac=0, account=0;
		BankAccountAbstract userAccount = null;	
		
		while(transac >= 0) {			
			tempBalance = 0;
			System.out.print("Choose an account:\n1. Savings\n2. Current\n->");
			account = scanner.nextInt();
			
			userAccount = account == 1 ? new SavingsAccount(savingsBalance) : new CurrentAccount(currentBalance);
			
			transac = chooseTransaction(scanner);
			switch (transac) {
				case 1: {
					tempBalance = userAccount.deposit(scanner.nextInt());
					break;
				}
				case 2 : {
					tempBalance = userAccount.withdraw(scanner.nextInt());
					break;
				}
				case 3 : {
					System.out.println("Your current balance is: " + userAccount.getBalance());
					break;
				}
			}
			
			savingsBalance = account == 1 && tempBalance != 0 ? tempBalance : savingsBalance;
			currentBalance = account == 2 && tempBalance != 0 ? tempBalance : currentBalance;

			System.out.println("-------------------------------------------");
		}
		return username + "," + savingsBalance + ","+ currentBalance;
	}
	
	private static int chooseTransaction(Scanner scanner) {
		int trans = -1;
		try{	
			System.out.print("Select transaction:\n1. Deposit \n2. Withdraw \n3. View Balance\n-> ");
			 scanner.nextInt();
			if(trans > 0 && trans <=3) {
				System.out.print(trans <= 2 ? "Enter amount: " : "");
			} else {
				throw new InputMismatchException();
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid transaction.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return trans;
	}
}
