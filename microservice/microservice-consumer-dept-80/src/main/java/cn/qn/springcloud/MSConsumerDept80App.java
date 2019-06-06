package cn.qn.springcloud;

import cn.qn.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MS-DEPT",configuration = MySelfRule.class)
public class MSConsumerDept80App {
    public static void main(String[] args) {
        SpringApplication.run(MSConsumerDept80App.class, args);
    }
}
