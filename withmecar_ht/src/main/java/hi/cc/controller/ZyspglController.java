package hi.cc.controller;


import hi.car.pojo.CarLogo;
import hi.car.pojo.Product;
import hi.cc.service.ProductService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class ZyspglController {
    @Autowired
    ProductService productService;

    @RequiresPermissions(value = {"shoppingxx"})
    @RequestMapping("/zyspgl")
    public String findAllProduct(@RequestParam(required = false,defaultValue = "1")int page,
                                 @RequestParam(required = false,defaultValue = "10")int row,
                                 Model model){
        int i = productService.maxPage(row);
        if (page<1){
            page=i;
        }
        if (page>i){
            page=1;
        }
        List<Product> findallproduct = productService.findAllProduct(page,row);
        model.addAttribute("currentPage",page);
        model.addAttribute("maxPage",i);
        model.addAttribute("findallproduct",findallproduct);
        return "zyspgl";
    }

    //    public Object findAllProduct(@RequestParam(value = "pageNum") Integer pageNum,
//                                 @RequestParam(value = "pageSize") Integer pageSize){
//        Map<S>
//    }
    @RequestMapping("/ap")
    public int ap(Product product){
        System.out.println(product);
        int count = productService.ap(product);
        System.out.println(count);
        return count;
    }
    @RequestMapping("/dp")
    public String dp(int id){
        boolean b = productService.dp(id);
        return "redirect:zyspgl";
    }
    @RequestMapping("/ci")
    public String ci(int id,Model model){
        CarLogo findcar = productService.fci(id);
        model.addAttribute("fci",findcar);
//        System.out.println(id);
        System.out.println(findcar);
        Product findp = productService.fpi(id);
        model.addAttribute("fpi",findp);
        System.out.println(findp);
        return "productyl";
    }

//    @RequestMapping("/pi")
//    public String pi(int id, Model model){
//        Product findp = productService.fpi(id);
//        model.addAttribute("fpi",findp);
//        System.out.println(findp);
//        return "productyl";
//    }
}
