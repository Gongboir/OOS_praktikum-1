package bank;
/**
 * Represents a deposit or withdrawal on an account.
 * - amount: positive -> deposit, negative -> withdrawal
 * - incomingInterest / outgoingInterest: percent in range [0, 1]
 */
public class Payment extends Transaction{

    // --- Payment-specific attributes ---
    private double incomingInterest; // [0, 1]
    private double outgoingInterest; // [0, 1]

    // --- Constructors ---
    /**
     * constructor with minimal attributes
     */
    public Payment(String date, double amount, String description){
        super(date, amount, description);
    }

    /**
     * complete constructor that also calls the constructor of the super class.
     */
    public Payment(String date, double amount, String description,
                   double incomingInterest, double outgoingInterest){
        super(date, amount, description); // calls the first constructor:- Payment(String date, double amount, String description)
        //sets the current object with the data from arguments
        setIncomingInterest(incomingInterest);
        setOutgoingInterest(outgoingInterest);
    }

    /**
     * copy constructor to copy the arguments directly from a second object.
     */
    public Payment(Payment different_object){
        super(different_object);
        this.incomingInterest = different_object.incomingInterest;
        this.outgoingInterest = different_object.outgoingInterest;
    }

    // --- Getters / Setters ---
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

    @Override
    public double calculate(){
        if(amount > 0)
            return amount - (amount * incomingInterest);
        else
            return amount + (amount * outgoingInterest);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", IncomingInterest: " + getIncomingInterest() +
                ", OutgoingInterest: " + getOutgoingInterest() +
                ", CalculatedAmount: " + calculate();
    }

    @Override
    public boolean equals(Object obj){
        if(!super.equals(obj)) return false; //refer to the equals method in the super class
        if(!(obj instanceof Payment)) return false; //check if the object is an instance of Payment
        Payment other = (Payment) obj;
        return Double.compare(this.incomingInterest, other.incomingInterest) == 0 &&
                Double.compare(this.outgoingInterest, other.outgoingInterest) ==0;
        //type case obj to payment
    }
}
