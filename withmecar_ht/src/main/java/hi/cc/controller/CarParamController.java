package hi.cc.controller;

import hi.car.pojo.CarParam;
import hi.car.pojo.CarParamType;
import hi.cc.service.CarParamService;
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
}
