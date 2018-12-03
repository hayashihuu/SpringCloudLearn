package com.syun.authresources.model;

import lombok.Data;

/**
 * @description:
 * @program: springcloudsecurity-demo
 * @author: syun
 * @create: 2018-11-24 16:36
 */
@Data
public class Person {

    private String name;
    private String city;
    private String country;
    private Integer age;
    private String sex;

    public Person(String name, String city, String country, Integer age, String sex) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.age = age;
        this.sex = sex;
    }
}
