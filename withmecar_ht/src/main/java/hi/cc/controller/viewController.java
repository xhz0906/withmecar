package hi.cc.controller;

import hi.car.pojo.AdminUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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
    public String main(HttpServletRequest request){
        AdminUser adminUser = new AdminUser();
        adminUser.setUsername("admin");
        request.getSession().setAttribute("user",adminUser);

        return "main";
    }
    @RequestMapping("/member1")
    public String main1(){
        return "member-details";
    }

    @RequestMapping("/index")
    public String city(){
        return "index";
    }

    @RequestMapping("/htRight")
    public String right(){
        return "htRight";
    }

    @RequestMapping("/header")
    public String header(HttpServletRequest request){
        AdminUser adminUser = new AdminUser();
        adminUser.setUsername("admin");
        request.getSession().setAttribute("user",adminUser);
        return "htheader";
    }

    @RequestMapping("/adminxxx")
    public String admin(){
        return "administrator";
    }

    @RequestMapping("/admin1xxx")
    public String admin1(){
        return "administrator-details1";
    }
    @RequestMapping("/admin2xxx")
    public String admin2(){
        return "administrator-details2";
    }
}
