package hi.cc.service.impl;

import com.github.pagehelper.PageHelper;
import hi.car.pojo.Article;
import hi.cc.mapper.ArticleMapper;
import hi.cc.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public List<Article> findAllArticle() {
        List<Article> articles=articleMapper.findAllArticle();

        return articles;
    }

    //添加资讯
    @Override
    public boolean addArticle(Article article) {
        boolean bool=articleMapper.addArticle(article);
        return bool;
    }
    //通过Id查询资讯
    @Override
    public Article loadArticleById(int id) {
        Article article=articleMapper.loadArticleById(id);
        return article;
    }
    //修改
    @Override
    public boolean upResArticle(Article article) {
        boolean bool=articleMapper.upResArticle(article);
        return bool;
    }

    @Override
    public boolean upArticleState(int id) {
        boolean bool=articleMapper.upArticleState(id);
        return bool;
    }

    //删除资讯
    @Override
    public boolean delArticle(int id) {
        boolean bool=articleMapper.delArticle(id);
        return bool;
    }

    @Override
    public List<Article> findAllArticleCg(int page,int rows) {
        PageHelper.startPage(page,rows);
        List<Article> articles=articleMapper.findAllArticleCg();
        return articles;
    }

    @Override
    public List<Article> findAllArticleSh() {
        List<Article> articles=articleMapper.findAllArticleSh();
        return articles;
    }
    //通过审核
    @Override
    public boolean tgArticle(int id) {
        int bool=articleMapper.tgArticle(id);
        return bool>0?true:false;
    }
    //驳回审核
    @Override
    public boolean bhArticle(int id) {
        int bool=articleMapper.bhArticle(id);
        return bool>0?true:false;
    }

    @Override
    public List<Article> findFbArticle() {
        List<Article> articles=articleMapper.findFbArticle();
        return articles;
    }

    @Override
    public boolean fbArticle(int aid) {
        boolean bool=articleMapper.fbArticle(aid);
        return bool;
    }

    @Override
    public int findArticleStateById(int aid) {
        int artId=articleMapper.findArticleStateById(aid);
        return artId;
    }

    @Override
    public int findArticleTopId(int aid) {
        int topId=articleMapper.findArticleTopId(aid);
        return topId;
    }

    @Override
    public boolean comArticle(int aid) {
        boolean bool=articleMapper.comArticle(aid);
        return bool;
    }

    @Override
    public boolean unComArticle(int aid) {
        boolean bool=articleMapper.unComArticle(aid);
        return bool;
    }

    @Override
    public List<Article> findArticleYcom() {
        List<Article> articles=articleMapper.findArticleYcom();
        return articles;
    }

    @Override
    public int calcMaxArt(int rows) {
        int count=articleMapper.getTotalCount();
        return count%rows==0?count/rows:count/rows+1;
    }

    @Override
    public List<Article> recArticle() {
        return articleMapper.recArticle();
    }
}
