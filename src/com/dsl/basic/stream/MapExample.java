/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved.
 */

package com.dsl.basic.stream;

import com.dsl.basic.stream.object.Person;
import com.dsl.basic.stream.object.PersonBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapExample
{
    private Person john = PersonBuilder.getJohn();
    private Person bob = PersonBuilder.getBob();
    private Person anthony = PersonBuilder.getAnthony();

    private List<Person> persons = Arrays.asList(john, bob, anthony);

    public static void main(String[] args)
    {
        MapExample mapExample = new MapExample();
        mapExample.example();
        mapExample.example2();
        mapExample.example3();
        mapExample.example4();
    }

    private void example()
    {
        System.out.println("============ EXAMPLE ============");
        persons.stream().map(Person::getName).forEach(System.out::println);
        System.out.println("============ EXAMPLE ============");
    }

    private void example2()
    {
        System.out.println("============ EXAMPLE 2 ============");
        bob.getFamily().forEach((key, value) -> System.out.println(key + "=" + value));
        System.out.println("============ EXAMPLE 2 ============");
    }

    private void example3()
    {
        System.out.println("============ EXAMPLE 3 ============");
        IntStream.rangeClosed(0, 10).map(value -> value * 2).forEach(System.out::print);
        System.out.println("============ EXAMPLE 3 ============");
    }

    private void example4()
    {
        System.out.println("============ EXAMPLE 4 ============");
        persons.stream().filter(person -> Objects.equals(person.getName(), "Bob")).map(person -> {
            person.setAge(32);
            person.getHobbies().add("Travel");
            return person;
        }).forEach(Person::print);
        System.out.println("============ EXAMPLE 4 ============");
    }
}
