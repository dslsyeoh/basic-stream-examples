/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved.
 */

package com.dsl.basic.stream;

import com.dsl.basic.stream.object.Person;
import com.dsl.basic.stream.object.PersonBuilder;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {

    public static void main(String[] args)
    {
        FlatMapExample flatMapExample = new FlatMapExample();
        flatMapExample.example();
        flatMapExample.example2();
        flatMapExample.example3();
    }

    private void example()
    {
        Person john = PersonBuilder.getJohn();
        Person bob = PersonBuilder.getBob();
        Person anthony = PersonBuilder.getAnthony();

        System.out.println("============ EXAMPLE ============");
        Arrays.asList(john, bob, anthony).stream().map(Person::getHobbies).flatMap(Collection::stream).forEach(System.out::println);
        System.out.println("============ EXAMPLE ============");
    }

    private void example2()
    {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(4, 5, 6);
        List<Integer> numbers3 = Arrays.asList(7, 8, 9);

        List<List<Integer>> list = Arrays.asList(numbers, numbers2, numbers3);
        List<Integer> mergedList = list.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println("============ EXAMPLE 2 ============");
        System.out.println("before merge: " + list);
        System.out.println("after merge: " + mergedList);
        System.out.println("============ EXAMPLE 2 ============");
    }

    private void example3()
    {
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();

        map1.put("map1_key_1", "map1_value_1");
        map1.put("map1_key_2", "map1_value_2");

        map2.put("map2_key_1", "map2_value_1");
        map2.put("map2_key_2", "map2_value_2");

        System.out.println("============ EXAMPLE 3 ============");
        Stream.of(map1, map2).map(Map::entrySet).flatMap(Collection::stream).forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));
        System.out.println("============ EXAMPLE 3 ============");
    }
}
