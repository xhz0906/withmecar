package hi.cc.shiro;

import hi.car.pojo.AdminMenuAuth;
import hi.car.pojo.AdminUser;
import hi.car.pojo.Member;
import hi.cc.service.AdminService_Xpy;
import hi.cc.service.AdminUserServiceXT;
import hi.cc.service.MemberService_Xpy;
import hi.cc.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
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
    @Autowired
    private AdminService_Xpy adminService;
    @Autowired
    private MemberService_Xpy memberService;

//    授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Object primaryPrincipal = principalCollection.getPrimaryPrincipal();
        if (!StringUtils.isEmpty(primaryPrincipal)){
            Subject subject= SecurityUtils.getSubject();//主体对象
            String username=(String)subject.getPrincipal();//获取用户身份信息
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
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //  获取用户身份
        Object principal = token.getPrincipal();
        if (!StringUtils.isEmpty(principal)){
            String userName = (String) principal;
            String password = "";
            AdminUser user=adminService.findAdminByName(userName);
            ByteSource byteSource = null;
            if (user != null){
                password = user.getPassword();
                String salt = user.getSalt();
                byteSource = ByteSource.Util.bytes(salt);
            } else {
                Member member = memberService.findMemberByName(userName);
                password = member.getPassword();
                byteSource = ByteSource.Util.bytes("abc");
            }
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName,password,byteSource,getName());
            return info;
        }
        return null;
    }
}
