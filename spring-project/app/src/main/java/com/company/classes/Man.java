package com.company.classes;

public class Man implements Person {
    private String name;
    private int age;
    private String city;
    private String country;

    public Man(String name, int age, String city, String country) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.country = country;
    }

    @Override
    public void introduce(String name) {
        System.out.println(this.name);

    }

    @Override
    public void sayAge(int age) {
        System.out.println(this.age);
    }

    @Override
    public void sayWhereFrom(String city, String country) {
        System.out.println(this.city + " " + this.country);
    }

}
