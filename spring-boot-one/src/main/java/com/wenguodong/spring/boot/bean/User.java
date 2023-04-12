package com.wenguodong.spring.boot.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 *@Time：2023/4/9
 *@Author：Jelly
 */
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode //Equals方法和HashCode方法
public class User {
    private String name;
    private int age;
    private Pet pet;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
