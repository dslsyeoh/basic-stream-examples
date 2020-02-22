/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved.
 */

package com.dsl.basic.stream;

import com.dsl.basic.stream.object.Person;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class PersonBuilder
{
    private static Person getJohn()
    {
        Map<String, String> family = new HashMap<>();
        family.put("wife", "Mrs John");
        family.put("son", "David");
        family.put("daughter", "Margaret");
        return new Person("John", 55, Arrays.asList("Workout", "Fishing"), family);
    }

    private static Person getBob()
    {
        Map<String, String> family = new HashMap<>();
        family.put("wife", "Mrs Bob");
        family.put("son", "Chris");
        return new Person("Bob", 30, Arrays.asList("Basketball", "Workout"), family);
    }

    private static Person getAnthony()
    {
        Map<String, String> family = new HashMap<>();
        family.put("wife", "Mrs Anthony");
        family.put("son", "Paul");
        family.put("daughter", "Paul");
        return new Person("Anthony", 30, Arrays.asList("Drawing", "Cycling", "Swimming"), family);
    }
}
