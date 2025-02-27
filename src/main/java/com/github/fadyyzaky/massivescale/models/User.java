package com.github.fadyyzaky.massivescale.models;

import java.util.UUID;

public class User {
    private String id;
    private String name;
    private Integer age;
    private String email;

    public User() {
        this.id = UUID.randomUUID().toString();
    }

    public User(String name, Integer age, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public User(String id, String name, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
