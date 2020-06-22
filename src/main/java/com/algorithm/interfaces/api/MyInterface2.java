package com.algorithm.interfaces.api;

@FunctionalInterface
public interface MyInterface2 {

    void sayStuff(String a);

    default void sayStuff2(String c){
        System.out.println(c);
    }

}
