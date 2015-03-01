package Discussion261B;

/**
 * Created by davidwang on 2/25/15. Needed for Discussion2 problems.
 */

public class IntList {
    public int head;
    public IntList tail;

    public IntList(int h, IntList t) {
        head = h;
        tail = t;
    }

    /** Returns the size of the IntList */
    public int size() {
        if (this.tail == null)
            return 1;
        int personInFrontOfMeSize = this.tail.size();
        return personInFrontOfMeSize + 1;
    }

    /** Iterative methods are often uglier. */
    public int iterativeSize() {
        IntList p = this;
        int size = 0;
        while (p != null) {
            size = size + 1;
            p = p.tail;
        }
        return size;
    }

    /** Size */
    public int get(int i) {
        if (i == 0) {
            return this.head;
        }
        return this.tail.get(i - 1);
    }

    public String toString() {
        if (tail == null)
            return Integer.toString(head);
        return Integer.toString(head) + " " + tail.toString();
    }

    public static void SquareDestructive(IntList L){

        while(L.tail != null){

            L.head = L.head * L.head;
            L = L.tail;


        }



    }

    public static IntList SquareNonDestructive(IntList L){

         if(L == null){

             return null;
         }

         IntList copy2 = new IntList(L.head * L.head, null);

         L = L.tail;
         while (L != null){

             IntList add = new IntList(L.head * L.head, null);
             copy2.tail = add;
             copy2 = copy2.tail;
             L = L.tail;
         }

         return copy2;
    }

    public static IntList reverseNondestructive(IntList L){

         IntList copy = null;

         while (L != null) {
             copy = new IntList(L.head, copy);
             L = L.tail;
         }

         return copy;

    }

    public static IntList reverseDestructive(IntList L){

        if(L == null || L.tail == null) { //base case
            return L;
        }



        IntList copy = reverseDestructive(L); //recursive call
        L.tail.tail = L;
        L.tail = null;

        return L;



    }



    public static void main(String[] args) {
        IntList L = new IntList(10, null);
        L.tail = new IntList(15, null);

        System.out.println(L.head);
        System.out.println(L.tail.head);
        System.out.println(L.size());
        System.out.println(L.iterativeSize());
        System.out.println(L.get(1));


    }
}
