import java.util.Iterator;
import java.util.Set;
import java.util.Collection;

/**
 * @author James Bottoms
 * @param <T> The type of objects contained in this MySet
 */
@SuppressWarnings("unchecked")
public class MySet<T> implements Set<T> {

    // The following statements have been provided to you.
    // Do not modify these statements.
    private T[] backingArray;
    private int numElements;
    private static final int DEFAULT_INITIAL_CAPACITY = 2;

    /**
     * Creates a new MySet and instantiates the backingArray that works in the
     * background and starts the number of elements in the MySet as 0
     */
    public MySet() {
        backingArray = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
        numElements = 0;
    }

    /**
     * Helper function that resizes the backingArray by doubling its size
     * whenever more space is needed to add new elements to the MySet and
     * therefore the backingArray
     */
    private void resizeBackingArray() {
        T[] temp = (T[]) new Object[backingArray.length * 2];
        for (int i = 0; i < this.backingArray.length; i++) {
            temp[i] = this.backingArray[i];
        }
        this.backingArray = temp;
    }

    @Override
    public boolean add(T t) {
        boolean isFound = this.contains(t);
        if (isFound) {
            return false;
        } else {
            if (numElements >= backingArray.length - 1) {
                resizeBackingArray();
            }
            backingArray[numElements] = t;
            numElements++;
            return true;
        }
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        int size = c.size();
        int initialNumElements = numElements;
        while (this.backingArray.length < size) {
            resizeBackingArray();
        }
        for (T t: c) {
            this.add(t);
        }
        return (!(initialNumElements == numElements));
    }

    @Override
    public void clear() {
        for (int i = 0; i < numElements; i++) {
            this.remove(this.backingArray[i]);
            i--;
        }
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i <= numElements; i++) {
            if (o.equals(backingArray[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        int size = c.size();
        for (Object o: c) {
            if (!this.contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (null == o) {
            return false;
        }
        if (this == o) {
            return false;
        }
        if (!(o instanceof MySet)) {
            return false;
        }
        MySet that = (MySet) o;
        return (that.size() == this.size()) && (this.containsAll(that));
    }

    @Override
    public boolean isEmpty() {
        return (numElements == 0);
    }

    @Override
    public boolean remove(Object o) {
        if (this.contains(o)) {
            int index = 0;
            for (int i = 0; i < numElements; i++) {
                if (backingArray[i].equals(o)) {
                    index = i;
                }
            }
            for (int j = index; j < this.backingArray.length - 1; j++) {
                this.backingArray[j] = this.backingArray[j + 1];
            }
            this.backingArray[this.backingArray.length - 1] = null;
            numElements--;
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int initialNumElements = numElements;
        for (Object o: c) {
            this.remove(o);
        }
        return (!(initialNumElements == numElements));
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int initialNumElements = numElements;

        for (int i = 0; i < numElements; i++) {
            if (!c.contains(this.backingArray[i])) {
                this.remove(this.backingArray[i]);
                i--;
            }
        }
        return (!(initialNumElements == numElements));
    }

    @Override
    public int size() {
        return numElements;
    }

    @Override
    public Object[] toArray() {
        T[] temp = (T[]) new Object[numElements];
        for (int i = 0; i < numElements; i++) {
            temp[i] = this.backingArray[i];
        }
        return temp;
    }


    // The methods below have been provided to you. You should not modify them.

    /**
     * Returns an iterator over the elements in this set.
     * You will need to know Iterable/Iterator for your exams, so take a look at
     * this implementation and the Javadocs
     * @return an iterator instance
     */
    @Override
    public Iterator<T> iterator() {
        return new MySetIterator();
    }

    private class MySetIterator implements Iterator<T> {
        private int index = 0;

        public boolean hasNext() {
            return index < numElements;
        }
        public T next() {
            return backingArray[index++];
        }
        public void remove() {
            MySet.this.remove(backingArray[index - 1]);
            index--;
        }
    }

    /**
     * Returns a hash representation of the object, based on the hashCode of the
     * backing array
     * @return an integer hash of the set
     */
    public int hashCode() {
        return java.util.Arrays.hashCode(backingArray);
    }

    /**
     * Not implemented in this Set
     * @param a an array which specifies the runtime return type for toArray
     * @param <S> the return type of the array
     * @return null
     */
    @Override
    public <S> S[] toArray(S[] a) {
        return null;
    }


    /**
     * Returns the backing array directly.
     * This violates the set's encapsulation principle, but is necessary for
     * grading.
     * @return the backing array
     */
    public T[] getBackingArray() {
        return this.backingArray;
    }
}
