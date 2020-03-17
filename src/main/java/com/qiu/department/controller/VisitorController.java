package com.qiu.department.controller;

import com.qiu.department.entity.Visitor;
import com.qiu.department.service.VisitorService;
import com.qiu.department.utils.Result;
import com.qiu.department.utils.ResultUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;


@RestController
@RequestMapping("/visitor")
public class VisitorController {
    /**
     * 服务对象
     */
    @Resource
    private VisitorService visitorService;


    @PreAuthorize("hasRole('admin')")
    @PostMapping("")
    public Result<String> addVisitor(@RequestParam("name") String name,
                                     @RequestParam("phone") String phone,
                                     @RequestParam("address") String address,
                                     @RequestParam("visitorRoom") String visitorRoom,
                                     @RequestParam("reason") String reason,
                                     @RequestParam("visitorTime") LocalDateTime localDateTime,
                                     @RequestParam(value = "departmentId", defaultValue = "1") Long departmentId) {

        Integer res = visitorService.addVisitor(name, phone, address, visitorRoom, reason, localDateTime, departmentId);
        if (res > 0) {
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
    public Visitor selectOne(Long id) {
        return this.visitorService.queryById(id);
    }

}