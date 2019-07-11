package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 服务降级
 * 新建一个实现FallbackFactory接口的类DeptClientServiceFallbackFactory
 */
@Component//不要忘记添加
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(long id) {
                return new Dept().setDeptNo(id).setDeptName("该ID：" + id + "没有对应的信息，服务降级信息来自@FeignClient#fallbackFactory").setDbSource("no this database in MySQL");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }

}
