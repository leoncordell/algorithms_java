package com.algorithm.search;

public class Triangle {
    public static void main(String[] args) {

        int[] A = {1, 2, 3, 4, 5, 6};
        System.out.println(solution(A));

        int[] A2 = {1, 2, 2};
        System.out.println(solution(A2));

        int[] A3 = {1, 3, 5};
        System.out.println(solution(A3));

        int[] A4 = {7, 1, 3, 5, 7};
        System.out.println(solution(A4));


    }


    static private int solution(int[] A) {
        //need A,B,C    from  indexes left  to  right
        //
        simpleSort(A);

        for (int i = 0; i < A.length - 2; i++) {
            if (A[i] + A[i + 1] > A[i + 2]) {
                if (A[i] + A[i + 2] > A[i + 1]) {
                    if (A[i + 2] + A[i + 1] > A[i]) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    private static void simpleSort(int[] A) {
        // sorted on left
        int unsortedStart = 0;
        int minIndex;
        for (int j = 0; j < A.length; j++) {
            {
                minIndex = j;
                for (int i = j; i < A.length; i++) {
                    if (A[i] < A[minIndex]) {
                        minIndex = i;
                    }
                }
                //swap
                if (minIndex != j) {
                    int tmp = A[j];
                    A[j] = A[minIndex];
                    A[minIndex] = tmp;
                }
            }
        }
    }
}
