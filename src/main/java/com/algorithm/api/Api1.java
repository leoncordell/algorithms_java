package com.algorithm.api;

public class Api1 {


    public static void main(String[] args) {
        doWrapper();
    }




   static void  doWrapper() {
       Integer a = new Integer(127);
       Integer b = 5;

       Integer c = Integer.valueOf(126);

       int d = c.intValue();

       Integer e = Integer.valueOf("126");

       int i = Integer.parseInt("123");
       Integer f = Integer.valueOf("126");

       String g = Integer.toBinaryString(f);
       System.out.format("%032d\n", Integer.parseInt(g));

   }


}
