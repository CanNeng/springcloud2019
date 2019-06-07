package cn.qn.springcloud.service.interfac;

import cn.qn.springcloud.entities.Dept;

import java.util.List;


public interface DeptService {
    boolean addDept(Dept dept);

    Dept findById(Long id);

    List<Dept> findAll();
}
