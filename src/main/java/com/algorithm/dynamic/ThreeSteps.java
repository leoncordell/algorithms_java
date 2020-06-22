package com.algorithm.dynamic;

public class ThreeSteps {
    public static void main(String[] args) {
        System.out.println(combinationCount(4));
    }

    static int solution(int n){

        return 0;
    }


    static int  combinationCount(int steps){
        if(steps <0 ){
            return 0;
        }else if(steps==0){
            return 1;
        }else{
            return combinationCount(steps-1) + combinationCount(steps-2) + combinationCount(steps-3);
        }
    }

    static int  combinationCount(int steps,int[] memo){
        if(steps <0 ){
            return 0;
        }else if(steps==0){
            return 1;
        }else if(memo[steps] > -1){
            return memo[steps];
        }else{
            memo[steps] = combinationCount(steps-1,memo) + combinationCount(steps-2,memo) + combinationCount(steps-3,memo);
            return  memo[steps];
        }
    }


}
