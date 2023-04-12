package com.wenguodong.spring.boot.web.controller;

/*
 *@Time：2023/4/11
 *@Author：Jelly
 */

import org.apache.tomcat.util.http.parser.Cookie;
import org.apache.tomcat.util.http.parser.Ranges;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ParameterTestController {

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String username,
                                      @PathVariable Map<String,String> allMap,

                                      @RequestHeader("sec-ch-ua-mobile")String secchuamobile,
                                      @RequestHeader Map<String,String> headMap) {
        //获取路径资源
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("username",username);
        map.put("allMap",allMap);

        //获取请求头
        map.put("Accept-Ranges",secchuamobile);
        map.put("headMap",headMap);

        return map;
    }

    @PostMapping("/carToUser")
    public Map<String,Object> getCar1(@RequestParam("name")String name,
                                      @RequestParam("password")String password,
                                      @RequestParam Map<String,String> paramMap,

                                      @CookieValue("Idea-aafc917b")String ideaaafc917b,
                                      @CookieValue("Idea-aafc917b")Cookie cookie,

                                      @RequestBody String content) {
        HashMap<String, Object> map = new HashMap<>();
        //获取请求参数
        map.put("name",name);
        map.put("password",password);
        map.put("paramMap",paramMap);
        //获取Cookie
        map.put("Idea-aafc917b",ideaaafc917b);
        map.put("cookie",cookie);

        //获取请求体
        map.put("content",content);
        return map;
    }
}
