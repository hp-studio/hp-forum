package com.hpstudio.forummain.controller;

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

    /**
     * 注册接口
     * @param user
     * @return
     */
    @PostMapping("add")
    public Result add(@RequestBody User user) {
        boolean success = service.save(user);
        return Result.success(success ? "注册成功" : "服务器开小差啦");
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     * @throws Throwable
     */
    @PostMapping("update")
    public Result update(@RequestBody User user) throws Throwable {
        boolean success = service.updateUser(user);
        System.out.println(success);
        return Result.success(success ? "修改成功" : "服务器开小差啦");
    }

    /**
     * 删除用户
     * @param user
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @PostMapping("delete")
    public Result delete(@RequestBody User user) throws NoSuchFieldException, IllegalAccessException {
        boolean success = service.deleteUser(user);
        return Result.fail(success ? "用户删除成功" : "服务器开小差啦");
    }

    /**
     * 查询用户列表
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("getUsers")
    public Result getUsers(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        return Result.success(service.getUsers(page, limit));
    }

    /**
     * 查询某位用户具体信息
     * @param id
     * @return
     */
    @GetMapping("getUser")
    public Result getUser(@RequestParam("id") Integer id) {
        return Result.success(service.getUser(id));
    }
}
