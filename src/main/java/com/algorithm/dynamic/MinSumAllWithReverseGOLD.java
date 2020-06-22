package com.algorithm.dynamic;


import java.util.Arrays;

public class MinSumAllWithReverseGOLD {
    public static void main(String[] args) {


        int[] A = {2,3,6,2,3};    //  gives sum of 25 (S=25) ;  1,3,6,10,17,25 ;  at 10v 15  ie 5    or 1-2+4-3 +7-8 ie 1
        // or   1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,25
        //dpj   1,1,1,1,1,1,1,1,1,1,1  ,1 , 1, 1,1,1,1,1,1,1,1,1,1,1,1
        // result  where  j <= Size/2  ie 25/2 ie 12 and 1 is solution

        // S= 31 ;
        //


        System.out.println(solution(A));

    }


    static int solution(int[] A) {
        if(A==null || A.length ==0){
            return 0;
        }
        if(A.length==1){
            return  A.length;
        }
        int maxValue =Integer.MIN_VALUE;
        int sum_S = 0;

        for (int i = 0; i <A.length ; i++) {
            A[i] = Math.abs(A[i]);
            maxValue = Math.max(maxValue,A[i]);
            sum_S +=A[i];
        }
        int S = sum_S;  //Size of interm values
        int[] dp = new int[S+1];
        Arrays.setAll(dp,a->0);
        dp[0]=1;

        int  [] counters = new int[S+1];

        Arrays.setAll(dp, a->-1);

        for (int i = 0; i < A.length; i++) {
            counters[A[i]] ++;
        }
        dp[0] =0;  // Value  from  array =k .
        for (int a = 0; a < maxValue+ 1 ; a++) {
            if(counters[a] > 0){
                  for (int j=0; j<S; j++) {
                    if (dp[j] >= 0) {   //  value  j  achieved
                        dp[j] = counters[a];  // value j  with extra counters of a
                    } else if ((j >= a) && (dp[j-a] > 0)) {          // value not  yet  achieved
                        dp[j] = dp[j-a]-1;
                    }
                }
                System.out.println(Arrays.toString(dp));
            }

        }
        System.out.println(Arrays.toString(dp));
        int result =0;
        for (int i = 0; i <= S/2 ; i++) {
            if(dp[i]>=0) {
                result = Math.max(result, i);
            }
        }

        return S- (result *2 );
    }

}



//Better
//or
//counts[1] =1 ,counts[2] =1 , counts[3] =1 , counts[7] = 1, counts[8] =1 ,counts[4] =1

//count[1] a=1 , dp[0] =1 ; dp[1] =1 dp[2] = 0 dp[3] = ...-1
//count[2] =2  a=2  ;  dp[0] = 2 ;  dp[1] = 2 ; dp[2]  =2  ;  dp[3] =1;

//j>a && dp[1] >0 then  dp[2] = 0
//
//        for (int a=1; a<M+1; a++) {
//            if (counts[a] > 0) {
//                for (int j=0; j<S; j++) {
//                    if (dp[j] >= 0) {
//                        dp[j] = counts[a];
//                    } else if ((j >= a) && (dp[j-a] > 0)) {
//                        dp[j] = dp[j-a]-1;
//                    }
//                }
//            }
//        }