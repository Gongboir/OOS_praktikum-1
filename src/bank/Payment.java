package bank;
/**
 * Represents a payment transaction, such as a deposit or withdrawal.
 * <p>
 * A positive {@code amount} represents a deposit (incoming funds),
 * while a negative {@code amount} represents a withdrawal (outgoing funds).
 * The calculation applies corresponding incoming or outgoing interest rates.
 *
 * @author Arjeet Gongboir
 * @version 2.0
 */
public class Payment extends Transaction implements CalculateBIll{

    /** The interest rate applied to deposits (value between 0 and 1). */
    private double incomingInterest; // [0, 1]
    /** The interest rate applied to withdrawals (value between 0 and 1). */
    private double outgoingInterest; // [0, 1]

    // --- Constructors ---
    /**
     * Creates a Payment with a date, amount, and description.
     *
     * @param date the date of the payment
     * @param amount the payment amount (positive for deposit, negative for withdrawal)
     * @param description a short description of the transaction
     */
    public Payment(String date, double amount, String description){
        super(date, amount, description);
    }


    /**
     * Creates a Payment with all attributes defined.
     *
     * @param date the date of the payment
     * @param amount the payment amount
     * @param description a short description
     * @param incomingInterest the interest rate for deposits (0–1)
     * @param outgoingInterest the interest rate for withdrawals (0–1)
     */
    public Payment(String date, double amount, String description,
                   double incomingInterest, double outgoingInterest){
        super(date, amount, description); // calls the first constructor:- Payment(String date, double amount, String description)
        //sets the current object with the data from arguments
        setIncomingInterest(incomingInterest);
        setOutgoingInterest(outgoingInterest);
    }

    /**
     * Copy constructor for Payment.
     *
     * @param different_object the Payment object to copy from
     */
    public Payment(Payment different_object){
        super(different_object);
        this.incomingInterest = different_object.incomingInterest;
        this.outgoingInterest = different_object.outgoingInterest;
    }

    // --- Getters / Setters ---
    /** @return the incoming interest rate */
    public double getIncomingInterest() {
        return incomingInterest;
    }
    /**
     * Sets the incoming interest rate.
     *
     * @param incomingInterest a value between 0 and 1
     */
    public void setIncomingInterest(double incomingInterest) {
        if (incomingInterest < 0.0 || incomingInterest > 1.0) {
            System.out.println("Error: incomingInterest must be between 0 and 1 (inclusive).");
            return;
        }
        this.incomingInterest = incomingInterest; // if user enters valid amount ,set it for the current object
    }

    /** @return the outgoing interest rate */
    public double getOutgoingInterest() {
        return outgoingInterest;
    }
    /**
     * Sets the outgoing interest rate.
     *
     * @param outgoingInterest a value between 0 and 1
     */
    public void setOutgoingInterest(double outgoingInterest) {
        if (outgoingInterest < 0.0 || outgoingInterest > 1.0) {
            System.out.println("Error: outgoingInterest must be between 0 and 1 (inclusive).");
            return;
        }
        this.outgoingInterest = outgoingInterest;
    }

    /**
     * Calculates the final amount after applying interest.
     * <p>
     * For deposits (positive amount): subtract incoming interest.<br>
     * For withdrawals (negative amount): add outgoing interest.
     *
     * @return the adjusted amount after applying interest
     */
    @Override
    public double calculate(){
        if(amount > 0)
            return amount - (amount * incomingInterest);
        else
            return amount + (amount * outgoingInterest);
    }

    /**
     * Returns a string representation including interest and calculated amount.
     *
     * @return a formatted string with all Payment details
     */
    @Override
    public String toString() {
        return super.toString() +
                ", IncomingInterest: " + getIncomingInterest() +
                ", OutgoingInterest: " + getOutgoingInterest() +
                ", CalculatedAmount: " + calculate();
    }

    /**
     * Compares this Payment with another object for equality.
     *
     * @param obj the object to compare
     * @return {@code true} if both Payments share identical data
     */
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
