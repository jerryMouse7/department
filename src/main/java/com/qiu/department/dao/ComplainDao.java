package com.qiu.department.dao;

import com.qiu.department.entity.Complain;
import org.apache.ibatis.annotations.Param;
import java.util.List;


public interface ComplainDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Complain queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Complain> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param complain 实例对象
     * @return 对象列表
     */
    List<Complain> queryAll(Complain complain);

    /**
     * 新增数据
     *
     * @param complain 实例对象
     * @return 影响行数
     */
    int insert(@Param("complain") Complain complain);

    /**
     * 修改数据
     *
     * @param complain 实例对象
     * @return 影响行数
     */
    int update(Complain complain);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}