package com.example.demo.service.serviceImpl;

import javax.annotation.Resource;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserDao;

@Service
public class UserServiceImpl implements UserService {
  @Resource
  private UserDao userDao;

  @Override
  public User loginService(String uname, String password) {
    // 验证用户名和密码，若有一个错误则返回null
    User user = userDao.findByUnameAndPassword(uname, password);

    // 如果验证成功，需要将密码清空，避免返回给前台重要信息
    if(user != null) {
      user.setPassword("");
    }
    return user;
  }

  @Override
  public User registService(User user) {
    // 注册之前先判断下用户名是否已经存在
    if(userDao.findByUname(user.getUname()) != null) {
      return null;
    } else {
      User newUser = userDao.save(user);
      if(newUser != null) {
        newUser.setPassword("");
      }
      return newUser;
    }
  }
}
