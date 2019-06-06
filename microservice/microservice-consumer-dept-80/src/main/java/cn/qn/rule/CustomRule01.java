package cn.qn.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import java.util.List;

/**
 * 源码参考地址 https://github.com/Netflix/ribbon/blob/master/ribbon-loadbalancer/src/main/java/com/netflix/loadbalancer/RandomRule.java
 */
public class CustomRule01 extends AbstractLoadBalancerRule {
    private static int total = 0;//总共给调用的次数,目前要求每台被调用5次
    private static int currentIndex = 0;//当前下标

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) return null;
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) return null;

            int index = getNextIndex(lb);
            server = upList.get(index);

            if (server == null) {
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }
            server = null;
            Thread.yield();
        }
        return server;

    }

    public int getNextIndex(ILoadBalancer lb) {
        if (total != 0 && total % 5 == 0) {
            currentIndex++;
            currentIndex = currentIndex % lb.getReachableServers().size();
        }
        total++;
        return currentIndex;
    }


    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }
}
