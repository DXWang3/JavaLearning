package Discussion161B;

/**
 * Created by davidwang on 2/25/15.
 */
public class fib {


    public static int calculate(int n){


        if (n == 0){


            return 0;


        }

        else if (n == 1){


            return 1;

        }




        return calculate(n-1) + calculate(n-2);

    }


    

    public static void main(String[] args){

        System.out.println(calculate(3));
    }
}
