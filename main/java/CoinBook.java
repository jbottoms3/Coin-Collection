import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
/**
 * A CoinBook in which all collected Coins are stored.
 *
 * @author James Bottoms
 */
public class CoinBook {
    private Set<Coin> coinBook;

    /**
     * Creates a new CoinBook and instantiates the set that works
     * in the background
     */
    public CoinBook() {
        coinBook = new MySet<Coin>();
    }

    /**
     * Adds the coin that is passed in into the CoinBook
     * @param  c The coin to be added to the CoinBook
     * @return   true if successfully added, false otherwise
     */
    public boolean addCoin(Coin c) {
        return coinBook.add(c);
    }

    /**
     * Removes the specified coin from the CoinBook
     * @param  c The coin to be removed from the CoinBook
     * @return   true if the coin is successfully removed, false otherwise
     */
    public boolean removeCoin(Coin c) {
        return coinBook.remove(c);
    }

    /**
     * Sorts the CoinBook in ascending order based on the value of the coins.
     * @return The list of Coins in the CoinBook sorted by value
     */
    public List<Coin> sortByValue() {
        List<Coin> coins = new ArrayList<>();
        for (Coin c: coinBook) {
            coins.add(c);
        }
        Collections.sort(coins);
        return coins;
    }

    /**
     * Sorts the CoinBook in ascending order based on the year that the coin
     * was created. If the years of two Coins are the same, then value is the
     * next compared attribute. If two Coins are quarters with the same year
     * and value, then they are ordered by their state.
     * @return The list of Coins in the CoinBook sorted by year
     */
    public List<Coin> sortByYear() {
        List<Coin> coins = new ArrayList<>();
        for (Coin c: coinBook) {
            coins.add(c);
        }
        Collections.sort(coins, new YearComparator());
        return coins;
    }

    @Override
    public String toString() {
        String cbString = "";
        for (Coin c: coinBook) {
            cbString += c.toString() + "\n";
        }
        return cbString;
    }

}
