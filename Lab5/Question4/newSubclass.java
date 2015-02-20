package Lab5.Question4;

/**
 * Created by davidwang on 2/20/15.
 */
public class newSubclass extends newSuperclass {

    public void print() {
        System.out.println("in subclass");
    }
    public static void main(String[] argv) {
        newSuperclass sup = new newSubclass();
        ((newSubclass)sup).print();

    }
}
