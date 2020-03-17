package com.qiu.department.dao;

import com.qiu.department.entity.NoticeWall;
import org.apache.ibatis.annotations.Param;
import java.util.List;


public interface NoticeWallDao {

    Integer addNoticeWall(@Param("noticeWall") NoticeWall noticeWall);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    NoticeWall queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<NoticeWall> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param noticeWall 实例对象
     * @return 对象列表
     */
    List<NoticeWall> queryAll(NoticeWall noticeWall);

    /**
     * 新增数据
     *
     * @param noticeWall 实例对象
     * @return 影响行数
     */
    int insert(NoticeWall noticeWall);

    /**
     * 修改数据
     *
     * @param noticeWall 实例对象
     * @return 影响行数
     */
    int update(NoticeWall noticeWall);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}