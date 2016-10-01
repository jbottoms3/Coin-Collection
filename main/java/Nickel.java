/**
 * Nickel class represents a Nickel, which is a coin that is worth
 * 5 cents and has a year that it was created in.
 *
 * @author James Bottoms
 * @version 1.0
 */
public class Nickel extends Coin {

    /**
     * Creates a new Nickel with specified year that it was created and a value
     * of 5 cents
     * @param  aYear Year that the nickel was created
     */
    public Nickel(int aYear) {
        super(5, aYear);
    }

    @Override
    public String toString() {
        return "Nickel: " + this.getValue() + " " + this.getYear();
    }

}