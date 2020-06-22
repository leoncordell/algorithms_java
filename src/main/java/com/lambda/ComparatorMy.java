package com.lambda;

import com.algorithm.interfaces.api.MyInterface2;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ComparatorMy {
    public static void main(String[] args) {
        List<String> stuff = List.of("Abe","Cat","Super","Art","Able");

        Predicate<String> p = a -> a.length() == 3;
        Predicate<String> p2 = a -> a.startsWith("A");

        Predicate<String> pipelin = p.and(p2);

        stuff.sort(Comparator.comparing(String::length));

        stuff.forEach(a-> System.out.println(a));






//         Function<String,String> addHeader = Letter::addHeader;
//        Function<String,String> addFooter = Letter::addFooter;
//        Function<String,String> addCaps = Letter::caps;
//
//        final Function<String, String> pipeLine = addHeader.andThen(addFooter);
//
//        final Function<String, String> pipeLine2 = pipeLine.andThen(addCaps);
//
//        System.out.println(pipeLine.apply("Dear Bosh"));
//
//        System.out.println(pipeLine2.apply("Dear Josh"));

    }
}

class Letter{

    public static String addHeader(String  text){
        return text;
    }

    public static String addFooter(String  text){
        return text + " Best  Reagrds";
    }

    public static String caps(String  text){
        return text.toUpperCase();
    }
}