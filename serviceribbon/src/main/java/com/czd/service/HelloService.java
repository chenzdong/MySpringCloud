package com.czd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 测试负载均衡service
 *
 * @author: czd
 * @create: 2018/3/16 15:40
 */

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;
    public String hi(String name){
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }
}
