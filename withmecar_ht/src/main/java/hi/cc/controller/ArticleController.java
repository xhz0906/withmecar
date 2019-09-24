package hi.cc.controller;

import hi.car.pojo.AdminUser;
import hi.car.pojo.Article;
import hi.cc.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @RequestMapping("/main")
    public String showHt(){
        return "main";
    }
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
    //添加名字
    private Article addName(int id,HttpServletRequest request){
        HttpSession session=request.getSession();
        AdminUser user=new AdminUser();
        user.setUsername("dade");
        session.setAttribute("user",user);
        AdminUser shuser=(AdminUser)session.getAttribute("user");
        String shuserName=shuser.getUsername();
        Article article=articleService.loadArticleById(id);
        if (article.getLastAuditUsername()==null){
            article.setLastAuditUsername(shuserName);
        }else {
            article.setPublishUname("xhz");
        }

        return article;
    }
    //通过审核
    @RequestMapping("/tGshArticle")
    public String tGshArticle(int id,HttpServletRequest request){
        Article article=addName(id, request);
        boolean bool=articleService.tgArticle(article);
        return bool?"redirect:article_sh":"hi";
    }
    //驳回审核
    @RequestMapping("/bHshArticle")
    public String bHshArticle(int id){
        boolean bool=articleService.bhArticle(id);
        return bool?"redirect:article_sh":"hi";
    }
    //发布咨询
    @RequestMapping("/article_fb")
    public String articleFb(Model model){
        List<Article> alist=articleService.findFbArticle();
        model.addAttribute("alist",alist);
        return "article_fb";
    }

    @RequestMapping("/lxz")
    @ResponseBody
    public int lxz(int id){
        int artId=articleService.findArticleStateById(id);
        return artId;
    }
    @RequestMapping("/fabuArt")
    public String fabuArt(@RequestParam("aid")int aid,HttpServletRequest request){
        int artId=articleService.findArticleStateById(aid);
        Article article=addName(aid,request);
        boolean bool=false;
        boolean boo=false;
        if (artId==3){
            boo=articleService.fbArticle(article);
        }else {
            bool=articleService.tgArticle(article);
        }
        return bool || boo?"redirect:article_fb":"hi";
    }
    //是否推荐
    @RequestMapping("/comArticle")
    public String comArticle(int aid){
        int artId=articleService.findArticleTopId(aid);
        boolean b1=false;
        boolean b2=false;
        if (artId==0){
            b1=articleService.comArticle(aid);
        }else {
            b2=articleService.unComArticle(aid);
        }
        return b1||b2?"redirect:article_fb":"hi";
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
