package hw4.synthesizer;

/**
 * Created by davidwang on 3/12/15.
 */


public class ArrayRingBuffer extends AbstractBoundedQueue {
    /* Index for the next dequeue or peek. */
    private int      first;
    /* Index for the next enqueue. */
    private int      last;
    /* Array for storing the buffer data. */
    private double[] rb;

    /** Create a new ArrayRingBuffer with the given capacity. */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue.
        this.capacity = capacity;
        first = 0;
        last = 0;
        rb = new double[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow")
     */
    public void enqueue(double x) {
        // is there room?
        if (this.isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        } else {
            rb[last] = x;
            last++;
            if (last == rb.length) last = 0;
            fillCount++;
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow");
     */


    public double dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update first.
        if (this.isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        } else {
            double rval = rb[first];
            fillCount--;
            first++;
            if (first == rb.length) first=0;
            return rval;
        }
    }

    /** Return oldest item, but don't remove it. */
    public double peek() {
        // TODO: Return the first item. None of your instance variables should change.
        if (capacity == 0) throw new RuntimeException("No items in buffer");
        return rb[first];
    }

}