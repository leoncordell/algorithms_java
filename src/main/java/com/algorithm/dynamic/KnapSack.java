package com.algorithm.dynamic;

import java.util.Arrays;

public class KnapSack {

    public static void main(String[] args) {

        int[] weights = {12,5,7,10,2};

        int[] values = {8,7,5,6,3};

        int totalWeight = 15;

        System.out.println(doKnapSack(weights,values,totalWeight));

    }

    public boolean  equals(Object o){
        int  a = 5;
        final boolean equals = super.equals(o);
        return o==this;
    }

    //To return max   value
    static  int doKnapSack(int[] w, int[] v ,int total){
        //items  rows/cols
        int[][] itemValue =new int[w.length+1][total +1];
        for (int i = 0; i < w.length+1; i++) {
            for (int j = 0; j < total+1 ; j++) {
                itemValue[i][j]=0;
            }
        }
        //First row & col left with zeros
        for (int item = 1; item < w.length + 1; item++) {
            for (int weight = 1; weight < total +1 ; weight++) {
                //if our weight exceeds item weight
                if( (weight-w[item-1]) >=0) {
                    itemValue[item][weight] = Math.max(v[item-1]  + itemValue[item-1][weight-w[item-1]], itemValue[item-1][weight] ) ;    // w[item-1],v[item-1]   relates to itemValue[item]
                    //if(j-w[i] ) {
                        //+ itemValue[i - 1][(j - w[i])];//- (j w[i]];  // row  above current col - w[i]
                    }else{
                    itemValue[item][weight] = itemValue[item-1][weight];
                }
                }
            }
        return itemValue[w.length][total];
    }

}
