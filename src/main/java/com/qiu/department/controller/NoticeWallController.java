package com.qiu.department.controller;

import com.qiu.department.entity.NoticeWall;
import com.qiu.department.service.NoticeWallService;
import com.qiu.department.utils.Result;
import com.qiu.department.utils.ResultUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/noticeWall")
public class NoticeWallController {
    /**
     * 服务对象
     */
    @Resource
    private NoticeWallService noticeWallService;


    @PreAuthorize("hasRole('admin')")
    @PostMapping("")
    public Result<String> addNoticeWall(@RequestParam("title")String title,
                                        @RequestParam("content")String content,
                                        @RequestParam("source")String source){

        Integer res =noticeWallService.addNoticeWall(title,content,source);
        if(res >0 ){
            return ResultUtil.sucess("添加成功");
        }

        return ResultUtil.sucess("添加失败");
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public NoticeWall selectOne(Long id) {
        return this.noticeWallService.queryById(id);
    }

}