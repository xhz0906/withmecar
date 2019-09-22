package hi.cc.shiro;

import hi.car.pojo.AdminMenuAuth;
import hi.car.pojo.AdminUser;
import hi.cc.service.AdminUserServiceXT;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 自定义的realm策略
 */
public class MyRealm extends AuthorizingRealm {
//    注入业务实现
    @Autowired
    private AdminUserServiceXT adminUserServiceXT;
//    授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Object primaryPrincipal = principalCollection.getPrimaryPrincipal();
        if (!StringUtils.isEmpty(primaryPrincipal)){
            String username = (String) primaryPrincipal;
            List<AdminMenuAuth> adminMenuInfo = adminUserServiceXT.findLoginNameAdminMenuInfo(username);
//          权限去重
            Set<String> perms = new HashSet<>();
            for (AdminMenuAuth perm: adminMenuInfo){
                String controller = perm.getController();
                perms.add(controller);
            }
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            simpleAuthorizationInfo.setStringPermissions(perms);
            return simpleAuthorizationInfo;

        }
        return null;
    }
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //  获取用户身份
        Object principal = authenticationToken.getPrincipal();
        if (!StringUtils.isEmpty(principal)){
            String username= (String) principal;
            //  调用业务逻辑方法 查询用户信息
            AdminUser sysUser = adminUserServiceXT.findLoginNameAdminInfo(username);
            if(sysUser == null){
                return  null;
            }

            ByteSource salt = ByteSource.Util.bytes("abc");
            // 添加带盐验证
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, sysUser.getPassword(), getName());
            return simpleAuthenticationInfo;
        }
        return null;
    }
}
