package org.zhubao.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zhubao.mybatis.mapper.UserMapper;
import org.zhubao.mybatis.model.User;

@Controller
public class UserController {

    @Autowired
    @Qualifier("userMapper")
    private UserMapper userMapper;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable("id") int id) {

        return userMapper.findById(id);
    }
}
