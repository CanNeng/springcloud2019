package cn.qn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class MSZuulGateway9527App {

    public static void main(String[] args) {
        SpringApplication.run(MSZuulGateway9527App.class, args);
    }

}
