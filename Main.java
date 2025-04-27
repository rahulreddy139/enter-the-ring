import java.util.Scanner;
import java.util.HashMap;

public class Main {
    private static HashMap<String, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\n--- Banking System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    createAccount(scanner);
                    break;
                case "2":
                    deposit(scanner);
                    break;
                case "3":
                    withdraw(scanner);
                    break;
                case "4":
                    checkBalance(scanner);
                    break;
                case "0":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid Option!");
            }
        } while (!choice.equals("0"));

        scanner.close();
    }

    private static void createAccount(Scanner scanner) {
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        accounts.put(accNum, new Account(accNum, name, 0));
        System.out.println("Account Created.");
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine();
        Account acc = accounts.get(accNum);
        if (acc != null) {
            System.out.print("Enter amount: ");
            double amt = scanner.nextDouble();
            scanner.nextLine(); // clear buffer
            acc.deposit(amt);
            System.out.println("Deposit Successful.");
        } else {
            System.out.println("Account Not Found.");
        }
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine();
        Account acc = accounts.get(accNum);
        if (acc != null) {
            System.out.print("Enter amount: ");
            double amt = scanner.nextDouble();
            scanner.nextLine();
            if (acc.withdraw(amt)) {
                System.out.println("Withdrawal Successful.");
            } else {
                System.out.println("Insufficient Balance.");
            }
        } else {
            System.out.println("Account Not Found.");
        }
    }

    private static void checkBalance(Scanner scanner) {
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine();
        Account acc = accounts.get(accNum);
        if (acc != null) {
            System.out.println("Balance: $" + acc.getBalance());
        } else {
            System.out.println("Account Not Found.");
        }
    }
}
