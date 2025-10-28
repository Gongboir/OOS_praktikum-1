package bank;
/**
 * Represents a money transfer between two parties.
 * <p>
 * This transaction type does not apply any interest.
 * It simply records the sender, recipient, and amount transferred.
 *
 * @author Arjeet Gongboir
 * @version 2.0
 */
public class Transfer extends Transaction{
    /** The name of the sender initiating the transfer. */
    private String sender;
    /** The name of the recipient receiving the transfer. */
    private String recipient;

    // --- Constructors ---
    /**
     * Constructs a Transfer with the given details.
     *
     * @param date the date of the transfer
     * @param amount the transfer amount (must be positive)
     * @param description the description of the transfer
     */
    public Transfer(String date, double amount, String description){
        super(date, amount, description);
    }

    /**
     * Constructs a Transfer with the given details.
     *
     * @param date the date of the transfer
     * @param amount the transfer amount (must be positive)
     * @param description the description of the transfer
     * @param sender the sender's name
     * @param recipient the recipient's name
     */
    public Transfer(String date, double amount, String description,
                    String sender, String recipient) {
        super(date, amount, description);
        setSender(sender);
        setRecipient(recipient);
    }

    /**
     * Copy constructor for Transfer.
     *
     * @param other the Transfer object to copy
     */
    public Transfer(Transfer other) {
        super(other);
        this.sender = other.sender;
        this.recipient = other.recipient;
    }

    // --- Getters / Setters ---
    /**
     * Ensures that transfer amounts are always positive.
     *
     * @param amount the amount to set
     */
    @Override
    public void setAmount(double amount) {
        if (amount <= 0.0) {
            System.out.println("Error: Transfer amount must be positive (> 0).");
            return;
        }
        this.amount = amount;
    }

    /** @return the sender's name */
    public String getSender() {
        return sender;
    }
    /** @param sender sets the sender's name */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /** @return the recipient's name */
    public String getRecipient() {
        return recipient;
    }
    /** @param recipient sets the recipient's name */
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    /**
     * Returns the transfer amount unchanged, as no interest applies.
     *
     * @return the same amount as the transaction value
     */
    @Override
    public double calculate(){
        return amount;
    }

    /**
     * Returns a string representation of this Transfer.
     *
     * @return a formatted string with sender, recipient, and amount
     */
    @Override
    public String toString() {
        return super.toString() +
                ", Sender: " + getSender() +
                ", Recipient: " + getRecipient() +
                ", CalculatedAmount: " + calculate();
    }


    /**
     * Compares this Transfer to another object for equality.
     *
     * @param obj the object to compare
     * @return {@code true} if both Transfers share identical data
     */
    @Override
    public boolean equals(Object obj){
        if(!super.equals(obj)) return false;//call the super class method equals
        if(!(obj instanceof Transfer)) return false;//check if obj is type Transfer
        Transfer other = (Transfer) obj;//type cast Transfer so that we can use other to compare each attribute
        return sender.equals(other.sender) && recipient.equals(other.recipient);
    }
}
