import java.util.Scanner;

class ATM {

    static Scanner scan = new Scanner(System.in);
    private double balance;
	private double previousTransaction;
    private int pin = 1120;


    // Set the PIN
	void setPin(int pin) {
		this.pin = pin;
    }


    // Get the PIN
	int getPin() {
		return pin;
	}


    // Credit an amount to the account
    void deposit(double amount)	{
		if(amount > 0){
		balance += amount;
		previousTransaction = amount;
        System.out.println("***************************************************************");
        System.out.println("credited :" + amount + " Rs/- Successfully.");
        System.out.println("***************************************************************");
		} 
        else {
            System.out.println("Invalid deposit amount.");
        }
	}


    // Debit an amount from the account
	void withdraw(double amount) {
		System.out.print("Enter ATM PIN to Withdrawal Money : ");
		int enteredPin = scan.nextInt();
		if(getPin() == enteredPin){
			if(amount > 0 && amount <= balance) {
			balance -= amount;
			previousTransaction = -amount;
            System.out.println("***************************************************************");
			System.out.println("Debited: " + amount + " Rs/- Successfully.");
            System.out.println("***************************************************************");
			}
            else {
                  System.out.println("Insufficient Balance");
            }
		}
		else {
			System.out.println("Invalid ATM PIN Number ! Try again ");
			withdraw(amount);
		}
	} 


    // Display the previous transtion
	void displayPreviousTransaction() {
		if(previousTransaction > 0) {
		System.out.println("The Amount Credited to your Account is : "+previousTransaction+"/-");
		}
		else if(previousTransaction < 0) {
		System.out.println("The Amount Debited from your Account is : "+previousTransaction+"/-");
		}
		else {
		System.out.println("No Transaction occured");
		}
	}


    // check the entered PIN and show the menu if correct
    public void checkPin() {
        System.out.println("Enter your pin: ");
        int enteredPin = scan.nextInt();
        if(getPin() == enteredPin) {
            displayMenu();
        } 
        else {
            System.out.println("Enter a Valid PIN");
            checkPin();
        }  
    }


    // Display the ATM menu
    public void displayMenu() {
        System.out.println("===============================================================");
        System.out.println("Enter Your Choice: ");
        System.out.println("===============================================================");
        System.out.println("1. Account balance inquiry");
        System.out.println("2. Cash withdrawl");
        System.out.println("3. Cash deposit");
        System.out.println("4. PIN change");
        System.out.println("5. Transaction history");
        System.out.println("6. EXIT");
        System.out.println("===============================================================");

        int option = scan.nextInt();

        switch (option) {
            case 1:
                displayBalance();
                break;
            case 2:
                promptWithdraw();
                break;
            case 3:
                promptDeposit();
                break;
            case 4:
                changePin();
                break;
            case 5:
                displayTransactionHistroy();
                break;
            case 6:
                System.out.println("***************************************************************");
                System.out.println("            THANKYOU ! for using our services :) ");
                System.out.println("***************************************************************");
                return;
            default:
                System.out.println("Enter a valid choice");
                displayMenu();
                break;
        }

    }


    // Display the account balance
    public void displayBalance() {
        System.out.println("***************************************************************");
        System.out.println("Account Balance is : " + balance);
        System.out.println("***************************************************************");
        displayMenu();
    }


    // Prompt for an amount to withdraw
    public void promptWithdraw() {
        System.out.println("***************************************************************");
        System.out.println("Enter amount to withdraw: " );
        System.out.println("***************************************************************");
        double amount = scan.nextDouble();
        withdraw(amount);
        displayMenu();
    }


    // Prompt for an amount to deposit
    public void promptDeposit() {
        System.out.println("***************************************************************");
        System.out.println("Enter the amount to deposit: ");
        System.out.println("***************************************************************");
        double amount = scan.nextDouble();
        deposit(amount);
        displayMenu();
    }


    // Change the PIN
    public void changePin() {
        System.out.print("Enter current ATM PIN: ");
        int oldPin = scan.nextInt();
        if(oldPin == getPin()){
            System.out.println("===============================================================");
            System.out.println("Validation Successful.");
            System.out.println("===============================================================");
            System.out.println("Enter new ATM pin: ");
            int newPin = scan.nextInt();
            setPin(newPin);
            System.out.println("***************************************************************");
            System.out.println("New PIN updated successfully.");
            System.out.println("***************************************************************");
        } 
        else {
            System.out.println("Incorrect current PIN.");
            changePin();
        }
        displayMenu();
    }


    // Display the transaction history
    public void displayTransactionHistroy() {
        System.out.println("***************************************************************");
        displayPreviousTransaction();
        System.out.println("***************************************************************");
        displayMenu();
    }

}