/**
 * Created by davidwang on 2/10/15.
 *
 *
 *  A class that provides a main function to read five lines of a commercial
 *   Web page and print them in reverse order, given the name of a company.
 */

import java.net.*;
import java.io.*;


public class OpenCommercial {



    /** Prompts the user for the name X of a company (a single string), opens
     *  the Web site corresponding to www.X.com, and prints the first five lines
     *  of the Web page in reverse order.
     *  @param arg is not used.
     *  @exception Exception thrown if there are any problems parsing the
     *             user's input or opening the connection.
     */
    public static void main(String[] arg) throws Exception {

        BufferedReader keyboard;
        String inputLine;

        keyboard = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Please enter the name of a company (without spaces): ");
        System.out.flush();        /* Make sure the line is printed immediately. */
        inputLine = keyboard.readLine();

        int i = 0;

        BufferedReader input = null;

        try{
          URL myURL = new URL("http://www." + inputLine + ".com/");
          input = new BufferedReader(new InputStreamReader(myURL.openStream()));

        } catch (Exception unknown){

            unknown.printStackTrace();
        }

        String[] lineRead = new String[5];



        //read 5 lines and save them in  a String array
        if(input != null) {
            while ((i < 5) && (lineRead[i] = input.readLine()) != null) {
                i++;
            }
        }

        i = i - 1;

        //print the 5 lines in verse oder
        for(; i >= 0; i--) {
            System.out.println(lineRead[i]);
        }


    }


}
