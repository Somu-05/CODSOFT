package Task3;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ATM_interface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial balance for the account: ");
        double initialBalance = 0;
        try {
            initialBalance = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a numeric value.");
            System.exit(1);
        }

        BankAccount account = new BankAccount(initialBalance);
        ATM atm = new ATM(account);

        while (true) {
            atm.displayMenu();
            System.out.print("Select an option: ");
            int option = 0;
            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }
            atm.executeOption(option);
        }
    }
}
 class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double checkBalance() {
        return balance;
    }
}

 class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void executeOption(int option) {
        switch (option) {
            case 1:
                checkBalance();
                break;
            case 2:
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                withdraw(withdrawAmount);
                break;
            case 4:
                System.out.println("Thank you for using the ATM.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void checkBalance() {
        double balance = account.checkBalance();
        System.out.printf("Your current balance is: $%.2f%n", balance);
    }

    private void deposit(double amount) {
        if (account.deposit(amount)) {
            System.out.printf("Deposited $%.2f successfully.%n", amount);
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    private void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.printf("Withdrew $%.2f successfully.%n", amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

