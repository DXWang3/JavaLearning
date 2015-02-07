/**
 * Created by davidwang on 2/4/15.
 */

public class ImprovedFibonacci {


    static final int MAX_INDEX = 9;

    /**
     * Print out the first few Fibonacci numbers,
     * marking evens with a '*'
     */
    public static FibNumber[] compute() {
        int lo = 1;
        int hi = 1;
        FibNumber[] list = new FibNumber[MAX_INDEX];


        for (int i = 0; i < MAX_INDEX; i++) {


            FibNumber first = new FibNumber (lo, false);


            if (lo % 2 == 0){
                first.even = true;
            }

            list[i] = first;


            hi = lo + hi;
            lo = hi - lo;
        }

        return list;
    }

    public static String[] storage(){

        String[] deposit = new String[MAX_INDEX];

        for(int i = 0; i < MAX_INDEX; i++){

            String entry = compute()[i].number + ":" + compute()[i].even;

            deposit[i] = entry;
        }
        return deposit;

    }

    public static void main(String[] args){

        for( int i = 0; i < storage().length; i++){

            System.out.println(storage()[i]);
        }


        for( int i = 0; i < compute().length; i++){

            System.out.printf("The %sth number is %s %n", i+1, compute()[i].number);
        }
    }




}
