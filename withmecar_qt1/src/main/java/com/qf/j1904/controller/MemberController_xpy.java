package com.qf.j1904.controller;

import com.qf.j1904.service.ArticleService_xpy;
import com.qf.j1904.service.CityService_xpy;
import com.qf.j1904.service.MemProfileService_xpy;
import com.qf.j1904.service.MessageService_xpy;
import hi.car.pojo.MemberProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MemberController_xpy {
    @Autowired
    private CityService_xpy cityService;
    @Autowired
    private MemProfileService_xpy memProfileService;
    @Autowired
    private MessageService_xpy messageService;
    @Autowired
    private ArticleService_xpy articleService;
    @RequestMapping("/MemManager")
    public String MemManager(HttpServletRequest request, Model model){
        MemberProfile loginMember = (MemberProfile) request.getSession().getAttribute("loginMember");

        model.addAttribute("country",cityService.findCityById(loginMember.getCountry()).getCityname());
        model.addAttribute("sheng",cityService.findCityById(loginMember.getProvince()).getCityname());
        model.addAttribute("shi",cityService.findCityById(loginMember.getCity()).getCityname());
        model.addAttribute("qu",cityService.findCityById(loginMember.getDistrict()).getCityname());
        request.getSession().setAttribute("messageXpy",messageService.findMessageDesc());
        request.getSession().setAttribute("articleXpy",articleService.findArticleDesc());
        return "MemManager";
    }
    @ResponseBody
    @RequestMapping("/updateMemPro")
    public boolean updateMemPro(String nickname,String name,String mobile,
                                String description,String address){
        MemberProfile memberProfile = new MemberProfile();
        memberProfile.setNickname(nickname);
        memberProfile.setName(name);
        memberProfile.setMobile(mobile);
        memberProfile.setDescription(description);
        memberProfile.setAddress(address);
        boolean bool = memProfileService.updatePro(memberProfile);
        return bool;
    }
}
