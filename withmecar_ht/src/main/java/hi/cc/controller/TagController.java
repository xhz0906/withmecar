package hi.cc.controller;


import hi.car.pojo.Tag;
import hi.cc.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TagController {
    @Autowired
    private TagService tagService;

    @RequestMapping("/mainview")
    public String mainview(){
        return "main";
    }
    @RequestMapping("/tagview")
    public String tagview(Model model){
        List<Tag> qbz = tagService.findQbz();
        List<Tag> sy = tagService.findSy();
        model.addAttribute("qbz",qbz);
        model.addAttribute("sy",sy);
        return "tag";
    }
    @RequestMapping("/updateTag")
    public String tagupdate(int tagid,Model model){
        Tag tag = tagService.findByid(tagid);
        int type = tag.getType();
        model.addAttribute("type",type);
        model.addAttribute("tag",tag);
        return "tagu";
    }
    @RequestMapping("/test")
    public String testlayui(){
        return "testlayui";
    }
    @ResponseBody
    @RequestMapping("/nametest")
    public int  nametest(String name){
        boolean b = tagService.findByName(name);
//        System.out.println(b);
//不为null为 true
        if(b==true){
           return 1;
        }else {
            return 0;
        }
    }
    @ResponseBody
    @RequestMapping("/upsul")
    public int updateSucessful(String name,int id,int clickCount){
       Tag tag=new Tag();
       tag.setId(id);
       tag.setClickCount(clickCount);
       tag.setName(name);
//        设置时间
       SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        sim.format(date);
        tag.setLastUpdateTime(date.toString());
        int i = tagService.updateById(tag);
        return i>0?1:0;
    }
    @ResponseBody
    @RequestMapping("/updateLoc")
    public int updateLoc(int id,int type){
        if(type==1){
            int i = tagService.updateLoc1(id);
            return i>0?1:0;
        }else {
            int i = tagService.updateLoc2(id);
            return i>0?1:0;
        }
    }
}
