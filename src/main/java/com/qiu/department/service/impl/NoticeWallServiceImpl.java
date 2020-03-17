package com.qiu.department.service.impl;

import com.qiu.department.entity.NoticeWall;
import com.qiu.department.dao.NoticeWallDao;
import com.qiu.department.service.NoticeWallService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;


@Service("noticeWallService")
public class NoticeWallServiceImpl implements NoticeWallService {
    @Resource
    private NoticeWallDao noticeWallDao;

    @Override
    public Integer addNoticeWall(String title, String content, String source) {
        NoticeWall noticeWall = new NoticeWall();
        noticeWall.setTitle(title);
        noticeWall.setContent(content);
        noticeWall.setSource(source);
        noticeWall.setCreateTime(LocalDateTime.now());
        return noticeWallDao.addNoticeWall(noticeWall);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public NoticeWall queryById(Long id) {
        return this.noticeWallDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<NoticeWall> queryAllByLimit(int offset, int limit) {
        return this.noticeWallDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param noticeWall 实例对象
     * @return 实例对象
     */
    @Override
    public NoticeWall insert(NoticeWall noticeWall) {
        this.noticeWallDao.insert(noticeWall);
        return noticeWall;
    }

    /**
     * 修改数据
     *
     * @param noticeWall 实例对象
     * @return 实例对象
     */
    @Override
    public NoticeWall update(NoticeWall noticeWall) {
        this.noticeWallDao.update(noticeWall);
        return this.queryById(noticeWall.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.noticeWallDao.deleteById(id) > 0;
    }
}