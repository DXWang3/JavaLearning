package hw5;

import java.util.Set; /* java.util.Set needed only for challenge problem. */
import java.util.Iterator;

/** A data structure that uses a linked list to store pairs of keys and values.
 *  Any key must appear at most once in the dictionary, but values may appear multiple
 *  times. Supports get(key), put(key, value), and contains(key) methods. The value
 *  associated to a key is the value in the last call to put with that key. 
 *
 *  For simplicity, you may assume that nobody ever inserts a null key or value
 *  into your map.
 */
public class ULLMap<K, V> implements Map61B<K, V>, Iterable<K> {
    /**
     * Keys and values are stored in a linked list of Entry objects.
     * This variable stores the first pair in this linked list. You may
     * point this at a sentinel node, or use it as a the actual front item
     * of the linked list.
     */
    private Entry front;

    @Override
    public V get(K key) {
        return front.get(key);
    }

    @Override
    public void put(K key, V val) { //FIX ME
        front = new Entry(key, val, front);
    }

    @Override
    public boolean containsKey(K key) { //FIX ME
        Entry pointer = front;
        while (pointer != null) {
            if (pointer.key.equals(key)) {
                return true;
            }
            pointer = pointer.next;
        }
        return false;
    }

    @Override
    public int size() {
        return 0; // FIX ME (you can add extra instance variables if you want)
    }

    @Override
    public void clear() {
        front = null;
    }

    public Iterator<K> iterator() {
        return new ULLMapIter<K>(front);
    }

    public static <K, V> ULLMap<V, K> invert(ULLMap<K, V> map) {
        ULLMap<V, K> inverted = new ULLMap();
        for (K key : map) {
            V val = map.get(key);
            inverted.put(val, key);
        }
        return inverted;
    }

    /**
     * Represents one node in the linked list that stores the key-value pairs
     * in the dictionary.
     */
    private class Entry {

        /** Stores the key of the key-value pair of this node in the list. */
        private K     key; //FIX ME
        /** Stores the value of the key-value pair of this node in the list. */
        private V     val; //FIX ME
        /** Stores the next Entry in the linked list. */
        private Entry next;

        /**
         * Stores KEY as the key in this key-value pair, VAL as the value, and
         * NEXT as the next node in the linked list.
         */
        public Entry(K key, V value, Entry n) { //FIX ME
            this.key = key;
            val = value;
            next = n;
        }

        /**
         * Returns the Entry in this linked list of key-value pairs whose key
         * is equal to KEY, or null if no such Entry exists.
         */
        public V get(K key) { //FIX ME
            if (this.key.equals(key)) {
                return this.val;
            } else {
                if (this.next != null) {
                    return this.next.get(key);
                }
                return null;
            }
        }

        public V remove(K key) {
            if (this.key.equals(key)) {
                return this.val;
            }
            return null;
        }
    }

    private class ULLMapIter<K> implements Iterator<K> {
        Entry pointer;

        public ULLMapIter(Entry p) {
            this.pointer = p;
        }

        @Override
        public boolean hasNext() {
            return pointer != null;
        }

        @Override
        public K next() {
            K rval = (K) pointer.key;
            pointer = pointer.next;
            return rval;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* Methods below are all challenge problems. Will not be graded in any way.
     * Autograder will not test these. */
    @Override
    public V remove(K key) {
        return front.remove(key);
    }

    @Override
    public V remove(K key, V value) { //FIX ME SO I COMPILE
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<K> keySet() { //FIX ME SO I COMPILE
        throw new UnsupportedOperationException();
    }


}