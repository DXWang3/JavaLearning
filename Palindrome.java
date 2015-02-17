/**
 * Created by davidwang on 2/7/15.
 */
public class Palindrome {


    public static void main(String[] args){

        Boolean testA = palindromic("level");
        Boolean testB = palindromic("hello");
        Boolean testC = palindromic("AbAbA");


        System.out.println(testB);
        System.out.println(testA);
        System.out.println(testC);



    }


    public static boolean palindromic(String a){

        Boolean pal = false;
        char[] testCase = a.toLowerCase().toCharArray();

        for(int i = 0; i < a.length(); i++){

            if(testCase[i] != testCase[a.length() - i - 1]){

                pal = false;
                break;

            }


            else{

                pal = true;

            }
        }

        return pal;
    }




}
