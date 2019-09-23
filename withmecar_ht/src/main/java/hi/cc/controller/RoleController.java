package hi.cc.controller;

import hi.car.pojo.AdminRole;
import hi.cc.service.RoleService;
import hi.cc.utils.RoleMenUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleMenUtils roleMenUtils;
   /* @RequestMapping("/index")
    public String index(){
        return "main";
    }*/
   /*@RequiresPermissions(value = {"rolexx"})*/
    @RequestMapping("/shows")
    private String showAll(Model model){
       System.out.println("model = xx");
       List<AdminRole> roles=roleService.findAll();
       System.out.println("roles = " + roles);
        model.addAttribute("roles",roles);
        return "rolemanager";
    }
    @ResponseBody
    @RequestMapping("saveRole")
    public int saveRole(String roleName){
        int c = 0;
        c = roleService.saveRoleByName(roleName);
        return c;
    }
   /*@RequiresPermissions(value = {"rolebjxx"})*/
    @RequestMapping("/edit")
    public String editRole(int roleId,Model model, HttpServletRequest request){
        model.addAttribute("roleId",roleId);
        model.addAttribute("huiyuan",roleMenUtils.test1(roleId,26));
        model.addAttribute("zixun",roleMenUtils.test1(roleId,27));
        model.addAttribute("biaoqian",roleMenUtils.test1(roleId,28));
        model.addAttribute("huodong",roleMenUtils.test1(roleId,29));
        model.addAttribute("shangpin",roleMenUtils.test1(roleId,30));
        model.addAttribute("cheku",roleMenUtils.test1(roleId,31));
        model.addAttribute("biaoqian2",roleMenUtils.test1(roleId,32));
        model.addAttribute("xiaoxi",roleMenUtils.test1(roleId,33));
        model.addAttribute("juese",roleMenUtils.test1(roleId,34));
        model.addAttribute("guanliyuan",roleMenUtils.test1(roleId,35));
        model.addAttribute("rizhi", roleMenUtils.test1(roleId, 36));
        return "redirect:shows";
    }

}
