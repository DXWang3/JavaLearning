package Lab161B;

/**
 * Created by davidwang on 2/25/15. Exercise 2
 */
public class ClassNameHere {

    public static int max(int[] m) {

        int highest = 0;

        for(int i = 0; i < m.length; i++){

            if(highest <= m[i]){   //if current highest number is less than next array term, the next array term is now highest.

                highest = m[i];
                i++;
            }



            else if(highest > m[i]){


               i++;
            }
        }


        return highest;


    }


    public static void main(String[] args) {


        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};

        System.out.println(max(numbers));


    }
}
