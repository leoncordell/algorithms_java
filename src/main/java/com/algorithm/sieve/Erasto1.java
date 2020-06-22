package com.algorithm.sieve;

public class Erasto1 {

    public static void main(String[] args) {

        int[] A = {3,1,2,3,6}; //  Number  of  non-divisers   -  3 everything  except 3,1   ie 2,6
                                        //  1 ,  everything other than 1
                                        // 2,

    }

    static int[] solution(int [] A){


        int max=0;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max,A[i]);
        }

        int[] count = new int[max + 1];

        for (int i = 0; i < A.length; i++) {
           count[A[i]] ++;
        }

        int[] nonDiv = new int[max +1];
        for (int i = 0; i < nonDiv.length; i++) {
            nonDiv[i] = A.length - count[i];     //  just  contains  other elements
        }

        //sieve
        for (int i = 1 ; i < nonDiv.length; i++) {
            if (count[i] != 0) {//skip numbers which don't exists in table A

                //  {3,1,2,3,6}  count of  2 is  1  , go to   4 reduce 4's  non-div by  count 2 ,then increment s by 2
                int s = i*2;
                while (s<nonDiv.length) {
                    if (nonDiv[s] != 0) {
                        //Sieve. Most important part. Decrease number of non-divisible by the number of occurrences of number 'i'.
                        nonDiv[s] -= count[i];
                    }
                    s+=i;
                }
            }
        }

        int[] result = new int[A.length];
        for (int i = 1 ; i < nonDiv.length; i++) {
            if (nonDiv[i] != 0) {
                result[i-1] = nonDiv[i];
            }
        }
        return result;
    }


}
