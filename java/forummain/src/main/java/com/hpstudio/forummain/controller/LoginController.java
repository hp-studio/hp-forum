package com.hpstudio.forummain.controller;

import com.hpstudio.forummain.entity.Result;
import com.hpstudio.forummain.entity.User;
import com.hpstudio.forummain.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mawen
 * @date 2020/9/9 9:33
 * @email 455766076@qq.com
 */
@RestController
@RequestMapping("user")
@Slf4j
public class LoginController {
    @Autowired
    private UserService service;

    @PostMapping("login")
    public Result login(@RequestBody User user) {
        try {
            boolean login = service.login(user);
            return Result.success(login ? "登录成功" : "账号或密码错误");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Result.fail();
        }
    }

    @PostMapping("update")
    public Result update(@RequestBody User user) {
        try {
            boolean success = service.updateUser(user);
            return Result.success(success ? "修改成功" : "服务器开小差啦");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Result.fail();
        }
    }
}
