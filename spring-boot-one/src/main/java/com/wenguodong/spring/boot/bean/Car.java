package com.wenguodong.spring.boot.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
 *@Time：2023/4/10
 *@Author：Jelly
 */

/**
 * 只有在容器中的组件，才能使用spring-boot提供的强大功能
 * 或者，在配置类里面增加EnableConfigurationProperties(Car.class)
 */
//@Component //加入到容器中
@ToString
@Data
@ConfigurationProperties(prefix = "mycar")  //prefix是在配置文件properties中寻找前缀相同的属性
public class Car {
    private String brand;
    private Integer price;
}
