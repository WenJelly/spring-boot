package com.wenguodong.spring.boot;

import com.wenguodong.spring.boot.bean.Pet;
import com.wenguodong.spring.boot.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/*
 *@Time：2023/4/9
 *@Author：Jelly
 */

/**
 * 主程序类,有一个就行了
 * 这是一个SpringBoot应用
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        //1.返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //2.查看容器里面的组件
        System.out.println(1);
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        //3.从容器中获取组件
        User getUser = run.getBean("getUser", User.class);
        System.out.println(getUser);

        //4.测试单实例
        User getUser1 = run.getBean("getUser", User.class);
        User getUser2 = run.getBean("getUser", User.class);
        System.out.println(getUser1 == getUser2);

        System.out.println("=============================================");

        //5.Import自动创建组件
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        for (String s :beanNamesForType) {
            System.out.println(s);
        }


    }
}
