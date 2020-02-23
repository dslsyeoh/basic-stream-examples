/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved.
 */

package com.dsl.basic.stream;

import com.dsl.basic.stream.object.Person;
import com.dsl.basic.stream.object.PersonBuilder;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReturnListExample
{
    public static void main(String[] args)
    {
        ReturnListExample returnListExample = new ReturnListExample();
        returnListExample.example();
        returnListExample.example2();
        returnListExample.example3();
        returnListExample.example4();
    }

    private void example()
    {
        List<Integer> numbers = IntStream.rangeClosed(0, 10).boxed().collect(Collectors.toList());
        System.out.println("============ EXAMPLE ============");
        System.out.println(numbers);
        System.out.println("============ EXAMPLE ============");
    }

    private void example2()
    {
        Person john = PersonBuilder.getJohn();
        Person bob = PersonBuilder.getBob();
        Person anthony = PersonBuilder.getAnthony();

        List<Person> persons = Stream.of(john, bob, anthony).filter(person -> person.getHobbies().contains("Workout")).collect(Collectors.toList());
        System.out.println("============ EXAMPLE 2 ============");
        persons.forEach(Person::print);
        System.out.println("============ EXAMPLE 2 ============");
    }

    private void example3()
    {
        List<String> names = Stream.of("person 1", "person 2", "person 3").collect(Collectors.toList());

        List<Person> persons = names.stream().map(name -> {
            Person person = new Person();
            person.setName(name);
            return person;
        }).collect(Collectors.toList());

        System.out.println("============ EXAMPLE 3 ============");
        persons.stream().map(Person::getName).forEach(name -> System.out.println("Name: " + name));
        System.out.println("============ EXAMPLE 3 ============");
    }

    private void example4()
    {
        Map<String, Map<String, String>> personMap = new HashMap<>();

        Map<String, String> person1 = new HashMap<>();
        person1.put("name", "Walker");
        person1.put("age", "30");

        Map<String, String> person2 = new HashMap<>();
        person2.put("name", "Stan");
        person2.put("age", "50");

        personMap.put("person_1", person1);
        personMap.put("person_2", person2);

        List<Person> persons = IntStream.rangeClosed(1, personMap.size()).boxed().map(value -> {
            Map<String, String> map = personMap.get("person_" + value);
            Person person = new Person();
            person.setName(map.get("name"));
            person.setAge(Integer.parseInt(map.get("age")));
            return person;
        })
        .collect(Collectors.toList());

        System.out.println("============ EXAMPLE 4 ============");
        persons.forEach(Person::print);
        System.out.println("============ EXAMPLE 4 ============");
    }
}
