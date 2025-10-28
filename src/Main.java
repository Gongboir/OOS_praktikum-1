import bank.*;

/**
 * Main class for testing the functionality of the OOS Praktikum 2 tasks.
 * <p>
 * Demonstrates creation, calculation, and comparison of {@link Payment} and {@link Transfer} objects.
 *
 * @author Arjeet Gongboir
 * @version 2.0
 */

public class Main {
    /**
     * Entry point for testing the Payment and Transfer classes.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        System.out.println("===== Creating Payment objects =====");
        // Deposit (positive amount)
        Payment deposit = new Payment("28.10.2025", 1000.0, "Salary Deposit",
                0.05, 0.1);
        // Withdrawal (negative amount)
        Payment withdrawal = new Payment("28.10.2025", -500.0, "ATM Withdrawal",
                0.05, 0.1);
        // Copy constructor
        Payment copyPayment = new Payment(deposit);
        // Display all
        System.out.println(deposit);
        System.out.println(withdrawal);
        System.out.println(copyPayment);


        System.out.println("\n===== Creating Transfer objects =====");
        // Transfer using all attributes
        Transfer transfer1 = new Transfer("28.10.2025", 300.0,
                "Rent Payment", "Alice", "Bob");
        // Copy constructor
        Transfer transferCopy = new Transfer(transfer1);
        System.out.println(transfer1);
        System.out.println(transferCopy);

        System.out.println("\n===== Testing equals() =====");
        System.out.println("deposit.equals(copyPayment): " + deposit.equals(copyPayment)); // true
        System.out.println("deposit.equals(withdrawal): " + deposit.equals(withdrawal));   // false
        System.out.println("transfer1.equals(transferCopy): " + transfer1.equals(transferCopy)); // true


        System.out.println("\n===== Testing toString() =====");
        System.out.println(deposit.toString());
        System.out.println(withdrawal.toString());
        System.out.println(transfer1.toString());
    }
}