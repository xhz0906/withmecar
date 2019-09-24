package com.qf.j1904.controller;

import com.qf.j1904.service.CarService_xpy;
import com.qf.j1904.service.MemCarService_xpy;
import hi.car.pojo.Car;
import hi.car.pojo.CarLogo;
import hi.car.pojo.MemberCar;
import hi.car.pojo.MemberProfile;
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
public class CarController_xpy {
    @Autowired
    private CarService_xpy carService;
    @Autowired
    private MemCarService_xpy memCarService;
    @RequestMapping("/pinpai")
    public String pinpai(String name, Model model){
        List<Car> carList = carService.findAllByPinpai(name);
        CarLogo carLogo = carService.findCarLgByName(name);
        model.addAttribute("zhong",carService.findCarLogoByCoun("中国"));
        model.addAttribute("de",carService.findCarLogoByCoun("法国"));
        model.addAttribute("fa",carService.findCarLogoByCoun("德国"));
        model.addAttribute("ri",carService.findCarLogoByCoun("日本"));
        model.addAttribute("ou",carService.findCarLogoByCoun("欧美"));
        model.addAttribute("yi",carService.findCarLogoByCoun("意大利"));
        model.addAttribute("carList",carList);
        model.addAttribute("pinpaiName",name);
        model.addAttribute("country",carLogo.getCountry());
        model.addAttribute("isPinPai",true);
        System.out.println(carList);
        return  "countCar";
    }
    @RequestMapping("/countCar")
    public String counCar(String count,Model model){
        model.addAttribute("zhong",carService.findCarLogoByCoun("中国"));
        model.addAttribute("de",carService.findCarLogoByCoun("法国"));
        model.addAttribute("fa",carService.findCarLogoByCoun("德国"));
        model.addAttribute("ri",carService.findCarLogoByCoun("日本"));
        model.addAttribute("ou",carService.findCarLogoByCoun("欧美"));
        model.addAttribute("yi",carService.findCarLogoByCoun("意大利"));
        List<Car> carList = carService.findAllByCountry(count);
        model.addAttribute("carList",carList);
        model.addAttribute("country",count);
        model.addAttribute("isPinPai",false);
        return "countCar";
    }

    @RequestMapping("/MyCar")
    public String MyCar(int type,HttpServletRequest request,Model model){
        MemberProfile loginMember = (MemberProfile) request.getSession().getAttribute("loginMember");
        MemberCar memberCar = memCarService.findMemCarById(loginMember.getId(),type);
        model.addAttribute("myDriver",memberCar);
        request.getSession().setAttribute("type",type);
        return "MyCar";
    }

    @RequestMapping("/MyCarOne")
    public String MyCarOne(HttpServletRequest request,Model model){
        MemberProfile loginMember = (MemberProfile) request.getSession().getAttribute("loginMember");
        int type = (int) request.getSession().getAttribute("type");
        MemberCar memberCar = memCarService.findMemCarById(loginMember.getId(),type);
        model.addAttribute("myDriver",memberCar);
        return "MyCar";
    }

    @RequestMapping("/deleteMyCar")
    public String deleteMyCar(int mcid,HttpServletRequest request,Model model){
        memCarService.deleteById(mcid);
        int type = (int) request.getSession().getAttribute("type");
        MemberProfile loginMember = (MemberProfile) request.getSession().getAttribute("loginMember");
        MemberCar memberCar = memCarService.findMemCarById(loginMember.getId(),type);
        model.addAttribute("myDriver",memberCar);
        return "MyCar";
    }
    @RequestMapping("/addMyCar")
    public String addMyCar(){
        return "addMyCar";
    }
    @RequestMapping("/UpdateCar")
    public String UpdateCar(int mcid,Model model){
        MemberCar memCar = memCarService.findMemCar(mcid);
        model.addAttribute("MyCar",memCar);
        return "UpdateCar";
    }
    @ResponseBody
    @RequestMapping("/saveMyCar")
    public boolean saveMyCar(String pinpai,String chexi,String chekuan,
            int buyyear,int current,String beizhu,HttpServletRequest request){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime = dateFormat.format(new Date());
        MemberProfile loginMember = (MemberProfile) request.getSession().getAttribute("loginMember");
        int maxId = carService.findMaxId();
        int type = (int) request.getSession().getAttribute("type");
        MemberCar memberCar = new MemberCar();
        memberCar.setType(type);
        memberCar.setMemberId(loginMember.getId());
        memberCar.setBuyYear(buyyear);
        memberCar.setCreateTime(updateTime);
        memberCar.setUpdateTime(updateTime);
        memberCar.setRemark(beizhu);
        memberCar.setCurrentMileage(current);
        boolean b = memCarService.saveMemCar(memberCar);
        if (b){
            Car car = new Car();
            car.setId(maxId+1);
            car.setBrandName(pinpai);
            car.setMakeName(chexi);
            car.setName(chexi);
            car.setCreateTime(updateTime);
            b = carService.addCar(car);
        }
        return b;
    }
    @ResponseBody
    @RequestMapping("/updateMyCar")
    public boolean updateMyCar(int id,int cid,String pinpai,String chexi,String chekuan,
                               int buyyear,int current,String beizhu,HttpServletRequest request){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime = dateFormat.format(new Date());
        MemberProfile loginMember = (MemberProfile) request.getSession().getAttribute("loginMember");
        MemberCar memberCar = new MemberCar();
        memberCar.setMemberId(loginMember.getId());
        memberCar.setBuyYear(buyyear);
        memberCar.setCreateTime(updateTime);
        memberCar.setUpdateTime(updateTime);
        memberCar.setRemark(beizhu);
        memberCar.setCurrentMileage(current);
        memberCar.setId(id);
        boolean b = memCarService.updateMemCar(memberCar);
        if (b){
            Car car = new Car();
            car.setId(cid);
            car.setBrandName(pinpai);
            car.setMakeName(chexi);
            car.setName(chexi);
            car.setCreateTime(updateTime);
            b = carService.updateCar(car);
        }
        return b;
    }

}
