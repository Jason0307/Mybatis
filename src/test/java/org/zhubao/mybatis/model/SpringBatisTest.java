package org.zhubao.mybatis.model;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zhubao.mybatis.mapper.ArticleMapper;
import org.zhubao.mybatis.mapper.UserMapper;

public class SpringBatisTest {
    private  ApplicationContext aContext = null;
    @Before
    public void initConfiguration() {
         aContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    
    @Test
    public void testSpring() {
        UserMapper userMapper = (UserMapper) aContext.getBean("userMapper");
        System.out.println(userMapper.findById(1));
        
        ArticleMapper articleMapper = (ArticleMapper) aContext.getBean("articleMapper");
        System.out.println(articleMapper.findById(1));
    }
}
