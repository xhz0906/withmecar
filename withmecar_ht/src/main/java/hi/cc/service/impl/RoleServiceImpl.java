package hi.cc.service.impl;

import hi.car.pojo.AdminRole;
import hi.cc.mapper.RoleMapper;
import hi.cc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;
    @Override
    public List<AdminRole> findAll() {
        return roleMapper.findAll();
    }

    @Override
    public int saveRoleByName(String name) {
        int i = 0;
        i = roleMapper.saveRoleByName(name);
        if (i != 0){
            i = roleMapper.findIdByName(name);
        }
        return i;
    }
}
