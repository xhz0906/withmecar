package hi.cc.service.impl;

import hi.car.pojo.AdminMenuAuth;
import hi.car.pojo.AdminUser;
import hi.cc.mapper.AdminUserMapper_xpy;
import hi.cc.service.AdminService_Xpy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminImpl_Xpy implements AdminService_Xpy {
    @Autowired
    private AdminUserMapper_xpy adminUserMapper;

    /**
     * 根据用户名处查询用户登录信息
     * @param name
     * @return
     */
    @Override
    public AdminUser findAdminByName(String name) {
        return adminUserMapper.findAdminByName(name);
    }

    /**
     * 根据管理员的name查询所拥有的的权限
     * @param name
     * @return
     */
    @Override
    public List<AdminMenuAuth> finUserMenu(int id) {
        return adminUserMapper.finUserMenu(id);
    }

    @Override
    public AdminUser findByEmail(String email) {
        return adminUserMapper.findByEmail(email);
    }
}
