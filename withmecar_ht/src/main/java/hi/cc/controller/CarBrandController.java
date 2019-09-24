package hi.cc.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import hi.car.pojo.CarBrand;
import hi.cc.service.CarBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class CarBrandController {
    @Autowired
    private CarBrandService carBrandService;

    /**
     * 查询汽车品牌
     * @param model
     * @return
     */
    @RequestMapping("/findCarBrand")
    public String findCarBrand(@RequestParam(required = false,defaultValue = "1") int page,
                               @RequestParam(required = false,defaultValue = "10") int rows,
                               Model model){
        int maxPage = carBrandService.getMaxPage(rows);
        if (page > maxPage){
            page = 1;
        }
        if (page < 1){
            page = maxPage;
        }
        List<CarBrand> carBrand = carBrandService.findCarBrand(page,rows);
        System.out.println("carBrand = " + carBrand);
        model.addAttribute("carBrand",carBrand);
        model.addAttribute("currentPage",page);
        model.addAttribute("maxPage",maxPage);
        return "carBrand";
    }
    @RequestMapping("/carBrandAdd")
    public String carBrandAdd(){
        return "carBrandSave";
    }

    /**
     * 添加品牌
     * @param
     * @return
     */
    @RequestMapping(value = "/saveCarBrand")
    public String saveCarBrand(String brandName,String brandLogo){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = dateFormat.format(new Date());
        System.out.println("createTime = " + createTime);
        boolean saveCarBrand = carBrandService.saveCarBrand(brandName,brandLogo ,createTime);
        return "redirect:findCarBrand";
    }

    /**
     * 删除品牌
     * @param id
     * @return
     */
    @RequestMapping("/deleteCarBrand")
    public String deleteCarBrand(int id){
        System.out.println("id = " + id);
        boolean deleteCarBrand = carBrandService.deleteCarBrand(id);
        return "redirect:findCarBrand";
    }

    /**
     * 修改
     * @param id
     * @return
     */
    @RequestMapping("/updateCarBrand1")
    public String updateCarBrand1(int id,Model model){
        CarBrand brand = carBrandService.findBrand(id);
        System.out.println("brand = " + brand);
        model.addAttribute("brand",brand);
        return "carBrandUpdate";
    }
    @RequestMapping("/updateCarBrand2")
    public String updateCarBrand2(HttpServletRequest request){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String updateTime = dateFormat.format(new Date());
        int id= Integer.parseInt(request.getParameter("brandId"));
        System.out.println("id = " + id);
        System.out.println("updateTime = " + updateTime);
        String name=request.getParameter("brandName");
        String logo=request.getParameter("brandLogo");
        System.out.println("logo = " + logo);
        boolean updateCarBrand = carBrandService.updateCarBrand(id,name,logo,updateTime);
        return "redirect:findCarBrand";
    }
    @RequestMapping("/findBrand")
    @ResponseBody
    public List<String> findBrand(){
        List<String> brand1 = carBrandService.findBrand1();
        System.out.println("brand1 = " + brand1);
        return brand1;
    }
    @RequestMapping("/findBrandLogo")
    @ResponseBody
    public  List<String> findBrandLogo(){
        List<String> brandLogo = carBrandService.findBrandLogo();
        return brandLogo;
    }


    /**
     * 通过logo查品牌名
     * @param brandLogo
     * @return
     */
    @RequestMapping("/findBrandName")
    @ResponseBody
    public String findBrandName(String brandLogo){
        String brandName = carBrandService.findBrandName(brandLogo);
        System.out.println("brandName = " + brandName);
        return brandName;
    }

    /**
     * 判断brandlogo和brandname是否存在
     * @param brandLogo
     * @param brandName
     * @return
     */
    @RequestMapping("/findBrandName1")
    @ResponseBody
    public int findBrandName1(String brandLogo,String brandName){
        int brandName1 = carBrandService.findBrandName1(brandName, brandLogo);
        System.out.println("brandName1 = " + brandName1);
        return brandName1;
    }
    /**
     * 通过logo查品牌名
     * @param brandLogo
     * @return
     */
    @RequestMapping("/findBrandName2")
    @ResponseBody
    public String findBrandName2(String brandLogo){
        System.out.println(brandLogo);
        String brandName2 = carBrandService.findBrandName2(brandLogo);
        return brandName2;
    }
    @RequestMapping("/findCountry")
    @ResponseBody
    public List<String> findCountry(){
        List<String> country = carBrandService.findCountry();
        return country;
    }
    @RequestMapping("/findBrand01")
    @ResponseBody
    public List<String> findBrand01(String country){
        List<String> brandName = carBrandService.findBrand01(country);
        return brandName;
    }
    @RequestMapping("findCarBrand1")
    public String findBrand02(@RequestParam(required = false,defaultValue = "1") int page,
                              @RequestParam(required = false,defaultValue = "10") int rows,String brandName,Model model){
        int maxPage = carBrandService.getMaxPage1(brandName,rows);
        if (page > maxPage){
            page = 1;
        }
        if (page < 1){
            page = maxPage;
        }
        List<CarBrand> brandName1 =carBrandService.findBrand02(brandName,page,rows);
        System.out.println(brandName1);
        model.addAttribute("brandName1",brandName1);
        model.addAttribute("currentPage",page);
        model.addAttribute("maxPage",maxPage);
        return "carBrand1";
    }
}
