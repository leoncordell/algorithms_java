package com.algorithm.dynamic;

public class Coins {

     public static  void     main(String[] args) {
        //System.out.println(combinations(1));
        int[] coins = {1, 5, 10, 25};
        System.out.println(combinations(50, coins, 0));     //1 + 10X1


    }

    //25 ,10,5 ,1
    static  int combinations(int value, int[] denoms, int index) {
        int coin = denoms[index];

        if (index == denoms.length - 1) {
            return value % coin == 0 ? 1 : 0;
        }

        int ways = 0;
        for (int amount=0;amount <= value ; amount +=coin){
            ways += combinations(value-amount,denoms,index+1);
        }
        return  ways;
    }


}
