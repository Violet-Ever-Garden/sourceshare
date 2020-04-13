package com.hw649.sources_share.service;

import com.hw649.sources_share.pojo.User;

public interface UserService {
    public User selectUserByName(String name);
    public User selectUserByEmail(String email);
    public void insertUser(User user);
}
