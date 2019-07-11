package com.atguigu.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    @Bean
    @LoadBalanced//Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端的负载均衡工具
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule() {
//        return new RandomRule();//随机算法
        return new RetryRule();//重试算法
    }

}
