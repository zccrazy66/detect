package cn.wmyskxz.springboot.config;

import cn.wmyskxz.springboot.DAO.EmployeeMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomRealm extends AuthorizingRealm {


//    private String admin;
    @Autowired
    EmployeeMapper employeeMapper;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("**********授权***********");
        String name = (String) principalCollection.getPrimaryPrincipal();
//        System.out.println("something"+ name + "something"+"eeee");
        String power = employeeMapper.Permit(name);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        if (power.equals("admin")){
            info.addStringPermission("admin");
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("**********认证**********");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String password = employeeMapper.Verification(token.getUsername());

        if (null == password){
            return null;
        }
        return new SimpleAuthenticationInfo(token.getUsername() , password,"");
    }
}
