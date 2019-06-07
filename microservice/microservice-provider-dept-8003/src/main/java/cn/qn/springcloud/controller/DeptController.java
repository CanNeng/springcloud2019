package cn.qn.springcloud.controller;

import cn.qn.springcloud.entities.Dept;
import cn.qn.springcloud.service.interfac.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return deptService.addDept(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Object get(@PathVariable("id") Long id) {
        return deptService.findById(id);
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
        return deptService.findAll();
    }

    @RequestMapping(value="/dept/discovery",method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        System.out.println("getServices:" + list);
        List<ServiceInstance> srvList = discoveryClient.getInstances("MS-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(String.format("serviceId:%s,host:%s,port:%s,url:%s",element.getServiceId(),element.getHost(),element.getPort(),element.getUri()));
        }
        return this.discoveryClient.getServices();
    }

}
