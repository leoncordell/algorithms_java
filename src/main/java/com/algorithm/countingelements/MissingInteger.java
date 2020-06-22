package com.algorithm.countingelements;

public class MissingInteger {
    public static void main(String[] args) {

        int[] B3 = {-2,-3,-4,1,2,3,4,6,7,8};
        System.out.println("Expected - 5  - " + solution(B3));

        int[] B2 = {-2,-3,-4,1,2,3,4,5,6,7,8};
        System.out.println("Expected - 9 - " + solution(B2));

        int[] B = {-2,-3,-4};
        System.out.println("Expected - 1 - " + solution(B));

        int[] A = {2,3,4};
        System.out.println("Expected - 1 - " + solution(A));

        int[] A2 = {2,3,4,1,5,6};
        System.out.println("Expected - 7 - " + solution(A2));

        int[] A3 = {2,3,4,1,5,6,-7,-4};
        System.out.println("Expected - 7 - " + solution(A3));


    }


    static  public int solution(int[] A) {
        // write your code in Java SE 8
        // -1,-2,-4   return  1;
        if(A.length==1){
            if(A[0] != 1){
                return 1;
            }else{
                return 2;
            }
        }
        int max=0;
        for(int i=0;i<A.length;i++){
            max = Math.max(max,A[i]);
        }
        if(max <1){
            return  1;
        }
        int[] cache = new int[max +1];

        for(int j=0;j<A.length;j++){
            if(A[j] > 0) {
                cache[A[j]] = 1;
            }
        }
        //  cache  -   0,1,2,3  return cache.length
        for(int k=1; k < cache.length ;k++){
            if(cache[k] != 1)
                return k;
        }
        return cache.length ;
    }
}
