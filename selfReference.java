/**
 * Created by davidwang on 2/7/15.
 */
public class selfReference {

    public static void main(String[] args){

       String[] reference = {

"public class selfReference {",

"    public static void main(String[] args)",

"       String[] reference = {",

"         for(int i = 0; i < 3; i++){System.out.println(reference[i]);}",

"         for(int i = 0; i < 3; i++){System.out.println((char)34 + reference[i] + (char)34 + (char)44);}",

"         for(int i = 3; i < 13; i++){System.out.println((char)34 + reference[i] + (char)34) + (char)44);}",

"         System.out.println(reference[10]);",

"         for(int i = 3; i < 10; i++){System.out.println(reference[i]);}",

"         System.out.println(reference[11]);",

"         System.out.println(reference[12]);",

"       };",

"   }",

"}",



      };

         for(int i = 0; i < 3; i++){System.out.println(reference[i]);}
         for(int i = 0; i < 3; i++){System.out.println((char)34 + reference[i] + (char)34 + (char)44);}
         for(int i = 3; i < 13; i++){System.out.println((char)34 + reference[i] + (char)34 + (char)44);}
         System.out.println(reference[10]);
         for(int i = 3; i < 10; i++){System.out.println(reference[i]);}
         System.out.println(reference[11]);
         System.out.println(reference[12]);





    }


}
