package hw5;
import java.util.AbstractList;

/**
 * Created by davidwang on 3/17/15.
 */
public class ArrayList61B<E> extends AbstractList<E> {
    private int capacity;
    private E[] list;
    private int size;


    /** Create a new ArrayList with initial size 0 and capacity 1  */

    public ArrayList61B() {
        size = 0;
        capacity = 1;
        list = (E[]) new Object[1];
    }

    /**
     * Create a new ArrayList with initial size 0
     *  and capacity of initialCapacity.
     **/
    public ArrayList61B(int initialCapacity) {
        if (initialCapacity < 1) {
            throw new IllegalArgumentException();
        }

        size = 0;
        this.capacity = initialCapacity;
        list = (E[]) new Object[initialCapacity];
    }

    /** Adds an item to the list  */
    @Override
    public boolean add(E item) {
        if (size < capacity) {
            list[size] = item;
        } else {
            E[] newlist = (E[]) new Object[capacity * 2];
            System.arraycopy(list, 0, newlist, 0, list.length);
            newlist[size] = item;
            this.list = newlist;
            this.capacity = this.capacity * 2;
        }
        size++;
        return true;
    }

    /** Returns the item at the position indicated by index. */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        return list[index];
    }

    /** Returns the size of the list. */
    @Override
    public int size() {
        return size;
    }


}
