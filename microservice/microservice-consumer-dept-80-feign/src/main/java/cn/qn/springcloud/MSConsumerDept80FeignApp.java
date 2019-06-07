package cn.qn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"cn.qn.springcloud"})
public class MSConsumerDept80FeignApp {
    public static void main(String[] args) {
        SpringApplication.run(MSConsumerDept80FeignApp.class, args);
    }
}
