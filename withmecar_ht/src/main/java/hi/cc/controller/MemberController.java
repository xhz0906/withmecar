package hi.cc.controller;

import hi.car.pojo.Car;
import hi.car.pojo.MemberProfile;
import hi.car.pojo.Tag;
import hi.cc.service.MemberServiceXT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    MemberServiceXT memberServiceXT;

    @RequestMapping("/findAllMemberPro")
    public String findAllMemberPro(Model model){
        List<MemberProfile> allMemberPro = memberServiceXT.findAllMemberPro();

        model.addAttribute("allMemberPro",allMemberPro);
        return "member";
    }


    @RequestMapping("findMemberProById")
    public String findMemberProById(int id,Model model){

        System.out.println("id = " + id);
        MemberProfile memberProById = memberServiceXT.findMemberProById(id);
        List<Tag> tagById = memberServiceXT.findTagById(id);
        model.addAttribute("tagById",tagById);
        model.addAttribute("memberProById",memberProById);
        return "member-details";
    }

    @RequestMapping("findTagById")
    public String findTagById(int memberId,Model model){
        List<Tag> tagById = memberServiceXT.findTagById(memberId);
        model.addAttribute("tagById",tagById);
        return "member";
    }

//    根据个人id查询出已购车型
    @ResponseBody
    @RequestMapping("findCarById")
    public List<Car> findCarById(int memberId,int type,Model model){
        List<Car> carById = memberServiceXT.findCarById(memberId, type);
        model.addAttribute("carById",carById);
        return carById;
    }
}
