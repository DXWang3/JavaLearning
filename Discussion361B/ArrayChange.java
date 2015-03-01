package Discussion361B;
import java.util.Arrays;
/**
 * Created by davidwang on 3/1/15.
 */
public class ArrayChange {



    public static int[] insert(int[] x, int val, int position){

        int[] result = new int[x.length+1];

        for(int i = 0; i < position; i++){

           result[i] = x[i];
        }

        result[position] = val;

        for(int i = position + 1; i < result.length; i++){

            result[i] = x[i-1];
        }

        return result;

    }

    public static int[] xify(int[] x){

        int lengthOfNew = 0;

        for(int i = 0; i < x.length; i++){ //create new Array with length of sum of all terms in x.
            lengthOfNew = lengthOfNew + x[i];
        }

        int[] result = new int[lengthOfNew];
        int track = 0; //keep track of current position on new array.

        for (int i = 0; i < x.length; i++){ //iterates through the terms of x
            for(int j = 0; j < x[i]; j++){ //repeats the term at x[i] up to x[i] times

                result[track] = x[i];
                track++;

            }

        }




        return result;

    }

    public static void main(String[] args){

        int[] data = {5, 9, 10, 14};

        int[] result = insert(data, 7, 2);

        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }

        int[] secondResult = xify(result);

        for(int i = 0; i < secondResult.length; i++){
            System.out.println(secondResult[i]);
        }

    }
}
