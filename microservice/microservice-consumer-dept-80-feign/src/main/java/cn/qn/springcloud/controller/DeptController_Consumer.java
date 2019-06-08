package cn.qn.springcloud.controller;

import cn.qn.springcloud.entities.Dept;
import cn.qn.springcloud.entities.Result;
import cn.qn.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController_Consumer {

    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping(value = "/consumer/dept/get/{id}", method = {RequestMethod.GET})
    public Result get(@PathVariable("id") Long id) {
        return this.deptClientService.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list", method = {RequestMethod.GET})
    public Result list() {
        return this.deptClientService.list();
    }

    @RequestMapping(value = "/consumer/dept/add", method = {RequestMethod.POST})
    public Result add(Dept dept) {
        return this.deptClientService.add(dept);
    }
}
