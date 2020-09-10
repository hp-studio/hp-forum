package com.hpstudio.forummain.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hpstudio.forummain.entity.User;
import com.hpstudio.forummain.mapper.UserMapper;
import com.hpstudio.forummain.util.UpdateWrapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mawen
 * @date 2020/9/9 10:25
 * @email 455766076@qq.com
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    @Autowired
    private UpdateWrapperUtil<User> updateWrapperUtil;

    public boolean login(User user) {
        //目前限定只能root用户登录
        User root = baseMapper.selectRoot();
        if (root.getId() == user.getId()) {
            return true;
        }
        return false;
    }

    public boolean updateUser(User user) throws IllegalAccessException {
        UpdateWrapper<User> wrapper = updateWrapperUtil.updateWrapper(user, true);
        return update(wrapper);
    }

    public IPage<User> selectUsers(int page, int limit) {
        return baseMapper.selectUsers(new Page<>(page, limit));
    }
}
