package hi.cc.service;

import hi.car.pojo.AdminMenuAuth;
import hi.car.pojo.AdminUser;

import java.util.List;

public interface AdminService_Xpy {
    public AdminUser findAdminByName(String name);
    public List<AdminMenuAuth> finUserMenu(int id);
    /**
     * 根据email查询adminUser
     * @param email
     * @return
     */
    public AdminUser findByEmail(String email);
}
