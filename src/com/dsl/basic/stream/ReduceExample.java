/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved.
 */

package com.dsl.basic.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReduceExample
{
    public static void main(String[] args)
    {
        ReduceExample reduceExample = new ReduceExample();
        reduceExample.example();
        reduceExample.example2();
        reduceExample.example3();
        reduceExample.example4();
    }

    private void example()
    {
        System.out.println("============ EXAMPLE ============");
        IntStream.rangeClosed(0, 10).boxed().reduce(Integer::sum).ifPresent(value -> System.out.println("total: " + value));
        System.out.println("============ EXAMPLE ============");
    }

    private void example2()
    {
        List<String> list = Arrays.asList("Hello", "World");
        String sentence = list.stream().reduce((acc, next) -> acc + " " + next + ", Hows your days?").orElse("");
        System.out.println("============ EXAMPLE 2 ============");
        System.out.println(sentence);
        System.out.println("============ EXAMPLE 2 ============");
    }

    private void example3()
    {
        List<String> list1 = Stream.of("This", "is", "string", "array").collect(Collectors.toList());
        List<String> list2 = Arrays.asList("Hello", "World");

        List<List<String>> list = Stream.of(list1, list2).collect(Collectors.toList());
        List<String> result = list.stream().reduce((acc, next) -> {
            acc.addAll(next);
            return acc;
        }).orElse(Collections.emptyList());

        System.out.println("============ EXAMPLE 3 ============");
        System.out.println("before: " + list);
        System.out.println("after: " + result);
        System.out.println("============ EXAMPLE 3 ============");
    }

    private void example4()
    {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);

        int result = values.stream().reduce(1, (acc, next) -> acc * next);
        System.out.println(result);
    }
}
