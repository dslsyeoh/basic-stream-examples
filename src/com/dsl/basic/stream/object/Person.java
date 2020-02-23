/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved.
 */

package com.dsl.basic.stream.object;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person
{
    private String name;
    private int age;
    private List<String> hobbies;
    private Map<String, String> family;

    public Person()
    {
        setHobbies(new ArrayList<>());
        setFamily(new HashMap<>());
    }

    public Person(String name, int age, List<String> hobbies, Map<String, String> family)
    {
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
        this.family = family;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public List<String> getHobbies()
    {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies)
    {
        this.hobbies = hobbies;
    }

    public Map<String, String> getFamily()
    {
        return family;
    }

    public void setFamily(Map<String, String> family)
    {
        this.family = family;
    }

    public void print()
    {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        if(!hobbies.isEmpty()) System.out.println("Hobbies: " + hobbies.toString());
        if(!family.isEmpty()) System.out.println("Family: " + family.toString());
    }
}
