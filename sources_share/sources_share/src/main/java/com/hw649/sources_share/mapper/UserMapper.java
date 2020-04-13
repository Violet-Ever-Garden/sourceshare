package com.hw649.sources_share.mapper;

import com.hw649.sources_share.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    public User selectUserByName(String name);
    public User selectUserByEmail(String email);
    public void insertUser(User user);
}
