import java.util.Scanner;
                                                                               //Sourp Chakraborty
public class ATM_System {

    private static Scanner sc = new Scanner(System.in);
    private static String userId = "1234";                                      // Sample user ID
    private static String userPin = "5678";                                     // Sample user PIN
    private static double balance = 1000.00;                                    // Sample initial balance

    public static void main(String[] args) {

                                                                                // Prompt the user to enter their user 
        System.out.print("Enter your user ID: ");                             // ID and user PIN
        String inputUserId = sc.nextLine();
        System.out.print("Enter your user PIN: ");
        String inputUserPin = sc.nextLine();

                                                                                // Verify the user ID and user PIN
        if (inputUserId.equals(userId) && inputUserPin.equals(userPin)) {
            System.out.println("Welcome to the ATM system!");
            showMenu();
        } else {
            System.out.println("Invalid user ID or user PIN.");
        }

    }

    private static void showMenu() {

        int choice;

        do {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    showTransactionsHistory();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

    }

    private static void showTransactionsHistory() {
        System.out.println("Transaction history is not available.");
    }

    private static void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = sc.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            System.out.printf("Withdrawn %.2f. Current balance is %.2f.%n", amount, balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private static void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = sc.nextDouble();
        balance += amount;
        System.out.printf("Deposited %.2f. Current balance is %.2f.%n", amount, balance);
    }

    private static void transfer() {
        System.out.print("Enter the recipient's account number: ");
        String recipientAccountNumber = sc.nextLine();
        System.out.print("Enter the amount to transfer: ");
        double amount = sc.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            System.out.printf("Transferred %.2f to account %s. Current balance is %.2f.%n", amount,
                    recipientAccountNumber, balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

}
