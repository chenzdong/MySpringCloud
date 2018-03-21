package com.czd.serivefeign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feign调取的服务接口
 *
 * @author: czd
 * @create: 2018/3/16 16:30
 */
@FeignClient(value="service-hi",fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {
    @RequestMapping(value="/hi",method = RequestMethod.GET)
    String sayHi(@RequestParam(value = "name") String param);
}
