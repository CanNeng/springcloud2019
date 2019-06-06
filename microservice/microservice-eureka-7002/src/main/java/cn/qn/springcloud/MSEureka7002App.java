package cn.qn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MSEureka7002App {

    public static void main(String[] args) {
        SpringApplication.run(MSEureka7002App.class, args);
    }

}
