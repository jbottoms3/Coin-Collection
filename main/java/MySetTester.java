import java.util.Arrays;
import java.util.List;

/**
 * Tester to test MySet
 * @author James Bottoms
 */
public class MySetTester {

    /**
     * Main method to test all methods in MySet
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        /*
         * Test MySet
         */
        MySet<String> set = new MySet<>();

        System.out.println("\nTesting add and contains:");

        // test add and contains
        set.add("That");
        set.add("aint");
        set.add("Falco!");
        set.add("Falco!");
        set.add("That");
        System.out.printf("Your set has %d elements, and \"Falco!\" %s"
                        + " in the set.  PASS? %b\n",
                set.size(),
                set.contains("Falco!") ? "is" : "is not",
                set.size() == 3 && set.contains("Falco!"));

        // test remove
        System.out.println("\nTesting remove:");
        set.remove("Falco!");
        System.out.printf("Your set has %d elements, and \"Falco!\" %s"
                        + " in the set.  PASS? %b\n",
                set.size(),
                set.contains("Falco!") ? "is" : "is not",
                set.size() == 2 && !set.contains("Falco!"));

        // test addAll
        System.out.println("\nTesting addAll:");
        set.addAll(Arrays.asList("Happy", "Feet"));
        System.out.printf("Your set has %d elements, and \"Feet\" %s"
                        + " in the set.  PASS? %b\n",
                set.size(),
                set.contains("Feet") ? "is" : "is not",
                set.size() == 4 && set.contains("Feet"));

        // test removeAll
        System.out.println("\nTesting removeAll:");
        set.removeAll(Arrays.asList("Happy", "That"));
        System.out.printf("Your set has %d elements, and \"That\" %s"
                        + " in the set.  PASS? %b\n",
                set.size(),
                set.contains("That") ? "is" : "is not",
                set.size() == 2 && !set.contains("That"));

        // test containsAll
        System.out.println("\nTesting containsAll:");
        List<String> a = Arrays.asList("aint", "Feet");
        System.out.printf("Your set has %d elements, and "
                        + "\"aint\" and \"Feet\" %s"
                        + " in the set.  PASS? %b\n",
                set.size(),
                set.containsAll(a) ? "are both" : "are not both",
                set.size() == 2 && set.containsAll(a));

        // test retainAll
        System.out.println("\nTesting retainAll:");
        set.addAll(Arrays.asList("a", "b"));
        set.retainAll(Arrays.asList("Feet"));
        System.out.printf("Your set has %d elements, and "
                        + "\"Feet\" %s"
                        + " in the set.  PASS? %b\n",
                set.size(),
                set.contains("Feet") ? "is" : "is not",
                set.size() == 1 && set.contains("Feet"));

        // test clear and isEmpty
        System.out.println("\nTesting clear:");
        set.clear();
        System.out.printf("Your set has %d elements. "
                        + "  PASS? %b\n",
                set.size(),
                set.isEmpty());

        // test toArray
        System.out.println("\nTesting toArray:");
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("a");
        System.out.printf("The toArray method called on the set returns the "
                            + " array: \n" + Arrays.toString(set.toArray())
                            + "\nPASS? %b\n",
                            Arrays.equals(set.toArray(),
                                new String[]{"a", "b", "c"}));

        // test equals
        System.out.println("\nTesting equals:");
        MySet<String> equalSet = new MySet<>();
        equalSet.addAll(Arrays.asList("a", "b", "c"));
        MySet<String> unequalSet = new MySet<>();
        unequalSet.addAll(Arrays.asList("a", "b", "z"));
        System.out.printf("set.equals(equalSet) returns: %b\n"
                            + "set.equals(unequalSet) returns: %b\n"
                            + "PASS?   %b",
                            set.equals(equalSet),
                            set.equals(unequalSet),
                            set.equals(equalSet) && !(set.equals(unequalSet)));

    }
}
