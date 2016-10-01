/**
 * Abstract Coin class.
 *
 * @author James Bottoms
 * @version 1.0
 */
public abstract class Coin implements Comparable<Coin> {
    private int value;
    private int year;

    /**
     * Creates a new Coin with value and a year
     * @param  aValue Value in cents of the coin
     * @param  aYear  Year that the coin was created
     */
    public Coin(int aValue, int aYear) {
        this.value = aValue;
        this.year = aYear;
    }

    /**
     * Gets the value of the instance of the coin
     * @return the value of the coin
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Gets the year that the coin was created
     * @return the year that the coin was created
     */
    public int getYear() {
        return this.year;
    }

    @Override
    public String toString() {
        return ("Coin: " + this.value + " " + this.year);
    }

    @Override
    public int compareTo(Coin other) {
        if (this.value == other.getValue()) {
            return (this.year - other.getYear());
        } else {
            return (this.value - other.getValue());
        }
    }

    @Override
    public boolean equals(Object other) {
        if (null == other) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof Coin)) {
            return false;
        }
        Coin that = (Coin) other;
        return this.value == that.getValue() && (this.year == that.getYear());
    }




    // This method should not be modified
    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + year;
        hash = 31 * hash + value;
        return hash;
    }

}
