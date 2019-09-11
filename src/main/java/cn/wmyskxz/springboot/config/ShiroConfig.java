package cn.wmyskxz.springboot.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;



@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shirFilter(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {

//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        //Shiro的核心安全接口,这个属性是必须的
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        Map<String, Filter> filterMap = new LinkedHashMap<>();
//        filterMap.put("authc", new AjaxPermissionsAuthorizationFilter());
//        shiroFilterFactoryBean.setFilters(filterMap);
//        /*定义shiro过滤链  Map结构
//         * Map中key(xml中是指value值)的第一个'/'代表的路径是相对于HttpServletRequest.getContextPath()的值来的
//         * anon：它对应的过滤器里面是空的,什么都没做,这里.do和.jsp后面的*表示参数,比方说login.jsp?main这种
//         * authc：该过滤器下的页面必须验证后才能访问,它是Shiro内置的一个拦截器org.apache.shiro.web.filter.authc.FormAuthenticationFilter
//         */
//        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
//         /* 过滤链定义，从上向下顺序执行，一般将 / ** 放在最为下边:这是一个坑呢，一不小心代码就不好使了;
//          authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问 */
//        filterChainDefinitionMap.put("/login", "anon");
//        filterChainDefinitionMap.put("/static/**", "anon");
//        filterChainDefinitionMap.put("/user/login", "anon");
//        filterChainDefinitionMap.put("/user/logout", "anon");
//        filterChainDefinitionMap.put("/test1", "authc");
//        filterChainDefinitionMap.put("/error", "anon");
//        filterChainDefinitionMap.put("/**", "authc");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        return shiroFilterFactoryBean;







        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // setLoginUrl 如果不设置值，默认会自动寻找Web工程根目录下的"/login.html"页面 或 "/login" 映射
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 设置无权限时跳转的 url;
        shiroFilterFactoryBean.setUnauthorizedUrl("/notRole");

        Map<String, String> filtermap = new LinkedHashMap<String, String>();


        filtermap.put("/login", "anon");
        filtermap.put("/test", "anon");
        filtermap.put("/person", "perms[admin]");
        filtermap.put("/*", "authc");


        shiroFilterFactoryBean.setFilterChainDefinitionMap(filtermap);
        return shiroFilterFactoryBean;
    }

    /**
     * 注入 securityManager
     */
    @Bean
    public DefaultWebSecurityManager securityManager(@Qualifier("customRealm")CustomRealm customRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(customRealm);
        return securityManager;
    }

    /**
     * 自定义身份认证 realm;
     * 否则会影响 CustomRealm类 中其他类的依赖注入
     */
    @Bean
    public CustomRealm customRealm() {
        return new CustomRealm();
    }
}


