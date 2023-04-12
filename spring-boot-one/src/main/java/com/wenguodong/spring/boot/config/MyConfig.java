package com.wenguodong.spring.boot.config;

/*
 *@Time：2023/4/9
 *@Author：Jelly
 */

import com.wenguodong.spring.boot.bean.Car;
import com.wenguodong.spring.boot.bean.Pet;
import com.wenguodong.spring.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

/**
 * 1、配置类里面使用@Bean注解标注方法上给容器注册组件，默认也是单实例
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：代理bean的方法
 *      Full：全配置 proxyBeanMethods = true
 *          如果proxyBeanMethods是true 就是保证单实例，会先到容器中找实例
 *          反之则不会是单实例
 *      Lite：轻量配置 proxyBeanMethods = false
 *          每一次调用都会产生新实例
 *  如果不依赖组件，则一般都挑成false
 *  依赖组件的例子就是主人跟猫的例子
 *
 */

/**
 * 单实例的好处：
 * 比如 User类里面有一个属性 Pet 宠物的属性
 * 如果每次创建User都会导致新的Pet实例产生，虽然可能Pet里面的name都叫tom,但并非是同一个实例
 * 逻辑上说就是：一个主人每次的猫的名字相同，但不是同一只猫
 */

/**
 * 调成false的优点是：
 *      组件创建时不会检查这个组件在容器中是否存在，即跳过检查
 */

/**
 * Import 导入组件，会调用导入的类里面的无参构造器
 *      给容器中自动创建出这俩个类型的组件，默认名字为这个类的全类名
 */
@ImportResource("classpath:bean.xml")     //自动扫描bean.xml，将里面的组件导入到容器中
@Import(User.class)
@Configuration(proxyBeanMethods = true)//告诉SpringBoot这是一个配置类 == 配置文件
@EnableConfigurationProperties(Car.class)
/**
 * 1. 开启Car配置绑定功能
 * 2. 把这个Car这个组件自动注册到容器中
 */
public class MyConfig {

    @Bean("cat") //也可以指定组件id
    public Pet getPet() {
        return new Pet("Cat",4);
    }

    /**
     * 外部无论对配置类的组件调用多少次，都是获取容器里面的单实例，也就是同一个对象
     * user1 == user2
     * 除非把注解@Configuration(proxyBeanMethods 改为 false)
     * 此时 user1 ！= user2
     * @return
     */
    @ConditionalOnBean(name = "cat") //这个Conditional OnBean注解的意思是：如果容器中有cat这个组件的话，才会给容器中创建getUser这个组件
    //还有其他的条件组件，详细请看笔记
    @Bean //给容器添加组件，方法名作为id，返回类型就组件类型，返回值就是实例
    public User getUser() {
        return new User("WenGuoDong",18);
    }

}
