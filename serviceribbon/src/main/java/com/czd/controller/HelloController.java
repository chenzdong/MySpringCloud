package com.czd.controller;

import com.czd.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试负载均衡Controller
 *
 * @author: czd
 * @create: 2018/3/16 15:42
 */
@RestController
public class HelloController {
    @Autowired
    HelloService service;
    @RequestMapping(value="/hi")
    public String hi(@RequestParam String name){
        return service.hi(name);
    }
}
