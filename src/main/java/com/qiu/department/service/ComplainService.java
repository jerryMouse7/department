package com.qiu.department.service;

import com.qiu.department.entity.Complain;
import java.util.List;


public interface ComplainService {

    Integer addComplain(String username, Long departmentName,String room, String title, String content);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Complain queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Complain> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param complain 实例对象
     * @return 实例对象
     */
    Complain insert(Complain complain);

    /**
     * 修改数据
     *
     * @param complain 实例对象
     * @return 实例对象
     */
    Complain update(Complain complain);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}