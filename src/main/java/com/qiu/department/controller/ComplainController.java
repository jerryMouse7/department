package com.qiu.department.controller;

import com.qiu.department.entity.Complain;
import com.qiu.department.service.ComplainService;
import com.qiu.department.utils.Result;
import com.qiu.department.utils.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/complain")
public class ComplainController {
    /**
     * 服务对象
     */
    @Resource
    private ComplainService complainService;


    @PostMapping("")
    public Result<String> addComplain(@RequestParam("username")String username,
                                      @RequestParam("departmentName")Long departmentName,
                                      @RequestParam("room")String room,
                                      @RequestParam("title")String title,
                                      @RequestParam("content")String content){

        Integer res = complainService.addComplain(username, departmentName, room, title, content);
        if (res > 0 ){
            return ResultUtil.sucess("添加成功");
        }
        return ResultUtil.error("添加失败");
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Complain selectOne(Long id) {
        return this.complainService.queryById(id);
    }

}