package Discussion661B;

import Discussion661B.Stack;

/**
 * Created by davidwang on 3/19/15.
 */
public class StackQueue {
    private Stack toQueue;


    public StackQueue(int s) {
        toQueue = new Stack(s);
    }

    public void push(int entry){

        Stack newStack =  new Stack(toQueue.maxSize + 1);
        while(!toQueue.isEmpty()){
            newStack.push(toQueue.pop());
        }
        toQueue.push(entry);
        while(!newStack.isEmpty()){
            toQueue.push(newStack.pop());
        }
    }

    public int dequeue() {

        return toQueue.pop();
    }

    public boolean isEmpty() {
        return (toQueue.top == -1);
    }

    public static void main(String[] args) {
        StackQueue trial = new StackQueue(5);
        trial.push(10);
        trial.push(20);
        trial.push(30);
        trial.push(40);
        trial.push(50);
        while (!trial.isEmpty()) {
            int value = trial.dequeue();
            System.out.print(value);
            System.out.print(" ");
        }
        System.out.println("");
    }
}
