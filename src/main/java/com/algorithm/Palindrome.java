package com.algorithm;

import org.w3c.dom.ls.LSOutput;

public class Palindrome {


    public static void main(String[] args) {
        String  input  = "abcabceff" ;// 1 s , 2 o, 2 m , 2 r , 2 w , 2e




      System.out.println(input + " is Palindrome : " + isSortedPalindrome(input));
    }

    private static Boolean isSortedPalindrome(String input) {

        int control =0;

        //System.out.println(" bits -" +   String.format("%026d",Integer.parseInt(Integer.toBinaryString(control))) );
        String  binVals =String.format("%032d", Integer.parseInt(Integer.toBinaryString(control)));
        for(int i=0 ; i<input.length() ;i++){
            int val  = input.charAt(i) - 'a';


            if((control & (1<<val)) > 0 ){
                control = control ^ (1<<val) ;    //  SET  BIT   TO  ZERO
            }else{
                control = control  | (1 << val);
                //control |= (1 << val);
            }

            binVals =String.format("%032d", Integer.parseInt(Integer.toBinaryString(control)));
            System.out.println("val -" + val + " ;     bits -" +   binVals );

        }

        boolean oddValue =false;
        for (int i = 0; i < 32 ; i++) {
            if( binVals.charAt(i) !='0'){
                if(oddValue==true)
                    return  false;
                oddValue =true;
            }

        }
        return  true;
    }


}


//    String  binVals =String.format("%016d", Integer.parseInt(Integer.toBinaryString(checker)));
//
//            System.out.println(binVals);
//
//                    if ((checker & (1 << val)) > 0)      //  if  curr  char and  checker then  false
//                    return false;
//                    checker |= (1 << val);   //  setting  the  curr char
//                    }
//                    return true;
//                    }
//
//public static boolean isUniqueChars(String str) {
//        int checker = 0;
//        for (int i = 0; i < str.length(); ++i) {
//        int val = str.charAt(i) - 'a';
//        System.out.println(val);
//
//        String  binVals =String.format("%016d", Integer.parseInt(Integer.toBinaryString(checker)));
//
//        System.out.println(binVals);
//
//        if ((checker & (1 << val)) > 0)      //  if  curr  char and  checker then  false
//        return false;
//        checker |= (1 << val);   //  setting  the  curr char
//        }
//        return true;
//        }