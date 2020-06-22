package com.algorithm.caterpillar;

public class AbsDistinct {

    public static void main(String[] args) {

        int[] A = {5,-3,1,0,3,6};
        System.out.println(solution(A));


        int[] B = {5,5};
        System.out.println(solution(B));
    }


    static int solution(int[] A){
        if(A.length < 2){
            return A.length;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max,Math.abs(A[i]));
        }
        boolean[] vals = new boolean[max +1];
        int modV = 0;
        for (int i = 0; i < A.length; i++) {
            modV = Math.abs(A[i]);
            vals[modV]=true;
        }
        int count =0;
        for (int i = 0; i < vals.length; i++) {
            if(vals[i]){
                count++;
            }
        }
        return count;
    }

}
