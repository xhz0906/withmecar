package hi.cc.controller;

import hi.car.pojo.CarModel;
import hi.car.pojo.CarParamType;
import hi.cc.service.CarBrandService;
import hi.cc.service.CarParamTypeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CarParamTypeController {
    @Autowired
    private CarParamTypeService carParamTypeService;
    @RequestMapping("/findParamType")
    public String findParamType(@RequestParam(required = false,defaultValue = "1") int page,
                                @RequestParam(required = false,defaultValue = "6") int rows,Model model){
        int maxPage =carParamTypeService.getMaxPage(rows);
        if (page > maxPage){
            page = 1;
        }
        if (page < 1){
            page = maxPage;
        }
        List<CarParamType> carParamType = carParamTypeService.findParamType(page,rows);
        System.out.println("carParamType = " + carParamType);
        model.addAttribute("carParamType",carParamType);
        model.addAttribute("currentPage",page);
        model.addAttribute("maxPage",maxPage);
        return "carParamType";
    }
    @RequestMapping("/carParamTypeAdd")
    public String carParamTypeAdd(){
        return "carParamTypeSave";
    }

    /**
     * 增加
     * @param name
     * @param state
     * @return
     */
    @RequestMapping("/saveCarParamType")
    public String saveCarParamType(String name,String state){
        boolean b = carParamTypeService.saveCarParamType(name, state);
        return "redirect:findParamType";
    }
    /**
     * 修改
     * @param id
     * @return
     */
    @RequestMapping("/updateCarParamType1")
    public String updateCarParamType1(int id,Model model){
        CarParamType carParamType = carParamTypeService.findCarParamType(id);
        System.out.println("carParamType = " + carParamType);
        model.addAttribute("carParamType",carParamType);
        return "carParamTypeUpdate";
    }
    @RequestMapping("/updateCarParamType2")
    public String updateCarParamType2(int id, String name,String state){
        System.out.println(id);
        boolean b = carParamTypeService.updateCarParamType(id, name, state);
        return "redirect:findParamType";
    }
    @RequestMapping("/deleteCarParamType")
    public String  deleteCarParamType(int id){
        boolean b = carParamTypeService.deleteCarParamType(id);
        return "redirect:findParamType";
    }
}
