package cn.qn.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable {
    private long deptNo;//主键
    private String deptName;//部门名称
    private String dbSource;//来自那个数据库,因为微服务架构可以一个服务对应一个数据库,同一个信息被存储到不同数据库
}
