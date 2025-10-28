package bank;

/**
 * Abstract superclass representing a general financial transaction.
 * <p>
 * This class provides common attributes such as date, amount, and description
 * and defines an abstract method {@link #calculate()} that subclasses must implement.
 * It also overrides {@code toString()} and {@code equals(Object)} from {@link Object}.
 *
 * @author Arjeet Gongboir
 * @version 1.0
 */
public abstract class Transaction {
    /** The date of the transaction in DD.MM.YYYY format. */
    protected String date;
    /** The amount of money involved in the transaction. */
    protected double amount;
    /** A short text description of the transaction. */
    protected String description;

    /**
     * Constructs a new Transaction with the specified date, amount, and description.
     *
     * @param date the date of the transaction
     * @param amount the transaction amount
     * @param description a short description of the transaction
     */
    public Transaction(String date, double amount, String description){
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    /**
     * Copy constructor for creating a new Transaction from an existing one.
     *
     * @param other the Transaction object to copy from
     */
    public  Transaction(Transaction other){
        this.date = other.date;
        this.amount= other.amount;
        this.description = other.description;
    }

    //getter and setter for all the attributes
    /** @return the transaction date */
    public String getDate() {return date;}
    /** @param date sets the transaction date */
    public void setDate(String date) {this.date = date;}

    /** @return the transaction amount */
    public double getAmount() {return amount;}
    /** @param amount sets the transaction amount */
    public void setAmount(double amount) {this.amount=amount;}

    /** @return the transaction description */
    public String getDescription(){return description;}
    /** @param description sets the transaction description */
    public void setDescription(String description){this.description=description;}


    /**
     * Calculates the resulting transaction value.
     * <p>
     * Subclasses like {@link Payment} and {@link Transfer} must define
     * how this calculation works.
     *
     * @return the calculated transaction value
     */
    public abstract double calculate();

    /**
     * Returns a string representation of this Transaction.
     *
     * @return a formatted string containing date, amount, and description
     */
    @Override
    public String toString(){
        return "Date: "+getDate()+", Amount: "+getAmount()+" , Description: "+getDescription();
    }

    /**
     * Compares this transaction with another object for equality.
     *
     * @param obj the object to compare
     * @return {@code true} if both transactions have the same date, amount, and description
     */
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true; //checks if both the objects are pointing to the same memory location
        if(!(obj instanceof Transaction)) return false;//Checks if obj is an instance of Transaction
        Transaction other = (Transaction) obj; //type cast the obj obejct to type Transaction
        return Double.compare(other.amount, this.amount) == 0 &&
                this.date.equals(other.date) &&
                this.description.equals(other.description);
    }

}
