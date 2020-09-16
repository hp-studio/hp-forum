package com.hpstudio.gateway.controller;

import com.hpstudio.gateway.entity.Result;
import com.hpstudio.gateway.entity.User;
import com.hpstudio.gateway.exception.exceptionType.PasswordErrorException;
import com.hpstudio.gateway.exception.exceptionType.UserNotExistException;
import com.hpstudio.gateway.login.annotation.CheckToken;
import com.hpstudio.gateway.login.annotation.LoginToken;
import com.hpstudio.gateway.login.util.JwtUtil;
import com.hpstudio.gateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author mawen
 * @date 2020/9/10 15:19
 * @email 455766076@qq.com
 */
@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping("login")
    @LoginToken(required = true)
    public Result login(@RequestBody User user) {
        User u = userService.selectUserById(user.getId());
        if (null == u) {
            throw new UserNotExistException();
        }
        if (!user.getPassword().equals(u.getPassword())) {
            throw new PasswordErrorException();
        }
        String token = JwtUtil.createJWT(600000, u);
        return Result.success(token);
    }

    @GetMapping("getUserInfo")
    @CheckToken
    public Result getUserInfo(@RequestParam("id") int id) {
        User user = userService.selectUserById(id);
        return Result.success(user);
    }
}
