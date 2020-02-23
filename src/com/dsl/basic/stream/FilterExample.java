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

public class FilterExample
{
    private Person john = PersonBuilder.getJohn();
    private Person bob = PersonBuilder.getBob();
    private Person anthony = PersonBuilder.getAnthony();

    private List<Person> persons = Arrays.asList(john, bob, anthony);

    public static void main(String[] args)
    {
        FilterExample filterExample = new FilterExample();
        filterExample.example();
        filterExample.example2();
        filterExample.example3();
        filterExample.example4();
    }

    private void example()
    {
        System.out.println("============ EXAMPLE ============");
        persons.stream().filter(person -> person.getHobbies().contains("Workout")).forEach(Person::print);
        System.out.println("============ EXAMPLE ============");
    }

    private void example2()
    {
        System.out.println("============ EXAMPLE 2 ============");
        Stream.of(john, bob, anthony).filter(person -> person.getAge() < 50).forEach(Person::print);
        System.out.println("============ EXAMPLE 2 ============");
    }

    private void example3()
    {
        System.out.println("============ EXAMPLE 3 ============");
        Stream.of(john, bob, anthony).filter(person -> Objects.nonNull(person.getFamily().get("daughter"))).forEach(Person::print);
        System.out.println("============ EXAMPLE 3 ============");
    }

    private void example4()
    {
        System.out.println("============ EXAMPLE 4 ============");
        IntStream.rangeClosed(0, 10).filter(value -> value % 2 == 0).forEach(System.out::println);
        System.out.println("============ EXAMPLE 4 ============");
    }
}
