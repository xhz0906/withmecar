package com.qf.j1904.service;

import hi.car.pojo.Article;

import java.util.List;

public interface ArticleService_xpy {
    /**
     * 根据发布时间升序查询信息
     * @return
     */
    public List<Article> findArticleDesc();
}
