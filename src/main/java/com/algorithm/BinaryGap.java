package com.algorithm;

public class BinaryGap {

    public static void main(String[] args) {

        int N = 134;
        System.out.println(solution(N));
    }

    static public int solution(int N) {
        // write your code in Java SE 8

        if(N==1){
            return 0;
        }


        String s = Integer.toBinaryString(N);

       // System.out.println(s);
        int counter =0;
        int maxCount= 0;

        int index = s.length() -1;

        final char c = s.charAt(index);

        if(s.charAt(index ) == '0') {
            while (s.charAt(index - 1) == '0') {
                index--;
            }
            s= s.substring(0,index );

        }

        // 1s  at both ends

        boolean counterSet =false;
        for(int i =0; i< s.length();i++){
            if( s.charAt(i) == '1' ){
                if(counterSet){
                    maxCount = Math.max(maxCount,counter);
                    counter=0;
                }else{
                    counterSet=true;
                    counter=0;
                }
            }else{
                if(counterSet){
                    counter++;
                }
            }

        }
        return maxCount;
    }


}
