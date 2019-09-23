package hi.cc.mapper;

import hi.car.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper {
    List<Article> findAllArticle();
    //添加资讯
    boolean  addArticle(Article article);
    //修改资讯内容/查询资讯通过Id
    Article loadArticleById(int id);
    boolean upResArticle(Article article);
    //提交资讯 改变资讯状态
    boolean upArticleState(int id);
    //删除资讯
    boolean delArticle(int id);
    //查询资讯
    List<Article> findAllArticleCg();
    List<Article> findAllArticleSh();
    //审核资讯 通过 驳回
    int tgArticle(int id);
    int bhArticle(int id);

    //发布资讯
    List<Article> findFbArticle();
    boolean fbArticle(int aid);
    //查询资讯状态通过id
    int findArticleStateById(int aid);
    //是否推荐
    boolean comArticle(int aid);
    boolean unComArticle(int aid);
    int findArticleTopId(int aid);
    //资讯列表查询已发布资讯
    List<Article> findArticleYcom();
    //查询最大页
    int getTotalCount();
    //查询前端推荐资讯
    List<Article> recArticle();
}
