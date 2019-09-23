package hi.cc.controller;

import hi.car.pojo.AdminUser;
import hi.car.pojo.City;
import hi.car.pojo.Member;
import hi.car.pojo.MemberProfile;
import hi.cc.service.AdminService_Xpy;
import hi.cc.service.CityService_xpy;
import hi.cc.service.MemProfileService_xpy;
import hi.cc.service.MemberService_Xpy;
import hi.cc.utils.MailUtils;
import hi.cc.utils.SimpleMD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class regController {
    @Autowired
    private CityService_xpy cityService;
    @Autowired
    private MailUtils mailUtils;
    @Autowired
    private AdminService_Xpy adminService;
    @Autowired
    private MemProfileService_xpy memProfileService;
    @Autowired
    private MemberService_Xpy memberService;

    //注册
    @RequestMapping("/register")
    public String reg(){
        return "register";
    }
    @ResponseBody
    @RequestMapping("/dealreg")
    public boolean dealreg(String country, String sheng, String shi, String xian, String phone,
                          String email, int sex, String password, HttpServletRequest request){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String regTime = dateFormat.format(new Date());
        String s = SimpleMD5Utils.getPassword(password);
        int countryId = cityService.findIdByName(country).getId();
        int shengId = cityService.findIdByName(sheng).getId();
        int shiId = cityService.findIdByName(shi).getId();
        int xianId = cityService.findIdByName(xian).getId();
        Member member = new Member();
        member.setUsername(phone);
        member.setPassword(s);
        member.setSource(1);
        boolean b = false;
        if (memberService.saveMember(member)){
            Member member1 = memberService.findMemberByName(phone);
            int id = member1.getId();
            MemberProfile profile = new MemberProfile();
            profile.setId(id);
            profile.setRegister_time(regTime);
            profile.setGender(sex);
            profile.setLevel(1);
            profile.setMobile_code("+86");
            profile.setMobile(phone);
            profile.setEmail(email);
            profile.setDescription("暂无");
            profile.setCountry(countryId);
            profile.setProvince(shengId);
            profile.setCity(shiId);
            profile.setDistrict(xianId);
            profile.setPoint(0);
            profile.setAvatar_url("img/img_not_logged_in.png");
            b = memProfileService.saveMemberProfile(profile);
            request.getSession().setAttribute("memberProfile",profile);
            return b;
        }
        return b;
    }
    //注册邮箱验证
    @ResponseBody
    @RequestMapping("/checkRegEmail")
    public boolean checkRegEmail(String email){
        MemberProfile profile = memProfileService.findByMail(email);
        AdminUser adminUser = adminService.findByEmail(email);
        boolean b = false;
        if (profile != null){
            b = true;
        } else if (adminUser != null){
            b = true;
        }
        return b;
    }
    @ResponseBody
    @RequestMapping("/checkMail")
    public String checkMail(String email){
        String mess = "您的注册验证码为：";
        String title = "验证码";
        String b = mailUtils.sendCode(email,mess,title);
        return b;
    }
    @RequestMapping("/unauth")
    public String unauth(){
        return "unauth";
    }
    @ResponseBody
    @RequestMapping("/regCheckPhone")
    public boolean regCheckPhone(String phone){
        List<Member> memberAll = memberService.findMemberAll();
        boolean b = false;
        for (Member m:memberAll) {
            if (m.getUsername().equals(phone)){
                b = true;
                return b;
            }
        }
        return b;
    }
    //获取地区信息
    @ResponseBody
    @RequestMapping("/regGetCountry")
    public List<String> regGetCountry(int type){
        List<City> cityList = cityService.findByType(type);
        List<String> list = new ArrayList<>();
        for (City c:cityList) {
            list.add(c.getCityname());
        }
        return list;
    }
    //获取地区信息
    @ResponseBody
    @RequestMapping("/regGetshengfen")
    public List<String> regGetshengfen(String name){
        return getcity(name);
    }
    //获取地区信息
    @ResponseBody
    @RequestMapping("/regGetshiqu")
    public List<String> regGetshiqu(String name){
        return getcity(name);
    }
    //获取地区信息
    @ResponseBody
    @RequestMapping("/regGetxianqu")
    public List<String> regGetxianqu(String name){
        return getcity(name);
    }

    private List<String> getcity(String name){
        City city = cityService.findIdByName(name);
        List<City> cityList = cityService.findByPid(city.getId());
        List<String> list = new ArrayList<>();
        for (City c:cityList) {
            list.add(c.getCityname());
        }
        return list;
    }
    @RequestMapping("/denglutiaozhuan")
    public String denglutiaozhuan(){
        return "denglutiaozhuan";
    }
}
