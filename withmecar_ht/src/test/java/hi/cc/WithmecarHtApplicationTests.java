package hi.cc;

import hi.car.pojo.*;
import hi.cc.mapper.AdminMapperxt;
import hi.cc.mapper.MemberMapper;
import hi.cc.mapper.ZiYouShangPingMapper;
import hi.cc.service.AdminUserServiceXT;
import hi.cc.service.MemberServiceXT;
import hi.cc.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WithmecarHtApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Resource
    private MemberMapper memberMapper;
    @Autowired
    private MemberServiceXT memberServiceXT;

    @Resource
    private AdminMapperxt adminMemberxt;
    
    @Resource
    AdminUserServiceXT adminUserServiceXT;

    @Resource
    RoleService roleService;
    @Resource
    ZiYouShangPingMapper ziYouShangPingMapper;
    @Test
    public void testAdmin8(){
        List<Product> allProduct = ziYouShangPingMapper.findAllProduct();
        System.out.println("allProduct = " + allProduct);
    }
    @Test
    public void testAdmin7(){
//        i
        List<AdminRole> all = roleService.findAll();
        System.out.println("b = " + all);

    }

    @Test
    public void testAdmin6(){
//        i
        int admin = adminMemberxt.findAdminUserByUsername("xx");
        System.out.println("b = " + admin);

    }

    @Test
    public void testAdmin5(){
//        boolean b = adminUserServiceXT.saveAdminUserRole(3, 3);
        boolean b = adminUserServiceXT.updateAdminUserRole(3, 2);

        System.out.println("b = " + b);

    }
    @Test
    public void testAdmin4(){
        List<AdminMenuAuth> admin = adminUserServiceXT.findLoginNameAdminMenuInfo("admin");
        System.out.println("admin = " + admin);
    }
    @Test
    public void testAdmin3(){
        AdminUser admin = adminUserServiceXT.findLoginNameAdminInfo("admin");
        System.out.println("admin = " + admin);
    }
    @Test
    public void testAdmin2(){
        Map<String , Integer> map = new HashMap<>();
        map.put("status",1);
        map.put("id",1);
        boolean b = adminUserServiceXT.upDateAdminUserStatus(1,1);
        System.out.println("b = " + b);

    }

    @Test
    public void testAdmin1(){
        AdminUser adminUser = new AdminUser();
        adminUser.setId(2);
        adminUser.setName("ssss");
        boolean b = adminUserServiceXT.updateAdminUser(adminUser);
        System.out.println("b = " + b);

    }
    @Test
    public void testAdmin(){
        List<AdminUser> adminUsers = adminMemberxt.allAdminUser();
        System.out.println("adminUsers = " + adminUsers);
    }
    @Test
    public void findAllMembertest(){
        List<MemberProfile> allMemberPro = memberMapper.findAllMemberPro();
        System.out.println("allMemberPro = " + allMemberPro);
    }
    @Test
    public void findMemberProTest(){
        MemberProfile memberProById = memberMapper.findMemberProById(1);
        System.out.println("memberProById = " + memberProById);

    }

    @Test
    public void findsTagById(){
        List<Tag> tagById = memberServiceXT.findTagById(1);
        System.out.println("tagById = " + tagById);
    }

    @Test
    public void findsTagByIdTest(){
        Map<String,Integer> map = new HashMap<>();
        map.put("memerId",1);
        map.put("type",2);
        List<Car> carById = memberServiceXT.findCarById(1, 2);
        System.out.println("carById = " + carById);


    }
    @Test
    public void findsPointByIdTest(){
        List<Car> memberPointById = memberMapper.findFavCarById(1);
        System.out.println("memberPointById = " + memberPointById);
    }

    @Test
    public void Test1(){
        List<Article> favArticleById = memberServiceXT.findFavArticleById(1);
        System.out.println("favArticleById = " + favArticleById);
    }
}
