import java.util.Comparator;

/**
 * YearComparator class acts as a Comparator to compare the years of coins.
 * It is to be used to help sort the coins in ascending order by year.
 *
 * @author James Bottoms
 * @version 1.0
 */
public class YearComparator implements Comparator<Object> {

    @Override
    public int compare(Object obj1, Object obj2) {
        Coin coin1 = (Coin) obj1;
        Coin coin2 = (Coin) obj2;

        if (!((coin1 instanceof Quarter) && (coin2 instanceof Quarter))) {
            if (coin1.getYear() != coin2.getYear()) {
                return coin1.getYear() - coin2.getYear();
            } else {
                return coin1.getValue() - coin2.getValue();
            }
        } else {
            Quarter q1 = (Quarter) coin1;
            Quarter q2 = (Quarter) coin2;
            if (q1.getYear() != q2.getYear()) {
                return q1.getYear() - q2.getYear();
            } else if (q1.getValue() != q2.getValue()) {
                return q1.getValue() - q1.getValue();
            } else {
                return q1.compareTo(q2);
            }

        }
    }
}