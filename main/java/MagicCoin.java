import java.util.Random;

/**
 * MagicCoin Class represents a MagicCoin which has a value between
 * 26 and 100 cents (inclusive), along with a year that it was created.
 *
 * @author James Bottoms
 * @version 1.0
 */
public class MagicCoin extends Coin {

    /**
     * Creates a MagicCoin created in the year specified, and assigns the coin
     * a random value from 26 to 100.
     * @param  aYear Year that the coin was created
     */
    public MagicCoin(int aYear) {
        this(26 + (new Random()).nextInt(75), aYear);
    }

    /**
     * Creates a MagicCoin created in the year specified, and the
     * value specified
     * @param  aValue Value of the coin
     * @param  aYear  Year that the coin was created
     */
    public MagicCoin(int aValue, int aYear) {
        super(aValue, aYear);
    }

    @Override
    public String toString() {
        return ("MagicCoin: " + this.getValue() + " " + this.getYear());
    }

}