package hi.cc.controller;

import hi.car.pojo.CarParam;
import hi.car.pojo.CarParamType;
import hi.cc.service.CarParamService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CarParamController {
    @Autowired
    private CarParamService carParamService;
    @RequiresPermissions(value = {"parameterglxx"})
    @RequestMapping("/findParam")
    public String findParam(@RequestParam(required = false,defaultValue = "1") int page,
                            @RequestParam(required = false,defaultValue = "10") int rows, Model model){
        int maxPage =carParamService.getMaxPage(rows);
        if (page > maxPage){
            page = 1;
        }
        if (page < 1){
            page = maxPage;
        }
        List<CarParam> carParam = carParamService.findParam(page,rows);
        System.out.println("carParam = " + carParam);
        model.addAttribute("carParam",carParam);
        model.addAttribute("currentPage",page);
        model.addAttribute("maxPage",maxPage);
        return "carParam";
    }
    @RequestMapping("/findParam1")
    public String findParam1(@RequestParam(required = false,defaultValue = "1") int page,
                            @RequestParam(required = false,defaultValue = "10") int rows, Model model,String param){
        int maxPage =carParamService.getMaxPage1(param,rows);
        if (page > maxPage){
            page = 1;
        }
        if (page < 1){
            page = maxPage;
        }
        List<CarParam> carParam1= carParamService.findParam1(param,page,rows);
        model.addAttribute("carParam1",carParam1);
        model.addAttribute("currentPage",page);
        model.addAttribute("maxPage",maxPage);
        return "carParam1";
    }
    @RequestMapping("/carParamAdd")
    public String carParamTypeAdd(){
        return "carParamSave";
    }
    /**
     * 修改
     * @param id
     * @return
     */
    @RequestMapping("/updateCarParam1")
    public String updateCarParam1(int id,Model model){
        CarParam carParam = carParamService.findCarParam(id);
        model.addAttribute("carParam",carParam);
        return "carParamUpdate";
    }
    @RequestMapping("/updateCarParam2")
    public String updateCarParam2(int id, String name,String type,String state){
        System.out.println(id);
        boolean b = carParamService.updateCarParam(id,name,type,state);
        return "redirect:findParam";
    }
    @RequestMapping("findType0000")
    @ResponseBody
    public List<String> findType001(){
        System.out.println("111111");
        List<String> type001 = carParamService.findType001();
        System.out.println(type001);
        return type001;
    }

}
