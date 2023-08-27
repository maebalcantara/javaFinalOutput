package FinalOutput;

public class CurrentAccount extends BankAccountAbstract {
	private double balance;
	public CurrentAccount(double balance) {
		this.balance = balance;
	}

	@Override
	public double deposit(double amount) {
		if(amount > 100) {
			System.out.println("Amount " + amount + " successfully deposited.");
			this.balance += amount;
		} else {
			System.out.println("Amount must be more than 100.");
		}
		return this.balance;
	}

	@Override
	public double withdraw(double amount) {
		if(amount > 100 && amount <= this.balance) {
			System.out.println("Amount " + amount + " successfully withdrew.");
			this.balance -= amount;
		} else {
			System.out.println("Amount must be more than 100 or should be less than or equal than current balance.");
		}
		return this.balance;
	}
	
	@Override
	public double getBalance() {
		return this.balance;
	}
}
