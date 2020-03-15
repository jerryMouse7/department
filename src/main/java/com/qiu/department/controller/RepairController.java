package com.qiu.department.controller;

import com.qiu.department.entity.Repair;
import com.qiu.department.service.RepairService;
import com.qiu.department.utils.Result;
import com.qiu.department.utils.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("repair")
public class RepairController {
    /**
     * 服务对象
     */
    @Resource
    private RepairService repairService;


    @GetMapping("")
    public Result<Repair> getRepair(@RequestParam(value = "studentName", required = false) String studentName,
                                    @RequestParam(value = "sno", required = false) String sno,
                                    @RequestParam(value = "instituteName", required = false) String instituteName,
                                    @RequestParam(value = "major", required = false) String major,
                                    @RequestParam(value = "room", required = false) String room,
                                    @RequestParam(value = "statue", required = false) Integer status,
                                    @RequestParam(value = "page", required = false) Integer _page,
                                    @RequestParam(value = "size", required = false) Integer _size) {


        int page = Objects.nonNull(_page) ? _page - 1 : 0;
        int size = Objects.nonNull(_size) ? _size : 10;
        List<Repair> repairs = repairService.getRepair(studentName, sno, instituteName, major, room, status, page, size);
        return ResultUtil.sucess(repairs);

    }

    @PutMapping("/status")
    public Result<String> updateStatus(@RequestParam("repairId") Long repairId,
                                       @RequestParam("status") int status) {
        repairService.updateStatus(repairId, status);
        return ResultUtil.sucess("修改成功");

    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Repair selectOne(Long id) {
        return this.repairService.queryById(id);
    }

}