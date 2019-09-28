package hi.cc.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import hi.car.pojo.AdminUser;
import hi.car.pojo.OperateLog;
import hi.cc.service.AdminUserServiceXT;
import hi.cc.service.OperateService;
import hi.cc.utils.SimpleMD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class AdminController {
    @Resource
    private AdminUserServiceXT adminUserServiceXT;
    @Autowired
    OperateService operateService;

    public OperateLog addlog(@ModelAttribute("user") AdminUser user ){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = dateFormat.format(new Date());
        OperateLog operateLog = new OperateLog();
        operateLog.setOperateUid(user.getId());
        operateLog.setOperateTime(createTime);
        return operateLog;
    }

    @RequiresPermissions(value = {"memberlistxx"})
    @RequestMapping("/admin")
    public String findAllAdminUser(@RequestParam(required = false,defaultValue = "1")int page,
                                   @RequestParam(required = false,defaultValue = "10")int rows,Model model,
                                   HttpServletRequest request){
        int maxpage = adminUserServiceXT.getMaxpage(rows);
        if (page > maxpage){
            page = 1;
        }
        if (page < 1){
            page = maxpage;
        }
        List<AdminUser> adminUsers = adminUserServiceXT.allAdminUser(page, rows);
        int sign = 1;
        model.addAttribute("sign",sign);
        model.addAttribute("adminUsers",adminUsers);
        model.addAttribute("currentPage",page);
        model.addAttribute("maxPage",maxpage);
       /* AdminUser adminUser = new AdminUser();
        adminUser.setUsername("admin");
        request.getSession().setAttribute("user",adminUser);*/
        return "administrator";
    }
    // 模糊搜索
    @RequestMapping("/findAdminMoHu")
    public String findAdminMoHu(@RequestParam(required = false,defaultValue = "1")int page,
                                @RequestParam(required = false,defaultValue = "10")int rows,
                                String xxx,Model model){
        int maxpage = adminUserServiceXT.getMaxpageMoHu(xxx, rows);
        if (page > maxpage){
            page = 1;
        }
        if (page < 1){
            page = maxpage;
        }
        List<AdminUser> adminUserMoHu = adminUserServiceXT.findAdminUserMoHu(xxx);
        model.addAttribute("adminUsers",adminUserMoHu);
        model.addAttribute("currentPage",page);
        model.addAttribute("maxPage",maxpage);
        return "administrator";
    }
    //  根据isSuper 搜索管理员
    @RequestMapping("/findAdmin")
    public String findAdmin(@RequestParam(required = false,defaultValue = "1")int page,
                            @RequestParam(required = false,defaultValue = "10")int rows,
                            int isSuper,Model model){
        System.out.println("isSuper = " + isSuper);
        int maxpage = adminUserServiceXT.getMaxpageByIsSuper(isSuper, rows);
        if (page > maxpage){
            page = 1;
        }
        if (page < 1){
            page = maxpage;
        }
        List<AdminUser> adminUserByIsSuper = adminUserServiceXT.findAdminUserByIsSuper(isSuper);
        int sign = 2;
        model.addAttribute("sss",isSuper);
        model.addAttribute("sign",sign);
        model.addAttribute("currentPage",page);
        model.addAttribute("maxPage",maxpage);
        model.addAttribute("adminUsers",adminUserByIsSuper);
        return "administrator";
    }
    /*删除管理员方法*/
    @RequiresPermissions(value = {"admindelxx"})
    @RequestMapping("/deleteAdminUser")
    public String deleteAdminUser(int id){
        System.out.println("id = " + id);
        boolean b = adminUserServiceXT.deleteAdminUser(id);
        return "redirect:admin";
    }
    /*编辑管理员方法*/
    @RequestMapping("/findAdminUserById")
    public String findAdminUserById(int id,Model model){
        AdminUser adminUserById = adminUserServiceXT.findAdminUserById(id);
        System.out.println("adminUserById = " + adminUserById);
        model.addAttribute("adminUserById",adminUserById);
        return "administrator-details2";
    }
    /*修改保存管理员信息*/
    @RequestMapping("/updateAdminUser")
    public String updateAdminUser(HttpServletRequest request){
        int isSuper = Integer.parseInt(request.getParameter("isSuper"));
        int id = Integer.parseInt(request.getParameter("id"));
        boolean b1 = adminUserServiceXT.updateAdminUserRole(id, isSuper);
        System.out.println("角色修改b1 = " + b1);
        String password = request.getParameter("password");
        String password1 = SimpleMD5Utils.getPassword(password);
        AdminUser adminUser = new AdminUser();
        adminUser.setId(id);
        adminUser.setUsername(request.getParameter("username"));
        adminUser.setPassword(password1);
        adminUser.setName(request.getParameter("name"));
        adminUser.setPhone(request.getParameter("phone"));
        adminUser.setEmail(request.getParameter("email"));
        adminUser.setIsSuper(isSuper);
        adminUser.setRemark(request.getParameter("remark"));
        adminUser.setConsumer(request.getParameter("consumer"));
        adminUser.setDept(request.getParameter("dept"));
        System.out.println("adminUser = " + adminUser);
        boolean b = adminUserServiceXT.updateAdminUser(adminUser);
        if (b==true){
            System.out.println("修改成功");
        }
        return "redirect:admin";
    }
    //  新增管理员
    @RequestMapping("/saveAdmin")
    public String insetAdminUser(HttpServletRequest request){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = dateFormat.format(new Date());
        int isSuper = Integer.parseInt(request.getParameter("isSuper"));
        String password = request.getParameter("password");
        String password1 = SimpleMD5Utils.getPassword(password);
        AdminUser adminUser = new AdminUser();
        adminUser.setUsername(request.getParameter("username"));
        adminUser.setPassword(password1);
        adminUser.setName(request.getParameter("name"));
        adminUser.setPhone(request.getParameter("phone"));
        adminUser.setEmail(request.getParameter("email"));
        adminUser.setCreateTime(createTime);
        adminUser.setIsSuper(Integer.parseInt(request.getParameter("isSuper")));
        adminUser.setRemark(request.getParameter("remark"));
        adminUser.setConsumer(request.getParameter("consumer"));
        adminUser.setDept(request.getParameter("dept"));
        boolean b = adminUserServiceXT.insertAdminUser(adminUser);
        if (b==true){
            System.out.println("添加成功");
        }
//        获取这个管理员的信息
        AdminUser username = adminUserServiceXT.findLoginNameAdminInfo(request.getParameter("username"));
        int id = username.getId();
        boolean b1 = adminUserServiceXT.saveAdminUserRole(id, isSuper);
        System.out.println("b1 = " + b1 + "---" +isSuper);
        System.out.println("添加角色b1 = " + b1);
        return "redirect:admin";
    }
//    跳往增加界面
    @RequiresPermissions(value = {"adminaddxx"})
    @RequestMapping("/admin1")
    public String admin2(){
        return "administrator-details1";
    }

//    启用|禁用
@RequiresPermissions(value = {"adminqyxx"})
    @RequestMapping("/updateStatus1")
    public String updateStatus(int id,int status){

        boolean b = adminUserServiceXT.upDateAdminUserStatus(id,status);
        return "redirect:admin";
    }

    /*@RequestMapping(value = "/login",method = RequestMethod.GET)
    public String showLoginForm(){
        return "logintest";
    }*/

    /*@RequestMapping(value = "/dealLogin",method = RequestMethod.POST)
    public String login (@RequestParam("username") String username,
                         @RequestParam("password") String password){
        *//**
         * 1 查询用户是否存在
         * 2、用户存在查询用户信息，比对凭证
         * 3 、对输入的凭证信息加密与查出凭证比较
         * 4、凭证一直，根据用户名查询该用户的权限信息集合
         * 5、将用户信息今夕脱密后和权限信息存储（session）
         * 6、返回登录成功信息
         *
         * 这些步骤统一交予shiro尽心处理
         *//*
        try {
            Subject subject= SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            subject.login(token);
            if (subject.isAuthenticated()){
                System.out.println("login  is successful");
                return "redirect:main1";
            }
        }catch (UnknownAccountException e) {
            System.out.println("用户名问题");
        }catch (IncorrectCredentialsException e) {
            System.out.println("密码错误");
        }catch (AuthenticationException e) {
            e.printStackTrace();
        }


        return "logintest";
    }*/
//权限不足访问的页面
    @RequestMapping("/unOauth")
    public String showUnOauth(){
        return "unauth";
    }
//    登出页面
    @RequestMapping("/logout")
    public String logout(){
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "login";
    }
//    跳往个人中心
    @RequestMapping("/htPersonalCenter")
    public String htPersonalCenter(/*String user,Model model, HttpServletRequest request, HttpSession httpSession*/){
       /* request.getAttribute(user);*/
      /*  AdminUser admin = adminUserServiceXT.findLoginNameAdminInfo("admin");
        AdminUser adminUser = new AdminUser();
        adminUser.setUsername("admin");*/
      /*  request.getSession().setAttribute("user",adminUser);*/
       /* AdminUser adminUser = (AdminUser) httpSession.getAttribute(user);
        int pid = adminUser.getId();
        model.addAttribute("pid",pid);*/
        return "htPersonalCenter";
    }
//      修改密码的
    @RequestMapping("/updatePasswordById")
    public String updatePasswordById(Model model,int id ,String password){
        String password1 = SimpleMD5Utils.getPassword(password);
        boolean b = adminUserServiceXT.updatePasswordById(id ,password1);
        return "redirect:htPersonalCenter";

    }
    //      根据username查询是否有同名的管理员

    @ResponseBody
    @RequestMapping("/isHaveUsername")
    public boolean isHaveUsername(String username){
        boolean b = adminUserServiceXT.findAdminUserByUsername(username);
        System.out.println("b = " + b);
        return b;
    }
}

