package hi.cc.mapper;

import hi.car.pojo.AdminRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RoleMapper {
    /**
     *查询所有角色
     */
    public List<AdminRole> findAll();

    /**
     * 添加角色
     * @param name
     * @return
     */
    public int saveRoleByName(String name);

    public int findIdByName(String name);
}
