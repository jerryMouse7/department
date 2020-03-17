package com.qiu.department.service;

import com.qiu.department.entity.Visitor;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

public interface VisitorService {

    Integer addVisitor(String name, String phone, String address, String visitorRoom, String reason, LocalDateTime localDateTime, Long departmentId);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Visitor queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Visitor> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param visitor 实例对象
     * @return 实例对象
     */
    Visitor insert(Visitor visitor);

    /**
     * 修改数据
     *
     * @param visitor 实例对象
     * @return 实例对象
     */
    Visitor update(Visitor visitor);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}