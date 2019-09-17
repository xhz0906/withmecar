package hi.cc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class viewController {
    @RequestMapping("/viewmember")
    public String member(){
        return "member";
    }
    @RequestMapping("/test1")
    public String test1(){
        return "test1";
    }
    @RequestMapping("/main1")
    public String main(){
        return "main";
    }
    @RequestMapping("/member1")
    public String main1(){
        return "member-details";
    }
}
