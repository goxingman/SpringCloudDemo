package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService = null;

    /**
     * 服务熔断
     * 一旦调用服务方法失败并抛出异常信息后，会自动调用@HystrixCommand中fallbackMethod指定的此类中的方法
     */
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = deptService.get(id);

        if (null == dept) {
            throw new RuntimeException("该ID：" + id + "没有对应的信息");
        }

        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id) {
        return new Dept().setDeptNo(id).setDeptName("该ID：" + id + "没有对应的信息，服务熔断信息来自@HystrixCommand#fallbackMethod").setDbSource("no this database in MySQL");
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
        return deptService.list();
    }

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return deptService.add(dept);
    }

}
