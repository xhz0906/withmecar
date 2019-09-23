package hi.cc.mapper;

import hi.car.pojo.AdminMenuAuth;
import hi.car.pojo.AdminUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminUserMapper_xpy {
    /**
     * 根据用户名处查询用户登录信息
     * @param name
     * @return
     */
    public AdminUser findAdminByName(String username);

    /**
     * 根据管理员的name查询所拥有的的权限
     * @param name
     * @return
     */
    public List<AdminMenuAuth> finUserMenu(int id);

    /**
     * 根据email查询adminUser
     * @param email
     * @return
     */
    public AdminUser findByEmail(String email);
}
