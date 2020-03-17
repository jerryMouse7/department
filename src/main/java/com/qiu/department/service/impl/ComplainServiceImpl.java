package com.qiu.department.service.impl;

import com.qiu.department.entity.Complain;
import com.qiu.department.dao.ComplainDao;
import com.qiu.department.service.ComplainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("complainService")
public class ComplainServiceImpl implements ComplainService {
    @Resource
    private ComplainDao complainDao;

    @Override
    public Integer addComplain(String username, Long departmentName, String room, String title, String content) {
        Complain complain = new Complain();
        complain.setUsername(username);
        complain.setDepartmentName(departmentName.toString());
        complain.setRoom(room);
        complain.setTitle(title);
        complain.setContent(content);
        return complainDao.insert(complain);

    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Complain queryById(Long id) {
        return this.complainDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Complain> queryAllByLimit(int offset, int limit) {
        return this.complainDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param complain 实例对象
     * @return 实例对象
     */
    @Override
    public Complain insert(Complain complain) {
        this.complainDao.insert(complain);
        return complain;
    }

    /**
     * 修改数据
     *
     * @param complain 实例对象
     * @return 实例对象
     */
    @Override
    public Complain update(Complain complain) {
        this.complainDao.update(complain);
        return this.queryById(complain.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.complainDao.deleteById(id) > 0;
    }
}