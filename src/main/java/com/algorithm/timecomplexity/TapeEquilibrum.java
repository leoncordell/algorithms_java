package com.algorithm.timecomplexity;

public class TapeEquilibrum {


    public static void main(String[] args) {

        int[] A= {3,1,2,4,3};                      //
        System.out.println(solution(A));

        int[] A2= {-2,-3,-5,-7};
        System.out.println(solution(A2));

        int[] A3= {-2,-3,-5,0};
        System.out.println("Expect - 0 " + solution(A3));

        int[] A4= {17,25};
        System.out.println("Expect - 8 " + solution(A4));

        int[] A5= {27,115,25,-95};
        System.out.println("Expect - 18 " + solution(A5));

        int[] A6= {-5,25,-6,3};
        System.out.println("Expect - 11 " + solution(A6));

        int[] A7= {-10,10};
        System.out.println("Expect - 20 " + solution(A7));

        int[] A8= {1,2,3,4,5,6,7,8,2,3,4,5,6};  //sum 56 ,  sum  first 28
        System.out.println("Expect - 0 " + solution(A8));


    }

    static public int solution(int[] A) {
        // write your code in Java SE 8

        if(A.length==2){
            return Math.abs(A[1]-A[0]);
        }
        int sum=0;
        for(int i=0;i<A.length;i++){
            sum=sum + A[i];
        }
        // -2,-3,-5,-7   gives 3 ; ie -10,-7  or sum is -17 ; 2xRunner get as  close to sum  can  exceed sum
        // running total = rt--5 ;Sum -17; ;diff = 2x rt v 17 ie 7 ;  rt =-10; 2xRT = 20 v 17 = 3;

        int runningTotal=0;
        int result = Math.abs(sum);
        for(int j=0;  j<A.length;j++){
            runningTotal = runningTotal +A[j];
            result = Math.min(result, Math.abs(2*runningTotal - sum));
        }

        return result;




    }



}
