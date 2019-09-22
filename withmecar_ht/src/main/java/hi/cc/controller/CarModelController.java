package hi.cc.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import hi.car.pojo.CarBrand;
import hi.car.pojo.CarManufacturer;
import hi.car.pojo.CarModel;
import hi.cc.mapper.CarModelMapper;
import hi.cc.service.CarBrandService;
import hi.cc.service.CarManufacturerService;
import hi.cc.service.CarModelService;
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
public class CarModelController {
    @Autowired
    private CarModelService carModelService;
    @Autowired
    private CarManufacturerService carManufacturerService;
    @Autowired
    private CarBrandService carBrandService;
    @RequestMapping("/findCarModel")
    public String findCarModel(@RequestParam(required = false,defaultValue = "1") int page,
                               @RequestParam(required = false,defaultValue = "10") int rows,Model model){
        int maxPage =carModelService.getMaxPage(rows);
        if (page > maxPage){
            page = 1;
        }
        if (page < 1){
            page = maxPage;
        }
        List<CarModel> carModel = carModelService.findCarModel(page,rows);
        model.addAttribute("carModel",carModel);
        System.out.println("carModel = " + carModel);
        model.addAttribute("currentPage",page);
        model.addAttribute("maxPage",maxPage);
        return "carModel";
    }
    @RequestMapping("findModel1")
    @ResponseBody
    public List<String> findModel1(){
        List<String> model1 = carModelService.findModel1();
        System.out.println("model1 = " + model1);
        return model1;
    }
    @RequestMapping("/carModelAdd")
    public String carModelAdd(){
        return "carModelSave";
    }
    @RequestMapping("/findManufacturerName")
    @ResponseBody
    public List<String> findManufacturerName(){
        List<String> manufacturerName = carManufacturerService.findManufacturerName();
        return manufacturerName;
    }
    @RequestMapping("/findType")
    @ResponseBody
    public List<String> findType(){
        List<String> type = carModelService.findType();
        System.out.println("type = " + type);
        return type;
    }
    @RequestMapping("/saveCarModel")
    public String saveCarModel(Model model,String name,String brandName,String levelName){
        //通过品牌名查询品牌id
        int brandId = carBrandService.saveId(brandName);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = dateFormat.format(new Date());
        boolean b = carModelService.saveCarModel(name, brandName, levelName, createTime);
        //通过品牌名修改品牌id
        boolean updateId = carModelService.updateId(brandId,brandName);
        return "redirect:findCarModel";
    }
    @RequestMapping("/deleteCarModel")
    public String deleteCarModel(int id){
        System.out.println("id = " + id);
        boolean b = carModelService.deleteCarModel(id);
        return "redirect:findCarModel";
    }
    /**
     * 修改
     * @param id
     * @return
     */
    @RequestMapping("/updateCarModel1")
    public String updateCarModel1(int id,String name,Model model){
        System.out.println("id = " + id);
        CarModel model1 = carModelService.findModel(id);
        model.addAttribute("model1",model1);
        System.out.println("model1 = " + model1);
        return "carModelUpdate";
    }
    @RequestMapping("/updateCarModel2")
    public String updateCarModel2(HttpServletRequest request, int id, String name, String brandName,String levelName){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime = dateFormat.format(new Date());
        //通过品牌名查询品牌id
        int brandId = carBrandService.saveId(brandName);
        System.out.println("levelName = " + levelName);
        carModelService.updateModel(id,name,brandName,levelName,updateTime);
        //通过品牌名修改品牌id
        boolean updateId = carModelService.updateId(brandId,brandName);
        return "redirect:findCarModel";
    }
}
