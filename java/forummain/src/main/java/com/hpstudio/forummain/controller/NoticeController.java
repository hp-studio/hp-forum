package com.hpstudio.forummain.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hpstudio.forummain.entity.Notice;
import com.hpstudio.forummain.entity.Result;
import com.hpstudio.forummain.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author mawen
 * @date 2020/9/17 9:23
 * @email 455766076@qq.com
 * @description 公告接口
 */
@RestController
@RequestMapping("notice")
public class NoticeController {

    @Autowired
    private NoticeService service;

    @PostMapping("add")
    public Result add(@RequestBody Notice notice) {
        boolean save = service.save(notice);
        return Result.success(save ? "新增公告成功" : "新增公告异常");
    }

    @PostMapping("update")
    public Result update(@RequestBody Notice notice) throws IllegalAccessException {
        boolean update = service.updateNotice(notice);
        return Result.success(update ? "更新公告成功" : "更新公告异常");
    }

    @PostMapping("delete")
    public Result delete(@RequestBody Notice notice) throws NoSuchFieldException, IllegalAccessException {
        boolean delete = service.deleteNotice(notice);
        return Result.success(delete ? "删除公告成功" : "删除公告异常");
    }

    @GetMapping("getNotices")
    public Result getNotices(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
        IPage<Notice> noticeList = service.getNoticeList(page, limit);
        return Result.success(noticeList.getRecords().isEmpty() ? "暂无公告" : noticeList);
    }

    @GetMapping("getNotice")
    public Result getNotice(@RequestParam("id") Integer id) {
        Notice notice = service.getNotice(id);
        return Result.success(null == notice ? "查询不到该公告" : notice);
    }
}
