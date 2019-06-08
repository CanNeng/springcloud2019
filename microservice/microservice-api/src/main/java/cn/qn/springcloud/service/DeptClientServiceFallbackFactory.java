package cn.qn.springcloud.service;

import cn.qn.springcloud.entities.Dept;
import cn.qn.springcloud.entities.Result;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Result get(Long id) {
                return Result.error(String.format("数据库中找不到id为%s的记录", id));
            }

            @Override
            public Result list() {
                return Result.error("当前服务不可用");
            }

            @Override
            public Result add(Dept dept) {
                return Result.error("当前服务不可用");
            }
        };
    }
}
