package cn.qn.springcloud.controller;

import cn.qn.springcloud.entities.Dept;
import cn.qn.springcloud.entities.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {

    private static final String REST_URL_PREFIX = "http://MS-DEPT";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/add", method = {RequestMethod.POST})
    public Result add(Dept dept) {
        return restTemplate.postForObject(String.format("%s/dept/add", REST_URL_PREFIX), dept, Result.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}", method = {RequestMethod.GET})
    public Result get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(String.format("%s/dept/get/%s", REST_URL_PREFIX, id), Result.class);
    }

    @RequestMapping(value = "/consumer/dept/list", method = {RequestMethod.GET})
    public Result list() {
        return restTemplate.getForObject(String.format("%s/dept/list", REST_URL_PREFIX), Result.class);
    }

    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery() {
        return restTemplate.getForObject(String.format("%s/dept/discovery", REST_URL_PREFIX), Object.class);
    }


}
