package com.qf.j1904.controller;

import com.qf.j1904.service.*;
import hi.car.pojo.Car;
import hi.car.pojo.Member;
import hi.car.pojo.MemberProfile;
import hi.car.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class ViewController_xpy {
    @Autowired
    private MemberService_xpy memberService;
    @Autowired
    private MemProfileService_xpy memProfileService;
    @Autowired
    private CarService_xpy carService;
    @Autowired
    private MessageService_xpy messageService;
    @Autowired
    private ArticleService_xpy articleService;
    @Autowired
    private TagService_xpy tagService;
    @RequestMapping("/index")
    public String shouye(String username, HttpServletRequest request){
        Member member = memberService.findMemberByName(username);
        MemberProfile memberProfile = memProfileService.findById(member.getId());
        request.getSession().setAttribute("loginMember",memberProfile);
        boolean b = true;
        if (member != null){
            b = false;
        }
        System.out.println(memberProfile);
        request.getSession().setAttribute("isLogin",b);
        return "redirect:shouye";
    }
    @RequestMapping("/shouye")
    public String shouye1(HttpServletRequest request,Model model){
        model.addAttribute("zhong",carService.findCarLogoByCoun("中国"));
        model.addAttribute("de",carService.findCarLogoByCoun("法国"));
        model.addAttribute("fa",carService.findCarLogoByCoun("德国"));
        model.addAttribute("ri",carService.findCarLogoByCoun("日本"));
        model.addAttribute("ou",carService.findCarLogoByCoun("欧美"));
        model.addAttribute("yi",carService.findCarLogoByCoun("意大利"));
        //热销
        List<Car> stateCar = carService.findAllByState();
        List<Car> staCar = showCount(stateCar, 8);
        model.addAttribute("staCar",staCar);
        List<Car> all = carService.findAll();
        List<Car> newCar = showCount(all, 14);
        model.addAttribute("newCar",newCar);
        if (request.getSession().getAttribute("isLogin")==null){
            request.getSession().setAttribute("isLogin",true);
        }
        request.getSession().setAttribute("messageXpy",messageService.findMessageDesc());
        request.getSession().setAttribute("articleXpy",articleService.findArticleDesc());
        MemberProfile loginMember = (MemberProfile) request.getSession().getAttribute("loginMember");
        List<Tag> tagByMid = tagService.findTagByMid(loginMember.getId());
        Set<Car> list = new HashSet<>();
        for (Tag t:tagByMid) {
            List<Car> byTag = carService.findByTag(t.getName());
            if (byTag != null){
                for (Car c:byTag) {
                    list.add(c);
                }
            }
        }
        model.addAttribute("TagCar",list);
        return "shouye";
    }
    private List<Car> showCount(List<Car> list,int c){
        List<Car> cars = new ArrayList<>();
        if (list.size() == 0){
            return cars;
        } else {
            if (list.size() <= c){
                for (int i = 0; i < list.size(); i++) {
                    cars.add(list.get(i));
                }
            } else {
                for (int i = 0; i < c; i++) {
                    cars.add(list.get(i));
                }
            }

        }
        return cars;
    }
    private List<Car> findCarByCountry(String name){
        List<Car> carList1 = carService.findAllByCountry(name);
        List<Car> c = new ArrayList<>();
        if (carList1.size() == 0){
            return c;
        } else {
            if (carList1.size() < 12){
                for (int i = 0; i < carList1.size(); i++) {
                    c.add(carList1.get(i));
                }
            } else {
                for (int i = 0; i < 12; i++) {
                    c.add(carList1.get(i));
                }
            }

        }
        return c;
    }
    @RequestMapping("/show")
    public String show(@RequestParam(required = false,defaultValue = "1")int page,
                       @RequestParam(required = false,defaultValue = "25")int rows,
                       Model model){
        int maxpage = carService.findMaxpage(rows);
        if (page > maxpage){
            page = 1;
        }
        if (page > 1){
            page = maxpage;
        }
        List<Car> cars = carService.findAllPage(page, rows);
        model.addAttribute("maxpage",maxpage);
        model.addAttribute("currentpage",page);
        model.addAttribute("cars",cars);
        return "show";
    }
    //根据国家查询车辆品牌和车辆
    //详情
    @RequestMapping("/detail")
    public String detail(int cid){
        System.out.println(cid);
        return "shouye";
    }
    //退出登录
    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:shouye";
    }
}
