package hi.cc.service;

import hi.car.pojo.AdminMenuAuth;
import hi.car.pojo.AdminUser;

import java.util.List;
import java.util.Map;

public interface AdminUserServiceXT {
    //  查询所有的管理员数据
    public List<AdminUser> allAdminUser(int page,int rows);
    //  根据isSuper（管理员类型）查询相应的管理员
    public List<AdminUser> findAdminUserByIsSuper(int isSuper);
    //  模糊查询管理员
    public List<AdminUser> findAdminUserMoHu(String xxx);
    //  对管理员的启用状态status进行设置
    public boolean upDateAdminUserStatus(int id , int status);
    //  根据id查询对应人员信息
    public AdminUser findAdminUserById(int id);
    //  新增管理员
    public boolean insertAdminUser(AdminUser adminUser);
    //   修改管理员信息
    public boolean updateAdminUser(AdminUser adminUser);
    //  根据id删除管理员adminUser
    public boolean deleteAdminUser(int id);
    //  根据id删除管理员-角色表
    public boolean deleteAdminUserRole(int id);
    // 所有管理员最大数量
    public int getMaxpage(int rows);
    //  部分管理员最大数量
    public int getMaxpageByIsSuper(int isSuper,int rows);
    //  模糊查询出的最大数量
    public int getMaxpageMoHu(String xxx,int rows);

    /**
     *  //  根据用户名查询用户登录信息
     * @param loginName
     * @return
     */
    public AdminUser findLoginNameAdminInfo(String loginName);

    /**
     * 根据用户名获取所拥有的的权限
     * @param username
     * @return
     */
    public List<AdminMenuAuth> findLoginNameAdminMenuInfo(String username);

    //  根据id修改密码
    public boolean updatePasswordById(int id,String password);
    // 修改admin-user-role的方法 根据userId
    public boolean updateAdminUserRole (int uid,int rid);
    // 新增admin-user-role的方法 根据userId
    public boolean saveAdminUserRole (int uid,int rid);
//    查询username 是否存在
    public boolean findAdminUserByUsername(String username);
}
