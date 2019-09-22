package hi.cc.config;

import hi.cc.shiro.MyRealm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration // 告诉系统 本类是一个配置类（用此对象初始化shiro）
public class ShiroConfig {

//    创建shiro安全过滤器
    @Bean
    public ShiroFilterFactoryBean filterFactoryBean(
            @Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
//        给过滤器装配安全策略
        filterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        Map<String ,String> map=new HashMap<>();
        map.put("/main1","authc"); //需要登录后才能访问
        map.put("/admin","authc"); //需要登录后才能访问
        map.put("/admin1","authc"); //需要登录后才能访问
        map.put("/admin2","authc"); //需要登录后才能访问
        map.put("/htPersonalCenter","authc"); //需要登录后才能访问
        map.put("/findAllMemberPro","authc"); //需要登录后才能访问
        map.put("/updatePasswordById","authc"); //需要登录后才能访问
//        map.put("/one","perms[user_edit]"); // 需要登录后 并且拥有edit权限的账号
//        map.put("/admin","perms[memberlistxx]"); // 需要登录后 并且拥有edit权限的账号
        filterFactoryBean.setLoginUrl("/login"); // 默认登录页
        filterFactoryBean.setUnauthorizedUrl("/unOauth");  // 权限不足
        filterFactoryBean.setFilterChainDefinitionMap(map); // 需要过滤链的定义
        return filterFactoryBean;
    }

    // 配置安全管理器
    @Bean("defaultWebSecurityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("myRealm") MyRealm myRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(myRealm);
        return defaultWebSecurityManager;
    }

    @Bean("myRealm")   // bean id=“myRealm” class = “……”
    public MyRealm myRealm(){
        MyRealm myRealm = new MyRealm();
        return myRealm;
    }
//    通过aop代理拦截权限设定
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true); // 设置代理模式为 cglib proxy、jdk
        return defaultAdvisorAutoProxyCreator;
    }

//    设置注解拦截原码中的权限设定
    @Bean
    public AuthorizationAttributeSourceAdvisor attributeSourceAdvisor(
            @Qualifier("defaultWebSecurityManager")DefaultWebSecurityManager defaultWebSecurityManager
    ){
        AuthorizationAttributeSourceAdvisor attributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        attributeSourceAdvisor.setSecurityManager(defaultWebSecurityManager);
        return attributeSourceAdvisor;
    }
}
