package com.qiu.department.service.impl;

import com.qiu.department.entity.Visitor;
import com.qiu.department.dao.VisitorDao;
import com.qiu.department.service.VisitorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;


@Service("visitorService")
public class VisitorServiceImpl implements VisitorService {
    @Resource
    private VisitorDao visitorDao;

    @Override
    public Integer addVisitor(String name, String phone, String address, String visitorRoom, String reason, LocalDateTime localDateTime, Long departmentId) {
        Visitor visitor  =new Visitor();

        visitor.setName(name);
        visitor.setPhone(phone);
        visitor.setAddress(address);
        visitor.setVisitorRoom(visitorRoom);
        visitor.setDeparmentId(departmentId);
        visitor.setReason(reason);
        visitor.setVisitorTime(localDateTime);
        return visitorDao.insert(visitor);

    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Visitor queryById(Long id) {
        return this.visitorDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Visitor> queryAllByLimit(int offset, int limit) {
        return this.visitorDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param visitor 实例对象
     * @return 实例对象
     */
    @Override
    public Visitor insert(Visitor visitor) {
        this.visitorDao.insert(visitor);
        return visitor;
    }

    /**
     * 修改数据
     *
     * @param visitor 实例对象
     * @return 实例对象
     */
    @Override
    public Visitor update(Visitor visitor) {
        this.visitorDao.update(visitor);
        return this.queryById(visitor.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.visitorDao.deleteById(id) > 0;
    }
}