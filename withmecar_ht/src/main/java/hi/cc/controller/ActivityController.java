package hi.cc.controller;

import hi.car.pojo.Activity;
import hi.cc.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ActivityController {
   @Autowired
   private ActivityService activityService;

    @RequestMapping("/active")
    public String active(@RequestParam(required = false,defaultValue = "1")int page,
                         @RequestParam(required = false,defaultValue = "9") int row,
                        Model model){
        System.out.println("活动 start");
        int maxPage = activityService.maxPage(row);
        System.out.println("maxPage"+maxPage);
        if(page<1){
            page=maxPage;
        }else if(page>maxPage){
            page=1;
        }
        List<Activity> all = activityService.findAll(page,row);
        System.out.println("all"+all);
       // System.out.println(all.size());
        model.addAttribute("all",all);
        model.addAttribute("currentPage",page);
        model.addAttribute("maxPage",maxPage);
        System.out.println("活动 end");
        return "activity";
    }
    @ResponseBody
    @RequestMapping("online")
    public List<Activity> bufen(int cid){
        List<Activity> activity = activityService.findByStatus(cid);
      //  System.out.println(activity.size());
        return activity;
    }
//    @ResponseBody
//    @RequestMapping("online1")
//    public List<Activity> bufen1(int cid){
//        List<Activity> activity = activityService.findByStatus(cid);
//        //  System.out.println(activity.size());
//        return activity;
//    }
@ResponseBody
@RequestMapping("status")
public List<Activity> bufen1(int sid){
    List<Activity> byRS = activityService.findByRS(sid);
    return byRS;
}
    @ResponseBody
    @RequestMapping("/acsearch")
    public List<Activity> search(String title){
    List<Activity> byTitleOrName = activityService.findByTitleOrName(title);
    return  byTitleOrName;
}
}
