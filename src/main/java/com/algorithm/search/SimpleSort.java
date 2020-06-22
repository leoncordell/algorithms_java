package com.algorithm.search;

import java.util.Arrays;

public class SimpleSort {
    public static void main(String[] args) {
    int[] A = {1,3,6,32,45,2,4,6,9};

        System.out.print(Arrays.toString(A)   + "  - "  );
        sort(A);
        System.out.println(Arrays.toString(A)   );


    }

    private static  void  sort(int[] a) {
         doSimpleSort(a,0,a.length-1);
    }

    private static void doSimpleSort(int[] a, int low, int high) {
        if (high > low) {
            int pivot = partition(a,low,high);
            doSimpleSort(a,pivot+1,high);
            doSimpleSort(a,low,pivot-1);
        }
    }

    private static int partition(int[] a, int min, int max) {
        int pivot = a[max];
        int doneIndex=min-1;
        for (int i = min; i < a.length; i++) {
            if (a[i] < pivot ){
                doneIndex++;
                int tmp = a[doneIndex];  //e.g 77  v 7
                a[doneIndex]=a[i];       // set 7
                a[i] = tmp;              //77

            }
        }
        int swapTmp = a[doneIndex+1];
        a[doneIndex+1] = pivot;
        a[max] = swapTmp;
        return doneIndex +1;
    }

}
