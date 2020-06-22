package com.algorithm.search;

import java.util.Arrays;

public class MergeSort2 {

    public static void main(String[] args) {
       // int[] A = {4,3};   //{1, 2, 5, 67, 3, 12, 24, 35, 9};
        int[] A = {1, 2, 5, 67, 3, 12, 24, 35, 9};
        System.out.println(Arrays.toString(A)  +  "-- " + Arrays.toString(sortLists(A)));
    }




    //1. Divide list into sublists
    static int[] sortLists(int[] A) {
        if (A.length == 1) {
            return A;
        }
        int midIndex = A.length / 2;
        int[] left = new int[midIndex];
        int[] right = new int[A.length - midIndex];

        for (int i = 0; i < midIndex; i++) {
            left[i]=A[i];
        }
        for (int j = midIndex; j < A.length; j++) {
            right[j-midIndex] = A[j];
        }
        left = sortLists(left);
        right = sortLists(right);
        return mergeList(left,right);

    }

    private static int[] mergeList(int[] left, int[] right) {
        int index =0;
        int l =0;
        int r =0;
        int[] result = new int[left.length + right.length];
        while(l<left.length && r<right.length){
            if(left[l] <= right[r]){
                result[index++] = left[l++];
            }else{
                result[index++] = right[r++];
            }
        }
        while(l<left.length){
            result[index++]= left[l++];
        }
        while(r<right.length){
            result[index++]=right[r++];
        }

        return  result;
    }


}
