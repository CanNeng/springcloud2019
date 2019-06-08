package cn.qn.springcloud.service;

import cn.qn.springcloud.entities.Dept;
import cn.qn.springcloud.entities.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "MS-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
    @RequestMapping(value = "/dept/get/{id}", method = {RequestMethod.GET})
    Result get(@PathVariable("id") Long id);

    @RequestMapping(value = "/dept/list", method = {RequestMethod.GET})
    Result list();

    @RequestMapping(value = "/dept/add", method = {RequestMethod.POST})
    Result add(Dept dept);
}
