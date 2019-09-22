package hi.cc.service;

import hi.car.pojo.Article;

import java.util.List;

public interface ArticleService {
    List<Article> findAllArticle();
    //添加资讯
    boolean  addArticle(Article article);
    //修改资讯/查询资讯通过Id
    Article loadArticleById(int id);
    boolean upResArticle(Article article);
    //提交资讯 改变资讯状态
    boolean upArticleState(int id);
    //删除资讯
    boolean delArticle(int id);
    //查询资讯
    List<Article> findAllArticleCg(int page, int rows);
    List<Article> findAllArticleSh();
    //审核资讯 通过 驳回
    boolean tgArticle(int id);
    boolean bhArticle(int id);
    //发布资讯
    List<Article> findFbArticle();
    boolean fbArticle(int aid);
    //查询资讯状态通过id
    int findArticleStateById(int aid);
    //是否推荐
    int findArticleTopId(int aid);
    boolean comArticle(int aid);
    boolean unComArticle(int aid);
    //资讯列表查询已发布资讯
    List<Article> findArticleYcom();
    //查询页数
    int calcMaxArt(int rows);
    //查询前端推荐资讯
    List<Article> recArticle();
}
