package Lab161B;

/**
 * Created by davidwang on 2/25/15.
 */
public class Triangle {


    /**
    Creates a string of n stars.
    **/
    public static String star(int n){

        String line = "*";

        for(int i = 0; i < n; i++){

            line = line + "*";
        }

        return line;
    }


    /**
         Exercise 1b
     */

    public static void drawTriangle(int n){



        int row = 1;

        while(row <= n){

            int column = 0;

            while(column < row){

                System.out.print("*");

                column++;
            }
            System.out.println("");
            row++;

        }


    }

    /**
     Prints five strings of progressively longer patterns of stars.
     **/

    public static void main(String[] args){


        for(int i = 0; i < 5; i++){

            System.out.println(star(i));
        }

        System.out.println("");

        drawTriangle(10);
    }
}

