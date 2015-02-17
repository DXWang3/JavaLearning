/**
 * Created by davidwang on 2/4/15.
 */
public class Fibonacci {


    final static String introduction = "Fibonacci Sequence terms less than 50";
    /** Print out the Fibonacci sequence for values < 50 */



    public static void main(String[] args){

        compute();

    }

    public static int[] compute() {

        int lo = 1;
        int hi = 1;
        int[] result = new int[9];

        for (int i = 0; i < 9; i++) {
            result[i] = lo;
            hi = lo + hi;       // new hi
            lo = hi - lo;       /* new lo is (sum - old lo)

                                 that is, the old hi */
        }

        System.out.println(introduction);
        for (int i = 0; i < 9; i++) {

            System.out.println(result[i]);
        }

        return result;
    }








}
