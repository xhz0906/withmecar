package hi.cc.service.impl;

import com.github.pagehelper.PageHelper;
import hi.car.pojo.AdminMenuAuth;
import hi.car.pojo.AdminUser;
import hi.cc.mapper.AdminMapperxt;
import hi.cc.service.AdminUserServiceXT;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminUserServiceImplXT implements AdminUserServiceXT {

    @Resource
    AdminMapperxt adminMapperxt;
    @Override
    public List<AdminUser> allAdminUser(int page,int rows) {
        PageHelper.startPage(page, rows);
        return adminMapperxt.allAdminUser();
    }

    @Override
    public List<AdminUser> findAdminUserByIsSuper(int isSuper) {
        return adminMapperxt.findAdminUserByIsSuper(isSuper);
    }

    @Override
    public List<AdminUser> findAdminUserMoHu(String xxx) {
        return adminMapperxt.findAdminUserMoHu(xxx);
    }

    @Override
    public boolean upDateAdminUserStatus(int id ,int status) {
        Map<String , Integer> map = new HashMap<>();
        map.put("status",status);
        map.put("id",id);
        boolean b = adminMapperxt.upDateAdminUserStatus(map);
        return b?true:false;
    }

    @Override
    public AdminUser findAdminUserById(int id) {
        return adminMapperxt.findAdminUserById(id);
    }

    @Override
    public boolean insertAdminUser(AdminUser adminUser) {

        int count = adminMapperxt.insertAdminUser(adminUser);
        return count>0?true:false;
    }

    @Override
    public boolean updateAdminUser(AdminUser adminUser) {
        return adminMapperxt.updateAdminUser(adminUser);
    }

    @Override
    public boolean deleteAdminUser(int id) {
        return adminMapperxt.deleteAdminUser(id);
    }

    @Override
    public boolean deleteAdminUserRole(int id) {
        return deleteAdminUserRole(id);
    }

    @Override
    public int getMaxpage(int rows) {
        //   获取最大数量
        int maxCount = adminMapperxt.getCountAllAdmin();
        //  最大页数
        int maxPage = maxCount%rows==0?maxCount/rows:maxCount/rows+1;
        return maxPage;
    }

    @Override
    public int getMaxpageByIsSuper(int isSuper, int rows) {
        int maxCount = adminMapperxt.getCountAdminByIsSuper(isSuper);
        int maxPage = maxCount%rows==0?maxCount/rows:maxCount/rows+1;
        return maxPage;
    }

    @Override
    public int getMaxpageMoHu(String xxx, int rows) {
        int maxCount = adminMapperxt.getCountAdminMoHu(xxx);
        int maxPage = maxCount%rows==0?maxCount/rows:maxCount/rows+1;
        return maxPage;
    }

    @Override
    public AdminUser findLoginNameAdminInfo(String loginName) {
        return adminMapperxt.findLoginNameAdminInfo(loginName);
    }

    @Override
    public List<AdminMenuAuth> findLoginNameAdminMenuInfo(String username) {
        return adminMapperxt.findLoginNameAdminMenuInfo(username);
    }

    @Override
    public boolean updatePasswordById(int id , String password) {
        Map<String ,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("password",password);
        return adminMapperxt.updatePasswordById(map);
    }

    @Override
    public boolean updateAdminUserRole(int uid, int rid) {
        Map<String , Integer> map = new HashMap<>();
        map.put("uid",uid);
        map.put("rid",rid);
        return adminMapperxt.updateAdminUserRole(map);
    }

    @Override
    public boolean saveAdminUserRole(int uid, int rid) {
        Map<String , Integer> map = new HashMap<>();
        map.put("uid",uid);
        map.put("rid",rid);
        return adminMapperxt.saveAdminUserRole(map);
    }

    @Override
    public boolean findAdminUserByUsername(String username) {
        int count = adminMapperxt.findAdminUserByUsername(username);
        return count>0?false:true;
    }
}
