package com.qiu.department.service.impl;

import com.qiu.department.entity.Repair;
import com.qiu.department.dao.RepairDao;
import com.qiu.department.service.RepairService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;


@Service("repairService")
public class RepairServiceImpl implements RepairService {
    @Resource
    private RepairDao repairDao;

    @Override
    public Integer addRepair(String username, String sno, Long deparmtentId, String room, String device, LocalDateTime createTime, String reason) {
        Repair repair = new Repair();
        repair.setUsername(username);
        repair.setSno(sno);
        repair.setDepartmentId(deparmtentId);
        repair.setRoom(room);
        repair.setReason(reason);
        repair.setDevice(device);
        repair.setCreateTime(createTime);
        repair.setUpdateTime(createTime);
        return repairDao.insert(repair);
    }

    @Override
    public void updateStatus(Long id, int status) {
        repairDao.updateStatus(id, status);
    }

    @Override
    public List<Repair> getRepair(String studentName, String sno, String instituteName, String major, String room, Integer status, int page, int size) {
        Repair repair = new Repair();
        repair.setUsername(studentName);
        repair.setSno(sno);
        repair.setMajor(major);
        repair.setInstituteName(instituteName);
        repair.setRoom(room);
        repair.setState(status);
        return repairDao.getRepair(repair, page, size);
    }

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
     * @param limit  查询条数
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