package bank;
/**
 * Represents a bank transfer.
 * - amount must be strictly positive
 * - sender and recipient identify the actors
 */
public class Transfer extends Transaction{
    private String sender;
    private String recipient;

    // --- Constructors ---
    /**
     * constructor with minimal attributes.
     */
    public Transfer(String date, double amount, String description){
        super(date, amount, description);
    }
    /**
     * constructor with all the attributes.
     */
    public Transfer(String date, double amount, String description,
                    String sender, String recipient) {
        super(date, amount, description);
        setSender(sender);
        setRecipient(recipient);
    }

    /**
     * copy constructor to copy the arguments directly from a second object.
     */
    public Transfer(Transfer other) {
        super(other);
        this.sender = other.sender;
        this.recipient = other.recipient;
    }

    // --- Getters / Setters ---
    /**
     * Only positive values are allowed.
     * On invalid input, print an error and keep previous value.
     */
    @Override
    public void setAmount(double amount) {
        if (amount <= 0.0) {
            System.out.println("Error: Transfer amount must be positive (> 0).");
            return;
        }
        this.amount = amount;
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

    @Override
    public double calculate(){
        return amount;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Sender: " + getSender() +
                ", Recipient: " + getRecipient() +
                ", CalculatedAmount: " + calculate();
    }

    @Override
    public boolean equals(Object obj){
        if(!super.equals(obj)) return false;//call the super class method equals
        if(!(obj instanceof Transfer)) return false;//check if obj is type Transfer
        Transfer other = (Transfer) obj;//type cast Transfer so that we can use other to compare each attribute
        return sender.equals(other.sender) && recipient.equals(other.recipient);
    }
}
