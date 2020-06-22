package com.algorithm.interfaces;

import com.algorithm.interfaces.api.MyInterface2;

import java.util.ArrayList;
import java.util.List;

public class InterfaceScope {

    public static void main(String[] args) {
        MyInterface2 myIf2 = (a)-> System.out.println(a);

        myIf2.sayStuff("What ho");

        myIf2.sayStuff2("5");

        List<String> f = new ArrayList<>();
    }
}


interface MyInterface{


}