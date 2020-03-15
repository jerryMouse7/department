package com.qiu.department.service.impl;

import com.qiu.department.entity.User;
import com.qiu.department.dao.UserDao;
import com.qiu.department.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void insertUser(Long departmentId, String studentName, String sno, String instituteName, String major, String room) {
        User user = new User();
        user.setDepartmentId(departmentId);
        user.setUsername(studentName);
        user.setSno(sno);
        user.setInstituteName(instituteName);
        user.setMajor(major);
        user.setRoom(room);
        user.setPassword(passwordEncoder.encode("11111111"));
        userDao.insertUser(user);
    }

    @Override
    public List<User> queryByDepartment(Long departmentId, String studentName, String sno, String instituteName, String major, String room, int page, int size) {
        User user = new User();
        user.setUsername(studentName);
        user.setDepartmentId(departmentId);
        user.setInstituteName(instituteName);
        user.setSno(sno);
        user.setMajor(major);
        user.setRoom(room);
        return userDao.queryByDepartment(user, page, size);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long id) {
        return this.userDao.queryById(id);
    }

    @Override
    public User queryByUsername(String username) {
        return userDao.queryByUsername(username);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.userDao.deleteById(id) > 0;
    }
}