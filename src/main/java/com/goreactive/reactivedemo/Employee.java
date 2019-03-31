package com.goreactive.reactivedemo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("employee")
public class Employee {

    @Id
    private String id;

    private String name;

    private int age;

    private String city;

    public Employee(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
