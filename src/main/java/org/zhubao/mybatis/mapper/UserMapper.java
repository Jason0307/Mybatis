package org.zhubao.mybatis.mapper;

import java.util.List;

import org.zhubao.mybatis.model.User;

public interface UserMapper {

    public void save(User user);

    public User findById(int id);
    
    public List<User> findAll();
}
