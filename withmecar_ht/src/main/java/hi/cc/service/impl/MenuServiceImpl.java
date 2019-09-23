package hi.cc.service.impl;

import hi.car.pojo.AdminMenuAuth;
import hi.car.pojo.AdminRoleMenu;
import hi.cc.mapper.MenuMapper;
import hi.cc.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;
    @Override
    public List<AdminMenuAuth> findAll() {
        List<AdminMenuAuth> menuAuths=menuMapper.findAll();
        return menuAuths;
    }

    @Override
    public List<AdminMenuAuth> findByParentId(int pid) {
        return menuMapper.findByParentId(pid);
    }

    @Override
    public boolean addMenu(AdminRoleMenu adminRoleMenu) {
        int count=menuMapper.addMenu(adminRoleMenu);
        return count>0?true:false;
    }

    @Override
    public List<AdminMenuAuth> findRoleMen(int roleId) {
        return menuMapper.findRoleMen(roleId);
    }

    @Override
    public boolean delMenuByRId(int rid) {
        int count = menuMapper.delMenuByRId(rid);
        boolean bool=count>0?true:false;
        return bool;
    }

    @Override
    public List<AdminRoleMenu> findRoleMenById(int roleId) {
        return menuMapper.findRoleMenById(roleId);
    }

    @Override
    public boolean delRolebyRid(int rid) {
        int bool = menuMapper.delRolebyRid(rid);
        return bool>0?true:false;
    }


}
