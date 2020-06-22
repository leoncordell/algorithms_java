package com.collections;

import java.util.*;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toCollection;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayListBasics {

    public static void main(String[] args) {

        List<String> list = LongStream.range(0, 16)
                .boxed()
                .map(Long::toHexString)
                .collect(toCollection(ArrayList::new));
        List<String> stringsToSearch = new ArrayList<>(list);
        stringsToSearch.addAll(list);

        Set<String> matchingStrings = new HashSet<>(Arrays.asList("a", "c", "9"));

        List<String> result = stringsToSearch
                .stream()
                .filter(matchingStrings::contains)
                .collect(toCollection(ArrayList::new));

        assertEquals(6, result.size());

    }

}
