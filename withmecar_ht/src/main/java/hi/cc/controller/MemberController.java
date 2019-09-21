package hi.cc.controller;

import hi.car.pojo.*;
import hi.cc.service.MemberServiceXT;
import hi.cc.utils.ExportExcel;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.server.ExportException;
import java.util.List;

@Slf4j
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


    @RequiresPermissions(value = {"memberxx"})
    @RequestMapping("findMemberProById")
    public String findMemberProById(int id,Model model){

        System.out.println("id = " + id);
        MemberProfile memberProById = memberServiceXT.findMemberProById(id);
        List<Tag> tagById = memberServiceXT.findTagById(id);
        int countryId = memberProById.getCountry();  // 国家Id
        int provinceId = memberProById.getProvince(); // 地区Id
        int cityId = memberProById.getCity(); //  市级标签
        int districtId = memberProById.getDistrict();//  县级Id
        String countryName = memberServiceXT.findCityById(countryId);
        String provinceName = memberServiceXT.findCityById(provinceId);
        String cityName = memberServiceXT.findCityById(cityId);
        String districtName = memberServiceXT.findCityById(districtId);
        String alladdress = countryName+provinceName+"省、"+cityName+"市、"+districtName+" ";
        System.out.println("alladdress = " + alladdress);
        String abc = alladdress;
//      根据个人id查询出此人收藏车系信息
        List<Car> favCarById = memberServiceXT.findFavCarById(id);
//      根据个人id查询出此人收藏资讯信息
        List<Article> favArticleById = memberServiceXT.findFavArticleById(id);
        //    根据个人Id查询出所属积分情况
        List<MemberPoint> memberPointById = memberServiceXT.findMemberPointById(id);
        model.addAttribute("favCarById",favCarById);
        model.addAttribute("favArticleById",favArticleById);
        model.addAttribute("memberPointById",memberPointById);
        model.addAttribute("abc",abc);
        model.addAttribute("tagById",tagById);
        model.addAttribute("memberProById",memberProById);
        return "member-details";
    }

    @RequestMapping("/log")
    public void log(){
        String name = "张阿三";
        int age = 10;
        log.trace("日志输出trace");
        log.debug("日志输出debug");
        log.info("日志输出info");
        log.warn("日志输出warn");
        log.error("日志输出error");
        log.info("name:"+name+"age:" + age);
        log.info("name:{},age:{}",name,age);
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
    public List<Car> findCarById(int memberId,int type,Model model) throws UnknownHostException {
        List<Car> carById = memberServiceXT.findCarById(memberId, type);
        model.addAttribute("carById",carById);
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("localHost = " + localHost);
        return carById;
    }

    @RequestMapping("findMemberProMoHu")
    public String findMemberProMoHu(String xxx,Model model){
        List<MemberProfile> allMemberPro = memberServiceXT.findMemberProMoHu(xxx);
        model.addAttribute("allMemberPro",allMemberPro);
        return "member";
    }

    //  导出member-pro表
    @ResponseBody
    @RequestMapping("/ExportMemberPro")
    public boolean ExportMemPro(String fileName){
        List<MemberProfile> allMemberPro = memberServiceXT.findAllMemberPro();
        System.out.println("allMemberPro = " + allMemberPro);
        boolean bool = ExportExcel.exportMember(allMemberPro,fileName);
        return bool;
    }

}
