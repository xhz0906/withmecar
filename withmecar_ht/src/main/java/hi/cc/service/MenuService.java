package hi.cc.service;

import hi.car.pojo.AdminMenuAuth;
import hi.car.pojo.AdminRoleMenu;

import java.util.List;

public interface MenuService {
    public List<AdminMenuAuth> findAll();
    public List<AdminMenuAuth> findByParentId(int pid);
    public boolean addMenu(AdminRoleMenu adminRoleMenu);
    public List<AdminMenuAuth> findRoleMen(int roleId);
    public boolean delMenuByRId(int rid);

    public List<AdminRoleMenu> findRoleMenById(int roleId);
    public boolean delRolebyRid(int rid);
}
