package com.algorithm.sort;

import java.util.Arrays;

public class NumberDiscIntersections {
    public static void main(String[] args) {
        int[] A = {0,1};  // 1
        System.out.println(solution(A));
        int[] A1 = {1,5,2,1,4,0};
        System.out.println(solution(A1));
    }

    static public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length < 2) {
            return 0;
        }
        Circle[] c = new Circle[A.length];

        for (int i = 0; i < A.length; i++) {
            c[i]= new Circle((long)i-A[i],(long)i + A[i]);
        }
        Arrays.sort(c);
        System.out.println("SORTED");
        System.out.println(Arrays.toString(c));

        int count = 0;
        for (int i = 0; i < A.length-1; i++) {
            for (int j = i+1; j < A.length ; j++) {  //Must  go  to last  circle
                if(c[i].right >= c[j].left){
                    count++;
                    if(count > 10000000){
                        return -1;
                    }
                }else{
                    break;
                }
            }

        }
        return  count;
    }


    private static class Circle implements Comparable{
        private  long left = Long.MAX_VALUE;
        private long  right = Long.MIN_VALUE;

        Circle(long l,long r){
            left = l;
            right = r;
        }

        public String  toString(){
            return "left :" + left + " right :" + right;
        }

        @Override
        public int compareTo(Object o) {
            Circle b = (Circle)o;
            if(this.left < b.left)
                return -1;
            if(this.left > b.left)
                return 1;
            if(this.right < b .right)
                return -1;
            if(this.right > b .right)
                return 1;
            return 0;
        }
    }


}


//left ,right
// if  left <0 ,all intersect