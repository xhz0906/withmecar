package hi.cc.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import hi.car.pojo.CarBrand;
import hi.car.pojo.CarManufacturer;
import hi.cc.service.CarBrandService;
import hi.cc.service.CarManufacturerService;
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
public class CarManufacturerController {
    @Autowired
    private CarManufacturerService carManufacturerService;
    @Autowired
    private CarBrandService carBrandService;
    /**
     * 查询厂商
     * @return
     */
    @RequestMapping("/findManufacturer")
    public String findManufacturer(@RequestParam(required = false,defaultValue = "1") int page,
                                   @RequestParam(required = false,defaultValue = "10") int rows,Model model){
        int maxPage = carManufacturerService.getMaxPage(rows);
        if (page > maxPage){
            page = 1;
        }
        if (page < 1){
            page = maxPage;
        }
        List<CarManufacturer> manufacturer = carManufacturerService.findManufacturer(page,rows);
        model.addAttribute("manufacturer",manufacturer);
        model.addAttribute("currentPage",page);
        model.addAttribute("maxPage",maxPage);
        return "carManufacturer";
    }
    /**
     * 查询厂商
     * @return
     */
    @RequestMapping("/findManufacturer1")
    public String findManufacturer1(@RequestParam(required = false,defaultValue = "1") int page,
                                   @RequestParam(required = false,defaultValue = "10") int rows,Model model,String name){
        int maxPage = carManufacturerService.getMaxPage1(name,rows);
        if (page > maxPage){
            page = 1;
        }
        if (page < 1){
            page = maxPage;
        }
        List<CarManufacturer> manufacturer1 = carManufacturerService.findManufacturer1(name,page,rows);
        System.out.println("manufacturer1 = " + manufacturer1);
        model.addAttribute("manufacturer1",manufacturer1);
        model.addAttribute("currentPage",page);
        model.addAttribute("maxPage",maxPage);
        return "carManufacturer1";
    }
    @RequestMapping("/findManufacturer01")
    @ResponseBody
    public List<String> findManufacturer01(String brandName){
        List<String> findManufacturer=carManufacturerService.findManufacturer01(brandName);
        return findManufacturer;
    }
    @RequestMapping("/findBrandByM")
    @ResponseBody
    public List<String> findBrandByM(){
        List<String> brandByM = carManufacturerService.findBrandByM();
        return brandByM;
    }

    @RequestMapping("/carManufacturerAdd")
    public String carBrandAdd(){
        return "carManufacturerSave";
    }
    /**
     * 添加厂商
     * @param request
     * @return
     */
    @RequestMapping(value = "/saveCarManufacturer")
    public String saveCarManufacturer(HttpServletRequest request,String brandName,String name){
        //通过品牌名查询品牌id
        int brandId = carBrandService.saveId(brandName);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = dateFormat.format(new Date());
        boolean saveCarManufacturer = carManufacturerService.saveCarManufacturer(name,brandName,createTime);
        //通过品牌名修改品牌id
        boolean updateId = carManufacturerService.updateId(brandId, brandName);
        return "redirect:findManufacturer";
    }
    /**
     * 删除厂商
     * @param id
     * @return
     */
    @RequestMapping("/deleteCarManufacturer")
    public String deleteCarManufacturer(int id){
        System.out.println("id = " + id);
        boolean deleteCarBrand = carManufacturerService.deleteCarManufacturer(id);
        return "redirect:findManufacturer";
    }
    /**
     * 修改
     * @param id
     * @return
     */
    @RequestMapping("/updateCarManufacturer1")
    public String updateCarManufacturer1(int id,String name,Model model){
        CarManufacturer manufacturer = carManufacturerService.findCarManufacturer(id);
        model.addAttribute("manufacturer",manufacturer);
        return "carManufacturerUpdate";
    }
    @RequestMapping("/updateCarManufacturer2")
    public String updateCarManufacturer2(HttpServletRequest request,int id,String name,String brandName){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime = dateFormat.format(new Date());
        System.out.println("updateTime = " + updateTime);
        //通过品牌名查询品牌id
        int brandId = carBrandService.saveId(brandName);
        carManufacturerService.updateCarManufacturer(id,name,brandName,updateTime);
        //通过品牌名修改品牌id
        boolean updateId = carManufacturerService.updateId(brandId, brandName);
        return "redirect:findManufacturer";
    }

}
