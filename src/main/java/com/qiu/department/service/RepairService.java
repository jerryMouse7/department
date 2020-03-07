package com.qiu.department.service;

import com.qiu.department.entity.Repair;
import java.util.List;


public interface RepairService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Repair queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Repair> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param repair 实例对象
     * @return 实例对象
     */
    Repair insert(Repair repair);

    /**
     * 修改数据
     *
     * @param repair 实例对象
     * @return 实例对象
     */
    Repair update(Repair repair);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}