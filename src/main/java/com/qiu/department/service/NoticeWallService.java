package com.qiu.department.service;

import com.qiu.department.entity.NoticeWall;
import java.util.List;


public interface NoticeWallService {

    Integer addNoticeWall(String title,String content,String source);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    NoticeWall queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<NoticeWall> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param noticeWall 实例对象
     * @return 实例对象
     */
    NoticeWall insert(NoticeWall noticeWall);

    /**
     * 修改数据
     *
     * @param noticeWall 实例对象
     * @return 实例对象
     */
    NoticeWall update(NoticeWall noticeWall);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}