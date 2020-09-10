package com.hpstudio.forummain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hpstudio.forummain.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author mawen
 * @date 2020/9/9 10:27
 * @email 455766076@qq.com
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    User selectRoot();

    IPage<User> selectUsers(Page<User> page);
}
