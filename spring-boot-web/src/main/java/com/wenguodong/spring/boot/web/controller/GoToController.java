package com.wenguodong.spring.boot.web.controller;

import com.sun.net.httpserver.HttpServer;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
 *@Time：2023/4/11
 *@Author：Jelly
 */
@Controller
public class GoToController {

    @GetMapping("goto1")
    public String goTo(HttpServletRequest request) {

        request.setAttribute("msg1","成功了");
        request.setAttribute("msg2",200);
        return "forward:/gotohere";  //转发到  /success请求
    }

    @ResponseBody
    @GetMapping("/gotohere")
    public Map<String, Object> goToHere(@RequestAttribute("msg1") String msg1,
                                        @RequestAttribute("msg2") String msg2,
                                        HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg1",msg1);
        map.put("msg2",msg2);
        //或者
        Object msg11 = request.getAttribute("msg1");
        Object msg22 = request.getAttribute("msg2");
        System.out.println(msg11 + "" + msg22);

        return map;

    }

}
