package com.qiu.department.controller;

import com.qiu.department.entity.Repair;
import com.qiu.department.service.RepairService;
import com.qiu.department.utils.Result;
import com.qiu.department.utils.ResultUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
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

    @PostMapping("")
    public Result<String> addRepair(@RequestParam("username") String username,
                                    @RequestParam("sno") String sno,
                                    @RequestParam("departmentId") Long deparmtentId,
                                    @RequestParam("room") String room,
                                    @RequestParam("device") String device,
                                    @RequestParam("createTime") LocalDateTime createTime,
                                    @RequestParam("reason") String reason) {
        Integer res = repairService.addRepair(username, sno, deparmtentId, room, device, createTime, reason);
        if (res > 0) {
            return ResultUtil.sucess("新增成功");
        }
        return ResultUtil.error("新增失败");

    }


    @PreAuthorize("hasRole('admin')")
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

    @DeleteMapping("")
    public Result<String> deleteRepair(@RequestParam("id") Long id) {
        repairService.deleteById(id);
        return ResultUtil.sucess("删除成功");
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