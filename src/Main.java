import bank.Payment;
import bank.Transfer;

/**
 * Main class used to test the functionality of Payment and Transfer.
 */

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Testing Payment Constructors ===");

        // Constructor with 3 parameters
        Payment p1 = new Payment("10.10.2025", 250.0, "Deposit");
        p1.printObject();

        // Constructor with all parameters
        Payment p2 = new Payment("11.10.2025", -100.0, "Withdrawal", 0.02, 0.03);
        p2.printObject();

        // Copy constructor
        Payment p3 = new Payment(p2);
        p3.printObject();

        // Test invalid interest values
        System.out.println("\n--- Testing invalid interest ---");
        p1.setIncomingInterest(2.5);   // invalid (>1)
        p1.setOutgoingInterest(-0.5);  // invalid (<0)

        // Print final state
        p1.printObject();

        System.out.println("\n=== Testing Transfer Constructors ===");

        // Constructor with 3 parameters
        Transfer t1 = new Transfer("12.10.2025", 500.0, "Transfer to friend");
        t1.printObject();

        // Constructor with all parameters
        Transfer t2 = new Transfer("13.10.2025", 750.0, "Rent payment", "Alice", "Bob");
        t2.printObject();

        //  Copy constructor
        Transfer t3 = new Transfer(t2);
        t3.printObject();

        // Test invalid amount
        System.out.println("\n--- Testing invalid amount ---");
        t1.setAmount(-100.0); // should print error

        // Print final state
        t1.printObject();

        System.out.println("\n=== End of Tests ===");
    }
}