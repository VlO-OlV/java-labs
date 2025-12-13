package lab6;

import java.util.*;

/**
 * A custom implementation of the {@link List} interface specifically for {@link Toy} objects.
 * <p>
 * This class provides a dynamic array-based list that grows automatically by 30% as elements are added.
 * It supports all standard list operations and is designed for managing collections of toys in a playroom context.
 * The initial capacity is 15, and it expands by approximately 30% when needed.
 * </p>
 *
 * @author Ivan Linichenko IP-31
 * @version 1.0
 * @since 2025-12-13
 */
public class ToysList implements List<Toy> {
    /** The underlying array storage for toys */
    private Toy[] toysArray;

    /** The current number of elements in the list */
    private int size = 0;

    /**
     * Constructs an empty list with an initial capacity of 15.
     */
    public ToysList() {
        toysArray = new Toy[15];
    }

    /**
     * Constructs a list containing a single toy.
     *
     * @param toy the initial toy to add
     */
    public ToysList(Toy toy) {
        this();
        add(toy);
    }

    /**
     * Constructs a list containing the elements of the specified collection.
     *
     * @param toys the collection whose elements are to be placed into this list
     */
    public ToysList(Collection<? extends Toy> toys) {
        this();
        addAll(toys);
    }

    /**
     * Increases the capacity of the internal array if necessary.
     * <p>
     * The new capacity is the old capacity plus 30%, or at least one more if that would not increase it.
     * </p>
     */
    private void grow() {
        int newCapacity = toysArray.length + (int) (toysArray.length * 0.3);
        if (newCapacity == toysArray.length) newCapacity++;
        Toy[] newArray = new Toy[newCapacity];
        System.arraycopy(toysArray, 0, newArray, 0, size);
        toysArray = newArray;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements
     */
    @Override
    public int size() {
        return toysArray.length;
    }

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns {@code true} if this list contains the specified element.
     *
     * @param o element whose presence is to be tested
     * @return {@code true} if this list contains the specified element
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator
     */
    @Override
    public Iterator<Toy> iterator() {
        return new Iterator<Toy>() {
            private int current = 0;

            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public Toy next() {
                if (!hasNext()) throw new NoSuchElementException();
                return toysArray[current++];
            }
        };
    }

    /**
     * Returns an array containing all of the elements in this list in proper sequence.
     *
     * @return an array containing the elements
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(toysArray, size);
    }

    /**
     * Returns an array containing all of the elements in this list in proper sequence;
     * the runtime type of the returned array is that of the specified array.
     *
     * @param <T> type of array to return
     * @param array the array into which the elements are to be stored, if it is big enough
     * @return an array containing the elements
     */
    @Override
    public <T> T[] toArray(T[] array) {
        if (array.length < size)
            return (T[]) Arrays.copyOf(toysArray, size, array.getClass());
        System.arraycopy(toysArray, 0, array, 0, size);
        if (array.length > size)
            array[size] = null;
        return array;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param toy element to be appended
     * @return {@code true} (as specified by {@link Collection#add})
     */
    @Override
    public boolean add(Toy toy) {
        if (size == toysArray.length) grow();
        toysArray[size++] = toy;
        return true;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     *
     * @param o element to be removed
     * @return {@code true} if this list contained the specified element
     */
    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    /**
     * Returns {@code true} if this list contains all of the elements of the specified collection.
     *
     * @param c collection to be checked for containment
     * @return {@code true} if this list contains all of the elements
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c)
            if (!contains(e))
                return false;
        return true;
    }

    /**
     * Appends all of the elements in the specified collection to the end of this list.
     *
     * @param c collection containing elements to be added
     * @return {@code true} if this list changed as a result of the call
     */
    @Override
    public boolean addAll(Collection<? extends Toy> c) {
        boolean modified = false;
        for (Toy e : c)
            if (add(e))
                modified = true;
        return modified;
    }

    /**
     * Inserts all of the elements in the specified collection into this list at the specified position.
     *
     * @param index index at which to insert the first element
     * @param c collection containing elements to be added
     * @return {@code true} if this list changed as a result of the call
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public boolean addAll(int index, Collection<? extends Toy> c) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        int numNew = c.size();
        if (size + numNew > toysArray.length) {
            int newCapacity = toysArray.length;
            while (newCapacity < size + numNew)
                newCapacity += (int) (newCapacity * 0.3);
            Toy[] newArray = new Toy[newCapacity];
            System.arraycopy(toysArray, 0, newArray, 0, size);
            toysArray = newArray;
        }
        System.arraycopy(toysArray, index, toysArray, index + numNew, size - index);
        int i = index;
        for (Toy e : c)
            toysArray[i++] = e;
        size += numNew;
        return numNew != 0;
    }

    /**
     * Removes from this list all of its elements that are contained in the specified collection.
     *
     * @param c collection containing elements to be removed
     * @return {@code true} if this list changed as a result of the call
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object e : c)
            while (remove(e))
                modified = true;
        return modified;
    }

    /**
     * Retains only the elements in this list that are contained in the specified collection.
     *
     * @param c collection containing elements to be retained
     * @return {@code true} if this list changed as a result of the call
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (int i = 0; i < size; i++) {
            if (!c.contains(toysArray[i])) {
                remove(i--);
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Removes all of the elements from this list.
     */
    @Override
    public void clear() {
        Arrays.fill(toysArray, 0, size, null);
        size = 0;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public Toy get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return toysArray[index];
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public Toy set(int index, Toy element) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Toy old = toysArray[index];
        toysArray[index] = element;
        return old;
    }

    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void add(int index, Toy element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (size == toysArray.length) grow();
        System.arraycopy(toysArray, index, toysArray, index + 1, size - index);
        toysArray[index] = element;
        size++;
    }

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public Toy remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Toy old = toysArray[index];
        System.arraycopy(toysArray, index + 1, toysArray, index, size - index - 1);
        toysArray[--size] = null;
        return old;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param o element to search for
     * @return the index of the first occurrence or -1
     */
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++)
            if (Objects.equals(o, toysArray[i]))
                return i;
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param o element to search for
     * @return the index of the last occurrence or -1
     */
    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--)
            if (Objects.equals(o, toysArray[i]))
                return i;
        return -1;
    }

    /**
     * Returns a list iterator over the elements in this list (in proper sequence).
     *
     * @return a list iterator
     */
    @Override
    public ListIterator<Toy> listIterator() {
        return listIterator(0);
    }

    /**
     * Returns a list iterator over the elements in this list (in proper sequence),
     * starting at the specified position in the list.
     *
     * @param index index of the first element to be returned from the list iterator
     * @return a list iterator starting at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public ListIterator<Toy> listIterator(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        return new ListIterator<Toy>() {
            private int current = index;
            private int lastRet = -1;

            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public Toy next() {
                if (!hasNext()) throw new NoSuchElementException();
                lastRet = current;
                return toysArray[current++];
            }

            @Override
            public boolean hasPrevious() {
                return current > 0;
            }

            @Override
            public Toy previous() {
                if (!hasPrevious()) throw new NoSuchElementException();
                lastRet = --current;
                return toysArray[current];
            }

            @Override
            public int nextIndex() {
                return current;
            }

            @Override
            public int previousIndex() {
                return current - 1;
            }

            @Override
            public void remove() {
                if (lastRet < 0) throw new IllegalStateException();
                ToysList.this.remove(lastRet);
                if (lastRet < current) current--;
                lastRet = -1;
            }

            @Override
            public void set(Toy e) {
                if (lastRet < 0) throw new IllegalStateException();
                ToysList.this.set(lastRet, e);
            }

            @Override
            public void add(Toy e) {
                ToysList.this.add(current++, e);
                lastRet = -1;
            }
        };
    }

    /**
     * Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
     *
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex high endpoint (exclusive) of the subList
     * @return a view of the specified range within this list
     * @throws IndexOutOfBoundsException for an illegal endpoint index value
     */
    @Override
    public List<Toy> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) throw new IndexOutOfBoundsException();
        List<Toy> sub = new ToysList();
        for (int i = fromIndex; i < toIndex; i++)
            sub.add(toysArray[i]);
        return sub;
    }
}