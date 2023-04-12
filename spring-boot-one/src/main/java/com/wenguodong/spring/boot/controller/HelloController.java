package com.wenguodong.spring.boot.controller;

import com.wenguodong.spring.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 *@Time：2023/4/9
 *@Author：Jelly
 */
@Slf4j  //日志功能
@RestController
/*@RestController注解包含了俩个注解：
  一个是@ResponseBody：发送请求给浏览器
  一个是@Controlller：
 */
public class HelloController {

    @Autowired
    private Car car;

    @RequestMapping("/car")
    public Car carTest() {
        return car;
    }
    @RequestMapping("/hello") //浏览器的映射请求
    public String handle01(@RequestParam("name")String name) {
        //    @RequestParam的作用是，从浏览器中传过来的name自动装填到参数的name中

        log.info("请求进来了。。。");
        return "Hello,Spring Boot 2!" + "你好：" + name;
    }
}
