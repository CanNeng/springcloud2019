package cn.qn.springcloud;

import cn.qn.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MS-DEPT",configuration = MySelfRule.class)//在启动该微服务的时候去加载自定义Ribbon配置类,从而使配置生效
public class MSConsumerDept80RibbonApp {
    public static void main(String[] args) {
        SpringApplication.run(MSConsumerDept80RibbonApp.class, args);
    }
}
