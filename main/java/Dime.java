/**
 * Dime class represents a Dime, which is a coin that is worth
 * 10 cents and has a year that it was created in.
 *
 * @author James Bottoms
 * @version 1.0
 */
public class Dime extends Coin {

    /**
     * Creates a new Dime with a value of 10, and a year that is specified
     * @param  aYear Year that the dime was created
     */
    public Dime(int aYear) {
        super(10, aYear);
    }

    @Override
    public String toString() {
        return "Dime: " + this.getValue() + " " + this.getYear();
    }

}