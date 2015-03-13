package hw4.synthesizer;

/**
 * Created by davidwang on 3/12/15.
 */
public interface BoundedQueue {

    int capacity();
    int fillCount();
    boolean isEmpty();
    boolean isFull();
    void enqueue(double x);
    double dequeue();
    double peek();
}
