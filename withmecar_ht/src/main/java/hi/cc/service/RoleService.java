package hi.cc.service;

import hi.car.pojo.AdminRole;

import java.util.List;

public interface RoleService {
    /**
     *
     */
    public List<AdminRole> findAll();
    /**
     * 添加角色
     * @param name
     * @return
     */
    public int saveRoleByName(String name);
}
