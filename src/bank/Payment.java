package bank;
/**
 * Represents a deposit or withdrawal on an account.
 * - amount: positive -> deposit, negative -> withdrawal
 * - incomingInterest / outgoingInterest: percent in range [0, 1]
 */
public class Payment {
    private String date; // Format: DD.MM.YYYY
    private double amount; // Positive -> deposit, negative -> withdrawal
    private String description; //extra notes about the payment

    // --- Payment-specific attributes ---
    private double incomingInterest; // [0, 1]
    private double outgoingInterest; // [0, 1]

    // --- Constructors ---

    /**
     * constructor with minimal attributes.
     */
    public Payment(String date, double amount, String description){
        //sets the current object with the data from arguments
        setDate(date);
        setAmount(amount);
        setDescription(description);

        //Initialise the Interest rates to 0
        this.incomingInterest = 0.0;
        this.outgoingInterest = 0.0;
    }

    /**
     * constructor with all the attributes.
     */
    public Payment(String date, double amount, String description,
                   double incomingInterest, double outgoingInterest){
        this(date, amount, description); // calls the first constructor:- Payment(String date, double amount, String description)
        //sets the current object with the data from arguments
        setIncomingInterest(incomingInterest);
        setOutgoingInterest(outgoingInterest);
    }

    /**
     * copy constructor to copy the arguments directly from a second object.
     */
    public Payment( Payment different_object){
        this(different_object.date, different_object.amount, different_object.description, different_object.incomingInterest,
                different_object.outgoingInterest);
    }

    // --- Getters / Setters ---

    public String getDate() {
        return date; //getter to fetch the date
    }

    public void setDate(String date) {
        // Spec: not programmatic.
        this.date = date; //setter to set the date
    }

    public double getAmount() {
        return amount; //getter to fetch the date
    }

    /**
     * For Payment, both positive (deposit) and negative (withdrawal) are allowed.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;//getter to fetch the date
    }

    public void setDescription(String description) {
        this.description = description;//setter to set the date
    }

    public double getIncomingInterest() {
        return incomingInterest;
    }

    /**
     * Must be in [0, 1]. On invalid input, print an error and keep previous value.
     */
    public void setIncomingInterest(double incomingInterest) {
        if (incomingInterest < 0.0 || incomingInterest > 1.0) {
            System.out.println("Error: incomingInterest must be between 0 and 1 (inclusive).");
            return;
        }
        this.incomingInterest = incomingInterest; // if user enters valid amount ,set it for the current object
    }

    public double getOutgoingInterest() {
        return outgoingInterest;
    }

    /**
     * Must be in [0, 1]. On invalid input, print an error and keep previous value.
     */
    public void setOutgoingInterest(double outgoingInterest) {
        if (outgoingInterest < 0.0 || outgoingInterest > 1.0) {
            System.out.println("Error: outgoingInterest must be between 0 and 1 (inclusive).");
            return;
        }
        this.outgoingInterest = outgoingInterest;
    }

    // --- Utility ---

    /**
     * Prints the contents of all attributes to the console.
     */
    public void printObject() {
        System.out.println("Payment {");
        System.out.println("  date = " + date);
        System.out.println("  amount = " + amount + " (positive=deposit, negative=withdrawal)");
        System.out.println("  description = " + description);
        System.out.println("  incomingInterest = " + incomingInterest);
        System.out.println("  outgoingInterest = " + outgoingInterest);
        System.out.println("}");
    }
}
