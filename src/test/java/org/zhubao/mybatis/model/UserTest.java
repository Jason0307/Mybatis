package org.zhubao.mybatis.model;

import java.util.List;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.zhubao.mybatis.config.MybatisTool;
import org.zhubao.mybatis.mapper.UserMapper;
import org.zhubao.mybatis.util.Md5Util;

public class UserTest {
    SqlSessionFactory sessionFactory = MybatisTool.getSessionFacoty();
    SqlSession session = sessionFactory.openSession();
    UserMapper userMapper = session.getMapper(UserMapper.class);
    @Test
    public void testConfigMybatis() {
        Assert.assertNotNull(MybatisTool.getSessionFacoty());
    }
    
    @Test
    public void testFindByUserId() {
        //User user = session.selectOne("org.zhubao.mybatis.mapper.UserMapper.findById", 1);
        User user = userMapper.findById(1);
        System.out.println(user);
    }
    
    @Test
    public void testSaveUser() {
        User user = new User();
        user.setAge(25);
        user.setEmail("baogee" + new Random().nextInt(10000) + "@vip.qq.com");
        user.setPassword(Md5Util.md5("123456"));
        user.setUsername("Jason" + new Random().nextInt(10000));
        session.insert("org.zhubao.mybatis.mapper.UserMapper.save", user);
        session.commit();
    }
    
    @Test
    public void testFindAll() {
        List<User> users = userMapper.findAll();
        for(User user : users) {
            System.out.println("User:" + user.getId() + " [ " + user + "]");
        }
    }
}
