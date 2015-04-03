package org.zhubao.mybatis.mapper;

import java.util.List;

import org.zhubao.mybatis.model.Article;

public interface ArticleMapper {

    public Article findById(int id);
    
    public void save(Article article);
    
    public List<Article> findByUserId(int userId);
}
