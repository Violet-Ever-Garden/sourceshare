package com.hw649.sources_share.Realm;

import com.hw649.sources_share.pojo.User;
import com.hw649.sources_share.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //System.out.println("授权");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //拿到当前登陆对象
        Subject subject = SecurityUtils.getSubject();
        //拿到user对象
        User currentUser = (User)subject.getPrincipal();
        //用用户拿到的权限
        info.addStringPermission(currentUser.getPerms());

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //System.out.println("认证");

        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;

        //连接数据库，获得数据库内用户的权限
        User user = userService.selectUserByName(userToken.getUsername());
        //UnknownAccountException
        if(user==null){return null;}

        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        session.setAttribute("loginUser",user);
        session.setAttribute("email",user.getEmail());
        session.setAttribute("userName",user.getName());
        return new SimpleAuthenticationInfo(user,user.getPwd(), ByteSource.Util.bytes(user.getName()),"");
}
}
