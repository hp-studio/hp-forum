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

    public boolean updateUser(User user) throws IllegalAccessException {
        UpdateWrapper<User> wrapper = updateWrapperUtil.updateWrapper(user, true);
        return update(wrapper);
    }

    public boolean deleteUser(User user) throws NoSuchFieldException, IllegalAccessException {
        UpdateWrapper<User> wrapper = updateWrapperUtil.deleteWrapper(user);
        return update(wrapper);
    }

    public IPage<User> getUsers(int page, int limit) {
        return baseMapper.getUsers(new Page<>(page, limit));
    }

    public User getUser(Integer id) {
        return baseMapper.getUser(id);
    }
}
