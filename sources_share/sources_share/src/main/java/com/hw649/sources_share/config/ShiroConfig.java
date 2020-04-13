package com.hw649.sources_share.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.hw649.sources_share.Realm.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(
            @Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
    //connect with SecurityManager
        bean.setSecurityManager(defaultWebSecurityManager);
        //添加Shiro内置过滤器
        /*
            anon:无需认证就可以访问
            authc:必须认证了才能访问
            user:必须拥有记住我功能
            perms:拥有对某个资源的权限才能访问
            role:拥有某个角色权限才能访问
         */
        Map<String,String> filterMap = new LinkedHashMap<>();

        filterMap.put("/toCreate","perms[user:add]");
        filterMap.put("/create","perms[user:add]");
        filterMap.put("/static/**","perms[anon]");
        filterMap.put("/user","authc");
        filterMap.put("/toCreate","authc");
        filterMap.put("/star/**","authc");
        filterMap.put("/upload/avatar","authc");
        bean.setFilterChainDefinitionMap(filterMap);
        //设置登陆页面请求
        bean.setLoginUrl("/toLogin");
        //设置未授权登陆页面请求
        bean.setUnauthorizedUrl("/noauth");
        return bean;
    }

    //DefaultWebSecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //connect with UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    // create realm object which need to define
    @Bean(name = "userRealm")
    public UserRealm userRealm(){
        UserRealm userRealm = new UserRealm();

        //替换当前 Realm 的 credentialsMatcher 属性.

        //直接使用 HashedCredentialsMatcher 对象, 并设置加密算法即可.

        userRealm.setCredentialsMatcher(hashedCredentialsMatcher());

        return userRealm;
    }


    //整合ShiroDialect: shiro-thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }


    /**

     * 加密算法

     * @return

     */

    @Bean

    public HashedCredentialsMatcher hashedCredentialsMatcher(){

        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();

        //设置加密算法

        hashedCredentialsMatcher.setHashAlgorithmName("MD5");

        //设置加密的次数

        hashedCredentialsMatcher.setHashIterations(1024);

        return hashedCredentialsMatcher;

    }
}
