package com.qiu.department.service.impl;

import com.qiu.department.entity.Repair;
import com.qiu.department.dao.RepairDao;
import com.qiu.department.service.RepairService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("repairService")
public class RepairServiceImpl implements RepairService {
    @Resource
    private RepairDao repairDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Repair queryById(Long id) {
        return this.repairDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Repair> queryAllByLimit(int offset, int limit) {
        return this.repairDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param repair 实例对象
     * @return 实例对象
     */
    @Override
    public Repair insert(Repair repair) {
        this.repairDao.insert(repair);
        return repair;
    }

    /**
     * 修改数据
     *
     * @param repair 实例对象
     * @return 实例对象
     */
    @Override
    public Repair update(Repair repair) {
        this.repairDao.update(repair);
        return this.queryById(repair.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.repairDao.deleteById(id) > 0;
    }
}