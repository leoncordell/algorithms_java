package com.algorithm.search;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] A = {77,89,1,5,4};
        sort(A);
        System.out.println(Arrays.toString(A));

    }


    private static void sort(int[] A) {

        mergeSort(A, A.length);

    }


    //Once  array size ==1 ; No calls to merge
    // stack unravels - call to merge with full arr 2 then 3, then 5
    static private void mergeSort(int[] arr, int size) {
        if (size < 2) {
            return;
        }
        int mid = size / 2;
        int[] left = new int[mid];
        int[] right = new int[size - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int j = mid; j < size; j++) {
            right[j-mid] = arr[j];
        }
        mergeSort(left, left.length);
        mergeSort(right, right.length);
        merge(arr, left, right, mid, size - mid);   //  array , leftArray, rightArray


    }


    //1,1   then 1,2  then  1,1 then 1,1 then  2,2 then 3,4   then 1,1

    private static void merge(int[] arr, int[] l, int[] r, int len_l, int len_r) {
        System.out.println(arr.length);
        int i = 0, j = 0, k = 0;
        while (i < len_l && j < len_r) {
            if (l[i] < r[j]) {
                arr[k++] = l[i++];
            } else {
                arr[k++] = r[j++];
            }
        }
        while (i < len_l) {
            arr[k++] = l[i++];
        }
        while (j < len_r) {
            arr[k++] = r[j++];
        }
    }


}
