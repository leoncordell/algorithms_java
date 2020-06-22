package com.algorithm.prefixsums;

//  0 to A  divisible by K  e.g  0... 10 ,div by 2 gives  A/k + 1 , ie 5  + 1
//  0 to B  divisibly by K  e.g  2 .. 9 , div by 3 gives 9/3 +1 - (2/3 + 1) ie 3 + 1 - 1





public class Divisors {
    public static void main(String[] args) {
        System.out.println(solution(0,0,1));

        System.out.println(solution(0,1,1));
        System.out.println(solution(0,2,1));

        System.out.println(better(6,11,2));
    }

    static private int better(int A, int B, int K){
        int b = (B/K) + 1;  // From 0 to B the integers divisible by K  so 11/2 + 1 ie 6
        int a = (A/K) + 1;  // From 0 to A the integers divisible by K  so 6/2 + 1 = 4

        if (A%K == 0) { // "A" is inclusive; if divisible by K then
            --a;        //   remove 1 from "a"
        }
        return b-a;     // return integers in range
    }

    static public int solution(int A, int B, int K) {
        // write your code in Java SE 8
        // 2  divisor

        int count = 0;
        for(long  i = A;i<=B;i++){
            if(i % K ==0){
                count++;
            }

        }

        return count;

    }


}
