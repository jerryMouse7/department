package com.qiu.department.controller;

import com.qiu.department.entity.User;
import com.qiu.department.service.UserService;
import com.qiu.department.utils.Result;
import com.qiu.department.utils.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Long id, Principal principal) {
        System.out.println(principal.getName());
        return this.userService.queryById(id);
    }

    @GetMapping("/all")
    public Result<User> selectAll(){
        List<User> users =  userService.queryAllByLimit(0,10);
        return ResultUtil.sucess(users);
    }

}