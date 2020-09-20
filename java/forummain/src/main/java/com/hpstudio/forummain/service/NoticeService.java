package com.hpstudio.forummain.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hpstudio.forummain.entity.Notice;
import com.hpstudio.forummain.mapper.NoticeMapper;
import com.hpstudio.forummain.util.UpdateWrapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mawen
 * @date 2020/9/17 9:22
 * @email 455766076@qq.com
 * @description 公告实现类
 */
@Service
public class NoticeService extends ServiceImpl<NoticeMapper, Notice> {
    @Autowired
    private UpdateWrapperUtil<Notice> updateWrapperUtil;

    public boolean updateNotice(Notice notice) throws IllegalAccessException {
        UpdateWrapper<Notice> wrapper = updateWrapperUtil.updateWrapper(notice, true);
        return update(wrapper);
    }

    public boolean deleteNotice(Notice notice) throws NoSuchFieldException, IllegalAccessException {
        UpdateWrapper<Notice> wrapper = updateWrapperUtil.deleteWrapper(notice);
        return update(wrapper);
    }

    public IPage<Notice> getNoticeList(Integer page, Integer limit) {
        return baseMapper.getNoticeList(new Page<>(page, limit));
    }

    public Notice getNotice(Integer id) {
        return baseMapper.getNotice(id);
    }
}
