package com.algorithm.exceptions;
// java  -cp . com.algorithm.exceptions.ExceptionsGenerally  "iSay" "Not this  time"
public class ExceptionsGenerally {

    public static void main(String[] args) {
        String input;
//        try{
//      //      input = args[0];
//        }catch(ArrayIndexOutOfBoundsException e){
//            System.out.println("More input strings  needed");
//            return;
//        }
      //  System.out.println("Input string :" + input);


        String symbol = "\u2202";


        System.out.println("what!"  + symbol);

        int c = 0x2202;

        String s = Character.toString((char)c);
       // String s = Character.toString((char)c);

        symbol = "\u0000";

        System.out.println("zero -"  + symbol);

        symbol = "\u0020";
        System.out.println("Space 0x20 32   -"  + symbol);
        symbol = "\u005A";
        System.out.println("Z 0x5A ie 90  -"  + symbol);

        symbol = "\u0041";
        System.out.println("A ox41 ie 65  -"  + symbol);



    }

}
