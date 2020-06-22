package com.algorithm.annotations;

@MyAnnotation(name="fred",count=3)
public class Annotation1 {

    public static void main(String[] args) {
        dStuff();
    }

    @MyAnnotation(name="fred",count=3)
    static void dStuff(){
        System.out.println();
    }
}
