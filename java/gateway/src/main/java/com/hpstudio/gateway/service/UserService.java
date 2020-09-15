package com.hpstudio.gateway.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hpstudio.gateway.entity.User;
import com.hpstudio.gateway.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author mawen
 * @date 2020/9/10 15:11
 * @email 455766076@qq.com
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    public User selectUserById(int id) {
        return baseMapper.selectUserById(id);
    }
}
