package com.qf.j1904.service.impl;

import com.qf.j1904.mapper.ArticleMapper_xpy;
import com.qf.j1904.service.ArticleService_xpy;
import hi.car.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl_xpy implements ArticleService_xpy {
    @Autowired
    private ArticleMapper_xpy articleMapper;
    @Override
    public List<Article> findArticleDesc() {
        return articleMapper.findArticleDesc();
    }
}
