package com.wenguodong.spring.boot.bean;

/*
 *@Time：2023/4/9
 *@Author：Jelly
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor //全参构造器
@NoArgsConstructor  //无参构造器
@Data
@ToString
public class Pet {
    private String name;
    private int age;
}
