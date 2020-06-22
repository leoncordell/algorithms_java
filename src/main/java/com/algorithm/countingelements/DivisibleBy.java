package com.algorithm.countingelements;

public class DivisibleBy {

    public static void main(String[] args) {




//        System.out.println("Expected - 3 : "  + solution(0,2,1));
//        System.out.println("Expected - 2 : "  + solution(1,2,1));
//
//        System.out.println("Expected - 3 : "  + solution(6,11,2));
//
//        System.out.println("Expected - 1 : "  + solution(6,6,2));
//
//        System.out.println("Expected - 0 : "  + solution(6,6,7));
//
//        System.out.println("Expected - 0 : "  + solution(6,8,5));  //if  K > B/2
//
//        System.out.println("Expected - 1 : "  + solution(0,0,5));  // 0/5 + 0/5 + 1



        System.out.println("Expected - 2 : "  + solution(0,4,4));  //  4/4 + 0/4 + 1 = 2



    }

    static int solution(int A, int B, int K)
    {
        int inclusive = ((A%K)==0) ? 1 : 0;
        return (B/K) - (A/K) + inclusive;
    }


}
