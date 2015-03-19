package Discussion661B;

import Discussion661B.Stack;

/**
 * Created by davidwang on 3/19/15.
 */
public class StackQueueRecur {
    private Stack toQueue;

    public StackQueueRecur(int s) {
        toQueue = new Stack(s);
    }

    public void enqueue(int entry){
        toQueue.push(entry);
    }

    public int dequeue(){
        return dequeueImplement(toQueue.pop());
    }

    private int dequeueImplement(int output){
        if(toQueue.isEmpty()){
            return output;
        }
        int cur = toQueue.pop();
        int temp = dequeueImplement(cur);
        enqueue(output);
        return temp;
    }

    public boolean isEmpty() {
        return (toQueue.top == -1);
    }

    public static void main(String[] args) {
        StackQueueRecur trial = new StackQueueRecur(5);
        trial.enqueue(10);
        trial.enqueue(20);
        trial.enqueue(30);
        trial.enqueue(40);
        trial.enqueue(50);
        while (!trial.isEmpty()) {
            int value = trial.dequeue();
            System.out.print(value);
            System.out.print(" ");
        }
        System.out.println("");
    }
}

