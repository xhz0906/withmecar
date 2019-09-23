package hi.cc.controller;

import hi.car.pojo.Article;
import hi.cc.service.ArticleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;


@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    /*@RequestMapping("/main")
    public String showHt(){
        return "main";
    }*/
    //草稿箱
    @RequestMapping("/article")
    public String loadArticle(@RequestParam(required = false,defaultValue = "1")int page,
                              @RequestParam(required = false,defaultValue = "6")int rows,
                              Model model){
        int maxPage=articleService.calcMaxArt(rows);

        if (page<1){
            page=maxPage;
        }
        if (page>maxPage){
            page=1;
        }
        List<Article> articles=articleService.findAllArticleCg(page, rows);
        model.addAttribute("articles",articles);
        model.addAttribute("currentPage",page);
        model.addAttribute("maxPage",maxPage);
        return "article";
    }
    //增加资讯
    @RequestMapping("addArticle")
    public String addArticle(){
        return "addarticle";
    }
    //返回增加结果
    @RequestMapping("/addArticleResult")
    public String addArticleResult(String aTitle,String aCheck,String artMs,String photoname,String Author,String aText){
        String path="img01/"+photoname+".jpg";
        Article article=new Article();
        article.setTitle(aTitle);
        article.setSource(aCheck);
        article.setAuthor(Author);
        article.setSummary(artMs);
        article.setCoverPic(path);
        article.setContent(aText);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String submit_time = dateFormat.format(new Date());
        article.setSubmitTime(submit_time);
        boolean bool=articleService.addArticle(article);
        return bool?"redirect:article":"hi";
    }
    //提交资讯
    @RequestMapping("/subArticleId")
    public String subArticle(int id){
        boolean bool=articleService.upArticleState(id);
        return bool?"redirect:article":"hi";
    }
    //修改资讯/通过idj加载资讯
    @RequestMapping("/upArticleId")
    public String upArticle(int id,Model model){
        Article a=articleService.loadArticleById(id);
        model.addAttribute("a",a);
        return "updateArticle";
    }
    //修改资讯
    @RequestMapping("/upResArticle")
    public String upResArticle(Article art){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String submit_time = dateFormat.format(new Date());
        art.setSubmitTime(submit_time);
        String imgpath="img01/"+art.getCoverPic();
        art.setCoverPic(imgpath);
        boolean bool=articleService.upResArticle(art);
        return bool?"redirect:article":"hi";
    }
    //删除资讯
    @RequestMapping("/delArticleId")
    public String delArticle(int id){
    boolean bool=articleService.delArticle(id);
    return bool?"redirect:article":"hi";
    }
    @RequestMapping("/hi")
    public String hi(){
        return "hi";
    }


    //审核资讯
    @RequiresPermissions(value = {"articlecheckxx"})
    @RequestMapping("/article_sh")
    public String articleSh(HttpServletRequest request){
        List<Article> articleList=articleService.findAllArticleSh();
        HttpSession session=request.getSession();
        session.setAttribute("articleList",articleList);
        return "article_sh";
    }
    @RequestMapping("/shArticle")
    public String shArticle(int id,Model model){
        Article article=articleService.loadArticleById(id);
        model.addAttribute("art",article);
        return "shArticle";
    }
    //通过审核
    @RequestMapping("/tGshArticle")
    public String tGshArticle(int id){
        boolean bool=articleService.tgArticle(id);
        return bool?"redirect:article_sh":"hi";
    }
    //驳回审核
    @RequestMapping("/bHshArticle")
    public String bHshArticle(int id){
        boolean bool=articleService.bhArticle(id);
        return bool?"redirect:article_sh":"hi";
    }
    //发布咨询

    @RequiresPermissions(value = {"articleissuexx"})
    @RequestMapping("/article_fb")
    public String articleFb(Model model){
        List<Article> alist=articleService.findFbArticle();
        model.addAttribute("alist",alist);
        return "article_fb";
    }
    @RequestMapping("/fabuArt")
    public String fabuArt(@RequestParam("aid")int aid){
        int artId=articleService.findArticleStateById(aid);
        if (artId==3){
            boolean bool=articleService.fbArticle(aid);
            return bool?"redirect:article_fb":"hi";
        }else {
            boolean bool=articleService.tgArticle(aid);
            return bool?"redirect:article_fb":"hi";
        }

    }
    //是否推荐
    @RequestMapping("/comArticle")
    public String comArticle(int aid){
        int artId=articleService.findArticleTopId(aid);
        if (artId==0){
            boolean bool=articleService.comArticle(aid);
            return bool?"redirect:article_fb":"hi";
        }else {
            boolean bool=articleService.unComArticle(aid);
            return bool?"redirect:article_fb":"hi";
        }
    }
    //资讯列表页面
    @RequestMapping("/article_list")
    public String articlelist(HttpServletRequest request){
        List<Article> articles=articleService.findArticleYcom();
        request.getSession().setAttribute("artList",articles);
        return "articleList";
    }
    //流程图
    @RequestMapping("/liuchengtu")
    public String liuchengtu(){
        return "liuchengtu";
    }

}
