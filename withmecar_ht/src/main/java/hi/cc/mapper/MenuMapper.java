package hi.cc.mapper;

import hi.car.pojo.AdminMenuAuth;
import hi.car.pojo.AdminRoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface MenuMapper {
    public List<AdminMenuAuth> findAll();
    public List<AdminMenuAuth> findByParentId(int pid);
    public int addMenu(@Param("adminRoleMenu") AdminRoleMenu adminRoleMenu);

    public List<AdminMenuAuth> findRoleMen(int roleId);
    public int delMenuByRId(int rid);

    public List<AdminRoleMenu> findRoleMenById(int roleId);
    public int delRolebyRid(int rid);
}
