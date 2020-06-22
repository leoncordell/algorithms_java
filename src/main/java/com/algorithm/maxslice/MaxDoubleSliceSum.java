package com.algorithm.maxslice;

public class MaxDoubleSliceSum {

    public static void main(String[] args) {
        //3, 2, 6, -1, 4, 5, -1, 2
//        int[] A = {3,2,6,-1,4,5,-1,2}; //{2,-3,4,-2,6,7};    //max left posXY....  0(0,1),3(0,2),7(0,3),12(0,4) to len -2
//                                     //if A[x+1] <0 then increment xIndex
//
//                                        //max right posYZ 0(4,5),6(3,5),11(2,5),15(1,5) to index 1
//                                        //combined 0,3,5 gives 13 ;  0,4,5 gives 12
//
//                                    //  PosY  maxL -  0n , 0,3,7,12,18
//
//                                    //  Pos maxR -
//        int[] A2 ={2,-3,4,-2,6,7};
//
//        System.out.println(solution(A));
//        System.out.println(solution(A2));

        int[] A3 ={1,2,4,2,6,7};
        System.out.println(solution(A3));

    }

    static int solution(int[] A){
        //preFixSum
        //Max Left , L1 , L2

        if(A.length <4){
            return 0;
        }

        int Ypos = 1;
        int Xpos = 0;
        int []maxLeft = new int[A.length];
        int []maxRight = new int[A.length];
        maxLeft[0] =0;
        maxLeft[1] =0;
        maxLeft[A.length-1] =0;
        for (int i = 2; i < A.length-1; i++) {
            if(maxLeft[i-1] + A[i-1] < 0){
                Xpos = i-1;
                maxLeft[i] = 0;
            }else {
                maxLeft[i] = maxLeft[i - 1] + A[i-1];
            }
        }

        Ypos=A.length-2;
        int zPos = A.length-1;
        maxRight[A.length -1] = 0;
        maxRight[A.length -2] = 0;
        maxRight[0] = 0;
        for (int j = A.length-3; j > 0; j--) {
            if(maxRight[j+1] + A[j+1]<0  ){
                maxRight[j] = 0;
            }else {
                maxRight[j] = maxRight[j + 1] + A[j+1];
            }
        }
        int max = 0;
        for (int l = 0; l < A.length; l++) {
            max = Math.max(max, maxLeft[l] + maxRight[l]);
        }


        return max;

    }


}
