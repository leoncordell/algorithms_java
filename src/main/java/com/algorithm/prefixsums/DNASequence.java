package com.algorithm.prefixsums;

import java.util.Arrays;

public class DNASequence {

    public static void main(String[] args) {

        String S = "CAGCCTA";
        int[] P = {2,5,0};
        int[] Q = {4,5,6};
        System.out.println(Arrays.toString(solution(S,P,Q)));

        String S2 = "T";
        int[] P2 = {0};
        int[] Q2 = {0};
        System.out.println(Arrays.toString(solution(S2,P2,Q2)));

        String S3 = "C";
        int[] P3= {0};
        int[] Q3 = {0};
        System.out.println(Arrays.toString(solution(S3,P3,Q3)));


    }


    static public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        // A 1   C 2  G 3  T 4
        int[] result = new int[P.length];
        //Each pair
       int[][] dnaSeq2 = new int[3][S.length() +1 ];   // col 0 will start  as  0
        for (int i = 0; i < S.length() ; i++) {
            int a=0,b=0,c =0;
            switch(S.charAt(i)){
                case 'A' : {
                    a++;
                    break;
                }
                case 'C' : {
                    b++;
                    break;
                }
                case 'G' : {
                    c++;
                    break;
                }
                case 'T' : {
                    break;
                }
            }

            dnaSeq2[0][i+1] = dnaSeq2[0][i] + a;
                dnaSeq2[1][i+1] = dnaSeq2[1][i] +  b;
                dnaSeq2[2][i+1] = dnaSeq2[2][i]  + c;

        }


        for (int i = 0; i < P.length; i++) {
            int  from = P[i] ;
            int  to = Q[i] ;
            if(dnaSeq2[0][to +1] - dnaSeq2[0][from] > 0){
                result[i] = 1;
            }else if(dnaSeq2[1][to + 1] - dnaSeq2[1][from] > 0){
                result[i] = 2;
            }else if(dnaSeq2[2][to + 1] - dnaSeq2[2][from] > 0){
                result[i] = 3;
            }else{
                result[i] =4 ;
            }
        }
        return  result;
    }

}
