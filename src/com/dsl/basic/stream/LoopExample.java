/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved.
 */

package com.dsl.basic.stream;

import com.dsl.basic.stream.object.Person;
import com.dsl.basic.stream.object.PersonBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class LoopExample
{
    private Person john = PersonBuilder.getJohn();
    private Person bob = PersonBuilder.getBob();
    private Person anthony = PersonBuilder.getAnthony();

    private List<Person> persons = Arrays.asList(john, bob, anthony);

    public static void main(String[] args)
    {
        LoopExample loopExample = new LoopExample();
        loopExample.example();
        loopExample.example2();
        loopExample.example3();
        loopExample.example4();
        loopExample.example5();
    }

    private void example()
    {
        System.out.println("============ EXAMPLE ============");
        Arrays.asList(john, bob, anthony).forEach(person -> {
            System.out.println("Name: " + person.getName());
            System.out.println("Age: " + person.getAge());
        });
        System.out.println("============ EXAMPLE ============");
    }

    private void example2()
    {
        System.out.println("============ EXAMPLE 2 ============");
        Arrays.asList(john, bob, anthony).forEach(Person::print);
        System.out.println("============ EXAMPLE 2============");
    }

    private void example3()
    {
        System.out.println("============ EXAMPLE 3 ============");
        IntStream.range(0, persons.size()).forEach(index -> {
            System.out.println("Name: " + persons.get(index).getName());
            System.out.println("Age: " + persons.get(index).getAge());
        });
        System.out.println("============ EXAMPLE 3 ============");
    }

    private void example4()
    {
        System.out.println("============ EXAMPLE 4 ============");
        System.out.println("Print 0 to 9");
        IntStream.range(0, 10).forEach(System.out::println);
        System.out.println("============ EXAMPLE 4 ============");
    }

    private void example5()
    {
        System.out.println("============ EXAMPLE 5 ============");
        System.out.println("Print 1 to 10");
        IntStream.rangeClosed(1, 10).forEach(System.out::println);
        System.out.println("============ EXAMPLE 5 ============");
    }
}
