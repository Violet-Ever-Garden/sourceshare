package com.hw649.sources_share.service;

import com.hw649.sources_share.mapper.UserMapper;
import com.hw649.sources_share.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;

import javax.websocket.OnClose;
import java.sql.Date;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;
    @Override
    public User selectUserByName(String name){
        return userMapper.selectUserByName(name);
    }

    @Override
    public User selectUserByEmail(String email){
        return userMapper.selectUserByEmail(email);
    }

    public User packege(String email, String name, String pwd, String signature,int age){
        Date time = new java.sql.Date(new java.util.Date().getTime());
        return new User(email,name,pwd,time,"user:add","这个人很懒，什么都没有留下",age);
    }

    @Override
    public void insertUser(User user){
        userMapper.insertUser(user);
        System.out.println(user.toString());
        System.out.println("注册");
    }
}
