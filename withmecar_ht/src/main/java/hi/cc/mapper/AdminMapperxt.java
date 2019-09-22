package hi.cc.mapper;

import hi.car.pojo.AdminMenuAuth;
import hi.car.pojo.AdminRole;
import hi.car.pojo.AdminUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminMapperxt {
    //  查询所有的管理员数据
    public List<AdminUser> allAdminUser();
    //  根据isSuper（管理员类型）查询相应的管理员
    public List<AdminUser> findAdminUserByIsSuper(int isSuper);
    //  模糊查询管理员
    public List<AdminUser> findAdminUserMoHu(String xxx);
    //  查出模糊查询查出数据的数量
    public int getCountAdminMoHu(String xxx);
    //  对管理员的启用状态status进行设置
    public boolean upDateAdminUserStatus(Map<String , Integer> map);
    //  根据id查询对应人员信息
    public AdminUser findAdminUserById(int id);
    //  新增管理员
    public int insertAdminUser(AdminUser adminUser);
    //   修改管理员信息
    public boolean updateAdminUser(AdminUser adminUser);
    //  根据id删除管理员adminUser
    public boolean deleteAdminUser(int id);
    //  根据id删除管理员-角色表
    public boolean deleteAdminUserRole(int id);
    //  根据Id查询管理员数量
    public int getCountAllAdmin();
    //  根据id查询出超级管理员、或在其他管理员的数量
    public int getCountAdminByIsSuper(int isSuper);



    /**
     *  //  根据用户名查询用户登录信息
     * @param loginName
     * @return
     */
    public AdminUser findLoginNameAdminInfo(String loginName);

    /**
     * 根据用户名获取所拥有的的权限
     * @param loginName
     * @return
     */
    public List<AdminMenuAuth> findLoginNameAdminMenuInfo(String loginName);

    //  根据id修改密码
    public boolean updatePasswordById(Map<String,Object> map);
    // 修改admin-user-role的方法 根据userId
    public boolean updateAdminUserRole (Map<String,Integer> map);
    // 新增admin-user-role的方法 根据userId
    public boolean saveAdminUserRole (Map<String,Integer> map);
//    根据username判断是否存在
    public int findAdminUserByUsername(String username);
}
