/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved.
 */

package com.dsl.basic.stream.object;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class PersonBuilder
{
    private PersonBuilder() {}

    public static Person getJohn()
    {
        Map<String, String> family = new HashMap<>();
        family.put("wife", "Mrs John");
        family.put("son", "David");
        family.put("daughter", "Margaret");
        return new Person("John", 55, toList("Workout", "Fishing"), family);
    }

    public static Person getBob()
    {
        Map<String, String> family = new HashMap<>();
        family.put("wife", "Mrs Bob");
        family.put("son", "Chris");
        return new Person("Bob", 30, toList("Basketball", "Workout"), family);
    }

    public static Person getAnthony()
    {
        Map<String, String> family = new HashMap<>();
        family.put("wife", "Mrs Anthony");
        family.put("son", "Paul");
        family.put("daughter", "Paul");
        return new Person("Anthony", 30, toList("Drawing", "Cycling", "Swimming"), family);
    }

    private static List<String> toList(String... hobbies)
    {
        return Stream.of(hobbies).collect(Collectors.toList());
    }

}
