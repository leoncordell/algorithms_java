package com.streams.collectors;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyCollector {

    public static void main(String[] args) {

    }


    static void doStuff(){
        Stream<Integer> streamInt = Stream.of(1,2,3,4,5);
        IntStream stream_int = IntStream.of(1,2,3,4,5);

        final Optional<Integer> mayIntOpt = streamInt.collect(Collectors.maxBy((a, b) -> a.compareTo(b)));




    }



}
