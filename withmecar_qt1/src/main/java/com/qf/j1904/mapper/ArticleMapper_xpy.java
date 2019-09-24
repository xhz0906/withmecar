package com.qf.j1904.mapper;

import hi.car.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper_xpy {
    /**
     * 根据发布时间升序查询信息
     * @return
     */
    public List<Article> findArticleDesc();
}
