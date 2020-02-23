/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved.
 */

package com.dsl.basic.stream;

import com.dsl.basic.stream.object.Person;
import com.dsl.basic.stream.object.PersonBuilder;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReturnMapExample
{
    public static void main(String[] args)
    {
        ReturnMapExample returnMapExample = new ReturnMapExample();
        returnMapExample.example();
        returnMapExample.example2();
    }

    private void example()
    {
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();

        map1.put("map1_key_1", "map1_value_1");
        map1.put("map1_key_2", "map1_value_2");
        map2.put("map2_key_1", "map2_value_1");
        map2.put("map2_key_2", "map2_value_2");

        Map<String, String> merged = Stream.of(map1, map2).map(Map::entrySet).flatMap(Collection::stream).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("============ EXAMPLE ============");
        System.out.println(merged);
        System.out.println("============ EXAMPLE ============");
    }

    private void example2()
    {
        Person john = PersonBuilder.getJohn();
        Person bob = PersonBuilder.getBob();
        Person anthony = PersonBuilder.getAnthony();

        Map<String, Person> personMap = Stream.of(john, bob, anthony).collect(Collectors.toMap(Person::getName, person -> person));

        System.out.println("============ EXAMPLE 2 ============");
        System.out.println(personMap);
        personMap.forEach((key, person) -> {
            System.out.println("=============== " + key + " ===============");
            person.print();
        });
        System.out.println("============ EXAMPLE 2 ============");

    }

}
