package com.qf.j1904.controller;

import com.qf.j1904.service.TagService_xpy;
import hi.car.pojo.MemberProfile;
import hi.car.pojo.MemberTag;
import hi.car.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class myTagController_xpy {
    @Autowired
    private TagService_xpy tagService;
    @RequestMapping("/MyTag")
    public String MyTag(HttpServletRequest request, Model model){
        MemberProfile loginMember = (MemberProfile) request.getSession().getAttribute("loginMember");
        List<Tag> all = tagService.findAll();
        List<Tag> tagByMid = tagService.findTagByMid(loginMember.getId());
        request.getSession().setAttribute("tagAll",all);
        request.getSession().setAttribute("tagMem",tagByMid);
        return "myTag";
    }
    @RequestMapping("/delTag")
    public String delTag(int tid,HttpServletRequest request){
        MemberProfile loginMember = (MemberProfile) request.getSession().getAttribute("loginMember");
        tagService.deleteMemTag(loginMember.getId(),tid);
        return "redirect:MyTag";
    }
    @RequestMapping("/addTag")
    public String addTag(int tid,HttpServletRequest request){

        MemberProfile loginMember = (MemberProfile) request.getSession().getAttribute("loginMember");
        Tag tag = tagService.findNameById(loginMember.getId(),tid);
        if (tag == null){
            MemberTag memberTag = new MemberTag();
            memberTag.setMemberId(loginMember.getId());
            memberTag.setTagId(tid);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String updateTime = dateFormat.format(new Date());
            memberTag.setCreateTime(updateTime);
            tagService.saveMemTag(memberTag);
        }
        return "redirect:MyTag";
    }
}
