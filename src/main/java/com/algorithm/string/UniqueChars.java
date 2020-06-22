package com.algorithm.string;



public class UniqueChars {

    public static void main(String[] args) {
        String a = "acdgf";
        int val = a.charAt(0) - 'a';
        //1 << val



        // System.out.println(isUniqueChars2(a));
    }

    public static boolean isUniqueChars2(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); ++i) {
            int val = str.charAt(i) - 'a';
            System.out.println(val);

            String  binVals =String.format("%016d", Integer.parseInt(Integer.toBinaryString(checker)));

            System.out.println(binVals);

            if ((checker & (1 << val)) > 0)      //  if  curr  char and  checker then  false
                return false;
            checker |= (1 << val);   //  setting  the  curr char
        }
        return true;
    }

    public static boolean isUniqueChars(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); ++i) {
            int val = str.charAt(i) - 'a';
            System.out.println(val);

            String  binVals =String.format("%016d", Integer.parseInt(Integer.toBinaryString(checker)));

            System.out.println(binVals);

            if ((checker & (1 << val)) > 0)      //  if  curr  char and  checker then  false
                return false;
            checker |= (1 << val);   //  setting  the  curr char
        }
        return true;
    }
}
