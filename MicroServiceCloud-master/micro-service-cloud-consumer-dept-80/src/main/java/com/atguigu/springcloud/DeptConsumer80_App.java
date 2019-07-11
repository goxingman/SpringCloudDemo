package com.atguigu.springcloud;

import com.atguigu.myrule.MyRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

//在启动该微服务的时候就能去加载我们自定义的Ribbon配置类，从而使配置生效
@RibbonClient(name = "MICRO-SERVICE-CLOUD-DEPT", configuration = MyRuleConfig.class)
@EnableEurekaClient
@SpringBootApplication
public class DeptConsumer80_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_App.class, args);
    }

}
