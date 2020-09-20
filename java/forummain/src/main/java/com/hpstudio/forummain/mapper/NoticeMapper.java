package com.hpstudio.forummain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hpstudio.forummain.entity.Notice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author mawen
 * @date 2020/9/17 9:21
 * @email 455766076@qq.com
 * @description 公告sql
 */
@Repository
public interface NoticeMapper extends BaseMapper<Notice> {

    IPage<Notice> getNoticeList(Page<Notice> page);

    Notice getNotice(@Param("id") Integer id);
}
