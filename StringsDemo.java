/**
 * Created by davidwang on 2/6/15.
 */
public class StringsDemo {

    public static void main(String[] args){

        String myName = "Petronius";
        String myTitle = "CEO";

        myName = myName + " Arbiter";
        myTitle = myTitle + " ,Executive Director of Operations.";


        System.out.println("Name = " + myName + ", " + myTitle);

        if (!myName.equals(myTitle)){

            System.out.println("Correct Format");

        }
    }

}
