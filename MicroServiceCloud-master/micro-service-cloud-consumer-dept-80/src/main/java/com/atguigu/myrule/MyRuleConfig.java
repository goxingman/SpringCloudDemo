package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRuleConfig {

    @Bean
    public IRule myRule() {
        return new MyRule();//自定义轮询算法，每台服务器连续提供5次服务后切换
    }

}
