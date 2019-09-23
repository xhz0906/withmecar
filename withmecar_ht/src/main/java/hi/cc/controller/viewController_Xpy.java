package hi.cc.controller;

import hi.car.pojo.AdminUser;
import hi.car.pojo.Member;
import hi.car.pojo.MemberProfile;
import hi.cc.service.AdminService_Xpy;
import hi.cc.service.MemProfileService_xpy;
import hi.cc.service.MemberService_Xpy;
import hi.cc.utils.MailUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

@Controller
public class viewController_Xpy {

    @Autowired
    private MailUtils mailUtils;
    @Autowired
    private AdminService_Xpy adminService;
    @Autowired
    private MemProfileService_xpy memProfileService;
    @Autowired
    private MemberService_Xpy memberService;
    /*@RequestMapping("/main")
    public String main(){
        return "main";
    }*/
    //账号登录
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @ResponseBody
    @RequestMapping("/dealLogin")
    public int dealLogin(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             HttpServletRequest request){
        int b = 0;
        AdminUser adminUser = adminService.findAdminByName(username);
        Member member = memberService.findMemberByName(username);
        System.out.println("adminUser"+adminUser);
        System.out.println("member"+member);
        try {
            Subject subject = SecurityUtils.getSubject();//从安全管理器中获取主体对象
            UsernamePasswordToken token=new UsernamePasswordToken(username,password); //构建令牌对象
            subject.login(token);
            if(subject.isAuthenticated()){//判断是否正确登录
                //用户信息与权限信息存储
                System.out.println("登陆成功");
                if (adminUser != null){
                    request.getSession().setAttribute("user",adminUser);
                    b = 2;
                } else if (member != null){
                    b = 1;
                    request.getSession().setAttribute("user",member);
                }
                return b;
            }
        }catch (UnknownAccountException e) {
            System.out.println("用户名问题");
        }catch (IncorrectCredentialsException e) {
            System.out.println("密码错误");
        }catch (AuthenticationException e){
            e.printStackTrace();
            System.out.println("登录失败");
        }
        return b;
    }
    //验证账号
    @ResponseBody
    @RequestMapping("/checkUserName")
    public boolean checkUserName(String username){
        AdminUser adminUser = adminService.findAdminByName(username);
        Member member = memberService.findMemberByName(username);
        boolean b = false;
        if (adminUser == null){
            b = true;
            return b;
        } else if (member == null){
            b = true;
            return b;
        }
        return b;
    }
    //验证账号登录验证码
    @ResponseBody
    @RequestMapping("/checkAccountCode")
    public boolean checkAccountCode(String checkcode,HttpServletRequest request){
        String number = (String) request.getSession().getAttribute("number");
        boolean b = false;
        if (number.equalsIgnoreCase(checkcode)){
            b = true;
            return b;
        }
        return b;
    }
    //账号登录验证码
    @GetMapping("/createImage")
    public void createImage(HttpServletResponse response, HttpSession session) throws IOException {
        int width=80,height=30;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Random r = new Random();
        g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
        g.fillRect(0, 0, width, height);
        //干扰线
        for (int i = 0; i < 10; i++) {
            g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
            g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
        }
        //获取生成的验证码
        String code = getNumber();
        //绑定验证码
        session.setAttribute("number", code);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        g.drawString(code, 5, 25);
        //设置消息头
        response.setContentType("image/jpeg");
        OutputStream os = response.getOutputStream();
        ImageIO.write(image, "jpeg", os);
    }
    private String getNumber(){
        String str="abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String code = "";
        for(int i= 0;i<4;i++){
            int index = (int)(Math.random()*str.length());
            code+=str.charAt(index);
        }
        return code;
    }
    //邮箱登录
    @ResponseBody
    @RequestMapping("/emailLogin")
    public String emailCheck(String email){
        String mess = "您的登录验证码为：";
        String title = "验证码";
        String b = mailUtils.sendCode(email,mess,title);
        return b;
    }
    //验证邮箱
    @ResponseBody
    @RequestMapping("/checkEmail")
    public int checkEmail(String email,HttpServletRequest request){
        MemberProfile profile = memProfileService.findByMail(email);
        AdminUser adminUser = adminService.findByEmail(email);
        if (profile != null){
            return 1;
        } else if (adminUser != null){
            return 2;
        }
        return 0;
    }
    //登录
    @ResponseBody
    @RequestMapping("/LoginByemail")
    public boolean LoginByemail(String email,int auth,HttpServletRequest request){
        String username = "";
        String password = "";
        int id = 0;
        boolean b = false;
        if (auth == 1){
            MemberProfile emailLogin = (MemberProfile) request.getSession().getAttribute("emailLogin");
            id = emailLogin.getId();
            Member member = memberService.findById(id);
            request.getSession().setAttribute("user",member);
            username = member.getUsername();
            password = member.getPassword();
        } else if (auth == 2){
            AdminUser adminUser = adminService.findByEmail(email);
            id = adminUser.getId();
            request.getSession().setAttribute("user",adminUser);
            username = adminUser.getUsername();
            password = adminUser.getPassword();
        }
        try {
            Subject subject = SecurityUtils.getSubject();//从安全管理器中获取主体对象
            UsernamePasswordToken token=new UsernamePasswordToken(username,password); //构建令牌对象
            subject.login(token);
            if(subject.isAuthenticated()){//判断是否正确登录
                //用户信息与权限信息存储
                System.out.println("登陆成功");
                b = true;
                return b;
            }
        }catch (AuthenticationException e){
            e.printStackTrace();
            System.out.println("登录失败");
        }
        return false;
    }
    //忘记密码
    @ResponseBody
    @RequestMapping("/remberLogin")
    public String rememberLogin(String email){
        String mess = "您的新密码为：";
        String title = "登录密码";
        String b = mailUtils.sendCode(email,mess,title);
        return b;
    }

}
