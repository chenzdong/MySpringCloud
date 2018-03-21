package com.czd.serivefeign;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 断路器类
 *
 * @author: czd
 * @create: 2018/3/19 9:45
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHi(@RequestParam(value = "name") String param) {
        return "sorry "+param;
    }
}
