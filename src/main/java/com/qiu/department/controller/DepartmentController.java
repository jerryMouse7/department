package com.qiu.department.controller;

import com.qiu.department.entity.Department;
import com.qiu.department.entity.User;
import com.qiu.department.service.DepartmentService;
import com.qiu.department.service.UserService;
import com.qiu.department.utils.Result;
import com.qiu.department.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    /**
     * 服务对象
     */
    @Resource
    private DepartmentService departmentService;

    @Autowired
    private UserService userService;


    @GetMapping("")
    public Result<List<Department>> getAllDepartment() {

        List<Department> departmentList = departmentService.queryAllByLimit(0, 100);

        return ResultUtil.sucess(departmentList);
    }

    @GetMapping("/{departmentId}")
    public Result<List<User>> getStudent(@PathVariable(value = "departmentId",required = false) Long departmentId,
                                         @RequestParam(value = "studentName",required = false) String studentName,
                                         @RequestParam(value = "sno",required = false) String sno,
                                         @RequestParam(value = "instituteName",required = false) String instituteName,
                                         @RequestParam(value = "major",required = false) String major,
                                         @RequestParam(value = "room",required = false) String room,
                                         @RequestParam(value = "page",required = false) Integer _page,
                                         @RequestParam(value = "size",required = false) Integer _size) {

        int page = Objects.nonNull(_page) ? _page - 1 : 0;
        int size = Objects.nonNull(_size) ? _size : 10;
        List<User> userList = userService.queryByDepartment(departmentId, studentName, sno, instituteName, major, room, page, size);
        return ResultUtil.sucess(userList);

    }

    @PostMapping("/{departmentId}")
    public Result<String> addStudent(@PathVariable("departmentId") Long departmentId,
                                     @RequestParam("studentName") String studentName,
                                     @RequestParam("sno") String sno,
                                     @RequestParam("instituteName") String instituteName,
                                     @RequestParam("major") String major,
                                     @RequestParam("room") String room,
                                     @RequestParam(value = "departmentId",required = false) Long departmentParam) {
        Long realDepartment = Objects.nonNull(departmentParam) ? departmentParam : departmentId;

        userService.insertUser(realDepartment, studentName, sno, instituteName, major, room);
        return ResultUtil.sucess("添加成功");
    }

    @DeleteMapping
    public Result<String> deleteStudent(@RequestParam("studentId") Long studentId) {
        userService.deleteById(studentId);
        return ResultUtil.sucess("删除成功");
    }


}