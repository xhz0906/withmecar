package hi.cc.controller;

import hi.car.pojo.AdminRole;
import hi.car.pojo.AdminRoleMenu;
import hi.cc.service.MenuService;
import hi.cc.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MenuController {
    @Resource
    private MenuService menuService;

    @RequiresPermissions(value = {"roleaddxx"})
    @RequestMapping("/addrole")
    public String addRole(Model model, HttpServletRequest request){
        model.addAttribute("huiyuan",menuService.findByParentId(26));
        model.addAttribute("zixun",menuService.findByParentId(27));
        model.addAttribute("biaoqian",menuService.findByParentId(28));
        model.addAttribute("huodong",menuService.findByParentId(29));
        model.addAttribute("shangpin",menuService.findByParentId(30));
        model.addAttribute("cheku",menuService.findByParentId(31));
        model.addAttribute("biaoqian2",menuService.findByParentId(32));
        model.addAttribute("xiaoxi",menuService.findByParentId(33));
        model.addAttribute("juese",menuService.findByParentId(34));
        model.addAttribute("guanliyuan",menuService.findByParentId(35));
        model.addAttribute("rizhi",menuService.findByParentId(36));

        return "addrole";
    }
    @ResponseBody
    @RequestMapping("/addMenu")
    public boolean addMenu(int roleId,String ids){
        String[] split = ids.split("-");
        boolean bool = false;
        for (int i = 0; i < split.length; i++) {
            int mid = Integer.parseInt(split[i]);
            AdminRoleMenu adminRoleMenu = new AdminRoleMenu();
            adminRoleMenu.setRoleId(roleId);
            adminRoleMenu.setMenuId(mid);
            bool = menuService.addMenu(adminRoleMenu);
        }
        return bool;
    }
    @ResponseBody
    @RequestMapping("/delRole")
    public int delRoleMenu(int rid){
        int i = 0;
        List<AdminRoleMenu> menu = menuService.findRoleMenById(rid);
        if (menu != null){
            boolean bool = menuService.delMenuByRId(rid);
            if (bool){
                i = 1;
            }
        } else {
            i = 1;
        }
        return i;
    }
    @RequiresPermissions(value = {"roledelxx"})
    @RequestMapping("/deleteRole")
    public String deleteRole(int rid){
        boolean bool1=false;
        boolean bool = menuService.delMenuByRId(rid);
        if(bool){
            bool1 =menuService.delRolebyRid(rid);
            return "redirect:shows";
        }else {
            return "error";
        }

    }
}
