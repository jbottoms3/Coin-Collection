/**
 * Penny class represents a Penny, which is a coin that is worth
 * 1 cent and has a year that it was created in.
 *
 * @author James Bottoms
 * @version 1.0
 */
public class Penny extends Coin {

    /**
     * Creates a new Penny created in the year specified and with a
     * calue of 1 cent
     * @param  aYear Year that the Penny was created
     */
    public Penny(int aYear) {
        super(1, aYear);
    }

    @Override
    public String toString() {
        return "Penny: " + this.getValue() + " " + this.getYear();
    }

}