package cn.qn.springcloud.cfgbeans;

import com.netflix.loadbalancer.*;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced//开启负载均衡,轮询算法
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule() {
        //return new RetryRule();//先按照RoundRobinRule的策略获取服务,如果获取服务失败则在指定时间内会进行重试,获取可用服务
        //return new WeightedResponseTimeRule();//根据响应时间分配一个weight，响应时间越长，weight越小，被选中的可能性越低。
        return new RoundRobinRule();//修改修改负载均衡算法为轮询算法,默认为轮询算法
        //return new RandomRule();//修改负载均衡算法为随机算法,默认为轮询算法
    }

}
