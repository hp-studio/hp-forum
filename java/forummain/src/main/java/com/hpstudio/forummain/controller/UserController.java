package com.hpstudio.forummain.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hpstudio.forummain.entity.Result;
import com.hpstudio.forummain.entity.User;
import com.hpstudio.forummain.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author mawen
 * @date 2020/9/9 9:33
 * @email 455766076@qq.com
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("login")
    public Result login(@RequestBody User user) throws Throwable {
        boolean login = service.login(user);
        return Result.success(login ? "登录成功" : "账号或密码错误");
    }

    @PostMapping("update")
    public Result update(@RequestBody User user) throws Throwable {
        boolean success = service.updateUser(user);
        return Result.success(success ? "修改成功" : "服务器开小差啦");
    }

    @GetMapping("getUsers")
    public Result getUsers(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        return Result.success(service.selectUsers(page, limit));
    }
}
