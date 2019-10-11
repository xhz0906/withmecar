package com.qf.j1904.controller;

import com.qf.j1904.service.ActivityService_xpy;
import com.qf.j1904.service.CarService_xpy;
import com.qf.j1904.service.MessageService_xpy;
import hi.car.pojo.Activity;
import hi.car.pojo.Car;
import hi.car.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ActivityController {
    @Autowired
    private ActivityService_xpy activityService;
    @Autowired
    private CarService_xpy carService;
    @Autowired
    private MessageService_xpy messageService;

    @RequestMapping("/activity")
    public String activity(Model model){
        List<Activity> all = activityService.findAll();
        model.addAttribute("activity",all);
        return "activity";
    }

    @RequestMapping("/activityDetail")
    public String activityDetail(int id,Model model){
        Activity activity = activityService.findById(id);
        List<Car> list = carService.findByAct(id);
        model.addAttribute("a",activity);
        model.addAttribute("cars",list);
        return "activityDetail";
    }

    @RequestMapping("/message")
    public String message(Model model){
        List<Message> messageDesc = messageService.findAll();
        model.addAttribute("mess",messageDesc);
        return "message";
    }
    @ResponseBody
    @RequestMapping("/readMessage")
    public String readMessage(int id){
        Message message = messageService.findById(id);
        messageService.updateIs(id);
        return message.getContent();
    }
}
