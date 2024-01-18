import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: $" + balance);
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
            return false;
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
            return true;
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a bank account with an initial balance
        BankAccount userAccount = new BankAccount(1000.0);

        while (true) {
            // Display menu
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            // Get user choice
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();

            // Perform action based on user choice
            switch (choice) {
                case 1:
                    checkBalance(userAccount);
                    break;
                case 2:
                    deposit(userAccount, scanner);
                    break;
                case 3:
                    withdraw(userAccount, scanner);
                    break;
                case 4:
                    System.out.println("Exiting ATM. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    private static void checkBalance(BankAccount account) {
        System.out.println("Current balance: $" + account.getBalance());
    }

    private static void deposit(BankAccount account, Scanner scanner) {
        System.out.print("Enter deposit amount: $");
        double depositAmount = scanner.nextDouble();
        account.deposit(depositAmount);
    }

    private static void withdraw(BankAccount account, Scanner scanner) {
        System.out.print("Enter withdrawal amount: $");
        double withdrawalAmount = scanner.nextDouble();
        account.withdraw(withdrawalAmount);
    }
}
