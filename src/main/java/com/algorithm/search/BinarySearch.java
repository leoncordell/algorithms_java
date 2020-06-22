package com.algorithm.search;



public class BinarySearch {


    public static void main(String[] args) {
        int[] A = {1,2,4,7,8,12,15,19,24,28,33,44,77,87,102};

        System.out.println(solution(A,18));

    }

    private static int  solution(int[] a, int i) {


        int  result = doBinarySearch(a,i,0,a.length);

        return  result;
    }

   static  private int  doBinarySearch(int[] a, int val, int start, int end) {
        if(start > end  || start <0){
            return -1;
        }
        if(end==start){
            return (a[end]==val)? end:-1;
        }
        int mid = start + (end-start) /2 ;
        if(val < a[mid]  ){
             doBinarySearch(a,val,start,mid-1);
        }else if(val > a[mid]){
             doBinarySearch(a,val,mid+1,end);
        }else if(a[mid]==val){
            return mid;
        }
        return -1;

    }

}
