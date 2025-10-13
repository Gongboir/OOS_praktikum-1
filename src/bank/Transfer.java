package bank;
/**
 * Represents a bank transfer.
 * - amount must be strictly positive
 * - sender and recipient identify the actors
 */
public class Transfer {
    // --- Common attributes with Payment ---
    private String date;         // Format: DD.MM.YYYY (not programmatically validated per spec)
    private double amount;       // Must be > 0
    private String description;  // Free-form notes

    // --- Transfer-specific attributes ---
    private String sender;
    private String recipient;

    // --- Constructors ---

    /**
     * constructor with minimal attributes.
     */
    public Transfer(String date, double amount, String description) {
        setDate(date);
        this.amount = 0.0;// initialize to a safe default value, in case there is no user input
        setAmount(amount);
        setDescription(description);

        //Initialise sender and recipient to null
        this.sender = "";
        this.recipient = "";
    }

    /**
     * constructor with all the attributes.
     */
    public Transfer(String date, double amount, String description,
                    String sender, String recipient) {
        this(date, amount, description);
        setSender(sender);
        setRecipient(recipient);
    }

    /**
     * copy constructor to copy the arguments directly from a second object.
     */
    public Transfer(Transfer other) {
        this(other.date, other.amount, other.description,
                other.sender, other.recipient);
    }

    // --- Getters / Setters ---

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        // Spec: do not enforce the format programmatically.
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    /**
     * Only positive values are allowed.
     * On invalid input, print an error and keep previous value.
     */
    public void setAmount(double amount) {
        if (amount <= 0.0) {
            System.out.println("Error: Transfer amount must be positive (> 0).");
            return;
        }
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    // --- Utility ---

    /**
     * Prints the contents of all attributes to the console.
     */
    public void printObject() {
        System.out.println("Transfer {");
        System.out.println("  date = " + date);
        System.out.println("  amount = " + amount);
        System.out.println("  description = " + description);
        System.out.println("  sender = " + sender);
        System.out.println("  recipient = " + recipient);
        System.out.println("}");
    }
}
