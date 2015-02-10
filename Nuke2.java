import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * Created by davidwang on 2/10/15.
 */
public class Nuke2 {

    public static void main (String[] args){

        BufferedReader keyboard;
        String inputLine;

        keyboard = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Please enter a word or phrase ");
        System.out.flush();        /* Make sure the line is printed immediately. */

        inputLine = null;

        try{

            inputLine = keyboard.readLine();

        }
        catch (Exception unknown) {

            unknown.printStackTrace();

        }




        char[] result = inputLine.toCharArray();


        char[] answer = new char[result.length - 1];

        answer[0] = result[0];

        for (int i = 1; i < answer.length; i++){


            answer[i] = result[i+1];
        }

        for (int i = 0; i < answer.length; i++){


            System.out.print(answer[i]);
        }




    }



}
