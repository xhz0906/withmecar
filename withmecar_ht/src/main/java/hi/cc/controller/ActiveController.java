package hi.cc.controller;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import hi.car.pojo.ActivityChannel;
import hi.cc.service.AchannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ActiveController {
    @Autowired
    private AchannelService achannelService;
    @RequestMapping("/achannel")
    public String achannel(@RequestParam(required = false,defaultValue = "1")int page,
                           @RequestParam(required = false,defaultValue = "20")int row,
                           Model model){
        List<ActivityChannel> all = achannelService.findAll(page, row);
        int maxPage = achannelService.maxPage(row);
        if(page<1){
            page=maxPage;
        }else if (page>maxPage){
            page=1;
        }
        model.addAttribute("all",all);
        model.addAttribute("currentPage",page);
       model.addAttribute("maxPage",maxPage);
        return "achannel";
    }
    @RequestMapping("/addChannel")
    public String addChannel(){
        return "addChannel";
    }
   /* @RequestMapping("/addC")
    public String add(String name,String useCount,String sign){
        ActivityChannel activityChannel=new ActivityChannel();
        activityChannel.setName(name);
        activityChannel.setUseCount(useCount);
        activityChannel.setSign(sign);
        SimpleDateFormat sim=new SimpleDateFormat();
        Date date=new Date();
        sim.format(date);
        activityChannel.setCreateTime(date.toString());
        achannelService.addAchannel(activityChannel);
        return "redirect:achannel";
    }*/
    @RequestMapping("/deletea")
    public String deletea(int id){
        boolean b = achannelService.deleteA(id);
        return "redirect:achannel";
    }
    @ResponseBody
    @RequestMapping("/searcha")
    public List<ActivityChannel> findByname(String key){
        List<ActivityChannel> bySName = achannelService.findBySName(key);
        return bySName;
    }
}
