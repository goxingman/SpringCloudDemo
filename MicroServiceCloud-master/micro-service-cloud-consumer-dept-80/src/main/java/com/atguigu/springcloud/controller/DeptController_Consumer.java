package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {

//    private static final String REST_URL_PREFIX = "http://localhost:8001";

    private static final String REST_URL_PREFIX = "http://MICRO-SERVICE-CLOUD-DEPT";

    /**
     * 使用restTemplate访问RESTful接口
     * restTemplate.getForObject(URI url, Class<T> responseType)
     * restTemplate.postForObject(URI url, @Nullable Object request, Class<T> responseType)
     *
     * @param url           请求地址
     * @param request       请求参数
     * @param responseType  响应对应的对象类型
     */
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    //测试@EnableDiscoveryClient，服务消费端可以调用服务发现
    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
    }

}
