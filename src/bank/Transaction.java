package bank;
/**
 * Abstract superclass representing a general transaction.
 */
public abstract class Transaction {
    protected String date;
    protected double amount;
    protected String description;

    // Constructor
    public Transaction(String date, double amount, String description){
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    //Copy constructor
    public  Transaction(Transaction other){
        this.date = other.date;
        this.amount= other.amount;
        this.description = other.description;
    }

    //getter and setter for all the attributes
    public String getDate() {return date;}
    public void setDate(String date) {this.date = date;}

    public double getAmount() {return amount;}
    public void setAmount(double amount) {this.amount=amount;}

    public String getDescription(){return description;}
    public void setDescription(String description){this.description=description;}

    //an abstract method that follows the interface calculateBILL
    public abstract double calculate();

    @Override
    public String toString(){
        return "Date: "+getDate()+", Amount: "+getAmount()+" , Description: "+getDescription();
    }

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
