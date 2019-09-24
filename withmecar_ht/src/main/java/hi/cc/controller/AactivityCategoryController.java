package hi.cc.controller;

import hi.car.pojo.ActivityCategory;
import hi.cc.service.AactiveCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class AactivityCategoryController {
   @Autowired
   private AactiveCategoryService aactiveCategoryService;
    @RequestMapping("/aactivityCategory")
    public String aactivityCategory(Model model){
        List<ActivityCategory> all = aactiveCategoryService.findAll();
        model.addAttribute("all",all);
        return "aactivityCategory";
    }
    @ResponseBody
    @RequestMapping("addaa")
    public int addaa(String name){
        ActivityCategory oneByName = aactiveCategoryService.findOneByName(name);
        return oneByName!=null?1:0;
    }
    @ResponseBody
    @RequestMapping("/addres")
    public int addres(String name){
        ActivityCategory activityCategory=new ActivityCategory();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat();
        Date date=new Date();
        simpleDateFormat.format(date);
        activityCategory.setCreateTime(date);
        activityCategory.setName(name);
        int addaa = aactiveCategoryService.addaa(activityCategory);
      //  System.out.println(addaa);
        if(addaa>0){
            return 1;
        }else {
            return 0;
        }
    }
    @ResponseBody
    @RequestMapping("/searchaa")
    public List<ActivityCategory> findByName(String key){
        List<ActivityCategory> byName = aactiveCategoryService.findByName(key);
        return byName;
    }
    @RequestMapping("/updateaa")
    public String updateaa(int id,Model model){
        ActivityCategory aa = aactiveCategoryService.findById(id);
        model.addAttribute("aa",aa);
        return "addactivityCategory";
    }
    @RequestMapping("/addCategory")
    public String addCategory(String name,String useCount,int id){
        ActivityCategory activityCategory=new ActivityCategory();
        activityCategory.setName(name);
        activityCategory.setId(id);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat();
        Date date=new Date();
        simpleDateFormat.format(date);
        activityCategory.setLastUpdateTime(date);
        aactiveCategoryService.updateaa(activityCategory);
        return "redirect:aactivityCategory";
    }
    @RequestMapping("/deleteaa")
    public  String deleteaa(int id){
        int deleteaa = aactiveCategoryService.deleteaa(id);
        return "redirect:aactivityCategory";
    }
}
