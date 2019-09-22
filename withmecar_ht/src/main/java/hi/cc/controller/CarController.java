package hi.cc.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import hi.car.pojo.Car;
import hi.car.pojo.CarModel;
import hi.cc.service.CarBrandService;
import hi.cc.service.CarManufacturerService;
import hi.cc.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private CarBrandService carBrandService;
    @RequestMapping("/findCar")
    public String findCar(@RequestParam(required = false,defaultValue = "1") int page,
                          @RequestParam(required = false,defaultValue = "6") int rows,Model model){
        int maxPage = carService.getMaxPage(rows);
        if (page > maxPage){
            page = 1;
        }
        if (page < 1){
            page = maxPage;
        }
        List<Car> car = carService.findCar(page,rows);
        model.addAttribute("car",car);
        System.out.println("car = " + car);
        model.addAttribute("currentPage",page);
        model.addAttribute("maxPage",maxPage);
        return "car1";
    }
    @RequestMapping("/saveCar")
    public String saveCar(String name, String brandName, String manuName, String makeName, String year, String levelName){
        //通过品牌名查询品牌id
        int brandId = carBrandService.saveId(brandName);
        System.out.println(brandId);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = dateFormat.format(new Date());
        boolean b = carService.saveCar(name, brandName, makeName, levelName, createTime);
        //通过品牌名修改品牌id
        boolean updateId = carService.updateId(brandId, brandName);
        List<Integer> carId = carService.findCarId();
        int id= Collections.max(carId);
        //添加指定year
        boolean b1 = carService.saveCarYear(id, year);
        return "redirect:findCar";
    }

    /**
     * 查车系
     * @return
     */
    @RequestMapping("/findMake")
    @ResponseBody
    public List<String> findMake(){
        List<String> make = carService.findMake();
        System.out.println("make = " + make);
        return make;
    }

    /**
     * 查年款
     * @return
     */
    @RequestMapping("/findYear")
    @ResponseBody
    public List<String> findYear(){
        List<String> year = carService.findYear();
        System.out.println("year = " + year);
        return year;
    }
    @RequestMapping("carAdd")
    public String carAdd(){
        return "car1Save";
    }
    @RequestMapping("deleteCar")
    public String deleteCar(int id){
        boolean b = carService.deleteCar(id);
        boolean b1 = carService.deleteCarYear(id);
        return "redirect:findCar";
    }
    /**
     * 修改
     * @param id
     * @return
     */
    @RequestMapping("/updateCar1")
    public String updateCar1(int id,String name,Model model){
        Car car1 = carService.findCar1(id);
        System.out.println("car1 = " + car1);
        model.addAttribute("car1",car1);
        return "car1Update";
    }
    @RequestMapping("/updateCar2")
    public String updateCar2( int id, String name, String brandName,String makeName,String levelName,String year){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime = dateFormat.format(new Date());
        //通过品牌名查询品牌id
        int brandId = carBrandService.saveId(brandName);
        System.out.println("makeName = " + makeName);
        carService.updateCar(id,name,brandName,makeName,levelName,updateTime);
        //通过品牌名修改品牌id
        boolean updateId = carService.updateId(brandId,brandName);
        //修改指定year
        System.out.println(id);
        boolean b1 = carService.updateCarYear(id, year);
        return "redirect:findCar";
    }

    /**
     * 传值到配置页面
     * @param name
     * @param model
     * @return
     */
    @RequestMapping("/configCar1")
    public String configCar1(String name, int id,Model model){
        //通过id 查出指定id所有属性
        Car config = carService.findConfig(id);
        System.out.println(config);
        model.addAttribute("config",config);
        model.addAttribute("name",name);
        return "car1Config";
    }

    /**
     * 修改配置
     * @return
     */
    @RequestMapping("/updateConfig")
    public String updateConfig(int id, String allSpell, String countryClassName, String bodyFormName, BigDecimal priceLow, BigDecimal priceHigh, String countryName){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime = dateFormat.format(new Date());
        boolean b = carService.updateConfig(id, allSpell, countryClassName, bodyFormName, priceLow, priceHigh, countryName,updateTime);
        return "redirect:findCar";
    }
}
