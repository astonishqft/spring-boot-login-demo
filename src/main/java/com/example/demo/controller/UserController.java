package com.example.demo.controller;

import com.example.demo.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.utils.Result;
import com.example.demo.domain.User;
// import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
  @Resource
  private UserService userService;

  @GetMapping("/test")
  public String testController() {
    return "hello";
  }
  
  @PostMapping("/login")
  public Result<User> loginController(@RequestParam String uname, @RequestParam String password) {
    User user = userService.loginService(uname, password);
    if(user != null) {
      return Result.success(user, "登录成功!");
    }
    return Result.error("123", "账号或密码出错!");
  }
  
  @PostMapping("/register")
  public Result<User> registController(@RequestBody User newUser) {
    User user = userService.registService(newUser);
    if(user != null) {
      return Result.success(user, "注册成功!");
    }
    return Result.error("456", "用户名已存在!");
  }
}
