/**
 * Quarter class represents a Quarter, which is a coin that is worth
 * 25 cents, has a year that it was created in, and also has a state, with the
 * state's name associated with the Quarter.
 *
 * @author James Bottoms
 * @version 1.0
 */
public class Quarter extends Coin {
    private State state;

    /**
     * Creates a new Quarter created in the year specified and associated with
     * the state specified
     * @param  aYear  Year that the quarter was created
     * @param  aState State that is on the back of the Quarter
     */
    public Quarter(int aYear, State aState) {
        super(25, aYear);
        this.state = aState;
    }


    @Override
    public String toString() {
        return ("Quarter: " + this.getValue() + " " + this.getYear() + " "
            + this.state);
    }

    @Override
    public int compareTo(Coin other) {
        if (other instanceof Quarter) {
            if (this.state.ordinal() == ((Quarter) other).state.ordinal()) {
                return (this.getYear() - other.getYear());
            } else {
                return ((-1) * (this.state.ordinal()
                    - ((Quarter) other).state.ordinal()));
            }
        } else {
            return super.compareTo(other);
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
        if (!(other instanceof Quarter)) {
            return false;
        }
        Quarter that = (Quarter) other;
        return ((this.getYear() == (that.getYear()))
            && (this.state.ordinal() == that.state.ordinal()));
    }

}
