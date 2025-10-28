package bank;
/**
 * Interface for classes that can calculate a final transaction value.
 * <p>
 * Implemented by {@link Payment} and {@link Transfer}.
 *
 * @author Arjeet Gongboir
 * @version 1.0
 */
public interface CalculateBIll {
    /**
     * Calculates the final transaction amount.
     * Implementations may apply fees or interest depending on transaction type.
     *
     * @return the calculated transaction value
     */
    double calculate(); //public and abstract are optional here as java already does it
}
