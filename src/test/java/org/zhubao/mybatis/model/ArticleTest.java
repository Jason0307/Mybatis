package org.zhubao.mybatis.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.zhubao.mybatis.config.MybatisTool;
import org.zhubao.mybatis.mapper.ArticleMapper;
import org.zhubao.mybatis.mapper.UserMapper;

public class ArticleTest {
    SqlSessionFactory sessionFactory = MybatisTool.getSessionFacoty();
    SqlSession session = sessionFactory.openSession();
    ArticleMapper articleMapper = session.getMapper(ArticleMapper.class);
    UserMapper userMapper = session.getMapper(UserMapper.class);
    
    @Test
    public void testSave(){
        Article article = new Article();
        article.setTitle("Have a nice dream");
        article.setContent("Today is a good day!");
        User user = userMapper.findById(1);
        article.setUser(user);
        articleMapper.save(article);
        session.commit();
        
    }
    
    @Test
    public void testFindById() {
        Article article = articleMapper.findById(1);
        System.out.println(article);
    }
    
    @Test
    public void testFindByUserId() {
        List<Article> articles = articleMapper.findByUserId(1);
        for(Article article : articles){
            System.out.println(article);
        }
        
    }
}
