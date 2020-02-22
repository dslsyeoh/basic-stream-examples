/*
 * Author Steven Yeoh
 * Copyright (c) 2020. All rights reserved.
 */

package com.dsl.basic.stream.object;

import java.util.List;
import java.util.Map;

public class Person
{
    private String name;
    private int age;
    private List<String> hobbies;
    private Map<String, String> family;

    public Person() {}

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
}
