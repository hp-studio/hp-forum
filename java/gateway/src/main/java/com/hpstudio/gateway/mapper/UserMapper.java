package com.hpstudio.gateway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hpstudio.gateway.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author mawen
 * @date 2020/9/10 15:07
 * @email 455766076@qq.com
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    User selectUserById(@Param("id") int id);
}
