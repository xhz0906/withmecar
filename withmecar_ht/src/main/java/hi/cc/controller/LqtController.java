package hi.cc.controller;

import hi.car.pojo.Article;
import hi.cc.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LqtController {
    @Autowired
    private ArticleService articleService;
    //精彩资讯
    @RequestMapping("/dinner")
    public String dinner(Model model){
        List<Article> articles=articleService.recArticle();
        model.addAttribute("recList",articles);
        return "Dinner";
    }
    //我的资讯
    @RequestMapping("/host")
    public String host(){
        return "Host";
    }
    //我要发布
    @RequestMapping("/release")
    public String release(){
        return "Release";
    }
}
